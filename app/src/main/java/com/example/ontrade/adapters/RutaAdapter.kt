package com.example.ontrade.adapters

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.ontrade.R
import com.example.ontrade.dbhelper.DBHelper
import com.example.ontrade.interfaces.RutaInterface
import com.example.ontrade.modelos.Ruta


class RutaAdapter(private var items: List<Ruta>, private val mAdapterCallback: RutaInterface) : RecyclerView.Adapter<RutaAdapter.RutaViewHolder>() {

    class RutaViewHolder(v: View) : ViewHolder(v) {
        // Campos respectivos de un item

        var zona: TextView = v.findViewById(R.id.zona_tv)
        var ruta: TextView = v.findViewById(R.id.ruta_tv)
        var tipo: TextView = v.findViewById(R.id.tipo_tv)
        var nombre: TextView = v.findViewById(R.id.nombre_tv)
        var cliente: TextView = v.findViewById(R.id.cliente_tv)
        var segmento: TextView = v.findViewById(R.id.segmento_tv)
        var descripcion: TextView = v.findViewById(R.id.descropcion_tv)
        var imagen: ImageView = v.findViewById(R.id.ruta_imagen)
    }

    private val db = DBHelper()

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup,i: Int): RutaViewHolder {
        val v: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.ruta_row, viewGroup, false)
        return RutaViewHolder(v)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(viewHolder: RutaViewHolder, i: Int) {
        val item = items[i]

        viewHolder.zona.text = " " + item.zona
        viewHolder.ruta.text = " "+item.ruta_venta
        viewHolder.tipo.text =item.getTipo()
        viewHolder.nombre.text =item.nombre
        viewHolder.cliente.text = " " + item.cliente
        viewHolder.segmento.text = item.getSegmentoNombre() + " - "
        viewHolder.descripcion.text =item.descripcion_ruta
        viewHolder.imagen.setImageResource(setImagen(item.imagen))


        viewHolder.itemView.setOnClickListener {
            mAdapterCallback.rutaOnClick(items[i])
        }
    }

    fun setImagen(nombre: String): Int = when (nombre) {
       "bar1" -> R.drawable.bar1
       "bar2" -> R.drawable.bar2
       "bar3" -> R.drawable.bar3
       "bar4" -> R.drawable.bar4
       "bar5" -> R.drawable.bar5
       else -> R.drawable.bar6
   }

    fun buscarRutas(busqueda: String) {
        items = filtrar(busqueda)
        notifyDataSetChanged()
    }

    /**Llega un string que valida si es una ruta,cliente o nombre y agrega las rutas que hacen match
     *
     */
    fun filtrar(s: String): List<Ruta> {

        val busqueda = s.toUpperCase();
        items = db.listaRutas()
        val lista : MutableList<Ruta> = mutableListOf<Ruta>()
        for (i in items) {
            if (i.ruta_venta == busqueda ||
                i.cliente.toUpperCase() == busqueda ||
                i.nombre.toUpperCase().contains(busqueda)){
                lista.add(i)
            }
        }
        Log.d("123",lista.size.toString())
        return lista //C24018
    }

    fun motrarTodos(){
        items = db.listaRutas()
        notifyDataSetChanged()
    }
}
