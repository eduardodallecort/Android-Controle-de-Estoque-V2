package br.edu.unisep.stockcontrol.ui.list.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.recyclerview.widget.RecyclerView
import br.edu.unisep.stockcontrol.data.entity.Stock
import br.edu.unisep.stockcontrol.databinding.ItemStockGroupBinding

class StocksAdapter:
    RecyclerView.Adapter<StocksAdapter.StocksViewHolder>(){

    var stocks = listOf<Stock>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StocksViewHolder {
        val binding = ItemStockGroupBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return StocksViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StocksViewHolder, position: Int) {
        holder.bindItem(stocks[position])
        holder.btnAccessStock.setOnClickListener {  }
    }

    override fun getItemCount(): Int {
        return stocks.size
    }

    inner class StocksViewHolder(private val binding: ItemStockGroupBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bindItem(stock: Stock) {
            binding.tvStockGroupName.text = stock.name
        }

        val btnAccessStock: ImageButton
            get() = binding.btnAcessStock


    }
}