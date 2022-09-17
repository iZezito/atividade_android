package tads.eaj.ufrn.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class RecebeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recebe)
        val label = intent.extras?.getString("label")
        var valor = intent.extras?.getInt("valor")


        val textViewLabelVariavel = findViewById<TextView>(R.id.textViewLabelVariavel)
        val editTextVariavel = findViewById<TextView>(R.id.editTextTextVariavel)

        textViewLabelVariavel.text = label
        editTextVariavel.text = valor.toString()


        val buttonOk = findViewById<Button>(R.id.buttonOk)
        val buttonCancelar = findViewById<Button>(R.id.buttonCancelar)


        buttonOk.setOnClickListener {
            val intent = Intent()
            val bundle = Bundle()

            bundle.putInt("valor", editTextVariavel.text.toString().toInt())
            intent.putExtras(bundle)
            setResult(RESULT_OK, intent)
            finish()
        }

        buttonCancelar.setOnClickListener {
            setResult(RESULT_CANCELED)
            finish()
        }

    }
}