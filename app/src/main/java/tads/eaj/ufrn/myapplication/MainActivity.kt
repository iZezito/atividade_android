package tads.eaj.ufrn.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {

    var variavelX:Int = 0
    var variavelY:Int = 0
    var resultado:Int = 0

    val setVariavelXLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            result ->
                if(result.resultCode == RESULT_OK){
                    variavelX = result.data!!.getIntExtra("valor",0)
                    var textViewVarialvelX = findViewById<TextView>(R.id.textViewVariavelX)
                    textViewVarialvelX.text = "${variavelX}"

                }

    }

    val setVariavelYLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            result ->
                if(result.resultCode == RESULT_OK) {
                    variavelY = result.data!!.getIntExtra("valor",0)
                    val textViewVarialvelY = findViewById<TextView>(R.id.textViewVariavelY)
                    textViewVarialvelY.text = "${variavelY}"

                }

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val textViewVarialvelX = findViewById<TextView>(R.id.textViewVariavelX)
        val textViewVarialvelY = findViewById<TextView>(R.id.textViewVariavelY)
        val textViewResultado = findViewById<TextView>(R.id.textViewResultado)


        val buttonSetVariavelX = findViewById<Button>(R.id.buttonSetVariavelX)
        val buttonSetVariavelY = findViewById<Button>(R.id.buttonSetVariavelY)
        val buttonCalcular = findViewById<Button>(R.id.buttonCalcular)

        textViewVarialvelX.text = "${variavelX}"
        textViewVarialvelY.text = "${variavelY}"
        textViewResultado.text = "${resultado}"

        buttonSetVariavelX.setOnClickListener {
            val intent = Intent(this, RecebeActivity::class.java)

            val bundle: Bundle = Bundle()
            bundle.putString("label", "Variável X:")
            bundle.putInt("valor",variavelX)
            intent.putExtras(bundle)
            setVariavelXLauncher.launch(intent)
        }

        buttonSetVariavelY.setOnClickListener {
            val intent = Intent(this, RecebeActivity::class.java)
            val bundle: Bundle = Bundle()
            bundle.putString("label", "Variável Y:")
            bundle.putInt("valor",variavelY)
            intent.putExtras(bundle)
            setVariavelYLauncher.launch(intent)

        }
        buttonCalcular.setOnClickListener {
            textViewResultado.text = "${variavelX + variavelY}"
        }
    }
}