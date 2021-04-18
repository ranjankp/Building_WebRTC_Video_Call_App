package com.example.vidcallapp

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.core.app.ActivityCompat
import com.google.firebase.ktx.Firebase
import com.google.firebase.ktx.initialize

class MainActivity : AppCompatActivity() {
    val permission= arrayOf(Manifest.permission.CAMERA, Manifest.permission.RECORD_AUDIO,Manifest.permission.BLUETOOTH)
    val requestcode = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(!isPermissionGranted()){
            askPermissions()
        }
        val usernameEdit = findViewById<EditText>(R.id.usernameEdit)
        val loginBtn = findViewById<Button>(R.id.loginBtn)

        Firebase.initialize(this)
        loginBtn.setOnClickListener {

            val username = usernameEdit.text.toString();
            val intent = Intent(this,CallActivity::class.java)
            intent.putExtra("username", username)
            startActivity(intent)
        }
    }
    private fun askPermissions() {
        ActivityCompat.requestPermissions(this,permission, requestcode)
    }
    private fun isPermissionGranted(): Boolean {

        permission.forEach {
            if (ActivityCompat.checkSelfPermission(this, it) != PackageManager.PERMISSION_GRANTED)
                return false
        }
        return true
    }
}
