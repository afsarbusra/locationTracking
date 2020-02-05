package com.example.locationtrackingapp.utility;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.cardview.widget.CardView;

import com.example.locationtrackingapp.R;

public class CustomToast {

    public static void toastIconError(Context context) {
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        Toast toast = new Toast(context.getApplicationContext());
        toast.setDuration(Toast.LENGTH_SHORT);
        View inflate = inflater.inflate(R.layout.toast_icon_text, null);
        ((TextView) inflate.findViewById(R.id.message)).setText("Transaction Failed");
        ((ImageView) inflate.findViewById(R.id.icon)).setImageResource(R.drawable.ic_close);
        ((CardView) inflate.findViewById(R.id.parent_view)).setCardBackgroundColor(context.getResources().getColor(R.color.red_600));
        toast.setView(inflate);
        toast.show();
    }



    public static void toastIconSuccess(Context context) {
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        Toast toast = new Toast(context.getApplicationContext());
        toast.setDuration(Toast.LENGTH_SHORT);
        View inflate = inflater.inflate(R.layout.toast_icon_text, null);
        ((TextView) inflate.findViewById(R.id.message)).setText("Transaction Successful");
        ((ImageView) inflate.findViewById(R.id.icon)).setImageResource(R.drawable.ic_done);
        ((CardView) inflate.findViewById(R.id.parent_view)).setCardBackgroundColor(context.getResources().getColor(R.color.green_500));
        toast.setView(inflate);
        toast.show();
    }




}
