package com.example.ontrade.dbhelper

import com.example.ontrade.modelos.ArticulosEncuesta
import com.example.ontrade.modelos.Ruta

class DBHelper {

    fun listaRutas() : List<Ruta>{

        val ruta1 = Ruta(1,"Billares el Hongo","GZ - BC","COSTA","C24018","AVRM_PVMX_MA_F24_R3_TECATE FOR",0,1,"300066319","bar1")
        val ruta2 = Ruta(2,"Billares Lalo","GZ - BC","COSTA","C24019","AVRM_PVMX_MA_F24_R3_TECATE FOR",0,1,"300071946","bar2")
        val ruta3 = Ruta(3,"Rancho Tecate","GZ - BC","COSTA","C80012","AVRM_PVMX_MA_F24_R3_TECATE FOR",1,0,"300072192","bar3")
        val ruta4 = Ruta(4,"El Santo Bare","GZ - BSC","BSC","C26007","AVRM_PVMX_CC_F24_R1_CC TIJUANA FOR",1,2,"300052192","bar4")
        val ruta5 = Ruta(5,"Hunger Park","GZ - BSC","BSC","C80032","AVRM_PVMX_CC_F24_R1_CC TIJUANA FOR",2,3,"300062192","bar5")
        val ruta6 = Ruta(6,"Maria Bonita","GZ - BSC","BSC","C80032","AVRM_PVMX_CC_F24_R1_CC TIJUANA FOR",2,1,"300072197","bar6")
        val lista : List<Ruta> = listOf(ruta1,ruta2,ruta3,ruta4,ruta5,ruta6)
        return lista
    }

    fun rutaById(id:Int) : Ruta{
        for (ruta in listaRutas()){
            if (ruta.id == id ){
                return  ruta;
            }
        }
        return listaRutas()[0]
    }

    fun listaArticulos(): List<ArticulosEncuesta>{
        val a = ArticulosEncuesta(1,"letrero",1,"Letrero tipo anuncio","letrero","",1,"exterior")
        val b = ArticulosEncuesta(1,"letrero",1,"Letrero tipo anuncio","letrero_luminoso","",1,"exterior")
        val c = ArticulosEncuesta(1,"letrero",1,"Letrero tipo anuncio","sombras","",1,"exterior")
        val d = ArticulosEncuesta(1,"letrero",1,"Letrero tipo anuncio","sombras2","",1,"exterior")
        val lista : List<ArticulosEncuesta> = listOf(a,b,c,d)
        return lista
    }
}