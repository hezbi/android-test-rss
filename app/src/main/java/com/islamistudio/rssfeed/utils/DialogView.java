package com.islamistudio.rssfeed.utils;

import android.app.AlertDialog;
import android.content.Context;

public class DialogView {

    public static void show(Context context, int title, int message) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);
        alertDialog.setTitle(title);
        alertDialog.setMessage(message);
        alertDialog.setNegativeButton(android.R.string.ok, (dialogInterface, i) -> dialogInterface.dismiss());

        AlertDialog dialog = alertDialog.create();
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
    }
}
