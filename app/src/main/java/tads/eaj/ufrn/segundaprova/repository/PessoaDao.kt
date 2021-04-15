package tads.eaj.ufrn.segundaprova.repository

import androidx.lifecycle.LiveData
import androidx.room.*
import tads.eaj.ufrn.segundaprova.model.Pessoa

@Dao
interface PessoaDao {
    @Insert
    suspend fun insert(p: Pessoa)
    @Delete
    suspend fun delete(p: Pessoa)
    @Update
    suspend fun update(p: Pessoa)
    @Query("SELECT * FROM pessoa")
    fun listAll():LiveData<List<Pessoa>>
    @Query("SELECT * FROM pessoa WHERE id = :id")
    suspend fun listById(id: Long): Pessoa
}