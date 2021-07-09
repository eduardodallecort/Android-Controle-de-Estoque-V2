package br.edu.unisep.stockcontrol.domain.dto.Item

data class RegisterItemDto(
    val name: String,
    val count: Int,
    val stockId: Int,
)
