package com.droidafricana.protocodetest.main

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.droidafricana.protocodetest.R
import com.droidafricana.protocodetest.models.OrderItem
import kotlinx.android.synthetic.main.order_item.view.*

class OrderSummaryAdapter(private val context: Context) :
    ListAdapter<OrderItem, OrderSummaryAdapter.OrderItemsViewHolder>(OrderItemsDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderItemsViewHolder {
        return OrderItemsViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: OrderItemsViewHolder, position: Int) {
        holder.bind(getItem(position), context)
    }

    class OrderItemsViewHolder constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: OrderItem, context: Context) = with(itemView) {
            order_name.text = item.name
            order_quantity.text = context.getString(R.string.order_quantity, item.quantity)
            order_price.text = context.getString(R.string.item_total, item.totalPrice)
        }

        companion object {
            fun from(parent: ViewGroup): OrderItemsViewHolder {
                val view =
                    LayoutInflater.from(parent.context).inflate(R.layout.order_item, parent, false)
                return OrderItemsViewHolder(view)
            }
        }
    }
}

class OrderItemsDiffCallback : DiffUtil.ItemCallback<OrderItem>() {
    override fun areItemsTheSame(oldItem: OrderItem, newItem: OrderItem): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: OrderItem, newItem: OrderItem): Boolean {
        return oldItem == newItem
    }
}
