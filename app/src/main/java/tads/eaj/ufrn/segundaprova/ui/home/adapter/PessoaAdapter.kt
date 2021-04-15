package tads.eaj.ufrn.segundaprova.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import tads.eaj.ufrn.segundaprova.model.Pessoa
import tads.eaj.ufrn.segundaprova.R
import tads.eaj.ufrn.segundaprova.databinding.PessoaInflaterBinding

class PessoaAdapter : ListAdapter<Pessoa, PessoaAdapter.PessoaViewHolder>(PessoaDiffCallBack()) {

    // ListAdapter terá sua propria lista
    // var list:List<Pessoa> = ArrayList<Pessoa>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PessoaViewHolder {
        return PessoaViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: PessoaViewHolder, position: Int) {
        val pessoa = getItem(position)
        holder.bind(pessoa)
    }

    /*
    desnecessário, listAdapter já conhece isso
    override fun getItemCount(): Int {
        return list.size
    }
     */


    class PessoaViewHolder private constructor(val binding: PessoaInflaterBinding) : RecyclerView.ViewHolder(binding.root){
        /*
        var nomeTextView = binding.findViewById<TextView>(R.id.nomeTextView)
        var sobrenomeTextView = binding.findViewById<TextView>(R.id.sobrenomeTextView)
        var idadeTextView = binding.findViewById<TextView>(R.id.idadeTextView)
        var sexoTextView = binding.findViewById<TextView>(R.id.sexoTextView)
        var alturaTextView = binding.findViewById<TextView>(R.id.alturaTextView)
        var pesoTextView = binding.findViewById<TextView>(R.id.pesoTextView)

         */

        fun bind(pessoa: Pessoa) {
            /*
            binding.nomeTextView.text = pessoa.nome
            binding.sobrenomeTextView.text = pessoa.sobrenome
            binding.idadeTextView.text = pessoa.idade.toString()
            binding.sexoTextView.text = pessoa.sexo
            binding.alturaTextView.text = pessoa.altura.toString()
            binding.pesoTextView.text = pessoa.peso.toString()*/
            binding.pessoa = pessoa
            binding.executePendingBindings()

        }

        companion object {
            fun from(parent: ViewGroup): PessoaViewHolder {
                val inflater = LayoutInflater.from(parent.context)
                val binding:PessoaInflaterBinding = DataBindingUtil.inflate(inflater, R.layout.pessoa_inflater, parent, false)

                return PessoaViewHolder(binding)

                /*val view =
                    LayoutInflater.from(parent.context).inflate(R.layout.pessoa_inflater, parent, false)
                return PessoaViewHolder(view)
                 */
            }
        }
    }
}

class PessoaDiffCallBack : DiffUtil.ItemCallback<Pessoa>(){
    override fun areItemsTheSame(oldItem: Pessoa, newItem: Pessoa): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Pessoa, newItem: Pessoa): Boolean {
        return oldItem == newItem
    }
}