package com.example.gitrepositories.data.dto

import com.google.gson.annotations.SerializedName

data class GitHubRepositoriesDTO(
    @SerializedName("total_count")
    val totalCount: Int,
    @SerializedName("incomplete_results")
    val incompleteResults: Boolean,
    @SerializedName("items")
    val items: List<GitHubItemsDTO>
)
