package com.islamistudio.rssfeed.utils;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

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

    public static void show(Context context, int title, String message) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);
        alertDialog.setTitle(title);
        alertDialog.setMessage(message);
        alertDialog.setNegativeButton(android.R.string.ok, (dialogInterface, i) -> dialogInterface.dismiss());

        AlertDialog dialog = alertDialog.create();
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
    }

    public static void show(Context context, int title, int message, DialogInterface.OnClickListener onClickListener) {

        AlertDialog.Builder alertDlg = new AlertDialog.Builder(context);

        alertDlg.setTitle(title);
        alertDlg.setMessage(message);
        alertDlg.setNegativeButton(android.R.string.ok, onClickListener);

        AlertDialog dialog = alertDlg.create();
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
    }

    public static void show(Context context, int title, String message, DialogInterface.OnClickListener onClickListener) {

        AlertDialog.Builder alertDlg = new AlertDialog.Builder(context);

        alertDlg.setTitle(title);
        alertDlg.setMessage(message);
        alertDlg.setNegativeButton(android.R.string.ok, onClickListener);

        AlertDialog dialog = alertDlg.create();
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
    }
}
