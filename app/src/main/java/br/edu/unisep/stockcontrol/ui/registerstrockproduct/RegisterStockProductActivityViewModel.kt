package br.edu.unisep.stockcontrol.ui.registerstrockproduct

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.edu.unisep.stockcontrol.domain.dto.Item.RegisterItemDto
import br.edu.unisep.stockcontrol.domain.dto.repository.ItemRepository
import kotlinx.coroutines.launch

class  RegisterStockProductActivityViewModel(private val repository: ItemRepository) : ViewModel() {






    fun save(item: RegisterItemDto) {

        val items = RegisterItemDto(item.name,item.count,item.stockId)
        viewModelScope.launch {
            repository.save(items)
        }

    }
}