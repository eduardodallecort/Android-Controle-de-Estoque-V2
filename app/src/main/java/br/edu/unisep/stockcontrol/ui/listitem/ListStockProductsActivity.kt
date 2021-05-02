package br.edu.unisep.stockcontrol.ui.listitem

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import br.edu.unisep.stockcontrol.R
import br.edu.unisep.stockcontrol.data.entity.Item
import br.edu.unisep.stockcontrol.databinding.ActivityListStockProductsBinding
import br.edu.unisep.stockcontrol.dto.Stock.StockDto
import br.edu.unisep.stockcontrol.ui.listitem.adapter.ListStockProductsAdapter
import br.edu.unisep.stockcontrol.ui.listitem.contract.ListStockProductsContract.Companion.STOCK
import br.edu.unisep.stockcontrol.ui.listitem.viewmodel.ListStockProductsViewModel
import br.edu.unisep.stockcontrol.ui.liststock.ListStocksActivity
import br.edu.unisep.stockcontrol.ui.register.RegisterStockProductActivity
import br.edu.unisep.stockcontrol.ui.register.RegisterStockProductActivity.Companion.EXTRA_RESULT_ITEM

class ListStockProductsActivity : AppCompatActivity() {

    private lateinit var adapterList: ListStockProductsAdapter

    private val viewModel by viewModels<ListStockProductsViewModel>()

    val binding : ActivityListStockProductsBinding by lazy {
        ActivityListStockProductsBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initialize()


    }
    private fun initialize() {
        val stock = intent.getSerializableExtra(STOCK) as StockDto
        viewModel.stock=stock
        setupList()

        viewModel.findItems()
    }


    private fun setupList() {

        adapterList = ListStockProductsAdapter()

        binding.rvStockProducts.adapter = adapterList
        binding.rvStockProducts.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rvStockProducts.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))

        binding.btnBackMainActivity.setOnClickListener { backToMainActivity() }
    }



    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_CODE_NEW_PRODUCT && resultCode == RESULT_OK) {
            val item = data?.getSerializableExtra(EXTRA_RESULT_ITEM) as Item

        }
    }

    private fun openNewItem() {
        startActivityForResult(RegisterStockProductActivity.newIntent(this),
            REQUEST_CODE_NEW_PRODUCT
        )
    }

    private fun backToMainActivity() {
        startActivity(
            ListStocksActivity.createIntent(
                this,
                "Hello"
            )
        )
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_products, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (item.itemId == R.id.mnNewProduct) {
            openNewItem()
            return true
        }

        return false
    }


    companion object {

        fun createIntent(context: Context, message: String) =
            Intent(context, ListStockProductsActivity::class.java)


        const val REQUEST_CODE_NEW_PRODUCT = 1
    }
}