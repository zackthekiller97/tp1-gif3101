package ca.ulaval.ima.tp1

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.TextView
import ca.ulaval.ima.tp1.R
import java.text.SimpleDateFormat
import java.util.Locale

class ProfilActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_PROFIL = "EXTRA_PROFIL"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_profil)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val profil = intent.getParcelableExtra<Profil>(EXTRA_PROFIL)

        val txtPrenom = findViewById<TextView>(R.id.txtPrenom)
        val txtNom = findViewById<TextView>(R.id.txtNom)
        val txtDate = findViewById<TextView>(R.id.txtDate)
        val txtIdul = findViewById<TextView>(R.id.txtIdul)

        profil?.let {
            val formatter = SimpleDateFormat("dd/MM/yyyy", Locale.CANADA)

            txtPrenom.text = "Prénom : ${it.prenom}"
            txtNom.text = "Nom : ${it.nom}"
            txtDate.text = "Date de naissance : ${formatter.format(it.dateNaissance.time)}"
            txtIdul.text = "IDUL : ${it.idul}"
        }
    }
}