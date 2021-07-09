package br.edu.unisep.stockcontrol.ui.liststockproduct.contract

import android.content.Context
import android.content.Intent
import androidx.activity.result.contract.ActivityResultContract
import br.edu.unisep.stockcontrol.domain.dto.Stock.StockDto
import br.edu.unisep.stockcontrol.ui.liststockproduct.ListStockProductsActivity

class ListStockProductsContract: ActivityResultContract<StockDto, Unit>() {

    override fun createIntent(context: Context, input: StockDto?)=
        Intent(context, ListStockProductsActivity::class.java)
            .putExtra(STOCK,input)

    override fun parseResult(resultCode: Int, intent: Intent?) = Unit

    companion object {
        const val STOCK = "stock"
    }
}
