package com.example.locationtrackingapp.ui;

import android.Manifest;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.locationtrackingapp.R;
import com.example.locationtrackingapp.data.network.IEventBus;
import com.example.locationtrackingapp.di.BaseActivity;
import com.example.locationtrackingapp.eventbus.AccountEvent;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.SettingsClient;
import com.squareup.picasso.Picasso;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;


import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Optional;

public class GoogleSignInActivity extends BaseActivity implements GoogleApiClient.OnConnectionFailedListener, View.OnClickListener {

    private GoogleApiClient googleApiClient;
    private static final int code = 100;
    GoogleSignInAccount signInAccount;

    @Inject
    IEventBus eventBus;

    @Inject
    AccountEvent accountEvent;

    @BindView(R.id.ivUser)
    ImageView ivUser;

    @BindView(R.id.tvName)
    TextView tvName;

    @BindView(R.id.tvEmail)
    TextView tvEmail;

    SignInButton btnGoogleSignIn;
    LinearLayout lyProfile;

    private static final String FINE_LOCATION = Manifest.permission.ACCESS_FINE_LOCATION;
    private static final String COURSE_LOCATION = Manifest.permission.ACCESS_COARSE_LOCATION;
    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1234;
    private Boolean mLocationPermissionsGranted = false;
    private LocationSettingsRequest mLocationSettingsRequest;
    private SettingsClient mSettingsClient;
    private static final int REQUEST_CHECK_SETTINGS = 214;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_polygon);
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);


        GoogleSignInOptions signInOptions = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        googleApiClient = new GoogleApiClient.Builder(this).enableAutoManage(this, this).addApi(Auth.GOOGLE_SIGN_IN_API, signInOptions).build();


        /*btnGoogleSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                googleSocialLogin();
            }
        });*/
    }

    private void googleLogout() {
        Auth.GoogleSignInApi.signOut(googleApiClient).setResultCallback(new ResultCallback<Status>() {
            @Override
            public void onResult(@NonNull Status status) {
                onBackPressed();
            }
        });
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(sticky = true)
    public void onAccountEvent(AccountEvent accountEvent) {
        signInAccount = accountEvent.getAccount();
        tvName.setText(signInAccount.getDisplayName());
        tvEmail.setText(signInAccount.getEmail());
        Uri socialImageUrl = signInAccount.getPhotoUrl();
        Picasso.get()
                .load(socialImageUrl)
                .into(ivUser);

    }

    @Optional
    @OnClick({R.id.btnLogout, R.id.cV_locationTracking, R.id.cV_settings})
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.btnLogout:
                googleLogout();
                break;
            case R.id.cV_locationTracking:
                intent = new Intent(GoogleSignInActivity.this, LocationTracking.class);
                accountEvent.setAccount(signInAccount);
                ivUser.invalidate();
                BitmapDrawable drawable = (BitmapDrawable) ivUser.getDrawable();
                Bitmap bitmap = drawable.getBitmap();
                accountEvent.setBitmap(bitmap);
                eventBus.getBus().postSticky(accountEvent);
                startActivity(intent);
                break;
            case R.id.cV_settings:
                intent = new Intent(GoogleSignInActivity.this, SettingsActivity.class);
                startActivity(intent);
                break;

        }
    }
}
