package br.edu.unisep.stockcontrol.ui.liststock

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.edu.unisep.stockcontrol.domain.dto.Stock.StockDto
import br.edu.unisep.stockcontrol.domain.dto.repository.ItemRepository
import br.edu.unisep.stockcontrol.domain.dto.repository.StockRepository
import kotlinx.coroutines.launch

class ListStocksViewModel(private val repository: StockRepository) : ViewModel() {




    val mlistStocks : MutableLiveData<List<StockDto>> = MutableLiveData()
    val listStocks : LiveData<List<StockDto>>
    get() = mlistStocks

    fun list() {
        viewModelScope.launch {
            val result = repository.findAll()
            mlistStocks.postValue(result)
        }



}
}