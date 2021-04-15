package tads.eaj.ufrn.segundaprova.ui.altera

import android.util.Log
import androidx.lifecycle.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import tads.eaj.ufrn.segundaprova.model.Pessoa
import tads.eaj.ufrn.segundaprova.database.repository.PessoaRepository

class AlteraFragmentViewModel private constructor(id:Long, val pessoaRepository:PessoaRepository) : ViewModel() {
    private val _pessoa = MutableLiveData<Pessoa>()
    val pessoa: LiveData<Pessoa>
        get() = _pessoa

    private var _eventAlteraPessoa = MutableLiveData<Boolean>(false)
    val eventAlteraPessoa: LiveData<Boolean>
        get() = _eventAlteraPessoa

    init {
        getPessoa(id)
    }

    fun alteraPessoa(){
        viewModelScope.launch {
            pessoa.value?.let { pessoaRepository.update(it) }
        }
        _eventAlteraPessoa.value = true
    }

    fun onAlteraPessoaComplete(){
        _eventAlteraPessoa.value = false
    }

    fun getPessoa(id:Long){
        viewModelScope.launch {
            _pessoa.value = pessoaRepository.listById(id)
        }
    }

    class Factory(val id:Long, val pessoaRepository:PessoaRepository) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(AlteraFragmentViewModel::class.java)) {
                return AlteraFragmentViewModel(id, pessoaRepository) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}