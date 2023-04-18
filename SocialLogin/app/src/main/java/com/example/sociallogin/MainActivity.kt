package com.example.sociallogin

import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Base64
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import com.example.sociallogin.databinding.ActivityMainBinding
import com.facebook.CallbackManager
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.GoogleAuthProvider
import java.util.Calendar.getInstance
import com.google.firebase.auth.FirebaseAuth;
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException
import java.util.Currency.getInstance

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var client:GoogleSignInClient
    var auth:FirebaseAuth?=null
    var callBackManager :CallbackManager ?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

       setData()
        setOnClick()
        setContentView(binding.root)
    }
    fun loginFaceBook(){
        auth = FirebaseAuth.getInstance()
        callBackManager = CallbackManager.Factory.create()

    }
   fun setData(){
       val options = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
           .requestIdToken(getString(R.string.default_web_client_id))
           .requestEmail()
           .build()
       client = GoogleSignIn.getClient(this,options)
   }
    fun setOnClick(){
        binding.imgGG.setOnClickListener {
                val intent = client.signInIntent
            startActivityForResult(intent,10001)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val task = GoogleSignIn.getSignedInAccountFromIntent(data)
        val account = task.getResult(ApiException::class.java)
        val credential = GoogleAuthProvider.getCredential(account.idToken,null)
        FirebaseAuth.getInstance().signInWithCredential(credential)
            .addOnCompleteListener{task->
                if(task.isSuccessful){
                    val intent  = Intent(this,HomeActivity::class.java)
                    startActivity(intent)

                }else{
                    Toast.makeText(this,task.exception?.message,Toast.LENGTH_SHORT).show()
                }

            }
     }

    override fun onStart() {
        super.onStart()
        FirebaseApp.initializeApp(this);
        if (FirebaseAuth.getInstance().currentUser != null){
            val i=  Intent(this,HomeActivity::class.java)
            startActivity(i)
        }
    }
    fun privateKeyHash(){
        try {
            val infor = packageManager.getPackageInfo("com.example.sociallogin",PackageManager.GET_SIGNATURES)
            for (signature in infor.signatures){
                val md= MessageDigest.getInstance("SHA")
                md.update(signature.toByteArray())
                Log.e("KEYHASH", Base64.encodeToString(md.digest(),Base64.DEFAULT))

            }

        }
        catch (e:PackageManager.NameNotFoundException){}
        catch (e:NoSuchAlgorithmException){

        }
    }

}