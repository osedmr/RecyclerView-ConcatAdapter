package com.example.concatadapter

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.concatadapter.adapters.AllListBooksAdapter
import com.example.concatadapter.adapters.BestSellersListAdapter
import com.example.concatadapter.adapters.HeaderAdapter
import com.example.concatadapter.data.BooksData
import com.example.concatadapter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val bestSellersAdapter by lazy { BestSellersListAdapter()  }
    private val bestSellersHeaderAdapter by lazy { HeaderAdapter("Best Sellers") }

    private val allBooksHeaderAdapter by lazy { HeaderAdapter("All Books") }
    private val allBooksAdapter by lazy { AllListBooksAdapter() }

    private var concatAdapter = ConcatAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        bestSellersAdapter.updateList(BooksData.getBestSellers())
        allBooksAdapter.getList(BooksData.getAllBooks())

        concatAdapter =ConcatAdapter(
            bestSellersHeaderAdapter,
            bestSellersAdapter,
            allBooksHeaderAdapter,
            allBooksAdapter
        )

        binding.rvConcat.apply {
            layoutManager = LinearLayoutManager(this@MainActivity,LinearLayoutManager.VERTICAL,false)
            adapter = concatAdapter
        }


    }
}