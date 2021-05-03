package br.edu.unisep.stockcontrol.data.entity

import androidx.room.*


@Entity(tableName = "item")
data class Item (
    val name: String,
    val count: Int,
    val stockId: Int
){
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}
