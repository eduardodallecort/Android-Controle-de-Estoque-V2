package br.edu.unisep.stockcontrol

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.edu.unisep.stockcontrol.databinding.ActivityListStockProductBinding

class ListStockProductActivity : AppCompatActivity() {

    private val binding : ActivityListStockProductBinding by lazy {
        ActivityListStockProductBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val message = intent.getStringExtra(EXTRA_MESSAGE)


    }

    companion object {
        private const val EXTRA_MESSAGE = "message"

        fun createIntent(context: Context, message: String) =
            Intent(context, ListStockProductActivity::class.java)
                .putExtra(EXTRA_MESSAGE, message)
    }
}