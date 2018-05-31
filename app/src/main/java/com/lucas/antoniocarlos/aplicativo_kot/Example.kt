package com.lucas.antoniocarlos.aplicativo_kot

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by Antonio Carlos on 31/05/2018.
 */

class Example {

    @SerializedName("data")
    @Expose
    val data: List<Datum>? = null
}
