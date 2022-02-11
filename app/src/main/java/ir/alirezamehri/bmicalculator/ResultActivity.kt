package ir.alirezamehri.bmicalculator

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.github.inflationx.viewpump.ViewPumpContextWrapper
import ir.alirezamehri.bmicalculator.databinding.ActivityResultBinding
import kotlin.math.pow

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding
    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase!!))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityResultBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //val age = getIntent().getIntExtra("age", 0)
        //val gender = getIntent().getStringExtra("gender")
        val height = intent.getIntExtra("height", 0)
        val weight = intent.getIntExtra("weight", 0)
        val bmi: Double = computing(weight, height)

        binding.Bback.setOnClickListener() {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        binding.bmiNumber.text = String.format("%.2f", bmi)
        binding.result1.text = getResult(bmi)
        binding.result2.text = getInterpretation(bmi)


    }

}


fun computing(weight: Int, height: Int): Double {
    val heightm = height.toDouble() / 100
    return weight.toDouble() / heightm.pow(2.0)
}

fun getResult(bmi: Double): String {
    if (bmi >= 25.0) {
        return "اضافه وزن"
    } else if (bmi > 18.5) {
        return "عادی"
    } else {
        return "کمبود وزن"
    }
}

fun getInterpretation(bmi: Double): String {
    return if (bmi >= 25.0) {
        "وزن بدن شما بالاتر از حد طبیعی است. سعی کنید بیشتر ورزش کنید."
    } else if (bmi >= 18.5) {
        "شما وزن طبیعی دارید. آفرین!"
    } else {
        "وزن بدن شما کمتر از حد طبیعی است. می توانید کمی بیشتر بخورید."
    }
}

