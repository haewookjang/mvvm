package kr.co.deliveryhero.test.data.model


import com.google.gson.annotations.SerializedName

data class Users(
    @SerializedName("incomplete_results")
    val incompleteResults: Boolean,
    @SerializedName("items")
    val items: List<User>,
    @SerializedName("total_count")
    val totalCount: Int
)