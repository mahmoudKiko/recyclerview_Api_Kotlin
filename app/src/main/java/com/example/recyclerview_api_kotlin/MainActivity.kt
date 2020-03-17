package com.example.recyclerview_api_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerview_api_kotlin.adapter.MyAdapter
import com.example.recyclerview_api_kotlin.common.Common
import com.example.recyclerview_api_kotlin.interfacee.RetrofitService
import com.example.recyclerview_api_kotlin.model.Movie
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var mService: RetrofitService
    lateinit var latoutManger: LinearLayoutManager
    lateinit var adapter: MyAdapter
    lateinit var dialog: AlertDialog


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        mService = Common.retrofitService

        recyclerMoviList.setHasFixedSize(true)
        latoutManger = LinearLayoutManager(this)
        recyclerMoviList.layoutManager = latoutManger

        //dialog = SpotsDialog.Builder().setCancelable(false).setContext(this).build()

        getAllMovieList()


    }

    private fun getAllMovieList() {

        //dialog.show()
        mService.getMovieList().enqueue(object : Callback<MutableList<Movie>> {
            override fun onFailure(call: Call<MutableList<Movie>>, t: Throwable) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onResponse(call: Call<MutableList<Movie>>, response: Response<MutableList<Movie>>)
            {

                adapter = MyAdapter(baseContext , response.body() as MutableList<Movie>)
                adapter.notifyDataSetChanged()
                recyclerMoviList.adapter = adapter


            }
        })
    }
}