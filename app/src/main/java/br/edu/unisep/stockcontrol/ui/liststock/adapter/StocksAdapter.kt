package br.edu.unisep.stockcontrol.ui.liststock.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.recyclerview.widget.RecyclerView
import br.edu.unisep.stockcontrol.databinding.ItemProductStockBinding
import br.edu.unisep.stockcontrol.databinding.ItemStockGroupBinding
import br.edu.unisep.stockcontrol.dto.Stock.StockDto

class StocksAdapter :RecyclerView.Adapter<StocksAdapter.StocksViewHolder>() {

    lateinit var onItemSelected: (StockDto) -> Unit

    var stocks = listOf<StockDto>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StocksViewHolder {
        val binding = ItemStockGroupBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return StocksViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StocksViewHolder, position: Int) {
        holder.bindItem(stocks[position],onItemSelected)

    }

    override fun getItemCount(): Int {
        return stocks.size
    }

    inner class StocksViewHolder(binding: ItemStockGroupBinding) : RecyclerView.ViewHolder(binding.root) {

        private val binding = ItemStockGroupBinding.bind(itemView)

        fun bindItem(stock: StockDto, onItemSelected: (StockDto) -> Unit) {
            binding.tvStockGroupName.text = stock.name
            binding.root.setOnClickListener { onItemSelected(stock) }
        }


    }
}
