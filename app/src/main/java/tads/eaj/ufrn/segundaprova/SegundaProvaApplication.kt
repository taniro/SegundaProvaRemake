package tads.eaj.ufrn.segundaprova

import android.app.Application
import tads.eaj.ufrn.segundaprova.database.AppDatabase
import tads.eaj.ufrn.segundaprova.database.repository.PessoaRepository

class SegundaProvaApplication : Application() {
    val database by lazy { AppDatabase.invoke(this) }
    val pessoaRepository by lazy { PessoaRepository(database.pessoaDao()) }
}