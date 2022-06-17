package com.yazid.assessment3.ui.register

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.yazid.assessment3.R
import com.yazid.assessment3.database.RoomDb
import com.yazid.assessment3.databinding.FragmentRegisterBinding
import com.yazid.assessment3.entity.User
import com.yazid.assessment3.repository.LoginRepository
import com.yazid.assessment3.ui.login.LoginViewModel
import com.yazid.assessment3.ui.login.LoginViewModelFactory

class RegisterFragment : Fragment() {

    private val viewModel: LoginViewModel by lazy {
        val db = RoomDb.getInstance(requireContext())
        val repo = LoginRepository(db.userDao)
        val factory = LoginViewModelFactory(repo)
        ViewModelProvider(this, factory)[LoginViewModel::class.java]
    }
    private var _binding: FragmentRegisterBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initButton()
    }

    private fun initButton() {
        binding.btnRegister.setOnClickListener { register() }
        binding.toLogin.setOnClickListener {
            findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
        }
    }

    private fun checkInput(name: String, username: String, password: String): Boolean {
        return (TextUtils.isEmpty(name) || TextUtils.isEmpty(username) || TextUtils.isEmpty(password))
    }

    private fun register() {
        val name = binding.inputNameRegister.text.toString()
        val username = binding.inputUsernameRegister.text.toString()
        val password = binding.inputPasswordRegister.text.toString()

        if (checkInput(name, username, password)) {
            Toast.makeText(requireContext(), "Register not success", Toast.LENGTH_LONG).show()
            return
        }

        viewModel.getUserByUsername(username).observe(requireActivity()) {
            if (it != null) {
                Toast.makeText(requireContext(), "Account is already", Toast.LENGTH_LONG)
                    .show()
                return@observe
            }

            val user = User(0, name, username, password)
            viewModel.insertUser(user)
            findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
            Toast.makeText(requireContext(), "Register Successfully", Toast.LENGTH_LONG)
                .show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}