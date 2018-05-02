package com.domain.model

import com.google.gson.annotations.SerializedName

/**
 * Created by LeviHsiao on 2/12/18.
 */

class Info {
    @SerializedName("seed") var seed: String? = null
    @SerializedName("results") var results: Int? = null
    @SerializedName("page") var page: Int? = null
    @SerializedName("version") var version: String? = null
}
