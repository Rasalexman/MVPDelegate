package com.mincor.mvpdelegate.mvp.presentation.home

import com.mincor.mvpdelegate.mvp.base.delegation.BaseLifecycleDelegate
import kotlinx.android.synthetic.main.fragment_home.*

class HomeDelegate(presenter: IHomeContract.IPresenter) :
    BaseLifecycleDelegate<IHomeContract.IView, IHomeContract.IPresenter>(presenter), IHomeContract.IHomeDelegate {

    override fun delegate() {
        println("HERE A DELEGATION FRAGMENT WITH VIEW = $view AND PRESENTER = $this")

        with(view as HomeFragment) {
            showButton.setOnClickListener { presenter.sayHello() }
        }
    }
}