package core.pfe.blank.util;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.annotation.Nullable;

import java.util.Map;
import java.util.Set;

public class SessionManager {

    Context context;


    SharedPreferences preferences ;
    SharedPreferences.Editor editor;


    public SessionManager(Context context) {
        this.context = context;


    }


    public boolean isLogin(){

        return false;
    }

    public void login(){

    }

    public boolean isAdmin(){

        return false;
    }
}

