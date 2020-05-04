package com.nbali.alinadi.shahabmousaviapp.post

import android.app.Application
import androidx.lifecycle.LiveData
import com.nbali.alinadi.shahabmousaviapp.models.Post
import com.nbali.alinadi.shahabmousaviapp.models.Product

class PostRepository(context: Application) {
    private var postApiService =
        PostApiService(context)

    fun getAllProducts():LiveData<List<Product>>{
        return postApiService.getAllProducts()
    }

    fun getAllProductsTitle(): LiveData<List<Product>>{
        return postApiService.getAllProductsTitle()
    }

    fun getAllPosts(): LiveData<List<Post>>{
        return postApiService.getAllPosts()
    }
}