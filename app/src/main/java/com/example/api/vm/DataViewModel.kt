package com.example.api.vm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.api.model.Meme
import com.example.api.model.Tag

class DataViewModel :ViewModel(){

    var memes: MutableLiveData<ArrayList<Meme>> = MutableLiveData(arrayListOf())
    var tags: MutableLiveData<ArrayList<Tag>> = MutableLiveData(arrayListOf())

    fun memes(): ArrayList<Meme> {
        return memes.value!!
    }
    fun tags(): ArrayList<Tag> {
        return tags.value!!
    }

    fun setMemes(list:ArrayList<Meme>?){
        if(list != null)
            this.memes = MutableLiveData<ArrayList<Meme>>( list )
        else
            println("ESNULL")
    }
    fun setTags(list:ArrayList<Tag>?){
        if(list != null)
            this.tags = MutableLiveData<ArrayList<Tag>>( list )
    }
}