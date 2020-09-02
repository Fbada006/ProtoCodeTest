package com.droidafricana.protocodetest.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.droidafricana.protocodetest.databinding.FragmentLoginBinding
import com.google.android.material.snackbar.Snackbar
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
        onLoginClicked()
        onRegisterClicked()
        observeLogin()
    }

    private fun observeLogin() {
        loginViewModel.navigateToMainScreen.observe(viewLifecycleOwner, {
            if (it.getContentIfNotHandled()!!) {
                // navigate
            } else {
                Snackbar.make(
                    binding.root,
                    "Login failed. Please retry",
                    Snackbar.LENGTH_LONG
                )
                    .show()
            }
        })
    }

    private fun onLoginClicked() {
        val phone = binding.loginPhone.text.toString()
        val password = binding.loginPassword.text.toString()
        binding.phoneSignInButton.setOnClickListener {
            loginViewModel.onLoginClicked(
                phone,
                password
            )
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
