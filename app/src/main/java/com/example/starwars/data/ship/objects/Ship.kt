package com.example.starwars.data.ship.objects

import com.google.gson.annotations.SerializedName

data class Ship(
    /*
Copyright (c) 2024 Kotlin Data Classes Generated from JSON powered by http://www.json2kotlin.com

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

For support, please feel free to contact me at https://www.linkedin.com/in/syedabsar */

    @SerializedName("name") val name : String,
    @SerializedName("model") val model : String,
    @SerializedName("manufacturer") val manufacturer : String,
    @SerializedName("cost_in_credits") val cost_in_credits : String,
    @SerializedName("length") val length : String,
    @SerializedName("max_atmosphering_speed") val max_atmosphering_speed : String,
    @SerializedName("crew") val crew : String,
    @SerializedName("passengers") val passengers : String,
    @SerializedName("cargo_capacity") val cargo_capacity : String,
    @SerializedName("consumables") val consumables : String,
    @SerializedName("hyperdrive_rating") val hyperdrive_rating : String,
    @SerializedName("MGLT") val mGLT : String,
    @SerializedName("starship_class") val starship_class : String,
    @SerializedName("pilots") val pilots : List<String>,
    @SerializedName("films") val films : List<String>,
    @SerializedName("created") val created : String,
    @SerializedName("edited") val edited : String,
    @SerializedName("url") val url : String
)