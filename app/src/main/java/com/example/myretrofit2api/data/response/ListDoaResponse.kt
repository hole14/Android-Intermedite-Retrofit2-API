package com.example.myretrofit2api.data.response

import com.google.gson.annotations.SerializedName

data class ListDoaResponse(

	@field:SerializedName("ListDoaResponse")
	val listDoaResponse: List<ListDoaResponseItem>
)