package com.droidafricana.protocodetest.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.droidafricana.protocodetest.databinding.FragmentOrderSummaryBinding

class OrderSummaryFragment : Fragment() {

    private lateinit var binding: FragmentOrderSummaryBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOrderSummaryBinding.inflate(inflater, container, false)
        return binding.root
    }
}
