package br.edu.unisep.stockcontrol.dto.Item

data class RegisterItemDto(
    val name: String,
    val count: Int,
    val stockId: Int,
)
