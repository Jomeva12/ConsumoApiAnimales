package com.jomeva.animalesapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jomeva.animalesapi.adapters.AdapterAnimales
import com.jomeva.animalesapi.interfaces.AnimalesApi
import com.jomeva.animalesapi.modelos.AnimalesResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        searchName("ovcharka-caucasian")
    }
    fun searchName(raza:String){
        CoroutineScope(Dispatchers.IO).launch {
            val call:Response<AnimalesResponse> = AnimalesApi.retrofit.create(AnimalesApi::class.java).obtenerAnimales("newfoundland/images")
            val cachorro=call.body()

          runOnUiThread {
              if (call.isSuccessful){
                  val mascotas=cachorro?.message as MutableList<String>
                  inicializaRecycler(mascotas)
                  Log.d("cachorrros","${cachorro?.message}")
              }else{
                  Log.d("cachorrros","No consiguio")
              }
          }



        }

    }
    fun inicializaRecycler(mascotas: MutableList<String>) {
        val recicler=findViewById<RecyclerView>(R.id.recicler)
        recicler.layoutManager=LinearLayoutManager(this)
        val mAdapter=AdapterAnimales(mascotas,this)
        recicler.adapter=mAdapter

    }

}