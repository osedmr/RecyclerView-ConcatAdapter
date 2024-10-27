package com.example.concatadapter.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.concatadapter.data.BookModel
import com.example.concatadapter.databinding.ItemCardViewBinding
import com.squareup.picasso.Picasso

class BestSellersItemAdapter( ) :
    RecyclerView.Adapter<BestSellersItemAdapter.BestSellersItemViewHolder>() {

    private val bestSellersList = ArrayList<BookModel>()

    inner class BestSellersItemViewHolder(val binding: ItemCardViewBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun getItemCount(): Int {
        return bestSellersList.size
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BestSellersItemViewHolder {
        val binding = ItemCardViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BestSellersItemViewHolder(binding)
    }



    override fun onBindViewHolder(holder: BestSellersItemViewHolder, position: Int) {
        val book = bestSellersList[position]
        holder.binding.bookAuthorText.text = book.bookAuthor
        holder.binding.bookNameText.text = book.bookName
        holder.binding.bookPriceText.text = book.bookPrice + " ₺"
        Picasso.get().load(book.bookImageUrl).into(holder.binding.bookImageView)

    }
    fun updateList(newList: List<BookModel>) {
        bestSellersList.clear()
        bestSellersList.addAll(newList)
        notifyItemRangeChanged(0, bestSellersList.size - 1)

    }
}