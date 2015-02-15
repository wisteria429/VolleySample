package wisteria.fuji.volleysample.response;

import java.util.List;

import wisteria.fuji.volleysample.model.Chat;

/**
 * Created by fuji on 2015/02/12.
 */
public class ChatResponse {
    private List<Chat> chatList;

    public List<Chat> getChatList() {
        return chatList;
    }
    public void setChatList(List<Chat> chatList) {
        this.chatList = chatList;
    }



}
