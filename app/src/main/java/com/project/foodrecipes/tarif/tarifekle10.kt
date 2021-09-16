package com.project.foodrecipes.tarif

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import com.project.foodrecipes.R
import com.project.foodrecipes.activities.MainActivity
import com.project.foodrecipes.tarif.tarifekle10
import kotlinx.android.synthetic.main.activity_ilanekle.*
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_tarifekle.*
import kotlinx.android.synthetic.main.activity_tarifekle.btnBack3
import kotlinx.android.synthetic.main.activity_tarifekle.tarifadi
import kotlinx.android.synthetic.main.activity_tarifekle.tarifinstructions
import kotlinx.android.synthetic.main.activity_tarifekle.tarifkategori
import kotlinx.android.synthetic.main.activity_tarifekle.tarifmalzemeler
import kotlinx.android.synthetic.main.activity_tarifekle.tarifmalzemeolculeri
import kotlinx.android.synthetic.main.activity_tarifekle.x
import kotlinx.android.synthetic.main.activity_tarifekle10.*
import kotlinx.android.synthetic.main.activity_warning.*

import java.util.*

class tarifekle10 : AppCompatActivity() {
    private lateinit var auth1: FirebaseAuth
    private lateinit var storage1: FirebaseStorage
    private lateinit var database1: FirebaseFirestore

