package com.arka.veerabhadreshwaramantra

import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.AppBarConfiguration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.arka.veerabhadreshwaramantra.databinding.ActivityMainBinding
import com.google.android.gms.tasks.OnFailureListener
import com.google.android.gms.tasks.OnSuccessListener
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.ListResult


class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    // This loop will create 20 Views containing
    // the image with the count of view
    val dashboardList = mutableMapOf<String, Int>(
        "ಶ್ರೀ ವೀರಭದ್ರೇಶ್ವರ ಸುಪ್ರಭಾತ" to 1,

        "ಶ್ರೀ ವೀರಭದ್ರೇಶ್ವರ ಕವಚಂ" to 2,

        "ಶ್ರೀ ವೀರಭದ್ರೇಶ್ವರ ದಂಡಕಂ" to 3,

        "ಶ್ರೀ ವೀರಭದ್ರೇಶ್ವರ ತಾರಾವಳಿ" to 4,

        "ಶ್ರೀ ವೀರಭದ್ರಾಷ್ಟಕಂ" to 5,

        "ಶ್ರೀ ಭದ್ರ ಕವಚಂ" to 6,

        "ಶ್ರೀ ವೀರಭದ್ರೇಶ್ವರ ಸಹಸ್ರನಾಮಸ್ತೋತ್ರ" to 7,

        "ಶ್ರೀ ವೀರಭದ್ರೇಶ್ವರ ಸಹಸ್ರನಾಮವಳಿ" to 8,

        "ಶ್ರೀ ವೀರಭದ್ರೇಶ್ವರ ಅಷ್ಟೋತ್ತರ ಶತನಾಮಾವಳಿ ಸ್ತೋತ್ರO" to 9,

        "ಶ್ರೀ ವೀರಭದ್ರೇಶ್ವರ ಅಷ್ಟೋತ್ತರ ಶತನಾಮಾವಳಿ" to 10,

        "ಶ್ರೀ ವೀರಭದ್ರೇಶ್ವರ ವಡಪುಗಳು" to 11,

        "ಗುಗ್ಗುಳದ ಬಗ್ಗೆ ಮಾಹಿತಿ" to 12,

        "ಶ್ರೀ ವೀರಭದ್ರೇಶ್ವರ ಸಂಕ್ಷಿಪ್ತ ಪರಿಚಯ" to 13,

        "ಶ್ರೀ ವೀರಭದ್ರೇಶ್ವರ ಆಚರಣೆಗಳು" to 14,

        "ಶ್ರೀ ವೀರಭದ್ರೇಶ್ವರ ಪ್ರಾರ್ಥನೆ" to 15,

        "ಶ್ರೀ ವೀರಭದ್ರೇಶ್ವರ ಮಂಗಳ ಶ್ಲೋಕ" to 16,

        "ಶ್ರೀ ವೀರಭದ್ರೇಶ್ವರ ಶತಕ" to 17,

        "ಶ್ರೀ ವೀರಭದ್ರೇಶ್ವರ ಮಂಗಳ" to 18,

        "ದ್ವಾತ್ರಿಂಶದ್ಭುಜ ಶ್ರೀ ವೀರಭದ್ರ ಧ್ಯಾನಂ" to 19,

        "ಶ್ರೀ ಶರಭ ಹೃದಯ ಸ್ತೋತ್ರ" to 20,

        "ಶ್ರೀ ಶರಭೋಪನಿಷತ್ತು" to 21,
    )
    private val IMAGE_URL = "gs://veerabhadraswamywallpaper.appspot.com"
    private lateinit var auth: FirebaseAuth
    private val list: ArrayList<Long> = ArrayList()
    private var tinyDB: TinyDB? = null
    private val imagePath: ArrayList<String> = ArrayList()
    private var parentLayout: View? = null

    public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.currentUser
        if (currentUser != null) {
//            reload();
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        setSupportActionBar(binding.toolbar)

//        val navController = findNavController(R.id.nav_host_fragment_content_main)
//        appBarConfiguration = AppBarConfiguration(navController.graph)
//        setupActionBarWithNavController(navController, appBarConfiguration)

        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
            startActivity(Intent(applicationContext, HomePage::class.java))
        }

        // getting the recyclerview by its id
        val recyclerview = findViewById<RecyclerView>(R.id.recyclerview)

        // this creates a vertical layout Manager
        recyclerview.layoutManager = LinearLayoutManager(this)

        // ArrayList of class ItemsViewModel
        val data = ArrayList<ItemsViewModel>()

        for (i in dashboardList.keys) {
            data.add(ItemsViewModel(R.drawable.om, i))
        }

        // This will pass the ArrayList to our Adapter
        val adapter = ListViewCustomAdapter(data)

        // Setting the Adapter with the recyclerview
        recyclerview.adapter = adapter

        tinyDB = TinyDB(applicationContext)
        //firebase working
        auth = Firebase.auth
        val user = Firebase.auth.currentUser
        user?.let {
            // Name, email address, and profile photo Url
            val name = user.displayName
            val email = user.email
            val photoUrl = user.photoUrl

            // Check if user's email is verified
            val emailVerified = user.isEmailVerified

            // The user's ID, unique to the Firebase project. Do NOT use this value to
            // authenticate with your backend server, if you have one. Use
            // FirebaseUser.getToken() instead.
            val uid = user.uid
        }
        if (user != null) {
            checkIfFirstRun()
        } else {
            signInAnonymously()
        }

        parentLayout = findViewById(android.R.id.content)
    }

    private fun checkIfFirstRun() {
        Log.w("activity", "first time")
        fetchImagesFromFireBaseDB()
    }

    private fun signInAnonymously() {
        auth!!.signInAnonymously().addOnSuccessListener(this@MainActivity,
            OnSuccessListener<AuthResult?> { checkIfFirstRun() })
        auth!!.signInAnonymously().addOnFailureListener(this@MainActivity,
            OnFailureListener { exception ->
//                Toast.makeText(this@MainActivity, "signInAnonymously:FAILURE", Toast.LENGTH_LONG)
//                    .show()
                Log.e("Deepak", "signInAnonymously:FAILURE", exception)
                retrySnackBar()
            })
    }

    private fun retrySnackBar() {
        Snackbar.make(parentLayout!!, "This is main activity", Snackbar.LENGTH_LONG)
            .setAction("Retry") {
                auth = FirebaseAuth.getInstance()
                val user = auth!!.currentUser
                if (user != null) {
                    checkIfFirstRun()
                } else {
                    signInAnonymously()
                }
            }
            .setActionTextColor(resources.getColor(android.R.color.holo_red_light))
            .show()
    }

    private fun fetchImagesFromFireBaseDB() {
        val ref = FirebaseStorage.getInstance().getReferenceFromUrl(IMAGE_URL)
        ref.listAll().addOnSuccessListener { listResult: ListResult ->
            onSuccess(
                listResult
            )
        }
        ref.listAll().addOnFailureListener { e: Exception -> failure(e) }
    }

    private fun failure(e: Exception) {
//        Log.d("Deepak e")
        retrySnackBar()
    }

    private fun onSuccess(listResult: ListResult) {
        list.clear()
        for (i in listResult.items.indices) {
//            Toast.makeText(getApplicationContext(),"Count "+listResult.getItems().size(),Toast.LENGTH_LONG).show();
            listResult.items[i].downloadUrl.addOnSuccessListener { uri ->
                Log.d("Deepak Spalsh uri", uri.toString())
                saveImagesFromServer(uri.toString())
            }
        }
//        goToCarouselScreen()
    }

    private fun saveImagesFromServer(imageUrl: String) {
        imagePath.add(imageUrl)
        tinyDB!!.putListString("MyUsers", imagePath)
        //        tinyDB.getListString("MyUsers");
        Log.d("Deepak getDB ", tinyDB!!.getListString("MyUsers").toString())
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (grantResults.size > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            Log.v("Deepak", "Permission: " + permissions[0] + "was " + grantResults[0])
            //resume tasks needing this permission
            checkIfFirstRun()
        }
    }

//    private fun goToCarouselScreen() {
//        Handler().postDelayed(Runnable { /* Create an Intent that will start the Menu-Activity. */
//            progressBar!!.hide()
//            splashVideo!!.stopPlayback()
//            val mainIntent = Intent(this@SplashActivity, HomePage::class.java)
//            this@SplashActivity.startActivity(mainIntent)
//            this@SplashActivity.finish()
//        }, SPLASH_DISPLAY_LENGTH)
//    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

//    override fun onSupportNavigateUp(): Boolean {
//        val navController = findNavController(R.id.nav_host_fragment_content_main)
//        return navController.navigateUp(appBarConfiguration)
//                || super.onSupportNavigateUp()
//    }
}