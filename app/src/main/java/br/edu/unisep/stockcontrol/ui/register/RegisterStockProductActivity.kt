package br.edu.unisep.stockcontrol.ui.register

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import br.edu.unisep.stockcontrol.R
import br.edu.unisep.stockcontrol.data.entity.Item
import br.edu.unisep.stockcontrol.databinding.ActivityRegisterStockProductBinding
import br.edu.unisep.stockcontrol.ui.list.ListStockProductsActivity
import br.edu.unisep.stockcontrol.ui.list.MainActivity

class RegisterStockProductActivity : AppCompatActivity() {

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
        val item = Item(binding.etProductName.text.toString(), binding.etProductAmount.text.toString().toInt())

        val intentResult = Intent()

        intentResult.putExtra(EXTRA_RESULT_ITEM, item)

        setResult(RESULT_OK, intentResult)

        finish()

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