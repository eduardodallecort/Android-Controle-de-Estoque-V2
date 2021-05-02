package br.edu.unisep.stockcontrol.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "stock")
data class Stock (
    val name: String,
){
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}
