package br.edu.unisep.stockcontrol.ui.register

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import br.edu.unisep.stockcontrol.data.entity.Stock
import br.edu.unisep.stockcontrol.databinding.ActivityRegisterStockBinding

class RegisterStockActivity : AppCompatActivity() {

    private val binding: ActivityRegisterStockBinding by lazy {
        ActivityRegisterStockBinding.inflate(layoutInflater)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        setupEvents()

    }

    private fun setupEvents() {
        binding.btnRegisterStock.setOnClickListener { save() }
    }

    private fun save() {
        val stock = Stock(binding.etStockName.text.toString())

        val intentResult = Intent()

        intentResult.putExtra(EXTRA_RESULT_STOCK, stock)



        setResult(RESULT_OK, intentResult)
        finish()


    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
            return true
        }

        return false
    }


    companion object {
        const val EXTRA_RESULT_STOCK = "extra-stock"

        fun newIntent(context: Context) = Intent(context, RegisterStockActivity::class.java)
    }

}