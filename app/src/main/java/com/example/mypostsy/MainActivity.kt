package com.example.mypostsy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telecom.Call
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import okhttp3.Response
import retrofit2.http.POST
import javax.security.auth.callback.Callback

class MainActivity : AppCompatActivity() {
    lateinit var rvPost:RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rvPost=findViewById(R.id.rvComments)
        getPosts()
    }
    fun getPosts(){
        var retrofit =ApiClient.buildApiClient(ApiInterface::class.java)
        var request = retrofit.getPosts()
        request.enqueue(object : retrofit2.Callback<List<Post>?> {
            override fun onResponse(
                call: retrofit2.Call<List<Post>?>,
                response: retrofit2.Response<List<Post>?>
            ) {
                if (response.isSuccessful){
                    var postList = response.body()
                    var postAdapter = PostRecyclerViewAdapter(postList!!, baseContext)
                    rvPost.layoutManager = LinearLayoutManager(baseContext)
                    Toast.makeText(baseContext,postList?.size.toString(),Toast.LENGTH_LONG).show()
                }            }

            override fun onFailure(call: retrofit2.Call<List<Post>?>, t: Throwable) {
                Toast.makeText(baseContext,t.message,Toast.LENGTH_LONG).show()
            }
        })
       }
    }