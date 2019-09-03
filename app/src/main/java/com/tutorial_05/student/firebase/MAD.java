package com.tutorial_05.student.firebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MAD extends AppCompatActivity {

    EditText id,name,address,num;
    Button save,update,delete,show;

    Student std;

    DatabaseReference dbRef;

    private void clearControls(){

        id.setText("");
        name.setText("");
        address.setText("");
        num.setText("");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mad);

        id=findViewById(R.id.id);
        name=findViewById(R.id.name);
        address=findViewById(R.id.address);
        num=findViewById(R.id.num);

        save=findViewById(R.id.save);
        update=findViewById(R.id.update);
        delete=findViewById(R.id.delete);
        show=findViewById(R.id.show);

        std =new Student();

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbRef=FirebaseDatabase.getInstance().getReference().child("Student");

                try {
                    if(TextUtils.isEmpty(id.getText().toString()))
                        Toast.makeText(getApplicationContext(),"Ener Id",Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(name.getText().toString()))
                        Toast.makeText(getApplicationContext(),"Please enter a Name",Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(address.getText().toString()))
                        Toast.makeText(getApplicationContext(),"Please enter an Address",Toast.LENGTH_SHORT).show();
                    else {
                        std.setID(id.getText().toString().trim());
                        std.setName(name.getText().toString().trim());
                        std.setAddress(address.getText().toString().trim());
                        std.setConNum(Integer.parseInt(num.getText().toString().trim()));

                        dbRef.push().setValue(std);

                        Toast.makeText(getApplicationContext(),"Data Saved Successfully",Toast.LENGTH_SHORT).show();
                        clearControls();
                    }
                }
                catch (NumberFormatException e){
                    Toast.makeText(getApplicationContext(),"Invalid Contact Number",Toast.LENGTH_SHORT).show();
                }
            }
        });








    }




}
