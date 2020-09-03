package com.droidafricana.protocodetest.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.droidafricana.protocodetest.R
import com.droidafricana.protocodetest.databinding.FragmentOrderSummaryBinding
import com.droidafricana.protocodetest.utils.generateOrderList
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OrderSummaryFragment : Fragment() {

    private lateinit var binding: FragmentOrderSummaryBinding
    private val args: OrderSummaryFragmentArgs by navArgs()
    private val viewModel: OrderViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOrderSummaryBinding.inflate(inflater, container, false)
        viewModel.generateOrderTotal(args.order)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.orderTotal.observe(viewLifecycleOwner, {
            binding.orderSummary.text = getString(R.string.order_total, it)
        })

        val orderAdapter = OrderSummaryAdapter(requireContext())

        binding.ordersList.apply {
            adapter = orderAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }

        orderAdapter.submitList(args.order.generateOrderList())

    }
}
