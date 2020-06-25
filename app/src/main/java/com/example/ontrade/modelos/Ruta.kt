package com.example.ontrade.modelos

import com.example.ontrade.R

class Ruta(
    var id: Int,
    var nombre: String,
    var gerencia: String,
    var zona: String,
    var ruta_venta: String,
    var descripcion_ruta: String,
    var segmento: Int, //0 Bar Popular ,1 Bar Estandar ,2 Bar Premium
    var tipo: Int, // 0 BRONCE, 1 PLATA, 2 ORO, 3 PLATINO, 4 TITANIUM
    var cliente: String,
    var imagen: String
    //  var usuario_id : Int   /posiblemente se quite
) {
     fun getTipo(): String = when (tipo) {
        0 -> "Bronce"
        1 -> "PLATA"
        2 -> "ORO"
        3 -> "PLATINO"
        4 -> "TITANIUM"
        else -> ""
    }

    fun getSegmentoNombre(): String = when (segmento) {
        0 -> "Bar Popular"
        1 -> "Bar Estandar"
        2 -> "Bar Premium"
        else -> ""
    }
}






