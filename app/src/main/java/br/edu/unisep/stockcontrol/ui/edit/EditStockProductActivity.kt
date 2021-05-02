package br.edu.unisep.stockcontrol.ui.edit

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import br.edu.unisep.stockcontrol.databinding.ActivityEditStockProductBinding
import br.edu.unisep.stockcontrol.ui.listitem.ListStockProductsActivity

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

        fun newIntent(context: Context) = Intent(context, EditStockProductActivity::class.java)

    }


}