package com.mincor.mvpdelegate.mvp.presentation.home

import com.mincor.mvpdelegate.R
import com.mincor.mvpdelegate.mvp.base.delegation.BaseDelegationFragment
import kotlinx.android.synthetic.main.fragment_home.*
import org.kodein.di.generic.instance

class HomeFragment :
    BaseDelegationFragment<IHomeContract.IHomeDelegate>(),
    IHomeContract.IView {

    override val layoutResId: Int = R.layout.fragment_home

    override val delegate: IHomeContract.IHomeDelegate by instance()

    override fun showHello(value: String) {
        titleTextView.text = "HELLO FROM $value"
    }
}
