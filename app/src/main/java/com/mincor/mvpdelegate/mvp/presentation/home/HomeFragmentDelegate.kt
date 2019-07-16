package com.mincor.mvpdelegate.mvp.presentation.home

import com.mincor.mvpdelegate.mvp.base.delegation.BaseViewDelegate
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragmentDelegate(presenter: HomePresenter)
    : BaseViewDelegate<IHomeContract.IView, IHomeContract.IPresenter>(presenter) {

    override fun delegate() {
        println("HERE A DELEGATION FRAGMENT WITH VIEW = $view AND PRESENTER = $this")

        with(view as HomeFragment) {
            showButton.setOnClickListener { presenter.sayHello() }
        }

    }
}