package com.mincor.mvpdelegate.mvp.base.lifecycle

import kotlin.coroutines.Continuation
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

/**
 * This class designed for change configuration handling
 */
data class StickyContinuation<ReturnType> constructor(
    private val continuation: Continuation<ReturnType>,
    private var presenter: IBaseLifecyclePresenter<*>?,
    val strategy: StickyStrategy = StickyStrategy.Many
) : Continuation<ReturnType> by continuation {

    /**
     * Counter of how this sticky must be execute
     */
    private var _counter: Int = 0

    private var _resumeValue: ReturnType? = null
    val resumeValue: ReturnType?
        get() = _resumeValue

    private var _resumeException: Throwable? = null
    val resumeException: Throwable?
        get() = _resumeException

    override fun resumeWith(result: Result<ReturnType>) {
        when(true) {
            result.isSuccess -> {
                result.getOrNull()?.let { value ->
                    resume(value)
                }
            }
            result.isFailure -> {
                result.exceptionOrNull()?.let { exception ->
                    resumeWithException(exception)
                }
            }
        }
    }

    fun increaseCounter() {
        if(strategy is StickyStrategy.Counter) {
            _counter++
            val maxCountOfExecution = strategy.maxExecutionCounter
            if(maxCountOfExecution == _counter) {
                presenter?.removeStickyContinuation(this)
                clear()
            }
        }
    }

    fun clear() {
        presenter = null
    }

    private fun resume(value: ReturnType) {
        _resumeValue = value
        presenter?.removeStickyContinuation(this)
        continuation.resume(value)
    }

    private fun resumeWithException(exception: Throwable) {
        _resumeException = exception
        presenter?.removeStickyContinuation(this)
        continuation.resumeWithException(exception)
    }
}