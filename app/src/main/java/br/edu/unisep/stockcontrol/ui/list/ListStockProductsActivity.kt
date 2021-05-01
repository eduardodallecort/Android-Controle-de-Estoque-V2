package br.edu.unisep.stockcontrol.ui.list

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.edu.unisep.stockcontrol.databinding.ActivityListStockProductsBinding

class ListStockProductsActivity : AppCompatActivity() {

    val binding : ActivityListStockProductsBinding by lazy {
        ActivityListStockProductsBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

    companion object {

        fun createIntent(context: Context, message: String) =
            Intent(context, ListStockProductsActivity::class.java)

    }
}