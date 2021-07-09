package br.edu.unisep.stockcontrol.domain.dto.data.dao

import androidx.room.*
import br.edu.unisep.stockcontrol.domain.dto.data.entity.Item

@Dao
interface ItemDao {

    @Insert
    suspend fun save(item:Item)

    @Update
    suspend fun update(item:Item)

    @Delete
    suspend fun  delete(item: Item)

    @Query("select * from item where stockId = :stockid")
    suspend fun findAllStock(stockid: Int):List<Item>

    @Query("select * from item where id = :id")
    suspend fun findById(id: Int): Item


}