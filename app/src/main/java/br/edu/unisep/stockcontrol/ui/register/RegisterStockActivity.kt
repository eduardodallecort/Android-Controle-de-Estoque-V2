package br.edu.unisep.stockcontrol.ui.register

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.activity.viewModels
import br.edu.unisep.stockcontrol.data.entity.Stock
import br.edu.unisep.stockcontrol.databinding.ActivityRegisterStockBinding
import br.edu.unisep.stockcontrol.dto.Stock.RegisterStockDto
import br.edu.unisep.stockcontrol.ui.liststock.MainActivity
import br.edu.unisep.stockcontrol.ui.register.viewmodel.RegisterStockViewModel

class RegisterStockActivity : AppCompatActivity() {
    private val viewModel by viewModels<RegisterStockViewModel>()

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
        binding.btnBackMain.setOnClickListener { backToMainActivity() }
    }

    private fun save() {
        val stock = RegisterStockDto(binding.etStockName.text.toString())
        viewModel.save(stock)
        backToMainActivity()

    }

    private fun backToMainActivity() {
        startActivity(MainActivity.createIntent(this, "Hello"))
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