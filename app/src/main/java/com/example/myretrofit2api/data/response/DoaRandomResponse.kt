package com.example.myretrofit2api.data.response

import com.google.gson.annotations.SerializedName

data class DoaRandomResponse(

	@field:SerializedName("DoaRandomResponse")
	val doaRandomResponse: List<DoaRandomResponseItem>
)