package com.example.testapracticodipas.model

data class GamesModel(
    val count: Int,
    val results: List<GamesList>
)

data class GamesList(
    val id: Int,
    val name : String,
    val slug : String,
    val background_image: String
)