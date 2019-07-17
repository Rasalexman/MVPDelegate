package com.mincor.mvpdelegate.mvp.base

interface IBasePresenter<V : IBaseView> {
    var view:V?
    fun attachView(view: V)
}