package com.example.segarbox.data.remote.api

import com.example.segarbox.BuildConfig
import com.example.segarbox.data.local.static.Code
import com.example.segarbox.data.remote.response.*
import retrofit2.Response
import retrofit2.http.*

interface ApiServices {

    @GET("json")
    suspend fun getAddress(
        @Query("latlng") latLng: String,
        @Query("key") apiKey: String = BuildConfig.GOOGLE_MAPS_KEY,
    ): Response<MapsResponse>

    @GET("city")
    suspend fun getCity(
        @Header("key") key: String = BuildConfig.RAJAONGKIR_KEY,
    ): Response<CityResponse>

    @FormUrlEncoded
    @POST("cost")
    suspend fun getShippingCosts(
        @Header("key") key: String = BuildConfig.RAJAONGKIR_KEY,
        @Field("origin") origin: String = Code.SEMARANG_ID,
        @Field("destination") destination: String,
        @Field("weight") weight: String,
        @Field("courier") courier: String,
    ): Response<ShippingResponse>

    @FormUrlEncoded
    @POST("register")
    @Headers("Accept: application/json")
    suspend fun register(
        @Field("name") name: String,
        @Field("email") email: String,
        @Field("phone") phone: String,
        @Field("password") password: String,
        @Field("password_confirmation") password_confirmation: String
    ): Response<RegisterResponse>

    @FormUrlEncoded
    @POST("login")
    @Headers("Accept: application/json")
    suspend fun login(
        @Field("email") email: String,
        @Field("password") password: String
    ): Response<LoginResponse>

    @GET("products")
    @Headers("Accept: application/json")
    suspend fun getAllProduct(
        @Query("page[number]") page: Int,
        @Query("page[size]") size: Int
    ): Response<ProductResponse>

    @GET("products/{id}")
    @Headers("Accept: application/json")
    suspend fun getProductById(
        @Path("id") id: Int
    ): Response<ProductByIdResponse>

    @GET("products")
    @Headers("Accept: application/json")
    suspend fun getCategoryProduct(
        @Query("page[number]") page: Int,
        @Query("page[size]") size: Int,
        @Query("filter[category]") category: String
    ): Response<ProductResponse>

    @GET("products")
    @Headers("Accept: application/json")
    suspend fun getLabelProduct(
        @Query("page[number]") page: Int,
        @Query("page[size]") size: Int,
        @Query("filter[label]") label: String
    ): Response<ProductResponse>

    @GET("users/1")
    @Headers("Accept: application/json")
    suspend fun getUser(
        @Header("Authorization") token: String
    ): Response<UserResponse>

//    @GET("users/{id}")
//    @Headers("Accept: application/json")
//    suspend fun getUser(
//        @Header("Authorization") token: String,
//        @Path("id") id: Int
//    ): Response<UserResponse>

    @FormUrlEncoded
    @POST("logout")
    @Headers("Accept: application/json")
    suspend fun logout(
        @Header("Authorization") token: String
    ): Response<LogoutResponse>

    @FormUrlEncoded
    @POST("carts")
    @Headers("Accept: application/json")
    suspend fun addToCart(
        @Header("Authorization") token: String,
        @Field("product_id") productId: Int,
        @Field("product_qty") productQty: Int,
        @Field("is_checked") isChecked: Int = 1,
    ): Response<AddCartResponse>

    @GET("carts")
    @Headers("Accept: application/json")
    suspend fun getUserCart(
        @Header("Authorization") token: String,
        @Query("include") include: String = "product"
    ): Response<UserCartResponse>

}
