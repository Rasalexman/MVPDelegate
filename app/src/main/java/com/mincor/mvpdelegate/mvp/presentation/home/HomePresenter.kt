package com.mincor.mvpdelegate.mvp.presentation.home

import com.mincor.mvpdelegate.mvp.base.lifecycle.BaseLifecyclePresenter
import com.mincor.mvpdelegate.mvp.base.lifecycle.StickyStrategy
import com.mincor.mvpdelegate.mvp.base.lifecycle.sticky
import com.rasalexman.coroutinesmanager.CoroutinesProvider
import com.rasalexman.coroutinesmanager.launchOnUI
import com.rasalexman.coroutinesmanager.launchOnUITryCatchFinally
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import kotlin.random.Random

class HomePresenter : BaseLifecyclePresenter<IHomeContract.IView>(),
    IHomeContract.IPresenter {

    init {

        sticky {
            val count: Int = returnSomeIntType()
        }

        launchOnUI {
            view().stickySuspension {
                showManyContinuation()
            }
        }

        launchOnUI {
            view().stickySuspension(StickyStrategy.Single) {
                showSingleContinuationState()
            }
        }

        launchOnUI {
            view().stickySuspension(StickyStrategy.Counter(3)) {
                showCounterContinuation()
            }
        }
    }

    fun returnSomeIntType(): Int {
        println("-----> HELLO FROM returnSomeIntType")
        return Random.nextInt(1000)
    }

    override fun showCounterContinuation() {
        println("-----> HELLO FROM COUNTER CONTINUATION")
    }

    override fun showSingleContinuationState() {
        println("-----> HELLO FROM SINGLE CONTINUATION")
    }

    override fun showManyContinuation() {
        println("-----> HELLO FROM MANY CONTINUATION")
    }

    override fun onViewAttached(view: IHomeContract.IView) {
        super.onViewAttached(view)
        println("VIEW ISA ATTACHED")
    }

    override fun sayHello() = launchOnUITryCatchFinally(
        tryBlock = {

            val sum = withContext(CoroutinesProvider.COMMON) {
                delay(3000L)

                var period = 0f
                val max = Random.nextInt(100)
                for (i in 0 until max) {
                    period += i * 0.45f
                }

                period
            }

            view().stickySuspension<Unit>(StickyStrategy.Single) {
                showHello("$TAG period = $sum")
            }
        }, catchBlock = {

        }, finallyBlock = {

        })

    companion object {
        const val TAG = "HomePresenter"
    }
}