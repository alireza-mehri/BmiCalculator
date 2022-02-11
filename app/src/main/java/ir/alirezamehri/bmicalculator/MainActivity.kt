package ir.alirezamehri.bmicalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.slider.Slider
import ir.alirezamehri.bmicalculator.databinding.ActivityMainBinding
import kotlin.math.roundToInt


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        var gender = "male"
        var age = 19
        var weight = 74
        var height = 180

        // gender change
        binding.cardFemale.setOnClickListener() {
            gender = "female"
            binding.cardFemale.setCardBackgroundColor(getResources().getColor(R.color.DarkBlue100))
            binding.femaleText.setTextColor(getResources().getColor(R.color.white))

            binding.cardMale.setCardBackgroundColor(getResources().getColor(R.color.DarkBlue200))
            binding.maleText.setTextColor(getResources().getColor(R.color.gray))
        }
        binding.cardMale.setOnClickListener() {
            gender = "male"
            binding.cardMale.setCardBackgroundColor(getResources().getColor(R.color.DarkBlue100))
            binding.maleText.setTextColor(getResources().getColor(R.color.white))

            binding.cardFemale.setCardBackgroundColor(getResources().getColor(R.color.DarkBlue200))
            binding.femaleText.setTextColor(getResources().getColor(R.color.gray))
        }
        // age change
        binding.BaddAge.setOnClickListener() {
            if (age < 120) {
                age++
                binding.age.setText(age.toString())
            }
        }
        binding.BremoveAge.setOnClickListener() {
            if (age > 1) {
                age--
                binding.age.setText(age.toString())
            }
        }
        // weight change
        binding.BaddWeight.setOnClickListener() {
            if (weight < 250) {
                weight++
                binding.weight.setText(weight.toString())
            }
        }
        binding.BremoveWeight.setOnClickListener() {
            if (weight > 1) {
                weight--
                binding.weight.setText(weight.toString())
            }
        }
        // slider
        binding.continuousSlider.addOnSliderTouchListener(object : Slider.OnSliderTouchListener {
            override fun onStartTrackingTouch(slider: Slider) {
                // Responds to when slider's touch event is being started
                height = binding.continuousSlider.value.roundToInt()
                binding.height.setText(
                    binding.continuousSlider.value.roundToInt().toString() + " cm"
                )
            }

            override fun onStopTrackingTouch(slider: Slider) {
                // Responds to when slider's touch event is being stopped
                height = binding.continuousSlider.value.roundToInt()
                binding.height.setText(
                    binding.continuousSlider.value.roundToInt().toString() + " cm"
                )
            }
        })
        // computing
        binding.Bcomputing.setOnClickListener(){
            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("age",age)
            intent.putExtra("gender",gender)
            intent.putExtra("weight",weight)
            intent.putExtra("height",height)
            startActivity(intent)
        }

        // about
        binding.Babout.setOnClickListener(){
            val intent = Intent(this, InfoActivity::class.java)
            startActivity(intent)
        }
    }
}