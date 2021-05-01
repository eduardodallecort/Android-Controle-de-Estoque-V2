package br.edu.unisep.stockcontrol.ui.list

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import br.edu.unisep.stockcontrol.ListStockProductActivity
import br.edu.unisep.stockcontrol.R
import br.edu.unisep.stockcontrol.data.entity.Stock
import br.edu.unisep.stockcontrol.databinding.ActivityMainBinding
import br.edu.unisep.stockcontrol.ui.list.adapter.StocksAdapter
import br.edu.unisep.stockcontrol.ui.list.viewmodel.ListStocksViewModel
import br.edu.unisep.stockcontrol.ui.register.RegisterStockActivity
import br.edu.unisep.stockcontrol.ui.register.RegisterStockActivity.Companion.EXTRA_RESULT_STOCK

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: StocksAdapter

    private val viewModel by viewModels<ListStocksViewModel>()


    private val binding : ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setupList()

        viewModel.stocks.observe(this) { stocks ->
            adapter.stocks = stocks
        }

    }

    private fun setupList() {

        adapter = StocksAdapter()

        binding.rvStockGroups.adapter = adapter
        binding.rvStockGroups.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rvStockGroups.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))


    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_CODE_NEW_STOCK && resultCode == RESULT_OK) {
            val stock = data?.getSerializableExtra(EXTRA_RESULT_STOCK) as Stock

            viewModel.add(stock)
        }
    }

    private fun openNewStock() {
        startActivityForResult(RegisterStockActivity.newIntent(this), REQUEST_CODE_NEW_STOCK)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_stocks, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (item.itemId == R.id.mnNewExpense) {
            openNewStock()
            return true
        }

        return false
    }

    companion object {
        const val REQUEST_CODE_NEW_STOCK = 1
    }

    
}