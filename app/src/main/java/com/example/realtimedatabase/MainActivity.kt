package com.example.realtimedatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var ref: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ref = FirebaseDatabase.getInstance().getReference("USERS")

        btn_submit.setOnClickListener{ saveData() }
    }

    private fun saveData(){

        val nama = et_nama.text.toString()
        val email = et_email.text.toString()

        val user = Users(nama, email)
        val userId = ref.push().key.toString()

        ref.child(userId).setValue(user).addOnCompleteListener{
            Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show()
            et_nama.setText("")
            et_email.setText("")
    }
    }
}
