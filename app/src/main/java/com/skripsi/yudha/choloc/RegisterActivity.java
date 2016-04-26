package com.skripsi.yudha.choloc;

import android.app.ProgressDialog;
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
    private SessionManagement session;
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
                    CreateAccount m= (CreateAccount) new CreateAccount().execute();
                }

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
                Toast.makeText(RegisterActivity.this, "Pendaftaran berhasil! Silahkan cek email untuk verifikasi!", Toast.LENGTH_LONG).show();

            }
        }

    }
}

/*
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends Activity{

    private Button btnRegister;
    private EditText eUserName;
    private EditText eEmail;
    private EditText ePassword;
    private EditText eRePassword;
    private EditText eMobilePhone;
    private ProgressDialog pDialog;
    private SessionManagement session;
    private CheckBox cCheck;
    private Button bSignUp;
    private Button bCancel;

    public void onCreate (Bundle savedInstanceState){
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

        // Session Manager
        session = new SessionManagement(getApplicationContext());

        // check user udah login belum
        if(session.isLoggedIn()){
            // Kalo user udah login langsung ke menu utama
            Intent MenuUtamaAct = new Intent(RegisterActivity.this,HomeActivity.class);
            startActivity(MenuUtamaAct);
            finish();
        }

        // Sign Up Button Activity
        bSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = eUserName.getText().toString();
                String email = eEmail.getText().toString();
                String password = ePassword.getText().toString();
                String repass = eRePassword.getText().toString();
                String no_hp = eMobilePhone.getText().toString();

                if (!username.isEmpty() && !email.isEmpty() && !password.isEmpty()
                        && !repass.isEmpty() && !no_hp.isEmpty()){
                    registerUser(username,email,password,repass,no_hp);
                } else {
                    Toast.makeText(getApplicationContext(),"Isi sing bener jon",Toast.LENGTH_LONG)
                            .show();
                }
            }
        });



    }
    // Register User Method
    private void registerUser(final String username,final String email,final String password,
                              final String repass,final String no_hp) {
        // Tag buat ga jadi request register
        String tag_string_req = "req_register";

        pDialog.setMessage("Registering...");
        showDialog();
        StringRequest strReq = new StringRequest(Method.POST,
                AppConfig.URL_REGISTER, new Response.Listener<String>(){
           public void onResponse(String response){
               // ngecek response
               Log.d(TAG,"Register Response: "+ response.toString());
               hideDialog(); // buat ngumpetin dialog
               // pARSING KE JSON
               try{
                   JSONObject jObj = new JSONObject(response);
                   boolean error = jObj.getBoolean("Error");
                   if(!error){
                       // User berhasil disimpen di database server
                       //  kalo udah berhasil disimpen di MySql sekarang disimpen di device make Sqlite
                       String uid = jObj.getString("uid");

                       JSONObject user = jObj.getJSONObject("user");
                       String username = user.getString("username");
                       String email = user.getString("email");
                       String password = user.getString("password");
                       String repass = user.getString("rePass");
                       String no_hp = user.getString("No Hp");

                       String created_at = user.getString("created at");

                       // masukin data user kedalam tabel
                       db.addUser(username,email,password,repass,no_hp,uid,created_at);
                       Toast.makeText(getApplicationContext(), "User berhasil registrasi");

                       // launch login activity
                       Intent intent = new Intent(
                               RegisterActivity.this, LoginActivity.class);
                       startActivity(intent);
                       finish();
                   }
                   else {
                       // jika eror setelah registrasi
                       String errorMsg = jObj.getString("Registrasi Gagal");
                       Toast.makeText(getApplicationContext(),
                               errorMsg, Toast.LENGTH_LONG).show();
                   }
               } catch (JSONException e) {
                   e.printStackTrace();
               }
           }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, "Registrasi Error: " + error.getMessage());
                Toast.makeText(getApplicationContext(),
                        error.getMessage(), Toast.LENGTH_LONG).show();
                hideDialog();
            }
        }) {

            @Override
            protected Map<String, String> getParams() {
                // Posting params to register url
                Map<String, String> params = new HashMap<String, String>();
                params.put("username", username);
                params.put("email", email);
                params.put("password", password);
                params.put("repass", repass);
                params.put("no_hp", no_hp);

                return params;
            }
        };

        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(strReq, tag_string_req);
    }

    private void showDialog() {
        if (!pDialog.isShowing())
            pDialog.show();
    }

    private void hideDialog() {
        if (pDialog.isShowing())
            pDialog.dismiss();
    }

}
*/
