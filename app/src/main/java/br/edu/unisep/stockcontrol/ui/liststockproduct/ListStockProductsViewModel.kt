package br.edu.unisep.stockcontrol.ui.liststockproduct


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.edu.unisep.stockcontrol.domain.dto.Item.ItemDto
import br.edu.unisep.stockcontrol.domain.dto.Stock.StockDto
import br.edu.unisep.stockcontrol.domain.dto.repository.ItemRepository
import kotlinx.coroutines.launch


class ListStockProductsViewModel(private val repository: ItemRepository) : ViewModel() {

    lateinit var stock: StockDto

    private val mstockItems:MutableLiveData<List<ItemDto>> = MutableLiveData()
    val stockItems: LiveData<List<ItemDto>>
        get()= mstockItems

    fun findItems() {
        viewModelScope.launch {
            val result = repository.findByStock(stock.Id)
            mstockItems.postValue(result)
        }
    }


}

