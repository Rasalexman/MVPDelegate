package com.mincor.mvpdelegate.mvp.base.delegation

import androidx.lifecycle.Lifecycle
import com.mincor.mvpdelegate.mvp.base.IBasePresenter
import com.mincor.mvpdelegate.mvp.base.IBaseView

abstract class BaseViewDelegate<V, P>(override val presenter: P)
    : IBaseDelegate<V, P>, IBasePresenter<V> by presenter
    where V : IBaseView, P : IBasePresenter<V>
{
    override fun onViewCreated(view: V, viewLifecycle: Lifecycle) {
        attachView(view, viewLifecycle)
        delegate()
    }

    override fun onViewDestroy() {
        this.view = null
    }
}