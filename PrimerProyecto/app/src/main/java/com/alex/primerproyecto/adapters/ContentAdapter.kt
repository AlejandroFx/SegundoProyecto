package com.alex.primerproyecto.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.alex.primerproyecto.R
import com.alex.primerproyecto.entities.Content


class ContentAdapter(private val contents: List<Content>) : RecyclerView.Adapter<ContentAdapter.ContentAdapterViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContentAdapterViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.registros, parent, false)

        return ContentAdapterViewHolder(view)
    }

    override fun onBindViewHolder(holder: ContentAdapterViewHolder, position: Int) {
        val content = contents[position]
        holder.onBind(content)
    }

    override fun getItemCount(): Int {
        return contents.size
    }

    inner class ContentAdapterViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        fun onBind(content: Content) {
            val textViewNombre = view.findViewById<TextView>(R.id.textViewNombre)
            val textViewCorreo = view.findViewById<TextView>(R.id.textViewCorreo)
            val textViewTelefono = view.findViewById<TextView>(R.id.textViewTelefono)
            val textViewGenero= view.findViewById<TextView>(R.id.textViewGenero)
            val textViewPeliculas= view.findViewById<TextView>(R.id.textViewPeliculas)


            textViewNombre.text = content.nombre
            textViewCorreo.text = content.correo
            textViewTelefono.text = content.telefono.toString()
            textViewGenero.text=content.genero
            textViewPeliculas.text=content.peliculas


        }
    }
}