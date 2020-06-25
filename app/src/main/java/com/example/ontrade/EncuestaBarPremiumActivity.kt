package com.example.ontrade

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.ontrade.dbhelper.DBHelper
import com.example.ontrade.modelos.Ruta

class EncuestaBarPremiumActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_encuesta_premium)

        val ruta = getRuta()
        setNombreComercio(ruta.getSegmentoNombre() + " - " +ruta.nombre)
        setImagen(ruta.imagen)
    }

    fun getRuta() : Ruta{
        val rutaId: Int = intent.getIntExtra("rutaId",1)
        val db = DBHelper()
        return db.rutaById(rutaId)
    }

    fun setNombreComercio(nombre: String){
        val nombreComercio = findViewById<TextView>(R.id.nombre_comercio_tv)
        nombreComercio.text = nombre
    }

    fun setImagen(nombreImagen: String) {

        val imagenFondo = findViewById<ImageView>(R.id.encuesta_barpopular_img)
        imagenFondo.setImageResource(getImagen(nombreImagen))
    }

    fun getImagen(nombre: String): Int = when (nombre) {
        "bar1" -> R.drawable.bar1
        "bar2" -> R.drawable.bar2
        "bar3" -> R.drawable.bar3
        "bar4" -> R.drawable.bar4
        "bar5" -> R.drawable.bar5
        else -> R.drawable.bar6
    }
}