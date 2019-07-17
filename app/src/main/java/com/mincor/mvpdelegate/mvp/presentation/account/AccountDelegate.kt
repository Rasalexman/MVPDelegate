package com.mincor.mvpdelegate.mvp.presentation.account

import com.mincor.mvpdelegate.mvp.base.delegation.BaseDelegate

class AccountDelegate(
    presenter: IAccountContract.IPresenter
) : BaseDelegate<IAccountContract.IView, IAccountContract.IPresenter>(presenter), IAccountContract.IDelegate {

    override fun delegate() {
        println("Account delegate is ready to work")
    }
}