package com.nbali.alinadi.shahabmousaviapp.api

import com.nbali.alinadi.shahabmousaviapp.models.*
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @GET("api/allproducts")
    fun getAllProducts():Call<List<Product>>

    @GET("api/allproductstitle")
    fun getAllProductsTitle():Call<List<Product>>

    @GET("api/allsubscribes")
    fun getAllSubscribes():Call<List<Subscribe>>

    @FormUrlEncoded
    @POST("mobile/register_user")
    fun registerUser(
        @Field("firstName") firstName:String,
        @Field("lastName") lastName:String,
        @Field("email") email:String,
        @Field("password") password:String,
        @Field("phone") phone:String,
        @Field("gender") gender:Int
    ):Call<Message>

    @FormUrlEncoded
    @POST("mobile/login_user")
    fun loginUser(
        @Field("email") email:String,
        @Field("password") password:String
    ):Call<Message>

    @GET("api/allrules")
    fun getAllRules():Call<List<Rule>>

    @FormUrlEncoded
    @POST("mobile/ask")
    fun ask(
        @Field("title") title: String,
        @Field("text") text: String,
        @Field("product") product: String,
        @Field("type") type: Int
    ): Call<Message>

    @GET("api/answers")
    fun getAnswer():Call<List<Answer>>

    @GET("api/allposts")
    fun getAllPosts():Call<List<Post>>

    @FormUrlEncoded
    @POST("mobile/noanswers")
    fun getAllNoAnswers(@Field("role") role:String):Call<List<Answer>>

    @FormUrlEncoded
    @POST("mobile/returned")
    fun returnedAnswer(@Field("question_id") id:String):Call<Message>

    @FormUrlEncoded
    @POST("mobile/answer_question")
    fun answerQuestion(@Field("question_id") id:String,
                       @Field("question_answer") answer:String):Call<Message>

    @GET("api/uRole")
    fun getRole():Call<Message>
}