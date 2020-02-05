package com.example.locationtrackingapp.utility;

import android.app.Dialog;
import android.content.Context;
import com.example.locationtrackingapp.R;
import ir.alirezabdn.wp7progress.WP10ProgressBar;

public class Utils {

    public static Dialog showLoadingDialog(Context context) {
        WP10ProgressBar wp10ProgressBar;
        Dialog dialog;
        dialog = new Dialog(context);
        dialog.setContentView(R.layout.dialog_layout);
        dialog.setCancelable(false);
        wp10ProgressBar = dialog.findViewById(R.id.wp7progressBar);

        wp10ProgressBar.showProgressBar();

        return dialog;
    }

}
