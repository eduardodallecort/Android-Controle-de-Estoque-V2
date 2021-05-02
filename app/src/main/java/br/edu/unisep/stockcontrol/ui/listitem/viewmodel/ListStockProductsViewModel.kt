package br.edu.unisep.stockcontrol.ui.listitem.viewmodel


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.edu.unisep.stockcontrol.data.entity.Item
import br.edu.unisep.stockcontrol.dto.Item.ItemDto
import br.edu.unisep.stockcontrol.dto.Item.RegisterItemDto
import br.edu.unisep.stockcontrol.dto.Stock.RegisterStockDto
import br.edu.unisep.stockcontrol.dto.Stock.StockDto
import br.edu.unisep.stockcontrol.repository.ItemRepository
import kotlinx.coroutines.launch
import java.time.LocalDateTime
import java.time.temporal.ChronoUnit


class ListStockProductsViewModel : ViewModel() {

    lateinit var stock: StockDto

    val stockItems = MutableLiveData<List<ItemDto>>()

    private val repository = ItemRepository()

    fun findItems() {
        viewModelScope.launch {
            val result = repository.findByStock(stock.Id)
            stockItems.postValue(result)
        }
    }


}

