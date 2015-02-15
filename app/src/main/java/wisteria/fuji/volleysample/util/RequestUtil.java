package wisteria.fuji.volleysample.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

/**
 * Created by fuji on 2015/02/14.
 */
public class RequestUtil {
    /**
     * GETリクエスト用にMapからリクエストパラメータ文字列を作成する
     * @param params リクエストパラメータのMap
     * @param encoding リクエスト文字列のエンコードフォーマット デフォルトはUTF-8
     * @return
     * @throws UnsupportedEncodingException
     */
    public static String buildRequestQuery(Map<String,String> params, String encoding) throws UnsupportedEncodingException{
        // 引数のencodingがnull or 空文字だった場合はUTF-8にする
        if (encoding == null || encoding.equals("")) encoding = "UTF-8";

        //リクエスト文字列を作成する
        StringBuilder sBuilder = new StringBuilder();
        for (Map.Entry<String, String> e : params.entrySet()) {
            if (e.getKey().isEmpty()) continue;
            if (sBuilder.length() != 0) sBuilder.append("&");
            URLEncoder.encode(e.getKey(), encoding);
        }
        return sBuilder.toString();
    }
}
