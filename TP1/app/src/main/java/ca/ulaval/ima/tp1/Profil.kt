package ca.ulaval.ima.tp1

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.util.Calendar

@Parcelize
data class Profil(
    val nom: String,
    val prenom: String,
    val dateNaissance: Calendar,
    val idul: String
) : Parcelable