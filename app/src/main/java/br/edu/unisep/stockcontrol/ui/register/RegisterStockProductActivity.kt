package br.edu.unisep.stockcontrol.ui.register

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.activity.viewModels
import br.edu.unisep.stockcontrol.data.entity.Item
import br.edu.unisep.stockcontrol.databinding.ActivityRegisterStockProductBinding
import br.edu.unisep.stockcontrol.dto.Item.RegisterItemDto
import br.edu.unisep.stockcontrol.dto.Stock.StockDto
import br.edu.unisep.stockcontrol.ui.listitem.ListStockProductsActivity
import br.edu.unisep.stockcontrol.ui.listitem.contract.ListStockProductsContract
import br.edu.unisep.stockcontrol.ui.listitem.viewmodel.ListStockProductsViewModel

class RegisterStockProductActivity : AppCompatActivity() {

    private val viewModel by viewModels<ListStockProductsViewModel>()


    private val binding: ActivityRegisterStockProductBinding by lazy {
        ActivityRegisterStockProductBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        setupEvents()

    }

    private fun setupEvents() {
        binding.btnRegisterProduct.setOnClickListener { save() }
        binding.btnBackListProducts.setOnClickListener { backToListStockProductsActivity() }

    }

    private fun save() {
        val stock = intent.getSerializableExtra(ListStockProductsContract.STOCK) as StockDto
        viewModel.stock=stock
        val item = RegisterItemDto(binding.etProductName.text.toString(),binding.etProductAmount.text.toString().toInt(),1)

            viewModel.save(item)

    }

    private fun backToListStockProductsActivity() {
        startActivity(ListStockProductsActivity.createIntent(this, "Hello"))
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
            return true
        }

        return false
    }


    companion object {
        const val EXTRA_RESULT_ITEM = "extra-item"

        fun newIntent(context: Context) = Intent(context, RegisterStockProductActivity::class.java)
    }
}