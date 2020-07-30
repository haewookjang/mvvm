package io.markjang.app.mvvm.data.model


import com.google.gson.annotations.SerializedName

data class Item(
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("created_by")
    val createdBy: String,
    @SerializedName("curated")
    val curated: Boolean,
    @SerializedName("description")
    val description: String,
    @SerializedName("display_name")
    val displayName: String,
    @SerializedName("featured")
    val featured: Boolean,
    @SerializedName("name")
    val name: String,
    @SerializedName("released")
    val released: String,
    @SerializedName("score")
    val score: Double,
    @SerializedName("short_description")
    val shortDescription: String,
    @SerializedName("updated_at")
    val updatedAt: String
)