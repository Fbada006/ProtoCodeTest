package com.droidafricana.protocodetest.utils

import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.droidafricana.protocodetest.models.Accessory
import com.droidafricana.protocodetest.models.LPGOrder
import com.droidafricana.protocodetest.models.Order
import com.droidafricana.protocodetest.models.OrderItem
import com.google.android.material.snackbar.Snackbar

fun View.makeSnack(message: String) {
    Snackbar.make(
        this,
        message,
        Snackbar.LENGTH_LONG
    )
        .show()
}

fun Fragment.makeToast(message: String) {
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
}

fun Accessory.toOrder(lpgOrder: LPGOrder) = Order(
    smallOutright = lpgOrder.smallOutright,
    bigOutright = lpgOrder.bigOutright,
    smallRefill = lpgOrder.smallRefill,
    bigRefill = lpgOrder.bigRefill,
    smallMeko = this.smallMeko,
    bigMeko = this.bigMeko,
    cooker = this.cooker,
    regulator = this.regulator
)

fun Order.generateOrderList() = listOf(
    OrderItem("6KG Outright", this.smallOutright ?: 0, this.smallOutright?.times(1600) ?: 0),
    OrderItem("13KG Outright", this.bigOutright ?: 0, this.bigOutright?.times(1900) ?: 0),
    OrderItem("6KG Refill", this.smallRefill ?: 0, this.smallRefill?.times(600) ?: 0),
    OrderItem("13KG Refill", this.bigRefill ?: 0, this.bigRefill?.times(900) ?: 0),
    OrderItem("6KG Meko", this.smallMeko ?: 0, this.smallMeko?.times(400) ?: 0),
    OrderItem("13KG Meko", this.bigMeko ?: 0, this.bigMeko?.times(700) ?: 0),
    OrderItem("Cooker", this.cooker ?: 0, this.cooker?.times(1500) ?: 0),
    OrderItem("Regulator", this.regulator ?: 0, this.regulator?.times(300) ?: 0),
).filter { it.totalPrice != 0 }
