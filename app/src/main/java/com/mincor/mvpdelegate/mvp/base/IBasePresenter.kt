package com.mincor.mvpdelegate.mvp.base

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver

interface IBasePresenter<V : IBaseView> : LifecycleObserver {
    var view:V?
    fun attachView(view: V, viewLifecycle: Lifecycle)
    fun addStickyContinuation(continuation: StickyContinuation<*>, block: V.(StickyContinuation<*>) -> Unit)
    fun removeStickyContinuation(continuation: StickyContinuation<*>): Boolean
}