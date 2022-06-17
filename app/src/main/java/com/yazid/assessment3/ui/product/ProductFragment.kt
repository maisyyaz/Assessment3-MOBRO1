package com.yazid.assessment3.ui.product

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.yazid.assessment3.R
import com.yazid.assessment3.databinding.FragmentProductListBinding
import com.yazid.assessment3.databinding.FragmentRegisterBinding
import com.yazid.assessment3.network.ProductApi
import com.yazid.assessment3.placeholder.PlaceholderContent

class ProductFragment : Fragment() {

    private lateinit var myAdapter: MyProductRecyclerViewAdapter
    private val viewModel: ProductViewModel by lazy {
        ViewModelProvider(this).get(ProductViewModel::class.java)
    }

    private var _binding: FragmentProductListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProductListBinding.inflate(inflater, container, false)
        myAdapter = MyProductRecyclerViewAdapter()
        with(binding.list) {
            layoutManager = GridLayoutManager(context, 2)
            adapter = myAdapter
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getData().observe(viewLifecycleOwner) {
            myAdapter.updateData(it.data.data)
        }

        viewModel.getStatus().observe(viewLifecycleOwner) {
            updateProgress(it)
        }
    }

    private fun updateProgress(status: ProductApi.ApiStatus?) {
        when (status) {
            ProductApi.ApiStatus.LOADING -> binding.progressBar.visibility = View.VISIBLE
            ProductApi.ApiStatus.SUCCESS -> binding.progressBar.visibility = View.GONE
            ProductApi.ApiStatus.FAILED -> {
                binding.progressBar.visibility = View.GONE
                binding.networkError.visibility = View.VISIBLE
            }
        }
    }
}