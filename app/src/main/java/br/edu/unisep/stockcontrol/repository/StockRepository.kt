package br.edu.unisep.stockcontrol.repository

import br.edu.unisep.stockcontrol.data.db.StockDb
import br.edu.unisep.stockcontrol.data.entity.Stock
import br.edu.unisep.stockcontrol.dto.Stock.RegisterStockDto
import br.edu.unisep.stockcontrol.dto.Stock.StockDto

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