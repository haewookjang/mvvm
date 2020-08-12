package io.markjang.app.mvvm.data.model


import com.google.gson.annotations.SerializedName

data class RepositoryList(
    @SerializedName("incomplete_results")
    val incompleteResults: Boolean,
    @SerializedName("items")
    val items: List<ItemX>,
    @SerializedName("total_count")
    val totalCount: Int
)