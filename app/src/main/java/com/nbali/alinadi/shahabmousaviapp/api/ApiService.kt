package com.nbali.alinadi.shahabmousaviapp.api

import com.nbali.alinadi.shahabmousaviapp.models.*
import retrofit2.Call
import retrofit2.http.*

interface ApiService {
    @GET("api/firstpage")
    fun firstPage():Call<Info>

    @GET("api/contactus")
    fun contactUs():Call<Info>

    @GET("api/allproducts")
    fun getAllProducts():Call<List<Product>>

    @GET("api/allproductstitle")
    fun getAllProductsTitle():Call<List<Product>>

    @GET("api/allsubscribes")
    fun getAllSubscribes():Call<List<Subscribe>>

    @GET("mobile/registeruser")
    fun registerUser(
        @Query("firstName") firstName:String,
        @Query("lastName") lastName:String,
        @Query("email") email:String,
        @Query("password") password:String,
        @Query("phone") phone:String,
        @Query("gender") gender:Int
    ):Call<Message>

    @GET("mobile/loginuser")
    fun loginUser(
        @Query("email") email:String,
        @Query("password") password:String
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

    @GET("api/allanalysis")
    fun getAllAnalysis():Call<List<Analysis>>

    @GET("mobile/analysis_details")
    fun getAllRows(@Query("analysis_id") analysis_id:String):Call<List<AnalysisRow>>

    @GET("api/alladvices")
    fun getAllAdvices():Call<List<Advice>>

    @GET("mobile/advicetiming")
    fun getTiming(@Query("date") date:String):Call<Message>

    @FormUrlEncoded
    @POST("mobile/insert_timing")
    fun insertTiming(@Field("timing_id") timing_id:String):Call<Message>

    @FormUrlEncoded
    @POST("mobile/advice_timing_admin")
    fun getAllAdviceTimingAdmin(@Field("role") role:String):Call<List<Timing>>

    @GET("mobile/admin_change_request")
    fun changeRequestAdvice(@Query("request_id") rid:Int,
                            @Query("request_status") status:Int):Call<Message>

    @GET("api/usersubscribe")
    fun getUserSubscribe():Call<UserSubscribe>

    @GET("api/userinfo")
    fun userInfo():Call<User>

    @FormUrlEncoded
    @POST("mobile/updateprofile")
    fun updateProfile(@Field("firstName") firstName: String,
                      @Field("lastName") lastName: String,
                      @Field("phone") phone: String,
                      @Field("gender") gender: Int):Call<Message>
}