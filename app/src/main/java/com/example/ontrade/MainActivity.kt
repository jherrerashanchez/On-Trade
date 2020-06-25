package com.example.ontrade

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ontrade.adapters.RutaAdapter
import com.example.ontrade.dbhelper.DBHelper
import com.example.ontrade.interfaces.RutaInterface
import com.example.ontrade.modelos.Ruta
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() , RutaInterface  {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //se inicializa y configura el adapter y reciclerView
        val recycler = findViewById<RecyclerView>(R.id.reciclador)
        val adapter = initAdapter(recycler)
        recycler.adapter = adapter

        //metodos de la activity
        buscar(adapter)
        mostratTodo(adapter)


    }

    fun initAdapter(recycler: RecyclerView): RutaAdapter {
        recycler.setHasFixedSize(true)
        recycler.layoutManager =  LinearLayoutManager(this)
        val rutas = DBHelper().listaRutas()
        recycler.setHasFixedSize(true)
        recycler.layoutManager =  LinearLayoutManager(this)

        return RutaAdapter(rutas,this)
    }

    fun buscar(adapter: RutaAdapter) {
        val btn_buscar = findViewById<Button>(R.id.btn_buscar)
        btn_buscar.setOnClickListener{
            adapter.buscarRutas(et_busqueda.text.toString())
        }
    }

    fun mostratTodo(adapter: RutaAdapter) {

        //inicializar texto de busqueda
        val texto_busqueda = findViewById<TextView>(R.id.et_busqueda)

        val btn_mostrar = findViewById<Button>(R.id.btn_todo)
        btn_mostrar.setOnClickListener{
            adapter.motrarTodos()
            texto_busqueda.text = ""
        }
    }

    override fun rutaOnClick(ruta: Ruta) {

        val intent = selecionarEncuestaActivity(ruta.segmento)
        intent.putExtra("rutaId", ruta.id)
        startActivity(intent)

    }

    fun selecionarEncuestaActivity(segmento: Int): Intent {
        if (segmento == 2){
            return Intent(this, EncuestaBarPremiumActivity::class.java)
        }else if(segmento == 1){
            return Intent(this, EncuestaBarEstandarActivity::class.java)
        }else{
            return Intent(this, EncuestaBarPopularActivity::class.java)
        }
    }
}