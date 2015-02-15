package wisteria.fuji.volleysample;

import android.app.DownloadManager;
import android.content.Context;

import com.android.volley.Network;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

/**
 * Created by fuji on 2015/02/12.
 */
public class VolleyHelper {
    private static RequestQueue mQueue = null;
    private static ImageLoader mLoader = null;
    public static RequestQueue initRequestQueue(Context context) {
//        Network network = new BasicNetwork(new HurlStack());
        if (mQueue == null) {
            mQueue = Volley.newRequestQueue(context);
        }

        mQueue.start();
        return mQueue;
    }

    public static ImageLoader initImageLoader(Context context) {
        if (mLoader == null) {
            mLoader = new ImageLoader(initRequestQueue(context), new LruImageCache());
        }

        return mLoader;
    }

}
