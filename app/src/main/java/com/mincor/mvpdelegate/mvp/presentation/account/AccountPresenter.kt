package com.mincor.mvpdelegate.mvp.presentation.account

import com.mincor.mvpdelegate.mvp.base.BasePresenter
import com.mincor.mvpdelegate.mvp.model.UserDataUI

class AccountPresenter : BasePresenter<IAccountContract.IView>(), IAccountContract.IPresenter {

    override fun onViewAttached(view: IAccountContract.IView) {
        super.onViewAttached(view)
        println("AccountPresenter view is attached")
    }

    override fun getUserData() {
        view?.showUser(UserDataUI("userId", "Alexander", "Minkin"))
    }
}