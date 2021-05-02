package br.edu.unisep.stockcontrol.app

import android.app.Application
import br.edu.unisep.stockcontrol.data.db.StockDb

class StockApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        StockDb.initialize(applicationContext)
    }
}