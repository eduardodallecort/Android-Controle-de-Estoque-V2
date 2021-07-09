package br.edu.unisep.stockcontrol.ui.registerstrockproduct

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.activity.viewModels
import br.edu.unisep.stockcontrol.databinding.ActivityRegisterStockProductBinding
import br.edu.unisep.stockcontrol.domain.dto.Item.RegisterItemDto
import br.edu.unisep.stockcontrol.ui.liststockproduct.ListStockProductsActivity
import br.edu.unisep.stockcontrol.ui.registerstock.RegisterStockViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class RegisterStockProductActivity : AppCompatActivity() {

    private val viewModel:RegisterStockProductActivityViewModel by viewModel()


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


        val item = RegisterItemDto(binding.etProductName.text.toString(),binding.etProductAmount.text.toString().toInt(),getId())

            viewModel.save(item)

        backToListStockProductsActivity()

    }

    private fun backToListStockProductsActivity() {
        startActivity(Intent(this,ListStockProductsActivity::class.java).putExtra("STOCK_ID",getId()))
        finish()
    }

    private fun getId():Int{
        return intent.getExtras()!!.getInt("STOCK_ID");
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