package tads.eaj.ufrn.segundaprova.ui.detalhes

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import tads.eaj.ufrn.segundaprova.model.Pessoa
import tads.eaj.ufrn.segundaprova.repository.PessoaRepository

class DetalhesFragmentViewModel(id:Long, application: Application) : ViewModel() {
    lateinit var pessoa: Pessoa
    private val pessoaRepository = PessoaRepository(application)

    init {
        getPessoa(id)
    }

    fun getPessoa(id:Long){
        viewModelScope.launch {
            pessoa = pessoaRepository.listById(id)
        }
    }

    class DetalhesFragmentViewModelFactory(val id:Long, val application: Application) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(DetalhesFragmentViewModel::class.java)) {
                return DetalhesFragmentViewModel(id, application) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}