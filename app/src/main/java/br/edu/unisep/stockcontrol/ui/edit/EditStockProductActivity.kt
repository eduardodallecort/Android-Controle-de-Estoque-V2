package br.edu.unisep.stockcontrol.ui.edit

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import br.edu.unisep.stockcontrol.databinding.ActivityEditStockProductBinding
import br.edu.unisep.stockcontrol.dto.Item.ItemDto
import br.edu.unisep.stockcontrol.dto.Item.RegisterItemDto
import br.edu.unisep.stockcontrol.dto.Item.UpdateItemDto
import br.edu.unisep.stockcontrol.dto.Stock.StockDto
import br.edu.unisep.stockcontrol.ui.edit.viewmodel.EditStockProductViewModel
import br.edu.unisep.stockcontrol.ui.listitem.ListStockProductsActivity
import br.edu.unisep.stockcontrol.ui.listitem.adapter.ListStockProductsAdapter
import br.edu.unisep.stockcontrol.ui.listitem.viewmodel.ListStockProductsViewModel
import br.edu.unisep.stockcontrol.ui.register.RegisterStockProductActivity

class EditStockProductActivity : AppCompatActivity() {

    private val binding : ActivityEditStockProductBinding by lazy {
        ActivityEditStockProductBinding.inflate(layoutInflater)
    }

    private val viewModel by viewModels<EditStockProductViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        setupEvents()
        setupItem()
    }

    private fun setupEvents() {

        binding.btnEditBackListProducts.setOnClickListener { backToListStockProductsActivity() }
        binding.btnEditRegisterProduct.setOnClickListener { save() }
    }
    private fun setupItem() {

        viewModel.findById(getIdProcuct())

        binding.etEditProductName.setText(viewModel.item.name)
        binding.etEditProductAmount.setText(viewModel.item.count.toString())


    }


    private fun save() {
        val id = getIdProcuct()

        val item = UpdateItemDto(id,binding.etEditProductName.text.toString(),
                                    binding.etEditProductAmount.text.toString().toInt(),getId())

        viewModel.update(item)

       backToListStockProductsActivity()
    }

    private fun backToListStockProductsActivity() {
        val id = getId()
        val intent = Intent(this,ListStockProductsActivity::class.java)
        intent.putExtra("STOCK_ID",id)

        startActivity(intent)
    }

    private fun getId():Int {
        val bundle = intent.getExtras();
        val id = bundle!!.getInt("STOCK_ID")
        return id
    }
    private fun getIdProcuct():Int {
        val bundle = intent.getExtras();
        val id = bundle!!.getInt("PRODUCT_ID")
        return id
    }



    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
            return true
        }

        return false
    }

    companion object {

        fun newIntent(context: Context) = Intent(context, EditStockProductActivity::class.java)

        fun createIntent(context: Context, message: String) =
            Intent(context, EditStockProductActivity::class.java)

    }


}