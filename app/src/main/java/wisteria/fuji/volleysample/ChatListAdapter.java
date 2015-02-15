package wisteria.fuji.volleysample;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.List;

import wisteria.fuji.volleysample.model.Chat;
import wisteria.fuji.volleysample.view.BaseChatItemView;
import wisteria.fuji.volleysample.view.MyChatItemView;
import wisteria.fuji.volleysample.view.PartnerChatItemView;

/**
 * Created by fuji on 2015/02/15.
 */
public class ChatListAdapter extends ArrayAdapter<Chat>{
    private static final String TAG = "ChatListAdapter";
    private Context mContext;
    public ChatListAdapter(Context context, int resource, List<Chat> list) {
        super(context, resource, list);
        mContext = context;
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }



    @Override
    public int getItemViewType(int position) {

        return getItem(position).getDirection();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Log.d(TAG,"getView");
        Chat chat = getItem(position);
        int viewType = getItemViewType(position);
        if (convertView == null && viewType == Chat.DIRECTION_MY) {
            Log.d(TAG, "getView new DIRECTION_MY");
            convertView = new MyChatItemView(mContext, null);
        } else if (convertView == null && viewType == Chat.DIRECTION_PARTNER) {
            Log.d(TAG, "getView new DIRECTION_PARTNER");
            convertView = new PartnerChatItemView(mContext, null);

        }
        ((BaseChatItemView)convertView).bind(chat);
        return convertView;
    }


}
