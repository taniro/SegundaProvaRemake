package tads.eaj.ufrn.segundaprova.ui.cadastra

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import tads.eaj.ufrn.segundaprova.model.Pessoa
import tads.eaj.ufrn.segundaprova.repository.PessoaRepository

class CadastraFragmentViewModel (application: Application) : AndroidViewModel(application)  {
    var pessoa: Pessoa = Pessoa()
    private var _eventCadastroPessoa = MutableLiveData<Boolean>(false)
    val eventCadastroPessoa:LiveData<Boolean>
        get() = _eventCadastroPessoa


    private val pessoaRepository = PessoaRepository(application)

    fun cadastroPessoa() {
        viewModelScope.launch {
            pessoaRepository.insert(pessoa)
        }
        _eventCadastroPessoa.value = true
    }

    fun onCadastroPessoaComplete(){
        _eventCadastroPessoa.value = false
    }
}