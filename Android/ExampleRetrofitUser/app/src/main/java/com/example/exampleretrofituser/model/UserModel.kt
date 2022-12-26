package com.example.exampleretrofituser.model

 data class UserModel (
     val id: Int,
     val name: String,
     val username: String,
     val email: String,
     val address: AddressModel,
     val phone: String,
     val website: String,
     val company: CompanyModel
 )