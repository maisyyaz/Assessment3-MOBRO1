package com.yazid.assessment3.ui.product

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yazid.assessment3.entity.Product
import com.yazid.assessment3.network.ProductApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

class ProductViewModel: ViewModel() {
    private val data = MutableLiveData<Product>()
    private val status = MutableLiveData<ProductApi.ApiStatus>()

    init {
        retrieveData()
    }

    private fun retrieveData() = viewModelScope.launch(Dispatchers.IO){
        status.postValue(ProductApi.ApiStatus.LOADING)
        try {
            data.postValue(ProductApi.service.getProduct())
            status.postValue(ProductApi.ApiStatus.SUCCESS)
        } catch (e: Exception) {
            Log.d("MainViewModel", "Failure ${e.message}")
            status.postValue(ProductApi.ApiStatus.FAILED)
        }
    }

    fun getData() : LiveData<Product> = data

    fun getStatus(): LiveData<ProductApi.ApiStatus> = status
}