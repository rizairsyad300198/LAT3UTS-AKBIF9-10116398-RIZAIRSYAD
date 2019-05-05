package com.example.hafidz.myselfapp.Profil;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hafidz.myselfapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ContactFragment extends Fragment {

    private View view;
    String phoneNumber, instagramName, facebookName;
    @BindView(R.id.phone_call) LinearLayout phoneCall;
    @BindView(R.id.email) LinearLayout email;
    @BindView(R.id.instagram) LinearLayout instagram;
    @BindView(R.id.facebook) LinearLayout facebook;

    @BindView(R.id.txtPhoneNumber) TextView txtPhoneNumber;
    @BindView(R.id.txtEmail) TextView txtEmail;
    @BindView(R.id.txtInstagram) TextView txtInstagram;
    @BindView(R.id.txtFacebook) TextView txtFacebook;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =  inflater.inflate(R.layout.fragment_contact, container, false);
        ButterKnife.bind(this, view);

        phoneCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intentphonecall();
            }
        });
        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intentemail();
            }
        });
        instagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intentinstagram();
            }
        });
        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intentfacebook();
            }
        });

        return view;
    }

    public void intentphonecall() {
        phoneNumber = txtPhoneNumber.getText().toString();
        Intent callIntent = new Intent(Intent.ACTION_DIAL);
        callIntent.setData(Uri.parse("tel:"+phoneNumber));//change the number.
        startActivity(callIntent);
    }

    public void intentemail() {
        String emailadd = txtEmail.getText().toString();
        Intent likeIng = new Intent(Intent.ACTION_SEND);
        try {
             likeIng.setType("plain/text")
                    .putExtra(Intent.EXTRA_EMAIL,new String[] { emailadd })
                    .putExtra(Intent.EXTRA_SUBJECT, "MySelfApp email test")
                    .putExtra(Intent.EXTRA_TEXT, "Hello. this is a message sent from MySelfApp :-)");
            startActivity(likeIng);
        } catch (ActivityNotFoundException e) {
            Toast.makeText(getContext(), "email app not found or must be updated", Toast.LENGTH_SHORT).show();
        }

    }

    public void intentinstagram() {
        instagramName = txtInstagram.getText().toString();
        Uri uri = Uri.parse("http://instagram.com/_u/"+instagramName);
        Intent likeIng = new Intent(Intent.ACTION_VIEW, uri);

        likeIng.setPackage("com.instagram.android");

        try {
            startActivity(likeIng);
        } catch (ActivityNotFoundException e) {
            startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("http://instagram.com/"+instagramName)));
        }
    }

    public void intentfacebook() {
        facebookName = "rizairsyad225";
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/"+facebookName)));
    }
}
