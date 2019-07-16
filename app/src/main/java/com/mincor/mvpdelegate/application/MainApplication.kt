package com.mincor.mvpdelegate.application

import android.app.Application
import com.mincor.mvpdelegate.mvp.presentation.home.HomeFragmentDelegate
import com.mincor.mvpdelegate.mvp.presentation.home.HomePresenter
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class MainApplication : Application(), KodeinAware {

    override val kodein: Kodein by Kodein.lazy {
        bind<HomePresenter>() with singleton { HomePresenter() }
        bind<HomeFragmentDelegate>() with provider { HomeFragmentDelegate(instance()) }
    }
}