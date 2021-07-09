package br.edu.unisep.stockcontrol.domain.dto.Stock

import java.io.Serializable

data class StockDto (
    val Id: Int,
    val name: String,
): Serializable