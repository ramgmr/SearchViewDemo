package network

import com.google.gson.Gson
import com.google.gson.JsonSyntaxException
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.BufferedInputStream
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL

object MarvinNet : MarvinAPI {

    private fun sendGetRequest(apiRoute: String): String? {
        val url = URL("http://192.168.1.115:8080/$apiRoute")
        val urlConnection: HttpURLConnection = url.openConnection() as HttpURLConnection
        var jsonString: String? = null;
        try {
            val input: InputStream = BufferedInputStream(urlConnection.inputStream)
            jsonString = input.bufferedReader().use { it.readText() }
        } finally {
            urlConnection.disconnect()
        }
        return jsonString
    }

    override fun getSearchTags(query: String): Array<Sighting>? {
        val jsonString: String? = sendGetRequest("search_sightings/$query")
        var response: Array<Sighting>? = null;
        try {
            val gson = Gson()
            response = gson.fromJson(jsonString, Array<Sighting>::class.java)
        }
        catch (e: JsonSyntaxException) {

        }
        return response
    }


}