package com.mincor.mvpdelegate.mvp.presentation.account

import com.mincor.mvpdelegate.mvp.base.delegation.BaseDelegate
import kotlinx.android.synthetic.main.fragment_account.*

class AccountDelegate(
    presenter: IAccountContract.IPresenter
) : BaseDelegate<IAccountContract.IView, IAccountContract.IPresenter>(presenter),
    IAccountContract.IDelegate {

    override fun delegate() {
        println("Account delegate is ready to work")

        with(view as AccountFragment) {
            clickMeButton.setOnClickListener {
                presenter.getUserData()
            }
        }
    }
}