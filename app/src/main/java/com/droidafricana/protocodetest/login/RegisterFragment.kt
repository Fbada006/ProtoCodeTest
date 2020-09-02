package com.droidafricana.protocodetest.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.droidafricana.protocodetest.databinding.FragmentRegisterBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterFragment : Fragment() {

    private lateinit var binding: FragmentRegisterBinding
    private val loginViewModel: LoginViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onLoginClicked()
        onRegisterClicked()
    }

    private fun onLoginClicked() {
        binding.phoneSignInButton.setOnClickListener {
            findNavController().navigate(
                RegisterFragmentDirections.actionDestRegisterFragmentToDestLoginFragment()
            )
        }
    }

    private fun onRegisterClicked() {
        binding.registerButton.setOnClickListener { }
    }
}