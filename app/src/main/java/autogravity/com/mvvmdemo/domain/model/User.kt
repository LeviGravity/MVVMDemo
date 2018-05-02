package com.domain.model

import com.google.gson.annotations.SerializedName

/**
 * Created by LeviHsiao on 2/12/18.
 */

class User(name: Name) {

    @SerializedName("gender") var gender: String? = null
    @SerializedName("name") var name: Name? = null
    @SerializedName("location") var location: Location? = null
    @SerializedName("email") var email: String? = null
    @SerializedName("login") var login: Login? = null
    @SerializedName("dob") var dob: String? = null
    @SerializedName("registered") var registered: String? = null
    @SerializedName("phone") var phone: String? = null
    @SerializedName("cell") var cell: String? = null
    @SerializedName("id") var id: Id? = null
    @SerializedName("picture") var picture: Picture? = null
    @SerializedName("nat") var nat: String? = null
}
