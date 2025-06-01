package com.example.bfpcalculator.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.bfpcalculator.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class InfoDeveloper : BottomSheetDialogFragment() {

    override fun onCreateView(
        inflate: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ) : View? {
        return inflate.inflate(R.layout.bottomsheet_developer, container, false)
    }
}