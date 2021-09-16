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

class warningforrecipe : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_warningforrecipe)



        auth = FirebaseAuth.getInstance()
        val guncelkullanici = auth.currentUser

        back4.setOnClickListener {
            val intent1 = Intent(this@warningforrecipe, MainActivity::class.java)
            startActivity(intent1)
            finish()
        }
        imagechicken.setOnClickListener {

            if (guncelkullanici != null) {
                val intent1 = Intent(this@warningforrecipe, deneme::class.java)
                startActivity(intent1)
                finish()
            } else {

                val intent = Intent(this@warningforrecipe, LoginActivity::class.java)
                startActivity(intent)
                finish()
            }
        }

        imagebreakfast.setOnClickListener {
            if (guncelkullanici != null) {
                val intent1 = Intent(this@warningforrecipe, deneme13::class.java)
                startActivity(intent1)
                finish()
            } else {

                val intent = Intent(this@warningforrecipe, LoginActivity::class.java)
                startActivity(intent)
                finish()

            }
        }
        imagebeef.setOnClickListener {
            if (guncelkullanici != null) {
                val intent1 = Intent(this@warningforrecipe, deneme2::class.java)
                startActivity(intent1)
                finish()
            } else {

                val intent = Intent(this@warningforrecipe, LoginActivity::class.java)
                startActivity(intent)
                finish()

            }
        }
        imagedessert.setOnClickListener {
            if (guncelkullanici != null) {
                val intent1 = Intent(this@warningforrecipe, deneme3::class.java)
                startActivity(intent1)
                finish()
            } else {

                val intent = Intent(this@warningforrecipe, LoginActivity::class.java)
                startActivity(intent)
                finish()

            }
        }
        imagelamb.setOnClickListener {
            if (guncelkullanici != null) {
                val intent1 = Intent(this@warningforrecipe, deneme4::class.java)
                startActivity(intent1)
                finish()
            } else {

                val intent = Intent(this@warningforrecipe, LoginActivity::class.java)
                startActivity(intent)
                finish()

            }
        }
        imagemiscellaneous.setOnClickListener {
            if (guncelkullanici != null) {
                val intent1 = Intent(this@warningforrecipe, deneme5::class.java)
                startActivity(intent1)
                finish()
            } else {

                val intent = Intent(this@warningforrecipe, LoginActivity::class.java)
                startActivity(intent)
                finish()

            }
        }
        imagepasta.setOnClickListener {
            if (guncelkullanici != null) {
                val intent1 = Intent(this@warningforrecipe, deneme1::class.java)
                startActivity(intent1)
                finish()
            } else {

                val intent = Intent(this@warningforrecipe, LoginActivity::class.java)
                startActivity(intent)
                finish()

            }
        }
        imagepork.setOnClickListener {
            if (guncelkullanici != null) {
                val intent1 =
                    Intent(this@warningforrecipe, deneme6::class.java)
                startActivity(intent1)
                finish()
            } else {

                val intent =
                    Intent(this@warningforrecipe, LoginActivity::class.java)
                startActivity(intent)
                finish()

            }
        }
        imageseafood.setOnClickListener {
            if (guncelkullanici != null) {
                val intent1 =
                    Intent(this@warningforrecipe, deneme7::class.java)
                startActivity(intent1)
                finish()
            } else {

                val intent =
                    Intent(this@warningforrecipe, LoginActivity::class.java)
                startActivity(intent)
                finish()

            }
        }
        imageside.setOnClickListener {
            if (guncelkullanici != null) {
                val intent1 =
                    Intent(this@warningforrecipe, deneme8::class.java)
                startActivity(intent1)
                finish()
            } else {

                val intent =
                    Intent(
                        this@warningforrecipe,
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
                        this@warningforrecipe,
                        deneme10::class.java
                    )
                startActivity(intent1)
                finish()
            } else {

                val intent =
                    Intent(
                        this@warningforrecipe,
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
                        this@warningforrecipe,
                        deneme11::class.java
                    )
                startActivity(intent1)
                finish()
            } else {

                val intent =
                    Intent(
                        this@warningforrecipe,
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
                        this@warningforrecipe,
                        deneme9::class.java
                    )
                startActivity(intent1)
                finish()
            } else {

                val intent =
                    Intent(
                        this@warningforrecipe,
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
                        this@warningforrecipe,
                        deneme12::class.java
                    )
                startActivity(intent1)
                finish()
            } else {

                val intent =
                    Intent(
                        this@warningforrecipe,
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
                        this@warningforrecipe,
                        deneme14::class.java
                    )
                startActivity(intent1)
                finish()
            } else {

                val intent =
                    Intent(
                        this@warningforrecipe,
                        LoginActivity::class.java
                    )
                startActivity(intent)
                finish()

            }
        }

    }
}

