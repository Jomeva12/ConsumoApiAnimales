package com.jomeva.animalesapi.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.jomeva.animalesapi.R
import com.jomeva.animalesapi.modelos.AnimalesResponse
import com.squareup.picasso.Picasso


class AdapterAnimales(private val images: List<String>, context: Context) :
    RecyclerView.Adapter<AdapterAnimales.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val imagen=view.findViewById<ImageView>(R.id.cachorro)

            init { }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.card_dog, parent, false)
        return ViewHolder(layout)
    }

    override fun getItemCount(): Int = images.size


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var m = images[position]
        Picasso.get().load(m.toString())?.into(holder.imagen)
    }

}