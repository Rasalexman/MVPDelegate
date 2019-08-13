package com.mincor.mvpdelegate.mvp.presentation.account

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import com.mincor.mvpdelegate.R
import com.mincor.mvpdelegate.mvp.base.delegation.BaseDelegationFragment
import com.mincor.mvpdelegate.mvp.model.UserDataUI
import kotlinx.android.synthetic.main.fragment_account.*
import org.kodein.di.generic.instance

class AccountFragment : BaseDelegationFragment<IAccountContract.IDelegate>(), IAccountContract.IView {

    override val layoutResId: Int = R.layout.fragment_account

    override val delegate: IAccountContract.IDelegate by instance()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        println("Fragment is ready for delegation")
    }

    @SuppressLint("SetTextI18n")
    override fun showUser(userData: UserDataUI) {
        println("HELLO FROM USER NAME = ${userData.firstName}")
        accountTextView.text = "User name from Presenter is ${userData.firstName} ${userData.lastName}"
    }
}
