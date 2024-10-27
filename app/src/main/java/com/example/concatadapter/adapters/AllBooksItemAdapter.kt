package com.example.concatadapter.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.concatadapter.data.BookModel
import com.example.concatadapter.databinding.ItemAllBooksBinding
import com.squareup.picasso.Picasso

class AllBooksItemAdapter : RecyclerView.Adapter<AllBooksItemAdapter.AllBooksItemViewHolder>() {
    val allBooksList = ArrayList<BookModel>()

    class AllBooksItemViewHolder(val binding: ItemAllBooksBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AllBooksItemViewHolder {
        val binding = ItemAllBooksBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AllBooksItemViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return allBooksList.size
    }

    override fun onBindViewHolder(holder: AllBooksItemViewHolder, position: Int) {
        val book = allBooksList[position]
        holder.binding.bookAuthorText.text = book.bookAuthor
        holder.binding.bookNameText.text = book.bookName
        holder.binding.bookPriceText.text = book.bookPrice + " ₺"
        Picasso.get().load(book.bookImageUrl).into(holder.binding.bookImageView)
    }
    fun getList(list: List<BookModel>) {
        allBooksList.clear()
        allBooksList.addAll(list)
        notifyItemRangeChanged(0, allBooksList.size - 1)

    }
}