package wisteria.fuji.volleysample.parser;

import android.text.format.DateFormat;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import wisteria.fuji.volleysample.model.Chat;
import wisteria.fuji.volleysample.response.ChatResponse;

/**
 * ローカルサーチAPI用のparser
 */
public class ChatParser {
    private static final String TAG = "ChatParser";
    public static ChatResponse parse(String jsonString) throws JSONException, ParseException{
        JSONObject jsonObj = new JSONObject(jsonString);
       return parse(jsonObj);
    }

    public static ChatResponse parse(JSONObject jsonObj) throws JSONException, ParseException {
        Log.d(TAG, "parse");
        JSONArray result = jsonObj.getJSONArray("Result");


        List<Chat> chatList = new ArrayList<Chat>();
        for (int i=0; i < result.length(); i++) {
            JSONObject chat = result.getJSONObject(i);
            Chat c = new Chat();
            c.setText(chat.getString("text"));
            c.setDirection(chat.getInt("direction"));
            c.setImageUrl(chat.getString("image_url"));

            String dateSt = chat.getString("date");
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd H:m:s");
            c.setDate(df.parse(dateSt));
            chatList.add(c);

            Log.d(TAG, c.getText());
       }
        ChatResponse response = new ChatResponse();
        response.setChatList(chatList);
        return response;

    }
}
