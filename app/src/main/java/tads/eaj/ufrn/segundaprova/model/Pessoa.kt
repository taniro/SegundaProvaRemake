package tads.eaj.ufrn.segundaprova.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Pessoa(
        var nome: String,
        var sobrenome: String,
        var idade: Int,
        var sexo: String,
        var altura: Double,
        var peso: Double
) {
    @PrimaryKey (autoGenerate = true)
    var id = 0L

    constructor() : this("", "", 0, "", 0.0, 0.0)
}