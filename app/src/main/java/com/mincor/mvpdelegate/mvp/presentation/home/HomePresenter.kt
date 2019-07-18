package com.mincor.mvpdelegate.mvp.presentation.home

import com.mincor.mvpdelegate.mvp.base.lifecycle.BaseLifecyclePresenter
import com.rasalexman.coroutinesmanager.CoroutinesProvider
import com.rasalexman.coroutinesmanager.ICoroutinesManager
import com.rasalexman.coroutinesmanager.launchOnUITryCatchFinally
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class HomePresenter : BaseLifecyclePresenter<IHomeContract.IView>(),
    IHomeContract.IPresenter, ICoroutinesManager {

    override fun onViewAttached(view: IHomeContract.IView) {
        super.onViewAttached(view)

        println("VIEW ISA ATTACHED")
    }

    override fun sayHello() = launchOnUITryCatchFinally(
        tryBlock = {

            val sum = withContext(CoroutinesProvider.COMMON) {
                delay(10000L)

                var period = 0f
                for (i in 0 until 100) {
                    period += i * 0.45f
                }

                period
            }

            view().stickySuspension {
                showHello("$TAG period = $sum")
            }
        }, catchBlock = {

        }, finallyBlock = {

        })

    companion object {
        const val TAG = "HomePresenter"
    }
}