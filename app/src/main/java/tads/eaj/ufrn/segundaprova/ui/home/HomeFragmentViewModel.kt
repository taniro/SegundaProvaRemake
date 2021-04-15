package tads.eaj.ufrn.segundaprova.ui.home

import androidx.lifecycle.*
import tads.eaj.ufrn.segundaprova.model.Pessoa
import tads.eaj.ufrn.segundaprova.database.repository.PessoaRepository

class HomeFragmentViewModel private constructor(pessoaRepository: PessoaRepository) : ViewModel() {

    var list:LiveData<List<Pessoa>> = pessoaRepository.listAll.asLiveData()

    class Factory(val pessoaRepository:PessoaRepository) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(HomeFragmentViewModel::class.java)) {
                return HomeFragmentViewModel(pessoaRepository) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}

