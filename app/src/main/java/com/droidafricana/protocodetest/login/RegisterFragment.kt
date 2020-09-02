package com.droidafricana.protocodetest.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.droidafricana.protocodetest.R
import com.droidafricana.protocodetest.databinding.FragmentRegisterBinding
import com.droidafricana.protocodetest.utils.makeSnack
import com.droidafricana.protocodetest.utils.makeToast
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

    private fun observeRegistration() {
        loginViewModel.isRegisterSuccess.observe(viewLifecycleOwner, {
            if (it) {
                makeToast(getString(R.string.registration_successful))
                findNavController().navigate(
                    RegisterFragmentDirections.actionDestRegisterFragmentToDestLoginFragment()
                )
            } else {
                binding.root.makeSnack(getString(R.string.registration_failed))
            }
        })
    }

    private fun onLoginClicked() {
        binding.phoneSignInButton.setOnClickListener {
            findNavController().navigate(
                RegisterFragmentDirections.actionDestRegisterFragmentToDestLoginFragment()
            )
        }
    }

    private fun onRegisterClicked() {
        binding.registerButton.setOnClickListener {
            val phone = binding.registerPhone.text.toString().trim()
            val password = binding.loginPassword.text.toString().trim()
            val confirmPass = binding.loginConfirmPassword.text.toString().trim()
            loginViewModel.onRegisterClicked(phone, password, confirmPass)
            observeRegistration()
        }
    }
}
