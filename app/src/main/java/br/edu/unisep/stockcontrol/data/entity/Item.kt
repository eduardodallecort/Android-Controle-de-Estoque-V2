package br.edu.unisep.stockcontrol.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "item")
data class Item (
    val itemId: Int,
    val name: String,
    val count: Int,
    val stockId: Int,
){
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}
