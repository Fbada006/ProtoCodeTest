package com.droidafricana.protocodetest.main

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.droidafricana.protocodetest.models.Order
import com.droidafricana.protocodetest.service.OrderApi
import com.droidafricana.protocodetest.utils.generateOrderList
import kotlinx.coroutines.launch

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

    fun sendFakePostRequest(order: Order) {
        viewModelScope.launch {
            OrderApi.orderRetrofitService.saveOrder()
            // Do more stuff here
        }
    }

    fun getOrders() {
        viewModelScope.launch {
            OrderApi.orderRetrofitService.getOrdersAsync()
            // Do stuff with the data here
        }
    }
}