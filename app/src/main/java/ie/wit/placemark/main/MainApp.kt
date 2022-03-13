package ie.wit.placemark.main

import android.app.Application
import ie.wit.placemark.models.PlacemarkJSONStore
import ie.wit.placemark.models.PlacemarkMemStore
import ie.wit.placemark.models.PlacemarkStore
import timber.log.Timber
import timber.log.Timber.i

class MainApp : Application() {

    lateinit var placemarks: PlacemarkStore

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
        placemarks = PlacemarkJSONStore(applicationContext)
        i("Placemark started")
    }
}