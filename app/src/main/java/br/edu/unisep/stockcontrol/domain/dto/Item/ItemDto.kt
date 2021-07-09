package br.edu.unisep.stockcontrol.domain.dto.Item

import java.io.Serializable

data class ItemDto (
    val id: Int,
    val name: String,
    val count: Int,
): Serializable
