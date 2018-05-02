package com.domain.model

import com.google.gson.annotations.SerializedName

/**
 * Created by LeviHsiao on 2/12/18.
 */

class Id {
    @SerializedName("name") var name: String? = null
    @SerializedName("value") var value: String? = null
}
