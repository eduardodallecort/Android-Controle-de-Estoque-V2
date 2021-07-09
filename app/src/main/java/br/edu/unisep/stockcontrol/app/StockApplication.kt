package br.edu.unisep.stockcontrol.app

import android.app.Application
import br.edu.unisep.stockcontrol.di.repositoryModule
import br.edu.unisep.stockcontrol.di.viewModelModule
import br.edu.unisep.stockcontrol.domain.dto.data.db.StockDb
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class StockApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        StockDb.initialize(applicationContext)

        startKoin{
            androidLogger()
            androidContext(applicationContext)
            modules(
                viewModelModule,
                repositoryModule,


                )
        }
    }
    }
