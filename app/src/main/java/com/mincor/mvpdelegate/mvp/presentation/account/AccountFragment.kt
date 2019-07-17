package com.mincor.mvpdelegate.mvp.presentation.account

import android.os.Bundle
import android.view.View
import com.mincor.mvpdelegate.R
import com.mincor.mvpdelegate.mvp.base.delegation.BaseDelegationFragment
import com.mincor.mvpdelegate.mvp.model.UserDataUI
import org.kodein.di.generic.instance

class AccountFragment : BaseDelegationFragment<IAccountContract.IDelegate>(), IAccountContract.IView {

    override val layoutResId: Int = R.layout.fragment_account

    override val delegate: IAccountContract.IDelegate by instance()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        println("Fragment is ready for delegation")
    }

    override fun showUser(userData: UserDataUI) {
        println("HELLO FROM USER NAME = ${userData.firstName}")
    }
}
