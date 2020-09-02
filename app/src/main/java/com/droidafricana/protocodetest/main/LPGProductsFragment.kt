package com.droidafricana.protocodetest.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.droidafricana.protocodetest.databinding.FragmentLpgProductsBinding

class LPGProductsFragment : Fragment() {

    private lateinit var binding: FragmentLpgProductsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLpgProductsBinding.inflate(inflater, container, false)
        return binding.root
    }
}