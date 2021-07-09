package br.edu.unisep.stockcontrol.ui.editstockproduct

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import br.edu.unisep.stockcontrol.R
import br.edu.unisep.stockcontrol.databinding.ActivityEditStockProductBinding
import br.edu.unisep.stockcontrol.domain.dto.Item.ItemDto
import br.edu.unisep.stockcontrol.domain.dto.Item.UpdateItemDto
import br.edu.unisep.stockcontrol.ui.liststockproduct.ListStockProductsActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class EditStockProductActivity : AppCompatActivity() {

    private val binding : ActivityEditStockProductBinding by lazy {
        ActivityEditStockProductBinding.inflate(layoutInflater)
    }

    private val viewModel : EditStockProductViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        setupEvents()
        setupItem()
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.closeButton) {
            backToListStockProductsActivity()
            return true
        }

        return false
    }

    private fun setupEvents() {

        binding.btnEditBackListProducts.setOnClickListener { backToListStockProductsActivity() }
        binding.btnEditRegisterProduct.setOnClickListener { save() }
        binding.btnAdd.setOnClickListener { add() }
        binding.btnMinus.setOnClickListener { minus() }
    }
    private fun setupItem() {
        viewModel.item= getProcuct()

        binding.etEditProductName.setText(viewModel.item.name)
        binding.etEditProductAmount.setText(viewModel.item.count.toString())


    }


    private fun save() {
        viewModel.update(getUpdateItemDto(getProcuct()))
        backToListStockProductsActivity()
    }

    private fun backToListStockProductsActivity() {
        startActivity(Intent(this,ListStockProductsActivity::class.java).putExtra("STOCK_ID",getStockId()))
    }

    private fun getStockId():Int { return intent.getExtras()!!.getInt("STOCK_ID") }
    private fun getProcuct():ItemDto { return intent.getExtras()!!.get("PRODUCT") as ItemDto }
    private fun getUpdateItemDto(item: ItemDto):UpdateItemDto{
        return UpdateItemDto(item.id,
            binding.etEditProductName.text.toString(),
            binding.etEditProductAmount.text.toString().toInt(),
            getStockId())
    }

    private fun add(){
        val amount = binding.etEditProductAmount.text.toString().toInt()
        binding.etEditProductAmount.setText((amount+1).toString()) }
    private fun minus(){
        val amount = binding.etEditProductAmount.text.toString().toInt()
        binding.etEditProductAmount.setText((amount-1)).toString() }







}