package com.example.flixterplus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

/**
 * The MainActivity for the FlixterPlus app.
 * Launches a [FlixterPlusFragment].
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val supportFragmentManager = supportFragmentManager
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.content, FlixterPlusFragment(), null).commit()
    }
}