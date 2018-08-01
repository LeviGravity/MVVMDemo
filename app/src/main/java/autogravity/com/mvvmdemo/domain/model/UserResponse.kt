package com.domain.model

import com.google.gson.annotations.SerializedName

/**
 * Created by LeviHsiao on 2/12/18.
 */

data class UserResponse(
    @SerializedName("results") var results: List<User>? = null,
    @SerializedName("info") var info: Info? = null
)
