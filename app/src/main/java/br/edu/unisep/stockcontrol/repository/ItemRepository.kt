package br.edu.unisep.stockcontrol.repository

import androidx.room.PrimaryKey
import br.edu.unisep.stockcontrol.data.db.StockDb
import br.edu.unisep.stockcontrol.data.entity.Item
import br.edu.unisep.stockcontrol.dto.Item.ItemDto
import br.edu.unisep.stockcontrol.dto.Item.RegisterItemDto
import br.edu.unisep.stockcontrol.dto.Item.UpdateItemDto

class ItemRepository {

    private val dao = StockDb.instance.itemDao()

    suspend fun findByStock(stockId: Int): List<ItemDto> {
        val itens = dao.findAllStock(stockId)

        return itens.map { item ->
            ItemDto(item.id ?: 0,
                        item.name,
                        item.count)
        }
    }

    suspend fun findById(itemId: Int): ItemDto {
        val item = dao.findById(itemId)

        return ItemDto(item.id ?: 0,
            item.name,
            item.count)
        }


    suspend fun save(register: RegisterItemDto) {
        val entity = Item(null,register.name,register.count,register.stockId)
        dao.save(entity)
    }

    suspend fun update(item: UpdateItemDto) {
        val entity = Item(item.id,item.name, item.count,item.stockId)
        dao.update(entity)
    }

}