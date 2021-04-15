package tads.eaj.ufrn.segundaprova.ui.home.adapter

import android.widget.TextView
import androidx.databinding.BindingAdapter
import tads.eaj.ufrn.segundaprova.model.Pessoa

@BindingAdapter("alturaValueAsText")
fun TextView.setAlturaValueAsText(altura : Double?){
    altura?.let {
        text = it.toString()
    }
}

@BindingAdapter("pesoValueAsText")
fun TextView.setPesoValueAsText(item:Pessoa?){
    item?.let {
        text = it.peso.toString()
    }
}