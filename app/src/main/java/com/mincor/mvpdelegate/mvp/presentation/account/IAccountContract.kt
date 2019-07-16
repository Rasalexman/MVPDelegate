package com.mincor.mvpdelegate.mvp.presentation.account

import com.mincor.mvpdelegate.mvp.lifecycle.base.IBaseLifecyclePresenter
import com.mincor.mvpdelegate.mvp.lifecycle.base.IBaseLifecycleView

interface IAccountContract  {

    interface IView : IBaseLifecycleView<IPresenter> {
        fun showHello()
    }

    interface IPresenter : IBaseLifecyclePresenter<IView> {
        fun sayHello()
    }

}