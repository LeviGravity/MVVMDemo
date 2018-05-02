package com.domain.model

import com.google.gson.annotations.SerializedName

/**
 * Created by LeviHsiao on 2/12/18.
 */

class Location {
    @SerializedName("street") var street: String? = null
    @SerializedName("city") var city: String? = null
    @SerializedName("state") var state: String? = null
    @SerializedName("postcode") var postcode: String? = null
}
