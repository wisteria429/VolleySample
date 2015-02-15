package wisteria.fuji.volleysample.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.android.volley.RequestQueue;
import com.android.volley.Response.Listener;
import com.android.volley.Response.ErrorListener;
import com.android.volley.VolleyError;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import wisteria.fuji.volleysample.ChatListAdapter;
import wisteria.fuji.volleysample.R;
import wisteria.fuji.volleysample.VolleyHelper;
import wisteria.fuji.volleysample.model.Chat;
import wisteria.fuji.volleysample.request.ChatRequest;
import wisteria.fuji.volleysample.response.ChatResponse;


public class MainActivity extends Activity {
    private static final String TAG = "MainActivity";
    private RequestQueue mQueue;
    private List<Chat> list;
    private ListView chatlist;
    private ChatListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate");
        setContentView(R.layout.activity_main);

        chatlist = (ListView) findViewById(R.id.listView_chat);
        list = new ArrayList<Chat>();
        adapter = new ChatListAdapter(this, 0, list);
        chatlist.setAdapter(adapter);
        updateListData();
    }

    public void updateListData() {

        Log.d(TAG, "updateListData");
         try {
            mQueue = VolleyHelper.initRequestQueue(this);
            Map<String, String> params = new HashMap<String, String>();
            ChatRequest request = new ChatRequest(params, mLocalSearchResponseListener, mErrorListener);

            mQueue.add(request);
        } catch (UnsupportedEncodingException e) {
            Log.d(TAG, e.getMessage());
        }
    }

    private Listener<ChatResponse> mLocalSearchResponseListener = new Listener<ChatResponse>() {
        @Override
        public void onResponse(ChatResponse response) {
            Log.d(TAG, "onResponse");
            for (Chat c : response.getChatList()) {
                Log.d(TAG, c.getText());
                adapter.add(c);
            }

        }
    };

    private ErrorListener mErrorListener = new ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {

            Log.d(TAG, "onErrorResponse");
            Log.d(TAG, error.getMessage());

        }
    };

}
