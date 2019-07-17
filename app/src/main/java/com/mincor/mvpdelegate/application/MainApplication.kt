package com.mincor.mvpdelegate.application

import android.app.Application
import com.mincor.mvpdelegate.mvp.presentation.account.AccountDelegate
import com.mincor.mvpdelegate.mvp.presentation.account.AccountPresenter
import com.mincor.mvpdelegate.mvp.presentation.home.HomeDelegate
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
        bind<AccountPresenter>() with singleton { AccountPresenter() }

        bind<AccountDelegate>() with provider { AccountDelegate(instance()) }
        bind<HomeDelegate>() with provider { HomeDelegate(instance()) }
    }
}