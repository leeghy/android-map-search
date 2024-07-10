package campus.tech.kakao.map

import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchCallback(private val activity: MainActivity) : Callback<SearchResult> {
    override fun onResponse(call: Call<SearchResult>, response: Response<SearchResult>) {
        if (response.isSuccessful) {
            val result = response.body()
            result?.documents?.let { places ->
                activity.updateSearchResults(places)
            }
            Log.d("SearchCallback", "Data received from Kakao API")
        } else {
            Log.e("SearchCallback", "Error: ${response.code()}")
        }
    }

    override fun onFailure(call: Call<SearchResult>, t: Throwable) {
        Log.e("SearchCallback", "Error: ${t.message}")
    }
}