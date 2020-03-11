
/*
Copyright (c) 2020 Kotlin Data Classes Generated from JSON powered by http://www.json2kotlin.com

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

For support, please feel free to contact me at https://www.linkedin.com/in/syedabsar */
package com.example.applemusicapp.data
import com.google.gson.annotations.SerializedName


data class Album (

	@SerializedName("artistName") val artistName : String,
	@SerializedName("id") val id : Int,
	@SerializedName("releaseDate") val releaseDate : String,
	@SerializedName("name") val name : String,
	@SerializedName("kind") val kind : String,
	@SerializedName("copyright") val copyright : String,
	@SerializedName("artistId") val artistId : Int,
	@SerializedName("contentAdvisoryRating") val contentAdvisoryRating : String,
	@SerializedName("artistUrl") val artistUrl : String,
	@SerializedName("artworkUrl100") val artworkUrl100 : String,
	@SerializedName("genres") val genres : List<Genres>,
	@SerializedName("url") val url : String
)