package br.edu.unisep.stockcontrol.domain.dto.Item

data class UpdateItemDto (
        val id: Int,
        val name: String,
        val count: Int,
        val stockId : Int,
)