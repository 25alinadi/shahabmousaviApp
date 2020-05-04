package com.nbali.alinadi.shahabmousaviapp.post

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.nbali.alinadi.shahabmousaviapp.models.Post
import com.nbali.alinadi.shahabmousaviapp.models.Product

class PostViewModel(application: Application) : AndroidViewModel(application) {
    var context = application
    private var repository = PostRepository(context)

    fun getAllProducts(): LiveData<List<Product>> {
        return repository.getAllProducts()
    }

    fun getAllProductsTitle(): LiveData<List<Product>>{
        return repository.getAllProductsTitle()
    }

    fun getAllPosts(): LiveData<List<Post>>{
        return repository.getAllPosts()
    }
}