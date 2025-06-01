package com.example.bfpcalculator.repository

import com.example.bfpcalculator.model.BfpData
import com.example.bfpcalculator.model.BfpResult
import javax.inject.Inject
import kotlin.math.pow

class BfpRepository @Inject constructor() {

    fun calculateBfp(data: BfpData): BfpResult {
        // Calculate BMI
        val heightInMeters = data.height / 100
        val bmi = data.weight / (heightInMeters.pow(2))

        // Calculate BFP
        val bfp = if (data.gender == "Laki-laki") {
            (1.20 * bmi) + (0.23 * data.age) - 16.2
        } else {
            (1.20 * bmi) + (0.23 * data.age) - 5.4
        }

        // Determine category
        val category = when {
            bfp < 10 -> "Sangat Rendah"
            bfp <= 20 -> "Rendah (10-20%)"
            bfp <= 25 -> "Normal (21-25%)"
            bfp <= 30 -> "Tinggi (26-30%)"
            else -> "Sangat Tinggi (> 30%)"
        }
        return BfpResult(bmi, bfp, category)
    }
}