package br.edu.unisep.stockcontrol.domain.dto.data.entity

import androidx.room.*


@Entity(tableName = "item")
data class Item (
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    val name: String,
    val count: Int,
    val stockId: Int
){

}
