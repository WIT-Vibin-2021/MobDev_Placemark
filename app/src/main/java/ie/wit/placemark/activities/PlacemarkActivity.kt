package ie.wit.placemark.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import ie.wit.placemark.R
import ie.wit.placemark.databinding.ActivityPlacemarkBinding
import ie.wit.placemark.models.PlacemarkModel
import ie.wit.placemark.main.MainApp
import timber.log.Timber
import timber.log.Timber.i

class PlacemarkActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPlacemarkBinding
    var placemark = PlacemarkModel()
    //val placemarks = ArrayList<PlacemarkModel>()
    //var app : MainApp? = null
    lateinit var app: MainApp

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPlacemarkBinding.inflate(layoutInflater)
        //setContentView(R.layout.activity_placemark)
        setContentView(binding.root)

        //Timber.plant(Timber.DebugTree())
        app = application as MainApp
        i("Placemark Activity started...")

        binding.btnAdd.setOnClickListener() {

            placemark.title= binding.placemarkTitle.text.toString()
            placemark.description= binding.description.text.toString()
            if (placemark.title.isNotEmpty()) {
                app.placemarks.add(placemark.copy())
                i("add Button Pressed: ${placemark}")
                for (i in app.placemarks.indices)
                { i("Placemark[$i]:${app.placemarks[i]}")}
                setResult(RESULT_OK)
                finish()
            }
            else {
                Snackbar
                    .make(it,"Please Enter a title", Snackbar.LENGTH_LONG)
                    .show()
            }
        }
    }
}