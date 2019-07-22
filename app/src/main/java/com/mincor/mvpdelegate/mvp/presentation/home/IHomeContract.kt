package com.mincor.mvpdelegate.mvp.presentation.home

import com.mincor.mvpdelegate.mvp.base.IBaseView
import com.mincor.mvpdelegate.mvp.base.delegation.IBaseDelegate
import com.mincor.mvpdelegate.mvp.base.lifecycle.IBaseLifecyclePresenter

interface IHomeContract {

    interface IView : IBaseView {
        fun showHello(value: String)
    }

    interface IPresenter : IBaseLifecyclePresenter<IView> {
        fun sayHello()
        fun showSingleContinuationState()
        fun showManyContinuation()
        fun showCounterContinuation()
    }

    interface IHomeDelegate : IBaseDelegate<IPresenter>
}