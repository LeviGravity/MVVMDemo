package com.domain.model

import com.google.gson.annotations.SerializedName

/**
 * Created by LeviHsiao on 2/12/18.
 */

data class Login(
    @SerializedName("username") var username: String? = null,
    @SerializedName("password") var password: String? = null,
    @SerializedName("salt") var salt: String? = null,
    @SerializedName("md5") var md5: String? = null,
    @SerializedName("sha1") var sha1: String? = null,
    @SerializedName("sha256") var sha256: String? = null
)