    var secilenGorsel: Uri? = null
    var secilenBitmap: Bitmap? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tarifekle10)
        auth1 = FirebaseAuth.getInstance()
        storage1 = FirebaseStorage.getInstance()
        database1 = FirebaseFirestore.getInstance()

        /*addrecipe.setOnClickListener {
            val intent = Intent(this@tarifekle, SignUpActivity::class.java)
            startActivity(intent)
            finish()
        }*/
       /* tarifekle.setOnClickListener {
            val intent = Intent(this@tarifekle, tariffeedyeni::class.java)
            startActivity(intent)
            finish()
        }*/

        btnBack3.setOnClickListener {
            val intent = Intent(this@tarifekle10, MainActivity::class.java)
            startActivity(intent)
            finish()

        }

        /*tarifekle.setOnClickListener {
            //tarifekle()
            val intent = Intent(this@tarifekle, deneme::class.java)
            startActivity(intent)
            finish()
        }*/

    }


    fun tarifekle(view: View) {

        tarifekle10.setOnClickListener {
            //tarifekle()
            val intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

            val uuid = UUID.randomUUID()
            val gorselismi1 = "${uuid}.jpg"

            val storage1 = FirebaseStorage.getInstance()
            val reference1 =
                storage1.reference
            val gorselReference = reference1.child("starter resim")
                .child(gorselismi1)
            if (secilenGorsel != null) {
                gorselReference.putFile(secilenGorsel!!).addOnSuccessListener { taskSnapshot ->
                    val yuklenenGorselReference1 =
                        FirebaseStorage.getInstance().reference.child("starter resim")
                            .child(gorselismi1)
                    yuklenenGorselReference1.downloadUrl.addOnSuccessListener { uri ->

                        val guncelkullaniciemaili1 = auth1.currentUser!!.email.toString()
                        val downloadUrl1 = uri.toString()
                        val tarifadi = tarifadi.text.toString()
                        val tarifkategori = tarifkategori.text.toString()
                        val tarifmalzemeler = tarifmalzemeler.text.toString()
                        val tarifmalzemeolculeri = tarifmalzemeolculeri.text.toString()
                        val tarifinstructions = tarifinstructions.text.toString()
                        val tarih1 = com.google.firebase.Timestamp.now()

                        val postHashMap1 = hashMapOf<String, Any>()

                        postHashMap1.put("kullaniciemaili", guncelkullaniciemaili1)
                        postHashMap1.put("x", downloadUrl1)
                        postHashMap1.put("tarifadi", tarifadi)
                        postHashMap1.put("tarifkategori", tarifkategori)
                        postHashMap1.put("tarifmalzemeler", tarifmalzemeler)
                        postHashMap1.put("tarifmalzemeolculeri", tarifmalzemeolculeri)
                        postHashMap1.put("tarifinstructions", tarifinstructions)
                        postHashMap1.put("tarih", tarih1)

                        database1.collection("Starter").add(postHashMap1)
                            .addOnCompleteListener { task ->
                                if (task.isSuccessful) {
                                    finish()
                                }
                            }.addOnFailureListener { exception ->
                                Toast.makeText(
                                    applicationContext,
                                    exception.localizedMessage,
                                    Toast.LENGTH_LONG
                                ).show()
                            }

                    }.addOnFailureListener { exception ->
                        Toast.makeText(
                            applicationContext,
                            exception.localizedMessage,
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }

            }
            //listener ekle

            /*val uyarimesaji=AlertDialog.Builder(this@ilanekle)
         uyarimesaji.setTitle("Emin misiniz?")
         uyarimesaji.setMessage("İlanı yayınlamak istediğinize emin misiniz?")

         uyarimesaji.setPositiveButton("Evet",DialogInterface.OnClickListener{dialogInterface, i ->
             Toast.makeText(this,"İlan Paylaşıldı.",Toast.LENGTH_LONG).show()
         })
         uyarimesaji.setPositiveButton("Hayır",DialogInterface.OnClickListener{dialogInterface, i ->
             Toast.makeText(this,"İlan İptal Edildi.",Toast.LENGTH_LONG).show()
         })
         uyarimesaji.show()*/


    }




        fun gorselSec1(view: View) {
            //izin verilmediyse
            if (ContextCompat.checkSelfPermission(
                    this,
                    Manifest.permission.READ_EXTERNAL_STORAGE
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
                    1
                )
            } else {
                //izin verildiyse
                val galeriIntent =
                    Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
                startActivityForResult(galeriIntent, 2)
            }
        }


        override fun onRequestPermissionsResult(
            requestCode: Int,
            permissions: Array<out String>,
            grantResults: IntArray
        ) {
            if (requestCode == 1) {
                if (grantResults.size > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    //izin verilince yapılacaklar
                    val galeriIntent =
                        Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
                    startActivityForResult(galeriIntent, 2)
                }
            }
            super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        }

        override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
            if (requestCode == 2 && resultCode == RESULT_OK && data != null) {
                secilenGorsel = data.data
                if (secilenGorsel != null) {
                    if (Build.VERSION.SDK_INT >= 28) {
                        val source =
                            ImageDecoder.createSource(this.contentResolver, secilenGorsel!!)
                        secilenBitmap = ImageDecoder.decodeBitmap(source)
                        x.setImageBitmap(secilenBitmap)
                    } else {
                        secilenBitmap =
                            MediaStore.Images.Media.getBitmap(this.contentResolver, secilenGorsel)
                        x.setImageBitmap(secilenBitmap)
                    }
                }
            }
            super.onActivityResult(requestCode, resultCode, data)
        }


        /* override fun onCreateOptionsMenu(menu: Menu?): Boolean { //inflater xmlleri kodla bağlamak menuinflater da menuyle xml bağlamak içindir
         val menuInflater = menuInflater
         menuInflater.inflate(R.menu.options_menu, menu) //artık menumuz feed activitesi ile bağlandı
         return super.onCreateOptionsMenu(menu)
     }

     override fun onOptionsItemSelected(item: MenuItem): Boolean {
         if (item.itemId == R.id.kullanici) {
             //ilan eklenecek
             val intent = Intent(this, UsersActivity::class.java)
             startActivity(intent)

         } else if (item.itemId == R.id.profil) {
             val intent = Intent(this, ProfileActivity::class.java)
             startActivity(intent)
         }else if(item.itemId == R.id.ilanekle){
             val intent=Intent(this, ilanekle::class.java)
             startActivity(intent)}
         else if(item.itemId == R.id.cikisyap){
             //önce firebaseden cıkıs yapmak lazım
             auth.signOut()
             val intent = Intent(this, LoginActivity::class.java) // cıkıs yaparsak bizi girişe yönlendirecek
             startActivity(intent)
             finish()
         }
         return super.onOptionsItemSelected(item)
     }*/

}
