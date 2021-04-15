package tads.eaj.ufrn.segundaprova.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import tads.eaj.ufrn.segundaprova.database.dao.PessoaDao
import tads.eaj.ufrn.segundaprova.model.Pessoa

@Database(entities = [Pessoa::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun pessoaDao(): PessoaDao

    companion object {
        @Volatile private var instance: AppDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context)= instance ?: synchronized(LOCK){
            instance ?: buildDatabase(context).also { instance = it}
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(context,
            AppDatabase::class.java, "palmas_database.db")
            .fallbackToDestructiveMigration()
            .build()
    }
}