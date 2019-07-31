package com.mincor.mvpdelegate.mvp.base.delegation

import androidx.lifecycle.Lifecycle
import com.mincor.mvpdelegate.mvp.base.IBasePresenter
import com.mincor.mvpdelegate.mvp.base.IBaseView

interface IBaseDelegate<out P>
        where P : IBasePresenter<out IBaseView> {
    val presenter: P
    fun onViewCreated(view: IBaseView, viewLifecycle: Lifecycle)
    fun onViewDestroyed()
    fun delegate()
}