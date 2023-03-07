package com.example.loadmore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.loadmore.databinding.ActivityLoadMoreBinding
import com.example.loadmore.databinding.ActivityMainBinding

class LoadMoreActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoadMoreBinding
    lateinit var itemsCells: ArrayList<String?>
    lateinit var loadMoreItemsCells: ArrayList<String?>
    lateinit var adapterLinear: LoadingAdapter
    lateinit var scrollListener: RecyclerViewLoadMoreScroll
    lateinit var mLayoutManager: RecyclerView.LayoutManager
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityLoadMoreBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setItemsData()
        setAdapter()
        setRVLayoutManager()
        setRVScrollListener()

    }

    private fun setItemsData() {
        itemsCells = ArrayList()
        for (i in 0..20) {
            itemsCells.add("Item $i")
        }

    }

    private fun setAdapter() {
        adapterLinear = LoadingAdapter(itemsCells)
        with(adapterLinear){
            notifyDataSetChanged()
        }
        binding.rcvItems.adapter = adapterLinear
    }

    private fun setRVLayoutManager() {
        mLayoutManager = LinearLayoutManager(this)
        binding.rcvItems.layoutManager = mLayoutManager
        binding.rcvItems.setHasFixedSize(true)
    }

    private fun setRVScrollListener() {
        mLayoutManager = LinearLayoutManager(this)
        scrollListener = RecyclerViewLoadMoreScroll(mLayoutManager as LinearLayoutManager)
        scrollListener.setOnLoadMoreListener(object :
            OnLoadMoreListener {
            override fun onLoadMore() {
                loadMoreData()
            }
        })
        binding.rcvItems.addOnScrollListener(scrollListener)
    }

    private fun loadMoreData() {
        //Add the Loading View
        adapterLinear.addLoadingView()
        //Create the loadMoreItemsCells Arraylist
        loadMoreItemsCells = ArrayList()
        //Get the number of the current Items of the main Arraylist
        val start = adapterLinear.itemCount
        //Load 10 more items
        val end = start + 10
        //Use Handler if the items are loading too fast.
        Handler().postDelayed({
            for (i in start..end) {
                //Get data and add them to loadMoreItemsCells ArrayList
                loadMoreItemsCells.add("Item $i")
            }
            adapterLinear.removeLoadingView()
            // adding the data to our main ArrayList
            adapterLinear.addData(loadMoreItemsCells)
            //Change the boolean isLoading to false
            scrollListener.setLoaded()
            //Update the recyclerView in the main thread
            binding.rcvItems.post {
                adapterLinear.notifyDataSetChanged()
            }
        }, 3000)
    }
}