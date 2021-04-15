package tads.eaj.ufrn.segundaprova.ui.home

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import tads.eaj.ufrn.segundaprova.repository.PessoaRepository

class HomeFragmentViewModel(application: Application) : AndroidViewModel(application) {

    private val pessoaRepository = PessoaRepository(application)
    var list = pessoaRepository.listAll

    /*
    fun getPessoa(db:PessoaDatabase){
        viewModelScope.launch {
            Log.i("TESTE", db.pessoaDao().listById(2L).toString())
        }
    }*/


    /*
    suspend fun listById(id:Long, db:PessoaDatabase):Pessoa {
        lateinit var p :Pessoa
        withContext(Dispatchers.Default) {
            p = db.pessoaDao().listById(id)
        }
        return p;
    }*/

}