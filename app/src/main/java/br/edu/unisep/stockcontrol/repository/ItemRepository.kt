package br.edu.unisep.stockcontrol.repository

import br.edu.unisep.stockcontrol.data.db.StockDb
import br.edu.unisep.stockcontrol.data.entity.Item
import br.edu.unisep.stockcontrol.dto.Item.ItemDto
import br.edu.unisep.stockcontrol.dto.Item.RegisterItemDto
import br.edu.unisep.stockcontrol.dto.Stock.StockDto
import java.time.LocalDateTime

class ItemRepository {

    private val dao = StockDb.instance.itemDao()

    suspend fun findByStock(itemId: Int): List<ItemDto> {
        val itens = dao.findAllStock(itemId)

        return itens.map { item ->
            ItemDto(item.id ?: 0,
                        item.name,
                        item.count)
        }
    }

    suspend fun save(register: RegisterItemDto) {
        val entity = Item(register.name,register.count,register.stockId)
        dao.save(entity)
    }

}