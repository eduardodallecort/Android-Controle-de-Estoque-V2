package br.edu.unisep.stockcontrol.ui.editstockproduct

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.edu.unisep.stockcontrol.domain.dto.Item.ItemDto
import br.edu.unisep.stockcontrol.domain.dto.Item.UpdateItemDto
import br.edu.unisep.stockcontrol.domain.dto.repository.ItemRepository
import kotlinx.coroutines.launch

class EditStockProductViewModel(private val repository: ItemRepository) : ViewModel() {

    lateinit var item : ItemDto


    fun update(item: UpdateItemDto) {
        viewModelScope.launch {
            repository.update(item)
        }
    }

    }
