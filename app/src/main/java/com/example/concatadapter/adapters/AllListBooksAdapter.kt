package com.example.concatadapter.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.concatadapter.data.BookModel
import com.example.concatadapter.data.BooksData
import com.example.concatadapter.databinding.ListAllBooksBinding

class AllListBooksAdapter : RecyclerView.Adapter<AllListBooksAdapter.AllListBooksViewHolder>() {
    private val bestSellersList = ArrayList<BookModel>()

   inner class AllListBooksViewHolder(val binding: ListAllBooksBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AllListBooksAdapter.AllListBooksViewHolder {
        val binding = ListAllBooksBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AllListBooksViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: AllListBooksAdapter.AllListBooksViewHolder,
        position: Int
    ) {
        holder.binding.rvAllBooks.apply {
            layoutManager = GridLayoutManager(context,2,GridLayoutManager.VERTICAL,false)
            adapter = AllBooksItemAdapter().also {
                it.getList(BooksData.getAllBooks())
            }
        }
    }

    override fun getItemCount(): Int =1

    fun getList(newList: List<BookModel>) {
        bestSellersList.clear()
        bestSellersList.addAll(newList)
        notifyItemRangeChanged(0, bestSellersList.size - 1)

    }
}