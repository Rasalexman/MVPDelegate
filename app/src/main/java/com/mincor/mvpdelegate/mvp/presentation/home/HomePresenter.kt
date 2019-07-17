package com.mincor.mvpdelegate.mvp.presentation.home

import com.mincor.mvpdelegate.mvp.base.lifecycle.BaseLifecyclePresenter

class HomePresenter : BaseLifecyclePresenter<IHomeContract.IView>(), IHomeContract.IPresenter {

    override fun onViewAttached(view: IHomeContract.IView) {
        super.onViewAttached(view)

        println("VIEW ISA ATTACHED")
    }

    override fun sayHello() {
        /*
        view?.stickySuspension<Unit> {
            showHello(TAG)
        }*/

        view?.showHello(TAG)
    }

    companion object {
        const val TAG = "HomePresenter"
    }
}