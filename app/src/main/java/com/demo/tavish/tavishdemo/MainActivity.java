package com.demo.tavish.tavishdemo;

import android.animation.LayoutTransition;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.UserHandle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.demo.tavish.Model.UserModel;
import com.google.android.gms.common.oob.SignUp;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    RelativeLayout rr2;
    EditText editText_username, editText_password,editText_phn_no;
    Button btn_login;

    Handler handler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            rr2.setVisibility(View.VISIBLE);

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rr2 = (RelativeLayout) findViewById(R.id.rl_2);
        btn_login=(Button) findViewById(R.id.btn_login);
        btn_login.setOnClickListener(this);

        editText_username = (EditText) findViewById(R.id.et_username);
        editText_password = (EditText) findViewById(R.id.et_password);
        editText_phn_no = (EditText) findViewById(R.id.et_phn_no);


        handler.postDelayed(runnable,2000);



    }

    @Override
    public void onClick(View v) {
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference table_user = database.getReference("User");
       switch (v.getId()){

           case R.id.btn_login:
               final ProgressDialog mDialog = new ProgressDialog(MainActivity.this);
               mDialog.setMessage("Please Wait for a moment...");
               table_user.addValueEventListener(new ValueEventListener() {
                   @Override
                   public void onDataChange(DataSnapshot dataSnapshot) {
                       if(dataSnapshot.child(editText_phn_no.getText().toString()).exists()) {
                           mDialog.dismiss();
                           UserModel user = dataSnapshot.child(editText_phn_no.getText().toString()).getValue(UserModel.class);
                           if (user.getPassword().equals(editText_password.getText().toString())) {
                               Toast.makeText(MainActivity.this, "Sign-In Successfully!", Toast.LENGTH_SHORT).show();
                               Intent i = new Intent(MainActivity.this,slide.class);
                               startActivity(i);
                           } else {
                               mDialog.dismiss();
                               Toast.makeText(MainActivity.this, "Wrong Password", Toast.LENGTH_SHORT).show();
                           }
                       }else{

                           Toast.makeText(MainActivity.this, "User Not Exists in Database!", Toast.LENGTH_SHORT).show();
                       }
                   }

                   @Override
                   public void onCancelled(@NonNull DatabaseError databaseError) {

                   }



               });
               break;

               default:
                   break;

       }
    }
}
