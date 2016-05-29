package com.skripsi.yudha.choloc.helper;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

import com.skripsi.yudha.choloc.R;

/**
 * Created by yudha on 24/05/16.
 * you don’t have to write the alert code in all the activities
 * Function to display simple Alert Dialog
 * tinggal manggil aje
 */
public class AlertDialogManager {

    public void showAlertDialog(Context context, String title, String message, Boolean status){
        AlertDialog alertDialog = new AlertDialog.Builder(context).create();
        // Setting Dialog Title
        alertDialog.setTitle(title);

        // Setting Dialog Message
        alertDialog.setMessage(message);

        if(status != null)
            // Setting alert dialog icon
//            alertDialog.setIcon((status) ? R.drawable.success : R.drawable.fail);

        // Setting OK Button
        alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        // Showing Alert Message
        alertDialog.show();
    }

}
