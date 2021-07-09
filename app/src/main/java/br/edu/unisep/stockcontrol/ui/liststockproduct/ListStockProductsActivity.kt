package br.edu.unisep.stockcontrol.ui.liststockproduct

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.lifecycle.observe
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import br.edu.unisep.stockcontrol.R
import br.edu.unisep.stockcontrol.domain.dto.data.entity.Item
import br.edu.unisep.stockcontrol.databinding.ActivityListStockProductsBinding
import br.edu.unisep.stockcontrol.domain.dto.Stock.StockDto
import br.edu.unisep.stockcontrol.ui.editstockproduct.EditStockProductActivity
import br.edu.unisep.stockcontrol.ui.liststockproduct.contract.ListStockProductsContract.Companion.STOCK
import br.edu.unisep.stockcontrol.ui.liststock.ListStocksActivity
import br.edu.unisep.stockcontrol.ui.registerstrockproduct.RegisterStockProductActivity
import br.edu.unisep.stockcontrol.ui.registerstrockproduct.RegisterStockProductActivity.Companion.EXTRA_RESULT_ITEM
import org.koin.androidx.viewmodel.ext.android.viewModel

class ListStockProductsActivity : AppCompatActivity() {

    private lateinit var adapterList: ListStockProductsAdapter

    private val viewModel :ListStockProductsViewModel by viewModel()

    val binding : ActivityListStockProductsBinding by lazy {
        ActivityListStockProductsBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

    override fun onStart() {
        super.onStart()
        initialize()
    }

    override fun onResume() {
        super.onResume()
        initialize()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_products, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (item.itemId == R.id.mnNewProduct) {
            openNewItem(viewModel.stock)
            return true
        }

        return false
    }

    private fun initialize() {
        try{
        val stock = intent.getSerializableExtra(STOCK) as StockDto
            viewModel.stock=stock}
        catch (e:Exception)
    {
        val bundle = intent.extras
        val stock = StockDto(bundle!!.getInt("STOCK_ID"), "")
        viewModel.stock = stock
    }

        setupList()
        setupEvents()

    }

    private fun openNewItem(stock : StockDto) {
        startActivity(Intent(this, RegisterStockProductActivity::class.java).putExtra("STOCK_ID",stock.Id))
    }


    private fun setupEvents() {
        viewModel.stockItems.observe(this) { item -> this.adapterList.items = item }
        viewModel.findItems()
    }

    private fun setupList() {
        adapterList = ListStockProductsAdapter(::goEditProduct)

        binding.rvStockProducts.adapter = adapterList
        binding.rvStockProducts.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.btnBackMainActivity.setOnClickListener { backToMainActivity() }
    }

    private fun goEditProduct(position: Int) {
        val item = viewModel.stockItems.value?.get(position)

        val intent = Intent(this,EditStockProductActivity::class.java).putExtra("PRODUCT",item)
        intent.putExtra("STOCK_ID",viewModel.stock.Id)
        startActivity(intent)
        finish()
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 1 && resultCode == RESULT_OK) {
            val item = data?.getSerializableExtra(EXTRA_RESULT_ITEM) as Item

        }
    }

    private fun backToMainActivity() {
        startActivity(ListStocksActivity.createIntent(this,"go"))
        finish()
    }



}