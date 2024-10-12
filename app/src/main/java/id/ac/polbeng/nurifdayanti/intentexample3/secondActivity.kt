package id.ac.polbeng.nurifdayanti.intentexample3

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import id.ac.polbeng.nurifdayanti.intentexample3.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val bundle = intent.getBundleExtra("main_activity_data")
        val height = bundle?.getDouble("height")
        val weight = bundle?.getDouble("weight")
        binding.txtIntentData.text = "Height: $height | Weight: $weight"
        binding.btnCalculate.setOnClickListener {
            val intent = Intent()
            var bmiValue = 0.0
            if (height != null && weight != null){
                bmiValue = 703 * (weight / (height * height))
            }
            intent.putExtra("second_activity_data", bmiValue)
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }
}

class secondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}