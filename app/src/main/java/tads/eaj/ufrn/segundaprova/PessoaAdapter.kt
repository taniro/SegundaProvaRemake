package tads.eaj.ufrn.segundaprova

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PessoaAdapter : RecyclerView.Adapter<PessoaAdapter.PessoaViewHolder>() {

    var list:List<Pessoa> = ArrayList<Pessoa>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PessoaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.pessoa_inflater, parent, false)
        return PessoaViewHolder(view)
    }

    override fun onBindViewHolder(holder: PessoaViewHolder, position: Int) {
        val pessoa = list[position]
        holder.nomeTextView.text = pessoa.nome
        holder.sobrenomeTextView.text = pessoa.sobrenome
        holder.idadeTextView.text = pessoa.idade.toString()
        holder.sexoTextView.text = pessoa.sexo
        holder.alturaTextView.text = pessoa.altura.toString()
        holder.pesoTextView.text = pessoa.peso.toString()
    }

    override fun getItemCount(): Int {
        return list.size
    }


    class PessoaViewHolder(v: View) : RecyclerView.ViewHolder(v){
        var nomeTextView = v.findViewById<TextView>(R.id.nomeTextView)
        var sobrenomeTextView = v.findViewById<TextView>(R.id.sobrenomeTextView)
        var idadeTextView = v.findViewById<TextView>(R.id.idadeTextView)
        var sexoTextView = v.findViewById<TextView>(R.id.sexoTextView)
        var alturaTextView = v.findViewById<TextView>(R.id.alturaTextView)
        var pesoTextView = v.findViewById<TextView>(R.id.pesoTextView)
    }
}