package com.example.ontrade

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.ontrade.dbhelper.GetData
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class EjemploActivity : AppCompatActivity() {


    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejemplo)


        try {


            val userObservable = getObresvable()
            val userObserver = getResultado()



            userObservable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe()


        val retro = getResultado()

            Log.d("123", "FUNCIONA")
            Log.d("123",retro.toString())
        } catch (e: Exception) {
            Log.d("123", "NO FUNCIONA")
            Log.d("123", "Error$e")
        }
    }




    private fun getRetrofit(): GetData {
        return Retrofit.Builder()
            .baseUrl("https://dog.ceo/api/breeds/image/random/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build().create(GetData::class.java)
    }

    private fun getObresvable(): Observable<List<String>> {
        return getRetrofit().getData()
    }

    private fun getResultado(): DisposableSingleObserver<List<String>> {
        return object : DisposableSingleObserver<List<String>>(){
            override fun onSuccess(t: List<String>) {
                Log.d("123", t.toString())
            }

            override fun onError(e: Throwable) {
                Log.d("123", e.toString())
            }

        }
    }

}


