package com.mincor.mvpdelegate.mvp.base.delegation

import androidx.lifecycle.Lifecycle
import com.mincor.mvpdelegate.mvp.base.IBasePresenter
import com.mincor.mvpdelegate.mvp.base.IBaseView

abstract class BaseDelegate<V, out P>(override val presenter: P)
    : IBaseDelegate<P>, IBasePresenter<V> by presenter
    where V : IBaseView, P : IBasePresenter<V> {

    override fun onViewCreated(view: IBaseView, viewLifecycle: Lifecycle) {
        attachView(view as V)
        delegate()
    }

    override fun onViewDestroyed() {
        detachView()
        view = null
    }
}