package com.example.bfpcalculator.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.bfpcalculator.R
import com.example.bfpcalculator.databinding.ActivityMainBinding
import com.example.bfpcalculator.viewmodel.BfpViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    // NIM : 10122384
    // Nama : Aziyusman Maulana
    // Kelas : ANDRO-4
    // Tanggal : 01/06/2025

    private lateinit var binding: ActivityMainBinding
    private val viewModel: BfpViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupObservers()
        setupClickListeners()
    }

    private fun setupObservers() {
        viewModel.bfpResult.observe(this) { result ->
            val intent = Intent(this, ResultActivity::class.java).apply {
                putExtra("BMI", result.bmi)
                putExtra("BFP", result.bfp)
                putExtra("CATEGORY", result.category)
            }
            startActivity(intent)
        }

        viewModel.inputError.observe(this) { error ->
            Toast.makeText(this, error, Toast.LENGTH_SHORT).show()
        }
    }

    private fun setupClickListeners() {
        binding.btnCalculate.setOnClickListener {
            val weight = binding.etWeight.text.toString()
            val height = binding.etHeight.text.toString()
            val age = binding.etAge.text.toString()
            val gender = if (binding.rbMale.isChecked) "Laki-laki" else "Perempuan"

            if (weight.isEmpty() || height.isEmpty() || age.isEmpty()) {
                Toast.makeText(this, "Lengkapi semua field", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            viewModel.calculateBfp(weight, height, age, gender)
        }
    }
}