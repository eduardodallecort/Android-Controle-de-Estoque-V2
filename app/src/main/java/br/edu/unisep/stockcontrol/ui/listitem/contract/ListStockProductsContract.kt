package br.edu.unisep.stockcontrol.ui.listitem.contract

import android.content.Context
import android.content.Intent
import androidx.activity.result.contract.ActivityResultContract
import br.edu.unisep.stockcontrol.dto.Stock.StockDto
import br.edu.unisep.stockcontrol.ui.listitem.ListStockProductsActivity

class ListStockProductsContract: ActivityResultContract<StockDto, Unit>() {

    override fun createIntent(context: Context, input: StockDto?)=
        Intent(context, ListStockProductsActivity::class.java)
            .putExtra(STOCK,input)

    override fun parseResult(resultCode: Int, intent: Intent?) = Unit

    companion object {
        const val STOCK = "stock"
    }
}
