package com.project.foodrecipes.tarif

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import com.project.foodrecipes.R
import com.project.foodrecipes.activities.MainActivity
import kotlinx.android.synthetic.main.activity_deneme.*
import kotlinx.android.synthetic.main.activity_feed.*
import kotlinx.android.synthetic.main.activity_ilanekle.*
import kotlinx.android.synthetic.main.activity_ilanekle.view.*

import kotlinx.android.synthetic.main.recycler_row.*

import java.util.*
import kotlin.collections.ArrayList


class deneme3 : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var database: FirebaseFirestore
    private lateinit var recyclerViewAdapter: tariffeedadapter2_3
    var tariflistesi = ArrayList<tarif3>()
    //val displayList = ArrayList<tarif>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_deneme3)

        auth = FirebaseAuth.getInstance()
        database = FirebaseFirestore.getInstance()
        veri3()
        var layoutManager1 = LinearLayoutManager(this)
        irem.layoutManager = layoutManager1
        recyclerViewAdapter = tariffeedadapter2_3(tariflistesi)
        irem.adapter = recyclerViewAdapter

        //recyclerView1.layoutManager= LinearLayoutManager(this, LinearLayout.VERTICAL,false)

        exitbutton1.setOnClickListener {
            val intent = Intent(this@deneme3, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
       commentbutton_2.setOnClickListener {
            val intent = Intent(this@deneme3, tarifekle3::class.java)
            startActivity(intent)
            finish()
        }

    }

    fun veri3() {
        database.collection("Dessert")
            .orderBy("tarih", Query.Direction.DESCENDING)
            .addSnapshotListener { snapshot, exception ->
                if (exception != null) {
                    Toast.makeText(this, exception.localizedMessage, Toast.LENGTH_LONG).show()
                } else {
                    if (snapshot != null) {
                        if (!snapshot.isEmpty) {
                            val documents = snapshot.documents
                            tariflistesi.clear()
                            for (document in documents) {
                                val tarifadi = document.get("tarifadi") as? String
                                val kullaniciemaili = document.get("kullaniciemaili") as? Any
                                val tarifkategori = document.get("tarifkategori") as? String
                                val tarifmalzemeler = document.get("tarifmalzemeler") as? String
                                val tarifmalzemeolculeri = document.get("tarifmalzemeolculeri") as? Any
                                //val cinsiyet: String? = null
                                val tarifinstructions = document.get("tarifinstructions") as? String
                                val x = document.get("x") as? String
                                val indirilenpost1 = tarif3(tarifadi,kullaniciemaili,tarifkategori,tarifmalzemeler,tarifmalzemeolculeri,tarifinstructions,x)
                                tariflistesi.add(indirilenpost1)
                            }
                            recyclerViewAdapter.notifyDataSetChanged()
                        }

                    }
                }

            }
    }


}




