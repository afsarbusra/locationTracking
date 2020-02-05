package com.example.locationtrackingapp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.DialogFragment;

import android.app.Dialog;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;

import com.example.locationtrackingapp.R;
import com.example.locationtrackingapp.data.pref.ISharedPrefHelper;
import com.example.locationtrackingapp.di.BaseActivity;
import com.example.locationtrackingapp.eventbus.AccountEvent;
import com.example.locationtrackingapp.utility.CustomToast;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.squareup.picasso.Picasso;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Optional;

public class SettingsActivity extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Inject
    ISharedPrefHelper sharedPrefHelper;

    String distance;
    CustomToast toast = new CustomToast();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_sectioned);
        ButterKnife.bind(this);

        toolbar.setTitle("Settings");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(view -> onBackPressed());

        Log.d("TAG", "onCreate: " + sharedPrefHelper.getWarningDistance());
    }

    private void showCustomDialog() {
        final Dialog dialog = new Dialog(this);

        dialog.requestWindowFeature(1);
        dialog.setContentView(R.layout.dialog_add_review);
        dialog.setCancelable(true);

        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(dialog.getWindow().getAttributes());
        layoutParams.width = -2;
        layoutParams.height = -2;

        TextInputLayout textInputEditText = dialog.findViewById(R.id.til_topup);
        final EditText etDistance = dialog.findViewById(R.id.et_distance);

        dialog.findViewById(R.id.bt_cancel).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        dialog.findViewById(R.id.bt_submit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                distance = textInputEditText.getEditText().getText().toString().trim();
                if (!distance.equals("")) {
                    sharedPrefHelper.saveWarningDistance(distance);
                    dialog.dismiss();
                    toast.toastIconSuccess(SettingsActivity.this);
                }
            }
        });
        dialog.show();
        dialog.getWindow().setAttributes(layoutParams);
    }

    @Optional
    @OnClick({R.id.lout_shareApp})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.lout_shareApp:
                showCustomDialog();
                break;
        }
    }


}
