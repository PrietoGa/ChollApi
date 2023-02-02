package com.example.api.vm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.api.model.Meme
import com.example.api.model.TagPost

class DataViewModel :ViewModel(){

    var memes: MutableLiveData<ArrayList<Meme>> = MutableLiveData(arrayListOf())
    var tags: MutableLiveData<ArrayList<TagPost>> = MutableLiveData(arrayListOf())

    fun memes(): ArrayList<Meme> {
        return memes.value!!
    }
    fun tags(): ArrayList<TagPost> {
        return tags.value!!
    }

    fun setMemes(list:ArrayList<Meme>?){
        if(list != null)
            this.memes = MutableLiveData<ArrayList<Meme>>( list )
        else
            println("ESNULL")
    }
    fun setTags(list:ArrayList<TagPost>?){
        if(list != null)
            this.tags = MutableLiveData<ArrayList<TagPost>>( list )
    }
}