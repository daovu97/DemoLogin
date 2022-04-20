package com.example.demologin.data.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Coffee(
    @SerializedName("title")
    @Expose
    var title: String? = null,

    @SerializedName("description")
    @Expose
    var description: String? = null,

    @SerializedName("ingredients")
    @Expose
    var ingredients: List<String>? = null,

    @SerializedName("id")
    @Expose
    var id: Int? = null
)