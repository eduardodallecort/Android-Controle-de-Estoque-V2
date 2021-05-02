package br.edu.unisep.stockcontrol.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.edu.unisep.stockcontrol.data.dao.ItemDao
import br.edu.unisep.stockcontrol.data.dao.StockDao
import br.edu.unisep.stockcontrol.data.entity.Item
import br.edu.unisep.stockcontrol.data.entity.Stock

@Database(
    entities = [Item::class,Stock::class],
     version = 1
)


abstract class StockDb : RoomDatabase(){

    abstract fun itemDao(): ItemDao

    abstract fun stockDao(): StockDao

    companion object{
        private const val DATABASE_NAME = "db_stock"
        private lateinit var mInstance: StockDb


        val instance
         get() = mInstance


        fun initialize(context:Context){
            mInstance = Room.databaseBuilder(context,StockDb::class.java, DATABASE_NAME).build()
        }
    }


}