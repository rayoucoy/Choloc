package com.skripsi.yudha.choloc.utils;

/**
 * Created by yudha on 26/04/2016.
 */
public class Utility {

    public final static boolean isEmailValid(String email) {
        CharSequence target = email;
        if (target == null) {
            return false;
        } else {
            return android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
        }
    }

}
