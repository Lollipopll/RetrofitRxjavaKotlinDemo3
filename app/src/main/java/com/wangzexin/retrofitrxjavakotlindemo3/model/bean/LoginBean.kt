package com.wangzexin.retrofitrxjavakotlindemo3.model.bean
import com.google.gson.annotations.SerializedName


/**
 *
 * @author wangzexin
 * @date 2018/1/24
 * @describe
 */
//{"code":"200","data":{"uid":"97","token":"8E5DD788D0535FF318AB50058FD4A7BD6B9AE4B4","acctoken":"93d0c2b032a4063964f21339109aaab6"}}
data class LoginBean(
//		@SerializedName("code") val code: String = "",
//		@SerializedName("data") val data: Data = Data()

		@SerializedName("uid") val uid: String = "",
		@SerializedName("token") val token: String = "",
		@SerializedName("acctoken") val acctoken: String = ""
)

//data class Data(
//		@SerializedName("uid") val uid: String = "",
//		@SerializedName("token") val token: String = "",
//		@SerializedName("acctoken") val acctoken: String = ""
//)