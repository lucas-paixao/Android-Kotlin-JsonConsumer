package com.lucas.antoniocarlos.aplicativo_kot

import retrofit2.Call
import retrofit2.http.GET

/**
 * Created by Antonio Carlos on 31/05/2018.
 */

interface NoteService {
    @get:GET("pontotel-docs/data.json")
    val note: Call<Example>
}
