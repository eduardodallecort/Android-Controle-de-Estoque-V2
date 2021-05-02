package br.edu.unisep.stockcontrol.ui.register.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.edu.unisep.stockcontrol.dto.Stock.RegisterStockDto
import br.edu.unisep.stockcontrol.repository.StockRepository
import kotlinx.coroutines.launch

class RegisterStockViewModel : ViewModel() {

    private val repository = StockRepository()

    val onSaveComplete = MutableLiveData<Unit>()

    fun save(stock: RegisterStockDto) {
        viewModelScope.launch {
            repository.save(stock)
            onSaveComplete.postValue(Unit)
        }
    }
}