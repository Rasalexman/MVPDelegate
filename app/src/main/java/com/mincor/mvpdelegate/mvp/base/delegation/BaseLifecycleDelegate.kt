package com.mincor.mvpdelegate.mvp.base.delegation

import androidx.lifecycle.Lifecycle
import com.mincor.mvpdelegate.mvp.base.IBaseView
import com.mincor.mvpdelegate.mvp.base.lifecycle.IBaseLifecyclePresenter

abstract class BaseLifecycleDelegate<V, P>(override val presenter: P)
    : IBaseDelegate<P>, IBaseLifecyclePresenter<V> by presenter
        where V : IBaseView, P : IBaseLifecyclePresenter<V> {

    override fun onViewCreated(view: IBaseView, viewLifecycle: Lifecycle) {
        attachView(view as V, viewLifecycle)
        delegate()
    }
}