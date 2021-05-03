package br.edu.unisep.stockcontrol.ui.edit

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import br.edu.unisep.stockcontrol.databinding.ActivityEditStockProductBinding
import br.edu.unisep.stockcontrol.dto.Item.RegisterItemDto
import br.edu.unisep.stockcontrol.dto.Stock.StockDto
import br.edu.unisep.stockcontrol.ui.listitem.ListStockProductsActivity
import br.edu.unisep.stockcontrol.ui.register.RegisterStockProductActivity

class EditStockProductActivity : AppCompatActivity() {

    private val binding : ActivityEditStockProductBinding by lazy {
        ActivityEditStockProductBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        setupEvents()
    }

    private fun setupEvents() {

        binding.btnEditBackListProducts.setOnClickListener { backToListStockProductsActivity() }
        binding.btnEditRegisterProduct.setOnClickListener { save() }
    }

    private fun save() {

        val item = RegisterItemDto(binding.etEditProductName.text.toString(),
                                    binding.etEditProductAmount.text.toString().toInt(),
                                    getId())

        val intent = Intent(this, ListStockProductsActivity::class.java)
        val bundle = Bundle()
        bundle.putInt("STOCK_ID",item.stockId)
        intent.putExtras(bundle)
        startActivity(intent)
    }

    private fun backToListStockProductsActivity() {
        startActivity(ListStockProductsActivity.createIntent(this, "Hello"))
    }

    private fun getId():Int {
        val bundle = intent.getExtras();
        val id = bundle!!.getInt("STOCK_ID")
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

    }


}