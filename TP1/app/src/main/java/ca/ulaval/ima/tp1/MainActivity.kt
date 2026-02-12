package ca.ulaval.ima.tp1

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Calendar
import android.content.Intent
import android.widget.Button
import ca.ulaval.ima.tp1.R

class MainActivity : AppCompatActivity() {
    private lateinit var monProfil: Profil
    private lateinit var urlDepartement: String
    private lateinit var urlGoogleMapsULaval: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val dateNaissance = Calendar.getInstance().apply {
            set(2001, Calendar.MAY, 1)
        }

        monProfil = Profil(
            nom = "Marcotte",
            prenom = "Zachary",
            dateNaissance = dateNaissance,
            idul = "53686190"
        )

        urlDepartement =
            "https://www.fsg.ulaval.ca/departements/departement-de-genie-electrique-et-de-genie-informatique"

        urlGoogleMapsULaval =
            "https://www.google.com/maps?q=Université+Laval"

        val btnUniversite = findViewById<Button>(R.id.btnUniversite)

        btnUniversite.setOnClickListener {
            val intent = Intent(this, UniversiteLavalActivity::class.java)
            intent.putExtra("URL_MAPS", urlGoogleMapsULaval)
            startActivity(intent)
        }

        val btnDepartement = findViewById<Button>(R.id.btnDepartement)

        btnDepartement.setOnClickListener {
            val intent = Intent(this, DepartementActivity::class.java)
            intent.putExtra("URL_DEPARTEMENT", urlDepartement)
            startActivity(intent)
        }

        val btnProfil = findViewById<Button>(R.id.btnProfil)

        btnProfil.setOnClickListener {
            val intent = Intent(this, ProfilActivity::class.java)
            intent.putExtra(ProfilActivity.EXTRA_PROFIL, monProfil)
            startActivity(intent)
        }
    }
}