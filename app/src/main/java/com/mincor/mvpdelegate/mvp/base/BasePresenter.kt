package com.mincor.mvpdelegate.mvp.base

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.OnLifecycleEvent
import java.util.concurrent.atomic.AtomicBoolean
import kotlin.coroutines.Continuation
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

abstract class BasePresenter<V : IBaseView> : IBasePresenter<V> {
    override var view: V? = null

    private var viewLifecycle: Lifecycle? = null
    private val isViewResumed = AtomicBoolean(true)
    private val viewContinuations: MutableList<Continuation<V>> = mutableListOf()
    private val stickyContinuations: MutableMap<StickyContinuation<*>, V.(StickyContinuation<*>) -> Unit> =
        mutableMapOf()
    private var mustRestoreStickyContinuations: Boolean = false

    @Synchronized
    protected suspend fun view(): V {
        if (isViewResumed.get()) {
            view?.let { return it }
        }

        // We wait until the view is ready to be used again
        return suspendCoroutine { continuation -> viewContinuations.add(continuation) }
    }

    @Synchronized
    override fun attachView(view: V, viewLifecycle: Lifecycle) {
        this.view = view
        this.viewLifecycle = viewLifecycle
        viewLifecycle.addObserver(this)
        onViewAttached(view)
    }

    open protected fun onViewAttached(view: V) {
        // Nothing to do here. This is an event handled by the subclasses.
    }

    @Synchronized
    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    fun onViewStateChanged() {
        isViewResumed.set(viewLifecycle?.currentState?.isAtLeast(Lifecycle.State.RESUMED) ?: false)
    }

    @Synchronized
    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onViewReadyForContinuations() {

        this.view?.let { viewInstance ->
            val viewContinuationsIterator = viewContinuations.listIterator()

            while (viewContinuationsIterator.hasNext()) {
                val continuation = viewContinuationsIterator.next()

                // The view was not ready when the presenter needed it earlier,
                // but now it's ready again so the presenter can continue
                // interacting with it.
                viewContinuationsIterator.remove()
                continuation.resume(viewInstance)
            }
        }
    }

    @Synchronized
    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onViewReadyForStickyContinuations() {

        this.view?.let { viewInstance ->
            if (mustRestoreStickyContinuations) {
                mustRestoreStickyContinuations = false

                val stickyContinuationsIterator = stickyContinuations.iterator()

                while (stickyContinuationsIterator.hasNext()) {
                    val stickyContinuationBlockMap = stickyContinuationsIterator.next()
                    val stickyContinuation = stickyContinuationBlockMap.key
                    val stickyContinuationBlock = stickyContinuationBlockMap.value
                    viewInstance.stickyContinuationBlock(stickyContinuation)
                }
            }
        }


    }

    @Synchronized
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onViewDestroyed() {
        view = null
        viewLifecycle = null
        mustRestoreStickyContinuations = true
    }

    fun onCleared() {
        cleanup()
    }

    @Synchronized
    override fun addStickyContinuation(
        continuation: StickyContinuation<*>,
        block: V.(StickyContinuation<*>) -> Unit
    ) {
        stickyContinuations[continuation] = block
    }

    @Synchronized
    override fun removeStickyContinuation(continuation: StickyContinuation<*>): Boolean {
        return stickyContinuations.remove(continuation) != null
    }

    /**
     * Executes the given block on the view. The block is executed again
     * every time the view instance changes and the new view is resumed.
     * This, for example, is useful for dialogs that need to be persisted
     * across orientation changes.
     *
     * @param block code that has to be executed on the view
     */
    /*@Suppress("UNCHECKED_CAST")
    suspend fun <ReturnType> V.stickySuspension(
        block: V.(StickyContinuation<ReturnType>) -> Unit
    ): ReturnType {
        return kotlin.coroutines.suspendCoroutine { continuation ->
            val stickyContinuation: StickyContinuation<ReturnType> =
                com.mincor.mvpdelegate.mvp.lifecycle.base.StickyContinuation(continuation, this@BasePresenter)
            addStickyContinuation(stickyContinuation, block as V.(StickyContinuation<*>) -> Unit)
            block(stickyContinuation)
        }
    }*/

    @Synchronized
    open fun cleanup() {
        //cancelAllCoroutines()
    }
}