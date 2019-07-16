package com.mincor.mvpdelegate.mvp.base.delegation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mincor.mvpdelegate.R
import com.mincor.mvpdelegate.mvp.base.IBasePresenter
import com.mincor.mvpdelegate.mvp.base.IBaseView
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.kodein

abstract class BaseDelegationFragment<D, P, V> : Fragment(), IBaseView, KodeinAware
        where V : IBaseView, P : IBasePresenter<V>, D : IBaseDelegate<V, P> {

    override val kodein: Kodein by kodein()

    /**
     * Layout Resource Id
     */
    protected abstract val layoutResId: Int

    /**
     * Delegate
     */
    protected abstract val delegate: D

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_home, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        delegate.onViewCreated(this as V, this.lifecycle)
    }
}