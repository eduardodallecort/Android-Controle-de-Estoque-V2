package br.edu.unisep.stockcontrol.domain.dto.data.dao

import androidx.room.*
import br.edu.unisep.stockcontrol.domain.dto.data.entity.Stock

@Dao
interface StockDao {

    @Insert
    suspend fun save(stock: Stock)

    @Update
    suspend fun update(stock: Stock)

    @Delete
    suspend fun delete(stock: Stock)

    @Query("select * from stock")
    suspend fun findAll(): List<Stock>

    @Query("select * from stock where id = :stockId")
    suspend fun findById(stockId: Int): List<Stock>

}
