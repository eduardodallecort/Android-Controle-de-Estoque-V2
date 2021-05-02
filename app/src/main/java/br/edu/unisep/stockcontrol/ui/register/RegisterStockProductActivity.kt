package br.edu.unisep.stockcontrol.ui.register

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.activity.viewModels
import br.edu.unisep.stockcontrol.databinding.ActivityRegisterStockProductBinding
import br.edu.unisep.stockcontrol.dto.Item.RegisterItemDto
import br.edu.unisep.stockcontrol.ui.listitem.ListStockProductsActivity
import br.edu.unisep.stockcontrol.ui.register.viewmodel.RegisterStockProductActivityViewModel

class RegisterStockProductActivity : AppCompatActivity() {

    private val viewModel by viewModels<RegisterStockProductActivityViewModel>()


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
        val id = getId()
        val intent = Intent(this,ListStockProductsActivity::class.java)
        intent.putExtra("STOCK_ID",id)

        startActivity(ListStockProductsActivity.createIntent(this, "Hello"))
    }

    private fun getId():Int{
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
        const val EXTRA_RESULT_ITEM = "extra-item"

        fun newIntent(context: Context) = Intent(context, RegisterStockProductActivity::class.java)
    }
}