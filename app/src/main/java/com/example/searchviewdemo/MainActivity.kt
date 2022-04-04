package com.example.searchviewdemo

import androidx.appcompat.app.AppCompatActivity
import android.util.Log
import android.os.Bundle
import android.widget.*
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import network.MarvinNet
import network.Sighting
import org.json.JSONException
import org.json.JSONObject

class MainActivity : AppCompatActivity(){

    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val url = "http://192.168.1.115:8080/"

        val search=findViewById<SearchView>(R.id.searchView)
        val textView=findViewById<TextView>(R.id.textView)




        //val names= arrayOf("Android", "Java", "Php", "Python", "C", "C++", "Kotlin")

        //val adapter: ArrayAdapter<String> = ArrayAdapter(this, android.R.layout.simple_list_item_1,
            //names)

        //listView.adapter = adapter

        search.setOnQueryTextListener(object: SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                search.clearFocus()
                val query = query ?: return false

                val results: Array<Sighting> = MarvinNet.getSearchTags(query) ?: return false
                for (sighting in results) {
                    Log.d(TAG, sighting.license_plate)
                    Log.d(TAG, sighting.created_at)
                    Log.d(TAG, sighting.description)
                    Log.d(TAG, sighting.owner)
                    Log.d(TAG, sighting.photo)
                    Log.d(TAG, sighting.tags)
                    Log.d(TAG, sighting.title)
                    Log.d(TAG, sighting.updated_at)
                }
                return false
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                //adapter.filter.filter(p0)
                return false
            }


        })
    }



}