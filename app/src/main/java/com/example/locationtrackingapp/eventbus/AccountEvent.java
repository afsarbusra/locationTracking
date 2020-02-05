package com.example.locationtrackingapp.eventbus;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

import com.google.android.gms.auth.api.signin.GoogleSignInAccount;

public class AccountEvent {
    private GoogleSignInAccount account;

    Bitmap bitmap;

    public GoogleSignInAccount getAccount() {
        return account;
    }

    public void setAccount(GoogleSignInAccount account) {
        this.account = account;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }
}
