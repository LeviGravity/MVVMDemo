package com.domain.model

import autogravity.com.mvvmdemo.domain.model.Dob
import autogravity.com.mvvmdemo.domain.model.Registered
import com.google.gson.annotations.SerializedName

/**
 * Created by LeviHsiao on 2/12/18.
 */

data class User(
    @SerializedName("gender") var gender: String? = null,
    @SerializedName("name")
    var name: Name? = null,
    @SerializedName("location") var location: Location? = null,
    @SerializedName("email") var email: String? = null,
    @SerializedName("login") var login: Login? = null,
    @SerializedName("dob") var dob: Dob? = null,
    @SerializedName("registered") var registered: Registered? = null,
    @SerializedName("phone") var phone: String? = null,
    @SerializedName("cell") var cell: String? = null,
    @SerializedName("id") var id: Id? = null,
    @SerializedName("picture") var picture: Picture? = null,
    @SerializedName("nat") var nat: String? = null
)
