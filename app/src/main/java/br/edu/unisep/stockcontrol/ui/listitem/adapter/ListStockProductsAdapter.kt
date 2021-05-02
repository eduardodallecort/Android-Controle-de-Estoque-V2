package br.edu.unisep.stockcontrol.ui.listitem.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.recyclerview.widget.RecyclerView
import br.edu.unisep.stockcontrol.data.entity.Item
import br.edu.unisep.stockcontrol.databinding.ItemProductStockBinding
import br.edu.unisep.stockcontrol.dto.Item.ItemDto

class ListStockProductsAdapter:
    RecyclerView.Adapter<ListStockProductsAdapter.StockProductsViewHolder>(){

    var items = listOf<ItemDto>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StockProductsViewHolder {
        val binding = ItemProductStockBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return StockProductsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StockProductsViewHolder, position: Int) {
        holder.bindItem(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class StockProductsViewHolder(private val binding: ItemProductStockBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bindItem(item: ItemDto) {
            binding.tvProductStockName.text = item.name
            binding.tvProductStockAmount.text = item.count.toString()
        }

        val btnEditItem: ImageButton
            get() = binding.btnEditProduct

    }

}