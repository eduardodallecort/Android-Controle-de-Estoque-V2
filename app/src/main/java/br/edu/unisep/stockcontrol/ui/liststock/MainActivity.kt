package br.edu.unisep.stockcontrol.ui.liststock

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.observe
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import br.edu.unisep.stockcontrol.R
import br.edu.unisep.stockcontrol.data.entity.Stock
import br.edu.unisep.stockcontrol.databinding.ActivityMainBinding
import br.edu.unisep.stockcontrol.dto.Stock.StockDto
import br.edu.unisep.stockcontrol.ui.listitem.ListStockProductsActivity
import br.edu.unisep.stockcontrol.ui.listitem.contract.ListStockProductsContract
import br.edu.unisep.stockcontrol.ui.liststock.adapter.StocksAdapter
import br.edu.unisep.stockcontrol.ui.liststock.viewmodel.ListStocksViewModel
import br.edu.unisep.stockcontrol.ui.register.RegisterStockActivity
import br.edu.unisep.stockcontrol.ui.register.RegisterStockActivity.Companion.EXTRA_RESULT_STOCK

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: StocksAdapter

    private val viewModel: ListStocksViewModel by viewModels()


    private val binding : ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setupList()
        setupEvents()


    }

    private fun setupList() {

        adapter = StocksAdapter()
        adapter.onItemSelected = ::onStockSelected


        binding.rvStockGroups.adapter = adapter
        binding.rvStockGroups.layoutManager = LinearLayoutManager(this)
        binding.rvStockGroups.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))


    }
    private fun setupEvents() {
        viewModel.listStocks.observe(this) { stock ->
            this.adapter.stocks = stock
        }

        viewModel.list()
    }
    private fun onStockSelected(stock: StockDto) {
        openNewStock.launch(stock)

    }



    private val openNewStock  = registerForActivityResult(ListStockProductsContract()) {
       viewModel.list()
    }



    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_stocks, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (item.itemId == R.id.mnNewStock) {
            registerResult.launch(RegisterStockActivity.newIntent(this))
            return true
        }

        return false
    }

    private val registerResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == RESULT_OK) {
            viewModel.list()
        }
    }

    companion object {

        fun createIntent(context: Context, message: String) =
            Intent(context, MainActivity::class.java)



        const val REQUEST_CODE_NEW_STOCK = 1
    }

    
}