package com.example.bfpcalculator.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.bfpcalculator.model.BfpData
import com.example.bfpcalculator.model.BfpResult
import com.example.bfpcalculator.repository.BfpRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class BfpViewModel @Inject constructor(
    private val repository: BfpRepository
) : ViewModel() {

    private val _bfpResult = MutableLiveData<BfpResult>()
    val bfpResult: LiveData<BfpResult> = _bfpResult

    private val _inputError = MutableLiveData<String>()
    val inputError: LiveData<String> = _inputError

    fun calculateBfp(weight: String, height: String, age: String, gender: String) {
        try {
            val weightDouble = weight.toDouble()
            val heightDouble = height.toDouble()
            val ageInt = age.toInt()

            if (weightDouble <= 0 || heightDouble <= 0 || ageInt <= 0) {
                _inputError.value = "Masukkan nilai yang valid (lebih besar dari 0)"
                return
            }

            val bfpData = BfpData(weightDouble, heightDouble, ageInt, gender)
            val result = repository.calculateBfp(bfpData)
            _bfpResult.value = result

        } catch (e: NumberFormatException) {
            _inputError.value = "Masukkan angka yang valid"
        }
    }
}