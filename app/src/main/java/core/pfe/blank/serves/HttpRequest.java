package core.pfe.blank.serves;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class HttpRequest {


    protected   RequestQueue queue;
    protected  Context context;

    public static   String URL = "http://192.168.1.123:8018/api";
    public static  String uploads = "http://192.168.1.123:8018/uploads";

    public static String url(String url){
        return  URL+url;
    }
}
