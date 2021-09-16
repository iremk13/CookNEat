package com.project.foodrecipes.activities

import android.app.Activity
import android.app.ProgressDialog
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONObjectRequestListener
import com.project.foodrecipes.R
import com.project.foodrecipes.adapter.MainAdapter
import com.project.foodrecipes.model.ModelMain
import com.project.foodrecipes.networking.Api
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar_main.*
import org.json.JSONException
import org.json.JSONObject
import java.util.*
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_login.*

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity(), MainAdapter.onSelectData {

    var mainAdapter: MainAdapter? = null
    private lateinit var firebaseUser: FirebaseUser


    var progressDialog: ProgressDialog? = null
    var modelMain: MutableList<ModelMain> = ArrayList()
    lateinit var searchView: SearchView
    private lateinit var auth : FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        auth = FirebaseAuth.getInstance()


        val guncelkullanici = auth.currentUser



        yorumgoster.setOnClickListener {
                val intent = Intent(this@MainActivity, feedActivity::class.java)
                startActivity(intent)
                finish()

            }

        comment.setOnClickListener {
            if(guncelkullanici != null){
                val intent1 = Intent(this@MainActivity, warning2::class.java)
                startActivity(intent1)
                finish()
            }else{
                val intent = Intent(this@MainActivity, LoginActivity::class.java)
                startActivity(intent)
                finish()
            }
        }

       addyourrecipe.setOnClickListener {
           if(guncelkullanici != null){
               val intent1 = Intent(this@MainActivity, warning::class.java)
               startActivity(intent1)
               finish()
           }else{

               val intent = Intent(this@MainActivity, LoginActivity::class.java)
               startActivity(intent)
               finish()

           }
        }

       showrecipe.setOnClickListener {
            val intent = Intent(this@MainActivity, warningforrecipe::class.java)
            startActivity(intent)
            finish()
        }

        logout.setOnClickListener {
            auth.signOut()
            val intent = Intent(this@MainActivity, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR)
            }

            if (Build.VERSION.SDK_INT >= 21) {
                setWindowFlag(this, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, false)
                window.statusBarColor = Color.TRANSPARENT
            }

            progressDialog = ProgressDialog(this)
            progressDialog!!.setTitle("Welcome!")
            progressDialog!!.setMessage("Categories are uploading...")
            progressDialog!!.setCancelable(false)
            progressDialog!!.setCanceledOnTouchOutside(false)

            val mLayoutManager = GridLayoutManager(this, 2, RecyclerView.VERTICAL, false)
            rvMainMenu.setLayoutManager(mLayoutManager)
            rvMainMenu.setHasFixedSize(true)


            categories



        }


        private val categories: Unit
        private get () {
            progressDialog!!.show()
            AndroidNetworking.get(Api.Categories)
                .setPriority(Priority.HIGH)
                .build()
                .getAsJSONObject(object : JSONObjectRequestListener {
                    override fun onResponse(response: JSONObject) {
                        try {
                            progressDialog!!.dismiss()
                            val playerArray = response.getJSONArray("categories")
                            for (i in 0 until playerArray.length()) {

                                val temp = playerArray.getJSONObject(i)
                                val dataApi = ModelMain()
                                dataApi.strCategory = temp.getString("strCategory")
                                dataApi.strCategoryThumb = temp.getString("strCategoryThumb")
                                dataApi.strCategoryDescription =
                                    temp.getString("strCategoryDescription")
                                modelMain.add(dataApi)
                                showCategories()
                            }
                        } catch (e: JSONException) {
                            e.printStackTrace()
                            Toast.makeText(
                                this@MainActivity,
                                "Failed to display data!", Toast.LENGTH_SHORT
                            ).show()
                        }
                    }

                    override fun onError(anError: ANError) {
                        progressDialog!!.dismiss()
                        Toast.makeText(
                            this@MainActivity,
                            "No internet connection!",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                })
        }

        private fun showCategories() {
            mainAdapter = MainAdapter(this@MainActivity, modelMain, this)
            rvMainMenu!!.adapter = mainAdapter
        }

        override fun onSelected(modelMain: ModelMain) {
            val intent = Intent(this@MainActivity, FilterFoodActivity::class.java)
            intent.putExtra("showFilter", modelMain)
            startActivity(intent)
        }





        companion object {
            fun setWindowFlag(activity: Activity, bits: Int, on: Boolean) {
                val win = activity.window
                val winParams = win.attributes
                if (on) {
                    winParams.flags = winParams.flags or bits
                } else {
                    winParams.flags = winParams.flags and bits.inv()
                }
                win.attributes = winParams
            }
        }
    }


