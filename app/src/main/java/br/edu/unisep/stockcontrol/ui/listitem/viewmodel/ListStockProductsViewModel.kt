package br.edu.unisep.stockcontrol.ui.listitem.viewmodel


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.edu.unisep.stockcontrol.data.entity.Item


class ListStockProductsViewModel : ViewModel() {

    private val allProducts = mutableListOf<Item>()

    val items = MutableLiveData<List<Item>>()

    fun add(item: Item) {
        allProducts.add(item)
        items.postValue(allProducts)
    }


}