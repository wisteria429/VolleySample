package wisteria.fuji.volleysample.model;

import java.util.Date;

/**
 * ローカルサーチAPIのデータオブジェクト
 */
public class Chat {
    public static final int DIRECTION_MY = 0;
    public static final int DIRECTION_PARTNER = 1;
    private String text;
    private int direction;
    private String imageUrl;
    private Date date;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }



    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
