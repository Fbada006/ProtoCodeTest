package com.droidafricana.protocodetest.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.droidafricana.protocodetest.R
import com.droidafricana.protocodetest.databinding.FragmentLoginBinding
import com.droidafricana.protocodetest.utils.makeSnack
import com.droidafricana.protocodetest.utils.makeToast
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding
    private val loginViewModel: LoginViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onRegisterClicked()
        onLoginClicked()
    }

    private fun observeLogin() {
        loginViewModel.navigateToMainScreen.observe(viewLifecycleOwner, {
            if (it) {
                makeToast("Login successful!")
                findNavController().navigate(
                    LoginFragmentDirections.actionDestLoginFragmentToDestLpgProductsFragment()
                )
            } else {
                binding.root.makeSnack(getString(R.string.login_failed))
            }
        })
    }

    private fun onLoginClicked() {
        binding.phoneSignInButton.setOnClickListener {
            val phone = binding.loginPhone.text.toString().trim()
            val password = binding.loginPassword.text.toString().trim()
            loginViewModel.onLoginClicked(phone, password)
            observeLogin()
        }
    }

    private fun onRegisterClicked() {
        binding.registerButton.setOnClickListener {
            findNavController().navigate(
                LoginFragmentDirections.actionDestLoginFragmentToDestRegisterFragment()
            )
        }
    }
}
