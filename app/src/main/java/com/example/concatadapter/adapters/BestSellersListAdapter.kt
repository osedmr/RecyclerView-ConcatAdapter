package com.example.concatadapter.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.concatadapter.data.BookModel
import com.example.concatadapter.databinding.ListBestSellersBinding

class BestSellersListAdapter() : RecyclerView.Adapter<BestSellersListAdapter.BestSellersViewHolder>() {
    private val bestSellersList = ArrayList<BookModel>()
    inner class BestSellersViewHolder(val binding: ListBestSellersBinding) : RecyclerView.ViewHolder(binding.root) {

    }
    override fun getItemCount(): Int =1

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BestSellersListAdapter.BestSellersViewHolder {
        val binding = ListBestSellersBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BestSellersViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: BestSellersListAdapter.BestSellersViewHolder,
        position: Int
    ) {
        holder.binding.rvBestSellers.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter= BestSellersItemAdapter().also {
                it.updateList(bestSellersList)
            }
        }
    }

    fun updateList(newList: List<BookModel>) {
        bestSellersList.clear()
        bestSellersList.addAll(newList)
        notifyItemRangeChanged(0, bestSellersList.size - 1)

    }
}