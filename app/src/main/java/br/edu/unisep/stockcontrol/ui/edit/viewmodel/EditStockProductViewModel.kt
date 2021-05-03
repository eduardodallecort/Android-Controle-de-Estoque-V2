package br.edu.unisep.stockcontrol.ui.edit.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.edu.unisep.stockcontrol.dto.Item.RegisterItemDto
import br.edu.unisep.stockcontrol.repository.ItemRepository
import kotlinx.coroutines.launch

class EditStockProductViewModel : ViewModel() {



    private val repository = ItemRepository()

    fun update(item: RegisterItemDto) {
        viewModelScope.launch {
            repository.update(item)
        }
    }

}