package com.example.flixterplus

import com.google.gson.annotations.SerializedName

class FlixterItem(Title:String, Description:String, ImageLink:String){
    val title = Title
    val description = Description
    val fLink = "https://image.tmdb.org/t/p/w500/$ImageLink"
}