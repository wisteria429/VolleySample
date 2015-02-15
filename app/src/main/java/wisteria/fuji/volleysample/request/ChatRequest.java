package wisteria.fuji.volleysample.request;

import android.util.Log;

import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.JsonRequest;

import org.json.JSONException;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.util.Map;

import wisteria.fuji.volleysample.parser.ChatParser;
import wisteria.fuji.volleysample.response.ChatResponse;
import wisteria.fuji.volleysample.util.RequestUtil;

/**
 * ローカルサーチAPI取得用のリクエストクラス
 */
public class ChatRequest extends JsonRequest<ChatResponse> {
    private static final String TAG = "ChatRequest";
    private static final String URL = "";

    public ChatRequest(Map<String, String> params, Listener<ChatResponse> listener, ErrorListener errorListener) throws UnsupportedEncodingException{
        super(Method.GET, requestUrl(params), null, listener, errorListener);
        Log.d(TAG, "ChatRques");
    }

    private static String requestUrl(Map<String,String> params) throws UnsupportedEncodingException{
        Log.d(TAG, "requestUrl");

        return URL + "?" + RequestUtil.buildRequestQuery(params, null);
    }


    @Override
    protected Response<ChatResponse> parseNetworkResponse(NetworkResponse response) {
        try {
            //レスポンスを文字列にする
            String jsonString =
                    new String(response.data, HttpHeaderParser.parseCharset(response.headers));
            Log.d(TAG, jsonString);
            ChatResponse qResponse = ChatParser.parse(jsonString);

            return Response.success(qResponse,
                    HttpHeaderParser.parseCacheHeaders(response));
        } catch (UnsupportedEncodingException e) {
            return Response.error(new ParseError(e));
        } catch (JSONException e) {
            return Response.error(new ParseError(e));
        } catch (ParseException e) {
            return Response.error(new ParseError(e));
        }
    }
}
