package tads.eaj.ufrn.segundaprova

import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room

class AlteraFragmentViewModel(id:Long, application: Application) : ViewModel() {
    var pessoa:Pessoa
    private val db:PessoaDatabase by lazy {
        Room.databaseBuilder(application.applicationContext, PessoaDatabase::class.java, "pessoas.sqlite")
            .build()
    }

    init {
        pessoa = getPessoa(id, db.pessoaDao())
    }

    fun alteraPessoa() = AlteraPessoaAsyncTask(db.pessoaDao()).execute(pessoa)

    fun getPessoa(id:Long, pessoaDao:PessoaDao) = GetPessoaAsyncTask(pessoaDao).execute(id).get()

    class GetPessoaAsyncTask(var pessoaDao: PessoaDao) : AsyncTask<Long, Unit, Pessoa>() {
        override fun doInBackground(vararg params: Long?): Pessoa {
            return pessoaDao.listById(params[0]!!)
        }
    }


    class AlteraPessoaAsyncTask(var pessoaDao: PessoaDao) : AsyncTask<Pessoa, Unit, Unit>() {
        override fun doInBackground(vararg params: Pessoa?) {
            return pessoaDao.update(params[0]!!)
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