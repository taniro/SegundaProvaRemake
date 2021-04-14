package tads.eaj.ufrn.segundaprova

import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.AndroidViewModel
import androidx.room.Room

class CadastraFragmentViewModel (application: Application) : AndroidViewModel(application)  {
    var pessoa:Pessoa = Pessoa()

    private val db:PessoaDatabase by lazy {
        Room.databaseBuilder(application.applicationContext, PessoaDatabase::class.java, "pessoas.sqlite")
            .build()
    }


    fun cadastraPessoa() = CadastraPessoaAsyncTask(db.pessoaDao()).execute(pessoa)

    class CadastraPessoaAsyncTask(var pessoaDao: PessoaDao) : AsyncTask<Pessoa, Unit, Unit>() {
        override fun doInBackground(vararg params: Pessoa?) {
            return pessoaDao.insert(params[0]!!)
        }
    }
}