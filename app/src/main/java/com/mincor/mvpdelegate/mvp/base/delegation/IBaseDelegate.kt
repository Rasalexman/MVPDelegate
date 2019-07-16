package com.mincor.mvpdelegate.mvp.base.delegation

import androidx.lifecycle.Lifecycle
import com.mincor.mvpdelegate.mvp.base.IBaseView

interface IBaseDelegate<V : IBaseView> {
    fun onViewCreated(view: V, viewLifecycle: Lifecycle)
    fun onViewDestroy()
    fun delegate()
}