package com.ekiz.products.scenes.products

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.ekiz.products.R
import com.ekiz.products.base.BaseFragment
import com.ekiz.products.itemdecoration.ProductsItemDecoration
import kotlinx.android.synthetic.main.fragment_products.*

class ProductsFragment : BaseFragment<ProductsViewModel>() {

    var productsAdapter: ProductsAdapter? = null

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
        observeSuccess()
        observeSuccess()
        listenPullToRefresh()
        return view
    }

    override fun layoutId(): Int = R.layout.fragment_products

    private fun observeSuccess() {
        viewModel.result.observe(viewLifecycleOwner, Observer {
            it?.let {
                if (productsAdapter == null) {
                    val topPadding = context?.resources?.getDimensionPixelSize(R.dimen.dimen_16) ?: 0
                    val leftRightPadding = context?.resources?.getDimensionPixelSize(R.dimen.dimen_8) ?: 0
                    val bottomPadding = context?.resources?.getDimensionPixelSize(R.dimen.dimen_16) ?: 0
                    val itemVerticalOffset = context?.resources?.getDimensionPixelSize(R.dimen.dimen_8) ?: 0

                    recycler_view_products?.adapter = ProductsAdapter(it)
                    recycler_view_products.layoutManager = LinearLayoutManager(context)
                    recycler_view_products.addItemDecoration(ProductsItemDecoration(topPadding,leftRightPadding,bottomPadding,itemVerticalOffset))
                } else {
                    productsAdapter?.productContainerModel = it
                }
                productsAdapter?.notifyDataSetChanged()
            }
        })
    }

    private fun observeError() {
    }

    private fun listenPullToRefresh() {
    }

}