package tads.eaj.ufrn.segundaprova.database.dao

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import tads.eaj.ufrn.segundaprova.model.Pessoa

@Dao
interface PessoaDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(p: Pessoa)
    @Delete
    suspend fun delete(p: Pessoa)
    @Update
    suspend fun update(p: Pessoa)
    @Query("SELECT * FROM pessoa")
    fun listAll(): Flow<List<Pessoa>>
    @Query("SELECT * FROM pessoa WHERE id = :id")
    suspend fun listById(id: Long): Pessoa
}