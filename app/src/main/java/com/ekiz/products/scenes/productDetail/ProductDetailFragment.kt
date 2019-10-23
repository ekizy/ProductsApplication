package com.ekiz.products.scenes.productDetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ekiz.products.R
import com.ekiz.products.base.BaseFragment
import com.ekiz.products.scenes.products.ProductsAdapter

class ProductDetailFragment : BaseFragment<ProductDetailViewModel>() {


    override fun initialize() {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        retainInstance = true
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = super.onCreateView(inflater, container, savedInstanceState)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun layoutId(): Int = R.layout.fragment_product_detail

}