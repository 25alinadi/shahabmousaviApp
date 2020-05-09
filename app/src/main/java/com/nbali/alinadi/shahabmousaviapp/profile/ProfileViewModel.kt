package com.nbali.alinadi.shahabmousaviapp.profile

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.nbali.alinadi.shahabmousaviapp.models.Message
import com.nbali.alinadi.shahabmousaviapp.models.Info
import com.nbali.alinadi.shahabmousaviapp.models.User
import com.nbali.alinadi.shahabmousaviapp.utils.Utils

class ProfileViewModel(application: Application) : AndroidViewModel(application) {
    private var context = application
    private var profileRepository = ProfileRepository(context)

    fun registerUser(firstName:String,lastName:String,email:String,password:String,phone:String,gender:Int): LiveData<Message> {
        return profileRepository.registerUser(firstName,lastName, email, password, phone, gender)
    }

    fun loginUser(email:String,password:String): LiveData<Message>{
        return profileRepository.loginUser(email, password)
    }

    fun createToken(token: String,fullName:String,role:String) {
        Utils.myToken = token
        profileRepository.createToken(token,fullName,role)
    }

    fun getToken(): String {
        Utils.myToken = profileRepository.getToken()
        return profileRepository.getToken()
    }

    fun getFullName(): String {
        return profileRepository.getFullName()
    }

    fun getRole(): String {
        return profileRepository.getRole()
    }

    fun updateFullName(fullName:String){
        return profileRepository.updateFullName(fullName)
    }

    fun signOut(){
        return profileRepository.signOut()
    }

    fun firstPage():LiveData<Info>{
        return profileRepository.firstPage()
    }

    fun contactUs():LiveData<Info>{
        return profileRepository.contactUs()
    }

    fun userInfo(): LiveData<User>{
        return profileRepository.userInfo()
    }

    fun updateProfile(firstName: String,lastName: String,phone: String,gender: Int):LiveData<Message>{
        return profileRepository.updateProfile(firstName, lastName,phone, gender)
    }
}