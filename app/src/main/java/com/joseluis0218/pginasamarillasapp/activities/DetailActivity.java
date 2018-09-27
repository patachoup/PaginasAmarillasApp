package com.joseluis0218.pginasamarillasapp.activities;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.joseluis0218.pginasamarillasapp.R;

import java.util.Objects;

public class DetailActivity extends AppCompatActivity {

    private TextView tx_name ;
    private TextView tx_address;
    private TextView tx_category;
    private TextView tx_phone;
    private TextView tx_email;
    private TextView tx_info;
    private ImageView tx_logo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

         tx_name = findViewById(R.id.fullname_text);
         tx_address = findViewById(R.id.address_text);
         tx_category = findViewById(R.id.category_text);
         tx_phone = findViewById(R.id.phone_text);
         tx_email = findViewById(R.id.email_text);
         tx_info = findViewById(R.id.info_text);
         tx_logo = findViewById(R.id.picture_image);

        String name = Objects.requireNonNull(getIntent().getExtras().getString("fullname_text"));
        String address = getIntent().getExtras().getString("address_text");
        String category = getIntent().getExtras().getString("category_text");
        String phone = getIntent().getExtras().getString("phone_text");
        String email = getIntent().getExtras().getString("email_text");
        String url = getIntent().getExtras().getString("url_text");
        String info = getIntent().getExtras().getString("info_text");
        String logo = getIntent().getExtras().getString("picture_image");

        tx_name.setText(name);
        tx_address.setText(address);
        tx_category.setText(category);
        tx_phone.setText(phone);
        tx_email.setText(email);
        tx_info.setText(info);

        Context context = this;
        int idRes = context.getResources().getIdentifier(logo, "drawable", context.getPackageName());
        tx_logo.setImageResource(idRes);

    }
    public void BotonCall(View view){
        String number = getIntent().getExtras().getString("phone_text");
        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + number));
        intent.setData(Uri.parse("tel:" + number));
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
            return;
        }
        startActivity(intent);
    }
    public void BotonSMS(View v){
        String number = getIntent().getExtras().getString("phone_text");
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", number, null)));
    }

    public void BotonWeb(View view){
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);
        intent.setData(Uri.parse(getIntent().getExtras().getString("url_text")));
        startActivity(intent);
    }

    public void BotonEmail(View view){
        String name_email = tx_email.getText().toString();
        String company_name = tx_name.getText().toString();
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_EMAIL, new  String[]{name_email});
        intent.putExtra(Intent.EXTRA_SUBJECT,"Asunto");
        intent.putExtra(Intent.EXTRA_TEXT,"Buenas tardes compañia "+company_name);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void BotonShare(View view){
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, "Hey que te parece ir a este sitio !!");
        sendIntent.setType("text/plain");
        startActivity(sendIntent);
    }
}
