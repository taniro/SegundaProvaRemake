package tads.eaj.ufrn.segundaprova.ui.cadastra

import androidx.lifecycle.*
import kotlinx.coroutines.launch
import tads.eaj.ufrn.segundaprova.model.Pessoa
import tads.eaj.ufrn.segundaprova.database.repository.PessoaRepository

class CadastraFragmentViewModel private constructor(private val pessoaRepository:PessoaRepository) : ViewModel()  {
    var pessoa: Pessoa = Pessoa()
    private var _eventCadastroPessoa = MutableLiveData<Boolean>(false)
    val eventCadastroPessoa:LiveData<Boolean>
        get() = _eventCadastroPessoa

    fun cadastroPessoa() {
        viewModelScope.launch {
            pessoaRepository.insert(pessoa)
        }
        _eventCadastroPessoa.value = true
    }

    fun onCadastroPessoaComplete(){
        _eventCadastroPessoa.value = false
    }

    class Factory(val pessoaRepository:PessoaRepository) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(CadastraFragmentViewModel::class.java)) {
                return CadastraFragmentViewModel(pessoaRepository) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}