package tads.eaj.ufrn.segundaprova

import android.app.Application
import android.os.AsyncTask
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeFragmentViewModel(application: Application) : AndroidViewModel(application) {
    var list:LiveData<List<Pessoa>>

    private val db:PessoaDatabase by lazy {
        Room.databaseBuilder(application.applicationContext, PessoaDatabase::class.java, "pessoas.sqlite")
            .build()
    }

     init {
         list = db.pessoaDao().listAll()
     }

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