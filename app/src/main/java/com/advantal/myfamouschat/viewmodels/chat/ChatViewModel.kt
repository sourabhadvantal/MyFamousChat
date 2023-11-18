package com.advantal.myfamouschat.viewmodels.chat

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

import com.advantal.myfamous.data.chat.AllMessagesModel
import com.advantal.myfamous.data.chat.ChatUserModel
import com.advantal.myfamouschat.di.Resource

import com.advantal.myfamouschat.R
import com.advantal.myfamouschat.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ChatViewModel @Inject constructor(private val repository: MainRepository) : ViewModel() {
    val chatUserAuthenticate = MutableLiveData<Resource<ChatUserModel>>()

    fun getChatUserModel(): ArrayList<ChatUserModel> {
        var chatUserList = ArrayList<ChatUserModel>()

        chatUserList.add(ChatUserModel("Martha Craig" , "Sent 21m ago" ,false, R.drawable.ic_chat_user_1))
        chatUserList.add(ChatUserModel("Karen Castillo" , "Seen Yesterday" ,false, R.drawable.ic_chat_user_5))
        chatUserList.add(ChatUserModel("Maximillian Jacobscon" , "Seen Yesterday" ,false, R.drawable.ic_chat_user_2))
        chatUserList.add(ChatUserModel("Tabitha Potter" , "Sent 21m ago" ,false, R.drawable.ic_chat_user_3))
        chatUserList.add(ChatUserModel("Maisy Humphrey" , "Sent 21m ago" ,false, R.drawable.ic_chat_user_4))
        chatUserList.add(ChatUserModel("Kieron Dotson" , "Sent 21m ago" ,false, R.drawable.ic_chat_user_5))

        return chatUserList
    }
    fun getAllMessagesModel(): ArrayList<AllMessagesModel> {
        var chatUserList = ArrayList<AllMessagesModel>()

        chatUserList.add(AllMessagesModel("Martha Craig" , "Sent 21m ago" ,false ,0 ,"Hi " ))
        chatUserList.add(AllMessagesModel("Karen Castillo" , "Seen Yesterday" ,false ,0 ,"How are You?"))
        chatUserList.add(AllMessagesModel("Maximillian Jacobscon" , "Seen Yesterday" ,true ,0 ,""))
        chatUserList.add(AllMessagesModel("Tabitha Potter" , "Sent 21m ago" ,false , 1 ,"I am fine"))
        chatUserList.add(AllMessagesModel("Maisy Humphrey" , "Sent 21m ago" ,false ,1 ,"Nice Pic"))
        chatUserList.add(AllMessagesModel("Kieron Dotson" , "Sent 21m ago" ,false ,1 ,"Mate"))

        return chatUserList
    }


}