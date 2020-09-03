package com.droidafricana.protocodetest.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.droidafricana.protocodetest.databinding.FragmentLpgProductsBinding
import com.droidafricana.protocodetest.models.LPGOrder
import kotlinx.android.synthetic.main.order_layout.view.*

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onForwardFabClicked()
    }

    private fun onForwardFabClicked() {
        binding.forwardFab.setOnClickListener {
            val smallOutright = binding.outrightLayout.small_cylinder.text.toString().toIntOrNull()
            val bigOutright = binding.outrightLayout.big_cylinder.text.toString().toIntOrNull()
            val smallRefill = binding.refillLayout.small_cylinder.text.toString().toIntOrNull()
            val bigRefill = binding.refillLayout.big_cylinder.text.toString().toIntOrNull()

            val order = LPGOrder(
                smallOutright = smallOutright,
                bigOutright = bigOutright,
                smallRefill = smallRefill,
                bigRefill = bigRefill
            )

            findNavController().navigate(
                LPGProductsFragmentDirections.actionDestLpgProductsFragmentToDestAccessoriesFragment()
            )
        }
    }
}
