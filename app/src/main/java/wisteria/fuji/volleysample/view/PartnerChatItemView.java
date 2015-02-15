package wisteria.fuji.volleysample.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.android.volley.toolbox.NetworkImageView;

import wisteria.fuji.volleysample.R;
import wisteria.fuji.volleysample.VolleyHelper;
import wisteria.fuji.volleysample.model.Chat;

/**
 * Created by fuji on 2015/02/15.
 */
public class PartnerChatItemView extends BaseChatItemView{
    protected NetworkImageView imageView;
    public PartnerChatItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    public void bind(Chat chat) {
        super.bind(chat);
        imageView.setImageUrl(chat.getImageUrl(), VolleyHelper.initImageLoader(context));

    }

    @Override
    protected void view(Context context) {
        View v = LayoutInflater.from(context).inflate(R.layout.view_partner_chat_row, this);
        text = (TextView) v.findViewById(R.id.textView_partner_text);
        date = (TextView) v.findViewById(R.id.textView_partner_date);
        imageView = (NetworkImageView) v.findViewById(R.id.imageView_partner_profile);
    }
}
