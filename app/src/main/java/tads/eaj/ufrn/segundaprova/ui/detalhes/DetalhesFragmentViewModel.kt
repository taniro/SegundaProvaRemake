package tads.eaj.ufrn.segundaprova.ui.detalhes

import androidx.lifecycle.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import tads.eaj.ufrn.segundaprova.model.Pessoa
import tads.eaj.ufrn.segundaprova.database.repository.PessoaRepository

class DetalhesFragmentViewModel private constructor(val id:Long, val pessoaRepository:PessoaRepository) : ViewModel() {
    private val _pessoa = MutableLiveData<Pessoa>()
    val pessoa: LiveData<Pessoa>
        get() = _pessoa

    init {
        getPessoa(id)
    }

    fun getPessoa(id:Long){
        viewModelScope.launch {
            _pessoa.value = pessoaRepository.listById(id)
        }
    }

    class Factory(val id:Long, val pessoaRepository:PessoaRepository) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(DetalhesFragmentViewModel::class.java)) {
                return DetalhesFragmentViewModel(id, pessoaRepository) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}