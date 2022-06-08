package com.digel.movieapplication

data class MovieListResponse(
    val page: Int?,
    val results: List<Result>? = emptyList(),
    val totalPages: Int?,
    val totalResults: Int?
) {
    data class Result(
        val adult: Boolean?,
        val backdropPath: String?,
        val genreIds: List<Int?>?,
        val id: Int?,
        val originalLanguage: String?,
        val originalTitle: String?,
        val overview: String?,
        val popularity: Double?,
        val posterPath: String?,
        val releaseDate: String?,
        val title: String?,
        val video: Boolean?,
        val voteAverage: Double?,
        val voteCount: Int?
    )
}