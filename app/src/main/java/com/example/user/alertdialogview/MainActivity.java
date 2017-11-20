package com.example.user.alertdialogview;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btn1,btn2,btn3;
    TextView name,account,pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1=(Button)findViewById(R.id.btn1);
        btn2=(Button)findViewById(R.id.btn2);
        btn3=(Button)findViewById(R.id.btn3);
        name=(TextView)findViewById(R.id.name);
        account=(TextView)findViewById(R.id.account);
        pass=(TextView)findViewById(R.id.password);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name.setText("Zabir");
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                account.setText("KUET1507110");
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Builder Design Concept
                AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("Are you sure ?")
                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Ok click korle je kaj hobe ta akhane bole dibo
                        pass.setText("6396000");
                    }
                })
                        .setNegativeButton("Cancel",null).setCancelable(false);//set cancelable ai jonno deya hoice jate screen onno jaigai click korle kono change na hoi
                AlertDialog alertDialog=builder.create();
                alertDialog.show();

            }
        });
    }
    @Override
    public void onBackPressed(){

        AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Really Exit?")
         // .setMessage("Are you sure ?")//Massage dileo diya jai na dileo problem nai
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        MainActivity.super.onBackPressed();
                    }
                })
                .setNegativeButton("Cancel",null).setCancelable(false);
        AlertDialog alertDialog=builder.create();
        alertDialog.show();
    }
}
