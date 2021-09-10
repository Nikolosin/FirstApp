package com.example.firstapp

data class Post (
    val data: String,
    val name: String,
    val text: String,
    var itemLike: Int,
    var itemComm: Int,
    var itemShare: Int,
    var activeLike: Boolean = false,
    var activeComm: Boolean = false,
    var activeShare: Boolean = false,
        ){
}