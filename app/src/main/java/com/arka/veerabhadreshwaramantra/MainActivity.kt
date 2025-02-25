package com.arka.veerabhadreshwaramantra

import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.arka.veerabhadreshwaramantra.databinding.ActivityMainBinding
import com.google.android.gms.tasks.OnFailureListener
import com.google.android.gms.tasks.OnSuccessListener
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.storage.BuildConfig
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.ListResult


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var dialog: AlertDialog

    // This loop will create 20 Views containing
    // the image with the count of view
    private val dashboardList = mutableMapOf<String, Int>(
        "ಶ್ರೀ ವೀರಭದ್ರೇಶ್ವರ ಸುಪ್ರಭಾತ" to 1,

        "ಶ್ರೀ ವೀರಭದ್ರೇಶ್ವರ ಕವಚಂ" to 2,

        "ವೀರಾಗಮದಲ್ಲಿನ ಭದ್ರಕವಚ" to 3,

        "ಶ್ರೀ ವೀರಭದ್ರ ದಂಡಕಂ" to 4,

        "ಶ್ರೀ ವೀರಭದ್ರ ಪಂಚಕಂ" to 5,

        "ಶ್ರೀ ವೀರಭದ್ರ ರತ್ನ ಪಂಚಕಂ ಸ್ತುತಿ" to 6,

        "ಶ್ರೀ ವೀರಭದ್ರಾಷ್ಟಕಂ" to 7,

        "ಶ್ರೀ ವೀರಭದ್ರ ಶತಕ" to 8,

        "ಶ್ರೀವೀರಭದ್ರ ಶರಣಾಗತಿ ಸ್ತೋತ್ರಂ" to 9,

        "ಶ್ರೀ ವೀರಭದ್ರ ಭುಜಂಗ ಸ್ತೋತ್ರ" to 10,

        "ಆತ್ಮಾವೀರೇಶ್ವರಸ್ತೋತ್ರಂ" to 11,

        "ಶ್ರೀ ವೀರಭದ್ರಸ್ವಾಮಿ ಸ್ತೋತ್ರ" to 12,

        "ಶ್ರೀ ವೀರಭದ್ರ ಅಷ್ಟೋತ್ತರ\n" +
                "        ಶತನಾಮಾವಳಿ ಸ್ತೋತ್ರ" to 13,

        "ಶ್ರೀ ವೀರಭದ್ರ ಸಹಸ್ರನಾಮ ಸ್ತೋತ್ರಮ್" to 14,

        "ಶ್ರೀವೀರಭದ್ರ ನಕ್ಷತ್ರ ನಾಮಾವಲಿಃ" to 15,

        "ಶ್ರೀ ವೀರಭದ್ರಾಷ್ಟೋತ್ತರ ಶತನಾಮಾವಳಿ" to 16,

        "ಶ್ರೀ ವೀರಭದ್ರ ಸಹಸ್ರ ನಾಮಾವಲಿಃ" to 17,

        "ಶ್ರೀ ವೀರಭದ್ರ ಮಾಲಾ ಮಹಾಮಂತ್ರಃ " to 18,

        "ಶ್ರೀ ವೀರಭದ್ರ ಮೂಲಮಂತ್ರ" to 19,

        "ಶ್ರೀ ವೀರಭದ್ರ ಅಘೋರ ಮಂತ್ರ" to 20,

        "ಶರಭೋಪನಿಷತ್" to 21,

        "ಶ್ರೀ ಶರಭ ಹೃದಯ ಸ್ತೋತ್ರಂ" to 22,

        "ಶ್ರೀ ವೀರಭದ್ರ ಧ್ಯಾನ ಶ್ಲೋಕಗಳು" to 23,

        "ಶ್ರೀ ವೀರಭದ್ರ ಧ್ಯಾನ ಶ್ಲೋಕಗಳು" to 24,

        "ಶ್ರೀ ವೀರಭದ್ರ ಧ್ಯಾನಂ" to 25,

        "ಶ್ರೀ ಅಘೋರ ವೀರಭದ್ರ ಧ್ಯಾನಂ" to 26,

        "ಶ್ರೀ ಭದ್ರಕಾಳಿ ಭವಾನಿ ಧ್ಯಾನ" to 27,

        "ಶ್ರೀ ಭದ್ರಕಾಳೀ ಕವಚಂ" to 28,

        "ಶ್ರೀ ಭದ್ರಕಾಳಿ ಅಷ್ಟಕಂ" to 29,

        "ಶ್ರೀ ಭದ್ರಕಾಳಿ ಅಷ್ಟೋತ್ತರ ಶತನಾಮಾವಳಿ" to 30,

        "ಶ್ರೀ ಭದ್ರಕಾಳಿ ಸ್ತುತಿ" to 31,

        "ಶ್ರೀ ವೀರಭದ್ರ ಗುಗ್ಗುಳದ ಬಗ್ಗೆ ಮಾಹಿತಿ" to 32,

        "ಶ್ರೀವೀರಭದ್ರೇಶ್ವರ ವಡಪು" to 33,

        "ಜಯ ವೀರಭದ್ರ ಕರುಣಾ ಸಮುದ್ರಾ" to 34,

        "ಶ್ರೀ ವೀರಭದ್ರ ಪುಷ್ವಾಂಜಲಿ" to 35,

        //dummy added as the last item was not displaying
        "ಶ್ರೀ ವೀರಭದ್ರ" to 36
    )
    private val IMAGE_URL = "gs://veerabhadraswamymantra.appspot.com/"
    private lateinit var auth: FirebaseAuth
    private val list: ArrayList<Long> = ArrayList()
    private var tinyDB: TinyDB? = null
    private val imagePath: ArrayList<String> = ArrayList()
    private var parentLayout: View? = null

    public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        auth = FirebaseAuth.getInstance()
        val currentUser = auth.currentUser
        if (currentUser != null) {
            checkIfFirstRun()
        } else {
            signInAnonymously()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNavigationView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.home -> setCurrentFragment(1)
//                R.id.audio -> setCurrentFragment(2)
                R.id.pic -> setCurrentFragment(3)
                R.id.settings -> setCurrentFragment(4)
            }
            true
        }

        // getting the recyclerview by its id
        val recyclerview = findViewById<RecyclerView>(R.id.recyclerview)
        // this creates a vertical layout Manager
        recyclerview.layoutManager = LinearLayoutManager(this)

        // ArrayList of class ItemsViewModel
        val data = ArrayList<ItemsViewModel>()
        dashboardList.forEach{keys ->data.add(ItemsViewModel(R.drawable.om, keys.key))}
