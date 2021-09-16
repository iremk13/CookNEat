package com.project.foodrecipes.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import com.project.foodrecipes.R
import kotlinx.android.synthetic.main.activity_warning.*
import kotlinx.android.synthetic.main.activity_warning.imagebeef
import kotlinx.android.synthetic.main.activity_warning.imagebreakfast
import kotlinx.android.synthetic.main.activity_warning.imagechicken
import kotlinx.android.synthetic.main.activity_warning.imagedessert
import kotlinx.android.synthetic.main.activity_warning.imagefastfood
import kotlinx.android.synthetic.main.activity_warning.imagegoat
import kotlinx.android.synthetic.main.activity_warning.imagelamb
import kotlinx.android.synthetic.main.activity_warning.imagemiscellaneous
import kotlinx.android.synthetic.main.activity_warning.imagepasta
import kotlinx.android.synthetic.main.activity_warning.imagepork
import kotlinx.android.synthetic.main.activity_warning.imageseafood
import kotlinx.android.synthetic.main.activity_warning.imageside
import kotlinx.android.synthetic.main.activity_warning.imagestarter
import kotlinx.android.synthetic.main.activity_warning.imagevegan
import kotlinx.android.synthetic.main.activity_warning.imagevegetarian
import kotlinx.android.synthetic.main.activity_warning2.*

class warning2 : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_warning2)
        auth = FirebaseAuth.getInstance()
        back5.setOnClickListener {
            val intent1 = Intent(this@warning2, MainActivity::class.java)
            startActivity(intent1)
            finish()
        }
                val guncelkullanici = auth.currentUser
                imagechicken.setOnClickListener {

                    if (guncelkullanici != null) {
                        val intent1 = Intent(this@warning2, ilanekle::class.java)
                        startActivity(intent1)
                        finish()
                    } else {

                        val intent = Intent(this@warning2, LoginActivity::class.java)
                        startActivity(intent)
                        finish()
                    }
                }

                imagebreakfast.setOnClickListener {
                    if (guncelkullanici != null) {
                        val intent1 = Intent(this@warning2, ilanekle::class.java)
                        startActivity(intent1)
                        finish()
                    } else {

                        val intent = Intent(this@warning2, LoginActivity::class.java)
                        startActivity(intent)
                        finish()

                    }
                }
                imagebeef.setOnClickListener {
                    if (guncelkullanici != null) {
                        val intent1 = Intent(this@warning2, ilanekle::class.java)
                        startActivity(intent1)
                        finish()
                    } else {

                        val intent = Intent(this@warning2, LoginActivity::class.java)
                        startActivity(intent)
                        finish()

                    }
                }
                imagedessert.setOnClickListener {
                    if (guncelkullanici != null) {
                        val intent1 = Intent(this@warning2, ilanekle::class.java)
                        startActivity(intent1)
                        finish()
                    } else {

                        val intent = Intent(this@warning2, LoginActivity::class.java)
                        startActivity(intent)
                        finish()

                    }
                }
                imagelamb.setOnClickListener {
                    if (guncelkullanici != null) {
                        val intent1 = Intent(this@warning2, ilanekle::class.java)
                        startActivity(intent1)
                        finish()
                    } else {

                        val intent = Intent(this@warning2, LoginActivity::class.java)
                        startActivity(intent)
                        finish()

                    }
                }
                imagemiscellaneous.setOnClickListener {
                    if (guncelkullanici != null) {
                        val intent1 = Intent(this@warning2, ilanekle::class.java)
                        startActivity(intent1)
                        finish()
                    } else {

                        val intent = Intent(this@warning2, LoginActivity::class.java)
                        startActivity(intent)
                        finish()

                    }
                }
                imagepasta.setOnClickListener {
                    if (guncelkullanici != null) {
                        val intent1 = Intent(this@warning2, ilanekle::class.java)
                        startActivity(intent1)
                        finish()
                    } else {

                        val intent = Intent(this@warning2, LoginActivity::class.java)
                        startActivity(intent)
                        finish()

                    }
                }
                imagepork.setOnClickListener {
                    if (guncelkullanici != null) {
                        val intent1 =
                            Intent(this@warning2, ilanekle::class.java)
                        startActivity(intent1)
                        finish()
                    } else {

                        val intent =
                            Intent(this@warning2, LoginActivity::class.java)
                        startActivity(intent)
                        finish()

                    }
                }
                imageseafood.setOnClickListener {
                    if (guncelkullanici != null) {
                        val intent1 =
                            Intent(this@warning2, ilanekle::class.java)
                        startActivity(intent1)
                        finish()
                    } else {

                        val intent =
                            Intent(this@warning2, LoginActivity::class.java)
                        startActivity(intent)
                        finish()

                    }
                }
                imageside.setOnClickListener {
                    if (guncelkullanici != null) {
                        val intent1 =
                            Intent(this@warning2, ilanekle::class.java)
                        startActivity(intent1)
                        finish()
                    } else {

                        val intent =
                            Intent(
                                this@warning2,
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
                                this@warning2,
                                ilanekle::class.java
                            )
                        startActivity(intent1)
                        finish()
                    } else {

                        val intent =
                            Intent(
                                this@warning2,
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
                                this@warning2,
                                ilanekle::class.java
                            )
                        startActivity(intent1)
                        finish()
                    } else {

                        val intent =
                            Intent(
                                this@warning2,
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
                                this@warning2,
                                ilanekle::class.java
                            )
                        startActivity(intent1)
                        finish()
                    } else {

                        val intent =
                            Intent(
                                this@warning2,
                                ilanekle::class.java
                            )
                        startActivity(intent)
                        finish()
                    }
                }
                imagevegetarian.setOnClickListener {
                    if (guncelkullanici != null) {
                        val intent1 =
                            Intent(
                                this@warning2,
                                ilanekle::class.java
                            )
                        startActivity(intent1)
                        finish()
                    } else {

                        val intent =
                            Intent(
                                this@warning2,
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
                                this@warning2,
                                ilanekle::class.java
                            )
                        startActivity(intent1)
                        finish()
                    } else {

                        val intent =
                            Intent(
                                this@warning2,
                                LoginActivity::class.java
                            )
                        startActivity(intent)
                        finish()

                    }
                }

            }
        }


