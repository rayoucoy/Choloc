package com.skripsi.yudha.choloc.helper;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by yudha on 24/05/16.
 * we need to detect whether user has working internet connection or not.
 */
public class ConnectionDetector {
    private Context _context;

    public ConnectionDetector(Context context){
        this._context = context;
    }

    // cek semua jaringan provider

    public boolean isConnectingToInternet(){
        ConnectivityManager connectivity = (ConnectivityManager) _context.getSystemService(Context.CONNECTIVITY_SERVICE);
            if (connectivity !=null){
                NetworkInfo[] info = connectivity.getAllNetworkInfo();
                if(info != null)
                    for (int i =0; i<info.length; i++)
                        if(info[i].getState() == NetworkInfo.State.CONNECTED)
                        {
                            return  true;
                        }
            }
        return  false;
    }
}
