package com.example.mypostsy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CommentActivity : AppCompatActivity() {
    var postId = 0
    lateinit var tvPostTitle: TextView
    lateinit var tvpostBody: TextView

    lateinit var rvComment: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comment)

        rvComment=findViewById(R.id.rvComments)

        postId = intent.getIntExtra("POST_ID", 0)
        castView()
        getPost()
        getComment()
    }

    fun castView() {
        tvPostTitle = findViewById(R.id.tvPostTitle)
        tvpostBody = findViewById(R.id.tvpostBody)

    }

    fun getPost() {
        if (postId == 0) {
            Toast.makeText(baseContext, "post not found", Toast.LENGTH_LONG).show()
            finish()
        }
        var apiClient = ApiClient.buildApiClient(ApiInterface::class.java)
        var request = apiClient.getPost(postId)

        request.enqueue(object : Callback<Post?> {
            override fun onResponse(call: Call<Post?>, response: Response<Post?>) {
                if (response.isSuccessful) {
                    var post = response.body()
                    tvPostTitle.text = post?.title
                    tvpostBody.text = post?.body
                }
            }

            override fun onFailure(call: Call<Post?>, t: Throwable) {
                Toast.makeText(baseContext,t.message,Toast.LENGTH_LONG).show()
            }
        })
    }
}
fun getComment(){
    var rvComment=findViewById<RecyclerView>(R.id.rvComments)
    var retrofit=ApiClient.buildApiClient(ApiInterface::class.java)
    var request=retrofit.getComments(retrofit)
    request.enqueue(object :Callback<List<Comments>>{
        override fun onResponse(call: Call<List<Comments>>, response: Response<List<Comments>>) {
         var comment=response.body()!!
            var commentadapter=CommentViewHolder(comment)
            rvComment.Adapter =commentadapter
            rvComment.layoutManger=LinearLayoutManager(baseContext)
        }

        override fun onFailure(call: Call<List<Comments>>, t: Throwable) {
            Toast.makeText(baseContext,t.message,Toast.LENGTH_LONG).show()

        }
        })


    }

fun <T> findViewById(rvComments: Int) {
    return
}
















