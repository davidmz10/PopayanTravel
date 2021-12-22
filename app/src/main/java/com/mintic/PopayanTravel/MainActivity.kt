package com.mintic.PopayanTravel

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mintic.PopayanTravel.utlis.Utils
import org.json.JSONException
import org.json.JSONObject


class MainActivity : AppCompatActivity() {
    var cityName: ArrayList<String> = ArrayList()
    var cityOverview: ArrayList<String> = ArrayList()
    var cityScore: ArrayList<String> = ArrayList()
    var cityImage: ArrayList<String> = ArrayList()
    var cityDescription: ArrayList<String> = ArrayList()

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.optionmenu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.toPreferences -> {
                val intent: Intent = Intent(this, SettingsActivity::class.java)
                startActivity(intent)
                true
            }
            else -> {super.onOptionsItemSelected(item)}
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(applicationContext)

        try {
            val obj = JSONObject(Utils(this).loadJsonFromAssets(applicationContext, "places.json"))
            val placesArray = obj.getJSONArray("places")
            for (i in 0 until placesArray.length()) {
                val cityInfo = placesArray.getJSONObject(i)
                cityName.add(cityInfo.getString("name"))
                cityOverview.add(cityInfo.getString("overview"))
                cityScore.add(cityInfo.getString("score"))
                cityImage.add(cityInfo.getString("image"))
                cityDescription.add(cityInfo.getString("description"))
            }

        } catch (ex: JSONException) {
            ex.printStackTrace()
        }

        val customAdapter =
            CustomAdapter(this@MainActivity, cityName, cityOverview, cityScore, cityImage, cityDescription)
        recyclerView.adapter = customAdapter
    }

}