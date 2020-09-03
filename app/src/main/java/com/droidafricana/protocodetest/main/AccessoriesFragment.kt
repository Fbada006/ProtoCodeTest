package com.droidafricana.protocodetest.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.droidafricana.protocodetest.databinding.FragmentAccessoriesBinding
import com.droidafricana.protocodetest.models.Accessory
import com.droidafricana.protocodetest.utils.toOrder

class AccessoriesFragment : Fragment() {

    private lateinit var binding: FragmentAccessoriesBinding
    private val args: AccessoriesFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAccessoriesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onForwardFabClicked()
    }

    private fun onForwardFabClicked() {
        binding.orderFab.setOnClickListener {
            val smallMeko = binding.smallGrill.text.toString().toIntOrNull()
            val bigMeko = binding.bigGrill.text.toString().toIntOrNull()
            val cooker = binding.cooker.text.toString().toIntOrNull()
            val regulator = binding.regulator.toString().toIntOrNull()

            val order = Accessory(
                smallMeko = smallMeko,
                bigMeko = bigMeko,
                cooker = cooker,
                regulator = regulator
            ).toOrder(args.order)

            findNavController().navigate(
                AccessoriesFragmentDirections.actionDestAccessoriesFragmentToDestOrderSummaryFragment(
                    order
                )
            )
        }
    }
}
