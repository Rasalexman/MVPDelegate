package com.mincor.mvpdelegate.mvp.base.delegation

import com.mincor.mvpdelegate.mvp.base.IBasePresenter
import com.mincor.mvpdelegate.mvp.base.IBaseView

interface IDelegate<V : IBaseView, P : IBasePresenter<V>, D : IBaseDelegate<P>> {
    val delegate: D
}