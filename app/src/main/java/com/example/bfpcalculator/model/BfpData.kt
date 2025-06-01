package com.example.bfpcalculator.model

data class BfpData(
    val weight: Double,
    val height: Double,
    val age: Int,
    val gender: String
)

data class BfpResult(
    val bmi: Double,
    val bfp: Double,
    val category: String
)