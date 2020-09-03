package com.droidafricana.protocodetest.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.droidafricana.protocodetest.databinding.FragmentLpgProductsBinding
import com.droidafricana.protocodetest.utils.makeToast
import kotlinx.android.synthetic.main.order_layout.view.*

class LPGProductsFragment : Fragment() {

    private lateinit var binding: FragmentLpgProductsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLpgProductsBinding.inflate(inflater, container, false)

        binding.forwardFab.setOnClickListener {
            val sixOutright = binding.outrightLayout.et_6.text.toString()
            val sixRefill = binding.refillLayout.et_6.text.toString()
            makeToast("Six outright is $sixOutright and refill is $sixRefill")
        }
        return binding.root
    }
}
