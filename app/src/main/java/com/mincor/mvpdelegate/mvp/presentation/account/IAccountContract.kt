package com.mincor.mvpdelegate.mvp.presentation.account

import com.mincor.mvpdelegate.mvp.base.IBasePresenter
import com.mincor.mvpdelegate.mvp.base.IBaseView

interface IAccountContract  {

    interface IView : IBaseView {
        fun showHello()
    }

    interface IPresenter : IBasePresenter<IView> {
        fun sayHello()
    }

}