//        for (i in dashboardList.keys) {
//            data.add(ItemsViewModel(R.drawable.om, i)
//        }

        // This will pass the ArrayList to our Adapter
        val adapter = ListViewCustomAdapter(data)

        // Setting the Adapter with the recyclerview
        recyclerview.adapter = adapter

        tinyDB = TinyDB(applicationContext)
        //firebase working
        recyclerview.scheduleLayoutAnimation()
        parentLayout = findViewById(android.R.id.content)
    }

    private fun setCurrentFragment(num: Any) {
        var mIntent: Intent
        if (num == 1) {
            mIntent = Intent(applicationContext, MainActivity::class.java)
        } else if (num == 2) {
            mIntent = Intent(applicationContext, HomePage::class.java)
        } else if (num == 3) {
            mIntent = Intent(applicationContext, HomePage::class.java)
        } else {
            mIntent = Intent(applicationContext, SettingScreenActivity::class.java)
        }
        mIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        mIntent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        startActivity(mIntent)
    }

    private fun checkIfFirstRun() {
        Log.w("activity", "first time")
        fetchImagesFromFireBaseDB()
    }

    private fun signInAnonymously() {
        auth.signInAnonymously().addOnSuccessListener(this@MainActivity,
            OnSuccessListener<AuthResult?> { checkIfFirstRun() })
        auth.signInAnonymously().addOnFailureListener(this@MainActivity,
            OnFailureListener { exception ->
                Log.e("Deepak", "signInAnonymously:FAILURE", exception)
                retrySnackBar()
            })
    }

    private fun retrySnackBar() {
        Snackbar.make(parentLayout!!, "This is main activity", Snackbar.LENGTH_LONG)
            .setAction("Retry") {
                auth = FirebaseAuth.getInstance()
                val user = auth.currentUser
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
            R.id.action_settings -> newAboutCall()
            R.id.shareApp -> newShareAppCall()
//            R.id.rateUs -> newRateUsCall()
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun newAboutCall(): Boolean {
        val mIntent = Intent(applicationContext, AboutScreen::class.java)
        mIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        mIntent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        startActivity(mIntent)
        return true
    }

    private fun newShareAppCall(): Boolean {
        try {
            val shareIntent = Intent(Intent.ACTION_SEND)
            shareIntent.type = "text/plain"
            shareIntent.putExtra(Intent.EXTRA_SUBJECT, "ಶ್ರೀ ವೀರಭದ್ರಸ್ವಾಮಿ ಸ್ತೋತ್ರಮಾಲಾ")
            var shareMessage = "\nನಾನು ನಿಮಗೆ ಈ ಅಪ್ಲಿಕೇಶನ್ ಅನ್ನು ಶಿಫಾರಸು ಮಾಡುತ್ತೇನೆ\n\n"
            shareMessage =
                """
               ${shareMessage}https://play.google.com/store/apps/details?id=${BuildConfig.VERSION_NAME}
               """.trimIndent()
            shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage)
            startActivity(Intent.createChooser(shareIntent, "choose one"))
        } catch (e: java.lang.Exception) {
            //e.toString();
        }
        return true
    }

    private fun newRateUsCall(): Boolean {
//        val manager = ReviewManagerFactory.create(applicationContext)
//        val request = manager.requestReviewFlow()
//        request.addOnCompleteListener { request ->
//            if (request.isSuccessful) {
//                // We got the ReviewInfo object
//                val reviewInfo = request.result
//                val flow = manager.launchReviewFlow(this, reviewInfo)
//                flow.addOnCompleteListener { _ ->
//                    // The flow has finished. The API does not indicate whether the user
//                    // reviewed or not, or even whether the review dialog was shown. Thus, no
//                    // matter the result, we continue our app flow.
//                }
//            } else {
//                // There was some problem, continue regardless of the result.
//            }
//        }
        return true
    }

    override fun onBackPressed() {
        super.onBackPressed()
        val builder = AlertDialog.Builder(this@MainActivity)
        builder.setTitle("ಅಪ್ಲಿಕೇಶನ್ ನಿರ್ಗಮಿಸಿ")
            .setMessage("ಮುಖ್ಯ ಮುಖಪುಟ ಪರದೆಗೆ ಹೋಗುವುದನ್ನು ಖಚಿತಪಡಿಸಿ ?")
            .setCancelable(false)
            .setPositiveButton("ಹೌದು") { dialog, which ->
                dialog.cancel()
                killActivity()
            }
            .setNegativeButton(
                "ಇಲ್ಲ"
            ) { dialog, which -> dialog.cancel() }
        //Creating dialog box
        dialog = builder.create()
        dialog.show()
    }

    private fun killActivity() {
        finish()
    }
}