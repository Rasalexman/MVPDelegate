package com.mincor.mvpdelegate.mvp.presentation.home

import com.mincor.mvpdelegate.mvp.base.IBasePresenter
import com.mincor.mvpdelegate.mvp.base.IBaseView

interface IHomeContract {

    interface IView : IBaseView {
        fun showHello(value: String)
    }

    interface IPresenter : IBasePresenter<IView> {
        fun sayHello()
    }
}