package tads.eaj.ufrn.segundaprova.database.repository

import androidx.annotation.UiThread
import androidx.annotation.WorkerThread
import tads.eaj.ufrn.segundaprova.model.Pessoa
import kotlinx.coroutines.flow.Flow
import tads.eaj.ufrn.segundaprova.database.dao.PessoaDao

class PessoaRepository(private val pessoaDao: PessoaDao) {

    val listAll: Flow<List<Pessoa>> = pessoaDao.listAll()

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