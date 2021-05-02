package br.edu.unisep.stockcontrol.ui.register.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.edu.unisep.stockcontrol.dto.Item.ItemDto
import br.edu.unisep.stockcontrol.dto.Item.RegisterItemDto
import br.edu.unisep.stockcontrol.dto.Stock.StockDto
import br.edu.unisep.stockcontrol.repository.ItemRepository
import kotlinx.coroutines.launch

class RegisterStockProductActivityViewModel : ViewModel() {



    var registerResult = MutableLiveData<Unit>()

    private val repository = ItemRepository()


    fun save(item: RegisterItemDto) {

        val items = RegisterItemDto(item.name,item.count,item.stockId)
        viewModelScope.launch {
            repository.save(items)
            registerResult.postValue(Unit)
        }

    }
}