package com.yazid.assessment3.ui.login

import androidx.lifecycle.ViewModelProvider
import androidx.fragment.app.Fragment
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.yazid.assessment3.databinding.FragmentLoginBinding

import com.yazid.assessment3.R
import com.yazid.assessment3.database.RoomDb
import com.yazid.assessment3.entity.User
import com.yazid.assessment3.repository.LoginRepository

class LoginFragment : Fragment() {

    private val viewModel: LoginViewModel by lazy {
        val db = RoomDb.getInstance(requireContext())
        val repo = LoginRepository(db.userDao)
        val factory = LoginViewModelFactory(repo)
        ViewModelProvider(this, factory)[LoginViewModel::class.java]
    }
    private var _binding: FragmentLoginBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initButton()
    }

    private fun initButton() {
        binding.btnLogin.setOnClickListener { login() }
        binding.toRegister.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }
    }

    private fun isLogin(user: User, password: String): Boolean {
        if (user.password != password) return false
        return true
    }

    private fun login() {
        val username = binding.inputUsernameLogin.text.toString()
        val password = binding.inputPasswordLogin.text.toString()
        if (checkInput(username, password)) {
            Toast.makeText(requireContext(), "username and password is required", Toast.LENGTH_LONG)
                .show()
            return
        }
        viewModel.getUserByUsername(username)
            .observe(requireActivity()) {
                if (it == null) {
                    Toast.makeText(requireContext(), "Account not found", Toast.LENGTH_LONG)
                        .show()
                    return@observe
                }

                val isLogin = isLogin(it, password)
                if (!isLogin) {
                    Toast.makeText(requireContext(), "Auth failed", Toast.LENGTH_LONG).show()
                    return@observe
                }

                Toast.makeText(requireContext(), "Auth success", Toast.LENGTH_LONG).show()
                findNavController().navigate(R.id.action_loginFragment_to_productFragment)
            }
    }

    private fun checkInput(username: String, password: String): Boolean {
        return (TextUtils.isEmpty(username) || TextUtils.isEmpty(password))
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}