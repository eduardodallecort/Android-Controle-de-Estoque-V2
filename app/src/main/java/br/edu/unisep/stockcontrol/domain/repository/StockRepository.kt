package br.edu.unisep.stockcontrol.domain.dto.repository

import br.edu.unisep.stockcontrol.domain.dto.data.db.StockDb
import br.edu.unisep.stockcontrol.domain.dto.data.entity.Stock
import br.edu.unisep.stockcontrol.domain.dto.Stock.RegisterStockDto
import br.edu.unisep.stockcontrol.domain.dto.Stock.StockDto

class StockRepository {

    private val dao = StockDb.instance.stockDao()

    suspend fun save(stock: RegisterStockDto) {
        val entity = Stock(stock.name)
        dao.save(entity)
    }

    suspend fun findAll(): List<StockDto> {
        val stock = dao.findAll()

        return stock.map { stock ->
            StockDto(
                stock.id ?: 0,
                stock.name,
            )
        }
    }
}