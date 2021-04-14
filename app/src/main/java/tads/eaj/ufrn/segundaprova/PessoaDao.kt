package tads.eaj.ufrn.segundaprova

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface PessoaDao {
    @Insert
    fun insert(p:Pessoa)
    @Delete
    fun delete(p:Pessoa)
    @Update
    fun update(p: Pessoa)
    @Query("SELECT * FROM pessoa")
    fun listAll():LiveData<List<Pessoa>>
    @Query("SELECT * FROM pessoa WHERE id = :id")
    /*suspend*/ fun listById(id: Long):Pessoa
}