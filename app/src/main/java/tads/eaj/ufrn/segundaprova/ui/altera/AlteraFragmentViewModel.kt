package tads.eaj.ufrn.segundaprova.ui.altera

import android.app.Application
import androidx.lifecycle.*
import kotlinx.coroutines.launch
import tads.eaj.ufrn.segundaprova.model.Pessoa
import tads.eaj.ufrn.segundaprova.repository.PessoaRepository

class AlteraFragmentViewModel(id:Long, application: Application) : ViewModel() {
    lateinit var pessoa: Pessoa
    private var _eventAlteraPessoa = MutableLiveData<Boolean>(false)
    val eventAlteraPessoa: LiveData<Boolean>
        get() = _eventAlteraPessoa

    private val pessoaRepository = PessoaRepository(application)

    init {
        getPessoa(id)
    }

    fun alteraPessoa(){
        viewModelScope.launch {
            pessoaRepository.update(pessoa)
        }
        _eventAlteraPessoa.value = true
    }

    fun onAlteraPessoaComplete(){
        _eventAlteraPessoa.value = false
    }

    fun getPessoa(id:Long){
        viewModelScope.launch {
            pessoa = pessoaRepository.listById(id)
        }
    }

    class AlteraFragmentViewModelFactory(val id:Long, val application: Application) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(AlteraFragmentViewModel::class.java)) {
                return AlteraFragmentViewModel(id, application) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}