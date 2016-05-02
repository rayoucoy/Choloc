package com.skripsi.yudha.choloc;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.skripsi.yudha.choloc.utils.JSONParser;
import com.skripsi.yudha.choloc.utils.Utility;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class RegisterActivity extends AppCompatActivity {

    private EditText eUserName;
    private EditText eEmail;
    private EditText ePassword;
    private EditText eRePassword;
    private EditText eMobilePhone;
    private ProgressDialog pDialog;
    private CheckBox cCheck;
    private Button bSignUp;
    private Button bCancel;

    String sUserName, sEmail, sPassword, sRePassword, sMobilePhone;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // init Data
        eUserName = (EditText) findViewById(R.id.username);
        eEmail    = (EditText) findViewById(R.id.email);
        ePassword = (EditText) findViewById(R.id.password);
        eRePassword = (EditText) findViewById(R.id.repass);
        eMobilePhone = (EditText) findViewById(R.id.no_hp);
        cCheck      = (CheckBox) findViewById(R.id.checkCreate);
        bSignUp     = (Button) findViewById(R.id.signup_button);
        bCancel     = (Button) findViewById(R.id.cancel_button);

        // Progress Dialog
        pDialog = new ProgressDialog(this);
        pDialog.setCancelable(false);

        bSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sEmail = eEmail.getText().toString();
                sPassword = ePassword.getText().toString();
                sRePassword= eRePassword.getText().toString();
                sUserName = eUserName.getText().toString();
                sMobilePhone = eMobilePhone.getText().toString();

                if (sEmail.isEmpty() || sPassword.isEmpty() || sRePassword.isEmpty() || sUserName.isEmpty() || sMobilePhone.isEmpty())
                {Toast.makeText(getBaseContext(), "Gagal! Harap lengkapi semua kolom", Toast.LENGTH_SHORT).show();}
                else if (!Utility.isEmailValid(sEmail)){
                    eEmail.setError("Email tidak valid");
                }else
                if (!sPassword.equals(sRePassword)){
                    eRePassword.setText("");
                    eRePassword.setError("Password tidak sama");
                }
                else {
                    CreateAccount m = (CreateAccount) new CreateAccount().execute();
                }

            }
        });
        // Cancel button to Login Screen
        bCancel.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),
                        LoginActivity.class);
                startActivity(i);
                finish();
            }
        });
    }

    class CreateAccount extends AsyncTask<String, Void, String>
    {
        ProgressDialog pDialog;
        JSONParser jParser = new JSONParser();
        JSONArray posts = null;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(RegisterActivity.this);
            pDialog.setMessage("Loading..");
            pDialog.setIndeterminate(true);
            pDialog.setCancelable(false);
            pDialog.show();
        }

        @Override
        protected String doInBackground(String... sText) {
            String returnResult = createAccount();
            return returnResult;
        }

        public String createAccount()
        {
            List<NameValuePair> parameter = new ArrayList<NameValuePair>();
            parameter.add(new BasicNameValuePair("email", sEmail));
            parameter.add(new BasicNameValuePair("password", sPassword));
            parameter.add(new BasicNameValuePair("username", sUserName));
            parameter.add(new BasicNameValuePair("no_hp", sMobilePhone));

            try {
                String url_all_posts = "http://luxarcadia.com/choloc/api/create_user.php" ;

                JSONObject json = jParser.makeHttpRequest(url_all_posts,"POST", parameter);

                int success = json.getInt("success");
                if (success == 1) {
                    return "OK";
                }
                else if (success == 2){
                    return "email registered";
                }
                else {
                    return "fail";
                }

            } catch (Exception e) {
                e.printStackTrace();
                return "Exception Caught";
            }
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            pDialog.dismiss();
            if(result.equalsIgnoreCase("Exception Caught"))
            {
                Toast.makeText(RegisterActivity.this, "Erorr! Cek koneksi internet Anda", Toast.LENGTH_LONG).show();
            }
            else if(result.equalsIgnoreCase("fail"))
            {
                Toast.makeText(RegisterActivity.this, "Registrasi gagal, coba lagi!", Toast.LENGTH_LONG).show();
            }
            else if(result.equalsIgnoreCase("email registered"))
            {
                Toast.makeText(RegisterActivity.this, "Pendaftaran Gagal! Email Anda telah terdaftar!", Toast.LENGTH_LONG).show();
            }
            else {
                //SUKSES
                Toast.makeText(RegisterActivity.this, "Pendaftaran berhasil! Silahkan login!", Toast.LENGTH_LONG).show();
                // Launch login activity
                Intent intent = new Intent(
                        RegisterActivity.this,
                        LoginActivity.class);
                startActivity(intent);
                finish();
            }
        }

    }
}
