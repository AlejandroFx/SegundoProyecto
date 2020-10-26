package com.alex.primerproyecto.views

import android.os.Bundle
import android.widget.*
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.alex.primerproyecto.R
import com.alex.primerproyecto.adapters.ContentAdapter
import com.alex.primerproyecto.adapters.PlcAdaptador
import com.alex.primerproyecto.entities.Content
import com.alex.primerproyecto.viewModels.MainActivityViewModel
import com.alex.primerproyecto.viewModels.RegistroViewModel
import com.google.android.material.button.MaterialButton
import kotlinx.android.synthetic.main.activity_main.*

class AgregarRegistro : AppCompatActivity() {

    private val registroViewModel: RegistroViewModel by viewModels()
    private var contentAdapter: ContentAdapter?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.all_registros)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView_all_registros)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val viewModel : MainActivityViewModel by viewModels()
        viewModel.getContents().observe(this, { contents ->
            val contentAdapter = ContentAdapter(contents)

            recyclerView.adapter = contentAdapter

            contentAdapter.notifyDataSetChanged()
        })

    }


}