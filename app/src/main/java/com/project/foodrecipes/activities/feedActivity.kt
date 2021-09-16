package com.project.foodrecipes.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.project.foodrecipes.R
import kotlinx.android.synthetic.main.activity_detail_recipe.*
import kotlinx.android.synthetic.main.activity_feed.*

import kotlinx.android.synthetic.main.activity_login.*

class feedActivity : AppCompatActivity() {
    private lateinit var auth : FirebaseAuth
    private lateinit var database : FirebaseFirestore
    private lateinit var recyclerViewAdapter : feedRecyclerAdapter


    var ilanlistesi=ArrayList<ilan>()
    val db= Firebase.firestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feed)

        auth = FirebaseAuth.getInstance()
        database = FirebaseFirestore.getInstance()
        verilerial()
        var layoutManager= LinearLayoutManager(this)
        recyclerView.layoutManager=layoutManager
        recyclerViewAdapter= feedRecyclerAdapter(ilanlistesi)
        recyclerView.adapter=recyclerViewAdapter




        val guncelkullanici1 = auth.currentUser
        commentbutton.setOnClickListener {
            if(guncelkullanici1 == null) {
                val intent = Intent(this@feedActivity, LoginActivity::class.java)
                startActivity(intent)
                finish()
            }
            else{
                val intent = Intent(this@feedActivity, ilanekle::class.java)
                startActivity(intent)
                finish()
            }
        }

        exitbutton.setOnClickListener {
            val intent = Intent(this@feedActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    fun verilerial (){

        db.collection("yorum").orderBy("tarih", Query.Direction.DESCENDING).addSnapshotListener { snapshot, error ->
            if(error != null){
                Toast.makeText(this,error.localizedMessage,Toast.LENGTH_LONG).show()
            } else {
                if (snapshot != null){
                    if(!snapshot.isEmpty) {
                        val documents = snapshot.documents
                        ilanlistesi.clear()
                        for(document in documents){
                            val guncelkullaniciemaili = document.get("guncelkullaniciemaili") as? String
                            val yemekadi = document.get("yemekadi") as? String
                            val yemekkategori = document.get("yemekkategori") as? String
                            val yorum = document.get("yorum") as? String


                            val indirilenpost= ilan(guncelkullaniciemaili,yemekadi,yemekkategori,yorum)
                            ilanlistesi.add(indirilenpost)
                        }
                        recyclerViewAdapter.notifyDataSetChanged()
                    }
                }
            }
        }
        /*database.collection("Yorum").orderBy("tarih", Query.Direction.DESCENDING) //en son girilen tarih ilk basta cıkacak
            .addSnapshotListener { snapshot, exception ->
                if(exception != null){
                    Toast.makeText(this,exception.localizedMessage, Toast.LENGTH_LONG).show()
                }else{
                    if(snapshot != null){
                        if(!snapshot.isEmpty){
                            val documents = snapshot.documents
                            ilanlistesi.clear()
                            for(document in documents){
                                val kullaniciemail=document.get("kullaniciemail") as String //isimler ilan eklede yazılanın aynısı olmalı
                                val yemekadi=document.get("yemekadi") as String
                                val yemekkategori=document.get("yemekkategori") as String?
                                val yorum=document.get("yorum") as String
                              val gorselurl=document.get("gorselurl") as String?
                                val indirilenpost= ilan(kullaniciemail,yemekadi,yemekkategori,yorum,gorselurl)
                                ilanlistesi.add(indirilenpost)

                            }
                            recyclerViewAdapter.notifyDataSetChanged()
                        }

                    }
                }

            }*/
    }



}