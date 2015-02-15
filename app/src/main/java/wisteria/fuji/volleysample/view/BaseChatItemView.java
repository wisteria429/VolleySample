package wisteria.fuji.volleysample.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.text.SimpleDateFormat;

import wisteria.fuji.volleysample.model.Chat;

/**
 * Created by fuji on 2015/02/15.
 */
public abstract class BaseChatItemView extends RelativeLayout{
    protected TextView text;
    protected TextView date;
    protected Context context;

    protected BaseChatItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        view(context);
    }

    public void bind(Chat chat) {
        text.setText(chat.getText());
        SimpleDateFormat sdf = new SimpleDateFormat("H:mm");

        date.setText(sdf.format(chat.getDate()));
    }

    protected abstract void view(Context context);
}
