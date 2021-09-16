package com.project.foodrecipes.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import com.project.foodrecipes.R
import com.project.foodrecipes.tarif.*
import kotlinx.android.synthetic.main.activity_ilanekle.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_warning.*

class warning : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_warning)



        auth = FirebaseAuth.getInstance()
        val guncelkullanici = auth.currentUser

        back4.setOnClickListener {
            val intent1 = Intent(this@warning, MainActivity::class.java)
            startActivity(intent1)
            finish()
        }
        imagechicken.setOnClickListener {

            if (guncelkullanici != null) {
                val intent1 = Intent(this@warning, tarifekle::class.java)
                startActivity(intent1)
                finish()
            } else {

                val intent = Intent(this@warning, LoginActivity::class.java)
                startActivity(intent)
                finish()
            }
        }

        imagebreakfast.setOnClickListener {
            if (guncelkullanici != null) {
                val intent1 = Intent(this@warning, tarifekle13::class.java)
                startActivity(intent1)
                finish()
            } else {

                val intent = Intent(this@warning, LoginActivity::class.java)
                startActivity(intent)
                finish()

            }
        }
        imagebeef.setOnClickListener {
            if (guncelkullanici != null) {
                val intent1 = Intent(this@warning, tarifekle2::class.java)
                startActivity(intent1)
                finish()
            } else {

                val intent = Intent(this@warning, LoginActivity::class.java)
                startActivity(intent)
                finish()

            }
        }
        imagedessert.setOnClickListener {
            if (guncelkullanici != null) {
                val intent1 = Intent(this@warning, tarifekle3::class.java)
                startActivity(intent1)
                finish()
            } else {

                val intent = Intent(this@warning, LoginActivity::class.java)
                startActivity(intent)
                finish()

            }
        }
        imagelamb.setOnClickListener {
            if (guncelkullanici != null) {
                val intent1 = Intent(this@warning, tarifekle4::class.java)
                startActivity(intent1)
                finish()
            } else {

                val intent = Intent(this@warning, LoginActivity::class.java)
                startActivity(intent)
                finish()

            }
        }
        imagemiscellaneous.setOnClickListener {
            if (guncelkullanici != null) {
                val intent1 = Intent(this@warning, tarifekle5::class.java)
                startActivity(intent1)
                finish()
            } else {

                val intent = Intent(this@warning, LoginActivity::class.java)
                startActivity(intent)
                finish()

            }
        }
        imagepasta.setOnClickListener {
            if (guncelkullanici != null) {
                val intent1 = Intent(this@warning, tarifekle1::class.java)
                startActivity(intent1)
                finish()
            } else {

                val intent = Intent(this@warning, LoginActivity::class.java)
                startActivity(intent)
                finish()

            }
        }
        imagepork.setOnClickListener {
            if (guncelkullanici != null) {
                val intent1 =
                    Intent(this@warning, tarifekle6::class.java)
                startActivity(intent1)
                finish()
            } else {

                val intent =
                    Intent(this@warning, LoginActivity::class.java)
                startActivity(intent)
                finish()

            }
        }
        imageseafood.setOnClickListener {
            if (guncelkullanici != null) {
                val intent1 =
                    Intent(this@warning, tarifekle7::class.java)
                startActivity(intent1)
                finish()
            } else {

                val intent =
                    Intent(this@warning, LoginActivity::class.java)
                startActivity(intent)
                finish()

            }
        }
        imageside.setOnClickListener {
            if (guncelkullanici != null) {
                val intent1 =
                    Intent(this@warning, tarifekle8::class.java)
                startActivity(intent1)
                finish()
            } else {

                val intent =
                    Intent(
                        this@warning,
                        LoginActivity::class.java
                    )
                startActivity(intent)
                finish()

            }
        }
        imagestarter.setOnClickListener {
            if (guncelkullanici != null) {
                val intent1 =
                    Intent(
                        this@warning,
                        tarifekle10::class.java
                    )
                startActivity(intent1)
                finish()
            } else {

                val intent =
                    Intent(
                        this@warning,
                        LoginActivity::class.java
                    )
                startActivity(intent)
                finish()

            }
        }
        imagevegan.setOnClickListener {
            if (guncelkullanici != null) {
                val intent1 =
                    Intent(
                        this@warning,
                        tarifekle11::class.java
                    )
                startActivity(intent1)
                finish()
            } else {

                val intent =
                    Intent(
                        this@warning,
                        LoginActivity::class.java
                    )
                startActivity(intent)
                finish()
            }
        }
        imagefastfood.setOnClickListener {
            if (guncelkullanici != null) {
                val intent1 =
                    Intent(
                        this@warning,
                        tarifekle9::class.java
                    )
                startActivity(intent1)
                finish()
            } else {

                val intent =
                    Intent(
                        this@warning,
                        LoginActivity::class.java
                    )
                startActivity(intent)
                finish()
            }
        }
        imagevegetarian.setOnClickListener {
            if (guncelkullanici != null) {
                val intent1 =
                    Intent(
                        this@warning,
                        tarifekle12::class.java
                    )
                startActivity(intent1)
                finish()
            } else {

                val intent =
                    Intent(
                        this@warning,
                        LoginActivity::class.java
                    )
                startActivity(intent)
                finish()

            }
        }
        imagegoat.setOnClickListener {
            if (guncelkullanici != null) {
                val intent1 =
                    Intent(
                        this@warning,
                        tarifekle14::class.java
                    )
                startActivity(intent1)
                finish()
            } else {

                val intent =
                    Intent(
                        this@warning,
                        LoginActivity::class.java
                    )
                startActivity(intent)
                finish()

            }
        }

    }
}

