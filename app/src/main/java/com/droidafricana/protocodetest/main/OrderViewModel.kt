package com.droidafricana.protocodetest.main

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.droidafricana.protocodetest.models.Order
import com.droidafricana.protocodetest.utils.generateOrderList

class OrderViewModel @ViewModelInject constructor() : ViewModel() {

    private val _orderTotal = MutableLiveData(0)

    val orderTotal: LiveData<Int>
        get() = _orderTotal

    fun generateOrderTotal(order: Order) {
        val orderItems = order.generateOrderList()
        _orderTotal.value = orderItems.map {
            it.totalPrice
        }.sum()
    }
}