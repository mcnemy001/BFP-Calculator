package com.example.bfpcalculator.view

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.bfpcalculator.R
import com.example.bfpcalculator.databinding.ActivityResultBinding
import com.google.android.material.bottomsheet.BottomSheetDialog
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        displayResults()

        binding.btnInfo.setOnClickListener {
            val dialog = BottomSheetDialog(this)
            val view = layoutInflater.inflate(R.layout.bottomsheet_developer, null)
            dialog.setContentView(view)
            dialog.show()
        }
    }

    private fun displayResults() {
        val bmi = intent.getDoubleExtra("BMI", 0.0)
        val bfp = intent.getDoubleExtra("BFP", 0.0)
        val category = intent.getStringExtra("CATEGORY") ?: ""

        binding.tvBmiValue.text = String.format("%.2f", bmi)
        binding.tvBfpValue.text = String.format("%.2f%%", bfp)
        binding.tvCategoryValue.text = category
    }
}