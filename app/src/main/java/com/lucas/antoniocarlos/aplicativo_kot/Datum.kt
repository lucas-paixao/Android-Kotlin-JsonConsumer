package com.lucas.antoniocarlos.aplicativo_kot

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by Antonio Carlos on 31/05/2018.
 */

class Datum {

    @SerializedName("id")
    @Expose
    val id: String? = null
    @SerializedName("name")
    @Expose
    val name: String? = null
    @SerializedName("pwd")
    @Expose
    val pwd: String? = null

}
