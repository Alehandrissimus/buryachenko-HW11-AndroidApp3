package com.example.buryachenko_hw11_androidapp3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.buryachenko_hw11_androidapp3.databinding.ActivityMainBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior
import kotlinx.android.synthetic.main.bottom_sheet.view.*


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val bottomSheetBehavior: BottomSheetBehavior<ConstraintLayout> by lazy {
        BottomSheetBehavior.from(
            binding.root.bottomSheetContainer
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupBinding()
        setupListeners()
        setupBottomSheet()
    }

    private fun setupBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun setupListeners() {
        binding.mainButton1.setOnClickListener {
            showAlertDialog()
        }
        binding.mainButton2.setOnClickListener {
            showDialogFragment()
        }
        binding.mainButton3.setOnClickListener {
            showBottomSheet()
        }
        binding.mainButton4.setOnClickListener {
            showBottomSheetDialogFragment()
        }
    }

    private fun showAlertDialog() {
        AlertDialog.Builder(this)
            .setTitle("Title dialog")
            .setMessage("Message")
            .setIcon(R.drawable.ic_launcher_foreground)
            .setPositiveButton("Apply") { dialog, which ->
                Toast.makeText(this, "Yes", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("Decline") { dialog, which ->
                Toast.makeText(this, "No", Toast.LENGTH_SHORT).show()
            }
            .show()
    }

    private fun showDialogFragment() {
        supportFragmentManager.beginTransaction()
            .add(MyDialogFragment(), "TAG")
            .commitAllowingStateLoss()
    }

    private fun setupBottomSheet() {
        bottomSheetBehavior.state = BottomSheetBehavior.STATE_HIDDEN
    }

    private fun showBottomSheet() {
        bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
    }

    private fun showBottomSheetDialogFragment() {
        supportFragmentManager.beginTransaction()
            .add(MyBottomSheetDialogFragment(), "TAG")
            .commitAllowingStateLoss()
    }
}
