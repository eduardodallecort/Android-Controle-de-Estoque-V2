package br.edu.unisep.stockcontrol.ui.registerstock

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.edu.unisep.stockcontrol.domain.dto.Stock.RegisterStockDto
import br.edu.unisep.stockcontrol.domain.dto.repository.StockRepository
import kotlinx.coroutines.launch

class RegisterStockViewModel(private val repository: StockRepository) : ViewModel() {


    val onSaveComplete = MutableLiveData<Unit>()

    fun save(stock: RegisterStockDto) {
        viewModelScope.launch {
            repository.save(stock)
            onSaveComplete.postValue(Unit)
        }
    }
}