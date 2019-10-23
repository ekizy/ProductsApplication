package com.ekiz.products.itemdecoration

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class ProductsItemDecoration(
    val topPadding: Int,
    val leftRightPadding: Int,
    val bottomPadding: Int,
    val itemVerticalOffset: Int) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        if (parent.getChildAdapterPosition(view) == 0) {
            outRect.set(leftRightPadding, topPadding, leftRightPadding, 0)
        } else if (parent.getChildAdapterPosition(view) == state.itemCount - 1) {
            outRect.set(leftRightPadding, itemVerticalOffset, leftRightPadding, bottomPadding)
        } else {
            outRect.set(leftRightPadding, itemVerticalOffset, leftRightPadding, 0)
        }
    }

}