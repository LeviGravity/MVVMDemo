package com.domain.model

import com.google.gson.annotations.SerializedName

/**
 * Created by LeviHsiao on 2/12/18.
 */

class Name(first: String) {
    @SerializedName("title") var title: String? = null
    @SerializedName("first") var first: String? = null
    @SerializedName("last") var last: String? = null
}
