package com.example.hiltmvvm.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hiltmvvm.databinding.ActivityMainBinding
import com.example.hiltmvvm.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var productAdapter: ProductsAdapter
    private lateinit var mainViewModel: MainViewModel

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        productAdapter = ProductsAdapter()

        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]

        initView()
        setProductObserver()
    }

    private fun initView() {
        binding.rvProducts.layoutManager = LinearLayoutManager(this)
        binding.rvProducts.setHasFixedSize(true)
        binding.rvProducts.adapter = productAdapter
    }

    private fun setProductObserver() {
        mainViewModel.productsLiveData.observe(this) { productList ->
            productList?.let {
                productAdapter.updateProductList(it)
            }
        }
    }
}