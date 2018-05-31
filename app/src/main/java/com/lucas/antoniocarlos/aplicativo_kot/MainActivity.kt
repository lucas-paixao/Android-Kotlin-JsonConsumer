package com.lucas.antoniocarlos.aplicativo_kot

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {


    var listView: ListView? = null
    var dados: Array<String?>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var service: NoteService
        var dataPage: DataPage

        listView = findViewById(R.id.list) as ListView

        dataPage = DataPage()

        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        val client = OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build()

        val retrofit = Retrofit.Builder()
                .baseUrl(" https://s3-sa-east-1.amazonaws.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()


        service = retrofit.create(NoteService::class.java)

        val notes = service.note

        notes.enqueue(object : Callback<Example> {
            override fun onResponse(call: Call<Example>, response: Response<Example>) {

                val tamanho = response.body()!!.data
                val t = tamanho!!.size
                dados = arrayOfNulls<String>(t)

                for (i in 0..t - 1) {

                    val ide = response.body()!!.data!![i].id.toString()
                    val name = response.body()!!.data!![i].name.toString()
                    val pwd = response.body()!!.data!![i].pwd.toString()

                    dataPage.ide = ide
                    dataPage.name = name
                    dataPage.pwd = Integer.parseInt(pwd)

                    (dados as Array<String?>)[i] = "ID: " + dataPage.ide + "\n" +
                            "Name: " + dataPage.name + "\n" +
                            "Pwd: " + dataPage.pwd.toString()

                }
                listar()

            }

            override fun onFailure(call: Call<Example>, t: Throwable) {

            }
        })

    }

    fun listar() {
        val adapter = ArrayAdapter(this,
                android.R.layout.simple_list_item_1, dados)
        listView!!.adapter = adapter

    }

}