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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PessoaViewHolder {
        return PessoaViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: PessoaViewHolder, position: Int) {
        val pessoa = getItem(position)
        holder.bind(pessoa)
    }

    class PessoaViewHolder private constructor(val binding: PessoaInflaterBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(pessoa: Pessoa) {
            binding.pessoa = pessoa
            binding.executePendingBindings()

        }

        companion object {
            fun from(parent: ViewGroup): PessoaViewHolder {
                val inflater = LayoutInflater.from(parent.context)
                val binding:PessoaInflaterBinding = DataBindingUtil.inflate(inflater, R.layout.pessoa_inflater, parent, false)

                return PessoaViewHolder(binding)
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