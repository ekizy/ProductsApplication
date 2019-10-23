package com.ekiz.products.scenes.products

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ekiz.products.R
import com.ekiz.products.data.uimodels.ProductUIModel
import com.ekiz.products.data.uimodels.ProductsContainerUIModel
import com.ekiz.products.util.ImageUtils
import kotlinx.android.synthetic.main.view_product_available_item.view.*
import kotlinx.android.synthetic.main.view_product_available_item.view.text_view_avaiable_item_product_description
import kotlinx.android.synthetic.main.view_product_list_header.view.*
import kotlinx.android.synthetic.main.view_product_unavailable_item.view.*

class ProductsAdapter(var productContainerModel: ProductsContainerUIModel) :
    RecyclerView.Adapter<ProductsAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ListViewHolder {

        when (viewType) {
            ViewHolderType.HEADER.ordinal ->
                return HeaderViewHolder(
                    LayoutInflater.from(viewGroup.getContext())
                        .inflate(R.layout.view_product_list_header, viewGroup, false)
                )
            ViewHolderType.FOOTER.ordinal -> return FooterViewHolder(
                LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.view_product_list_footer_item, viewGroup, false)
            )
            ViewHolderType.AVAILABLE.ordinal -> return AvailableProductViewHolder(
                LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.view_product_available_item, viewGroup, false)
            )
            else -> return UnavailableProductViewHolder(
                LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.view_product_unavailable_item, viewGroup, false)
            )
        }

    }

    override fun getItemCount(): Int = (productContainerModel.products?.size ?: 0) + 2

    override fun getItemViewType(position: Int): Int {
        val listSize = productContainerModel.products?.size ?: 0
        var product: ProductUIModel? = null
        if (listSize >= position && position > 0) {
            product = productContainerModel.products?.get(position - 1)
        }
       return when {
            position == 0 -> return ViewHolderType.HEADER.ordinal
            position == listSize + 1 -> ViewHolderType.FOOTER.ordinal
            product?.available ?: false -> ViewHolderType.AVAILABLE.ordinal
            else -> ViewHolderType.UNAVAILABLE.ordinal
        }
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val listSize = productContainerModel.products?.size ?: 0
        var product: ProductUIModel? = null

        if (position <= listSize && position > 0) {
            product = productContainerModel.products?.get(position - 1)
        }

        if (holder is HeaderViewHolder) {
            holder.titleText = productContainerModel.header?.headerTitle
            holder.subTitleText = productContainerModel.header?.headerDescription
        }

        holder.bindViewHolder(product)
    }

    abstract class ListViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        abstract fun bindViewHolder(product: ProductUIModel?)
    }

    inner class AvailableProductViewHolder(view: View) : ListViewHolder(view) {
        override fun bindViewHolder(product: ProductUIModel?) {
            ImageUtils.loadImageToImageView(
                itemView.context,
                product?.imageURL,
                itemView.image_view_available_item_product_image
            )

            itemView.text_view_available_item_product_name.text = product?.name
            itemView.text_view_avaiable_item_product_description.text = product?.description
            itemView.text_view_available_item_product_price_value.text =
                product?.price?.value.toString()
            itemView.text_view_available_item_release_date.text = product?.getDateString()
            itemView.rating_bar_available_item_rating.rating = product?.rating?.toFloat() ?: 0.0f
        }
    }

    inner class UnavailableProductViewHolder(view: View) : ListViewHolder(view) {
        override fun bindViewHolder(product: ProductUIModel?) {
            ImageUtils.loadImageToImageView(
                itemView.context,
                product?.imageURL,
                itemView.image_view_unavailable_item_product_image
            )

            itemView.text_view_unavailable_item_product_name.text = product?.name
            itemView.text_view_unavaiable_item_product_description.text = product?.description
            itemView.rating_bar_unavailable_item_rating.rating = product?.rating?.toFloat() ?: 0.0f
        }
    }

    inner class HeaderViewHolder(view: View) : ListViewHolder(view) {

        var titleText: String? = null
        var subTitleText: String? = null

        override fun bindViewHolder(product: ProductUIModel?) {
            itemView.text_view_product_list_header_title.text = titleText
            itemView.text_view_product_list_header_subtitle.text = subTitleText
        }
    }

    inner class FooterViewHolder(view: View) : ListViewHolder(view) {
        override fun bindViewHolder(product: ProductUIModel?) = Unit
    }
}