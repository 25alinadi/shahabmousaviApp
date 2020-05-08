package com.nbali.alinadi.shahabmousaviapp.profile

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.nbali.alinadi.shahabmousaviapp.models.Message
import com.nbali.alinadi.shahabmousaviapp.models.Info
import com.nbali.alinadi.shahabmousaviapp.models.User

class ProfileRepository(var context: Application) {
    private var profileApiService = ProfileApiService(context)

    fun registerUser(firstName:String,lastName:String,email:String,password:String,phone:String,gender:Int): LiveData<Message>{
        return profileApiService.registerUser(firstName,lastName, email, password, phone, gender)
    }

    fun loginUser(email:String,password:String): LiveData<Message>{
        return profileApiService.loginUser(email, password)
    }

    fun getToken(): String {
        var sharedpreference = context.getSharedPreferences("smInfo", Context.MODE_PRIVATE)
        var token = sharedpreference.getString("key", "")
        return token!!
    }

    fun getFullName(): String {
        var sharedpreference = context.getSharedPreferences("smInfo", Context.MODE_PRIVATE)
        var fullName = sharedpreference.getString("fullName", "")
        return fullName!!
    }

    fun getRole(): String {
        var sharedpreference = context.getSharedPreferences("smInfo", Context.MODE_PRIVATE)
        var role = sharedpreference.getString("role", "")
        return role!!
    }

    fun createToken(token:String,fullName:String,role:String){
        var sharedPreference = context.getSharedPreferences(
            "smInfo",
            Context.MODE_PRIVATE
        )
        var editor: SharedPreferences.Editor = sharedPreference.edit()
        editor.putString("key", token)
        editor.putString("fullName", fullName)
        editor.putString("role", role)
        editor.apply()
    }

    fun updateFullName(fullName:String){
        var sharedPreference = context.getSharedPreferences(
            "smInfo",
            Context.MODE_PRIVATE
        )
        var editor: SharedPreferences.Editor = sharedPreference.edit()
        editor.putString("fullName", fullName)
        editor.apply()
    }

    fun firstPage():LiveData<Info>{
        return profileApiService.firstPage()
    }

    fun contactUs():LiveData<Info>{
        return profileApiService.contactUs()
    }

    fun userInfo(): LiveData<User>{
        return profileApiService.userInfo()
    }

    fun updateProfile(firstName: String,lastName: String,phone: String,gender: Int):LiveData<Message>{
        return profileApiService.updateProfile(firstName, lastName,phone, gender)
    }
}