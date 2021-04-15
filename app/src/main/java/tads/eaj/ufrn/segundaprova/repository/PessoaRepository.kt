package tads.eaj.ufrn.segundaprova.repository

import android.content.Context
import androidx.lifecycle.LiveData
import tads.eaj.ufrn.segundaprova.model.Pessoa

class PessoaRepository(context: Context) {

    private val pessoaDao: PessoaDao
    val listAll:LiveData<List<Pessoa>>

    init {
        val applicationDatabase:AppDatabase = AppDatabase.invoke(context)
        pessoaDao = applicationDatabase.pessoaDao()
        listAll = pessoaDao.listAll()
    }

    suspend fun insert(p: Pessoa){
        pessoaDao.insert(p)
    }
    suspend fun delete(p: Pessoa){
        pessoaDao.delete(p)
    }

    suspend fun update(p: Pessoa){
        pessoaDao.update(p)
    }

    suspend fun listById(id: Long): Pessoa{
        return pessoaDao.listById(id)
    }
}