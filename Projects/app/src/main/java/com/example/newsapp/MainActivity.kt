package com.example.newsapp


import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.AuthFailureError
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest


class MainActivity : AppCompatActivity(), ItemClicked {
    private  lateinit var recyclerView: RecyclerView
    private lateinit var mAdapter : NewsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recyclerView)

        recyclerView.layoutManager = LinearLayoutManager(this)
        fetchData()
        mAdapter = NewsAdapter( this)
        recyclerView.adapter = mAdapter
    }

    private fun fetchData() {
        val baseUrl = "https://newsapi.org/v2/everything?q=tesla&from=2022-01-21&sortBy=publishedAt&apiKey=a6cdd34a093540b6950a8dee53d98ccb"
        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.GET,
            baseUrl,
            null,
            {
                Log.e("Eneteter","$it")
                val newsJsonArray = it.getJSONArray("articles")
                val newsArray = ArrayList<NewsData>()
                for(i in 0 until newsJsonArray.length()) {
                    val newsJsonObject = newsJsonArray.getJSONObject(i)
                    val newsData = NewsData(
                        newsJsonObject.getString("title"),
                        newsJsonObject.getString("description"),
                        newsJsonObject.getString("url"),
                        newsJsonObject.getString("urlToImage")
                    )
                    newsArray.add(newsData)
                }

                mAdapter.updateNewsData(newsArray)
            },
            {
                Toast.makeText(this,"Oops!! There was some error.",Toast.LENGTH_SHORT).show()
            }
        )
        MySingleton.getInstance(this).addToRequestQueue(jsonObjectRequest)
    }

    override fun onItemClick(item: NewsData) {

    }


}
