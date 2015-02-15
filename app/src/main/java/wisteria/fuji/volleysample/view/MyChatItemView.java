package wisteria.fuji.volleysample.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import wisteria.fuji.volleysample.R;
import wisteria.fuji.volleysample.model.Chat;

/**
 * Created by fuji on 2015/02/15.
 */
public class MyChatItemView extends BaseChatItemView{

    public MyChatItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    protected void view(Context context) {
        View v = LayoutInflater.from(context).inflate(R.layout.view_my_chat_row, this);
        text = (TextView) v.findViewById(R.id.textView_text);
        date = (TextView) v.findViewById(R.id.textView_date);
    }


}
