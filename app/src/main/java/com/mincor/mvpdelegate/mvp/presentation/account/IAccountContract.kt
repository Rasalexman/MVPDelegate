package com.mincor.mvpdelegate.mvp.presentation.account

import com.mincor.mvpdelegate.mvp.base.IBasePresenter
import com.mincor.mvpdelegate.mvp.base.IBaseView
import com.mincor.mvpdelegate.mvp.base.delegation.IBaseDelegate
import com.mincor.mvpdelegate.mvp.model.UserDataUI

interface IAccountContract  {

    interface IView : IBaseView {
        fun showUser(userData: UserDataUI)
    }

    interface IPresenter : IBasePresenter<IView> {
        fun getUserData()
    }

    interface IDelegate : IBaseDelegate<IPresenter>
}