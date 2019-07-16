package com.mincor.mvpdelegate.mvp.presentation.account

import androidx.lifecycle.Lifecycle
import com.mincor.mvpdelegate.mvp.lifecycle.base.StickyContinuation

class AccountPresenter : IAccountContract.IPresenter {

    override var viewInstance: IAccountContract.IView?
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
        set(value) {}

    override fun attachView(view: IAccountContract.IView, viewLifecycle: Lifecycle) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun addStickyContinuation(
        continuation: StickyContinuation<*>,
        block: IAccountContract.IView.(StickyContinuation<*>) -> Unit
    ) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun removeStickyContinuation(continuation: StickyContinuation<*>): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun sayHello() {

    }
}