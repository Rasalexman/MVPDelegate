package com.mincor.mvpdelegate.mvp.base.delegation

import androidx.lifecycle.Lifecycle
import com.mincor.mvpdelegate.mvp.base.IBasePresenter
import com.mincor.mvpdelegate.mvp.base.IBaseView

interface IBaseDelegate<P : IBasePresenter<out IBaseView>> {
    val presenter: P
    fun delegate()
    fun onViewCreated(view: IBaseView, viewLifecycle: Lifecycle)
}