package com.example.ishan.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anonymous on 23/10/17.
 */

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener {

    private Button mAdd, mSub, mDiv, mMul, mSend;
    private EditText mNum1, mNum2;
    private TextView mResultText;

    float Num1, Num2, Result;

    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mMessagesDatabaseReference;
    private ChildEventListener mChildEventListener;

    private ListView mMessageListView;
    private MessageAdapter mMessageAdapter;

    String mUsername;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDiv =  findViewById(R.id.butdiv);
        mAdd =  findViewById(R.id.butadd);
        mSub =  findViewById(R.id.butsub);
        mMul =  findViewById(R.id.butmul);
        mSend = findViewById(R.id.sendButton);
        mSend.setEnabled(false);

        mAdd.setOnClickListener(this);
        mSub.setOnClickListener(this);
        mMul.setOnClickListener(this);
        mDiv.setOnClickListener(this);
        mSend.setOnClickListener(this);

        mNum1= findViewById(R.id.number2);
        mNum2 = findViewById(R.id.number1);
        mResultText=findViewById(R.id.answertext);

        Toast.makeText(this, "Welcome to Calconn", Toast.LENGTH_LONG).show();
        mUsername="Name";

        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mMessagesDatabaseReference = mFirebaseDatabase.getReference().child("messages");
        mMessageListView =  findViewById(R.id.messageListView);


        List<Message> Messages = new ArrayList<>();
        mMessageAdapter = new MessageAdapter(this, R.layout.item,Messages);
        mMessageListView.setAdapter(mMessageAdapter);

        mChildEventListener = new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Message friendlyMessage = dataSnapshot.getValue(Message.class);
                mMessageAdapter.add(friendlyMessage);
            }

            public void onChildChanged(DataSnapshot dataSnapshot, String s) {}
            public void onChildRemoved(DataSnapshot dataSnapshot) {}
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {}
            public void onCancelled(DatabaseError databaseError) {}
        };
        mMessagesDatabaseReference.addChildEventListener(mChildEventListener);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.butadd:
                    if(!TextUtils.isEmpty(mNum1.getText()) && !TextUtils.isEmpty(mNum2.getText())){
                        Num1 = Float.parseFloat(mNum1.getText().toString());
                        Num2 = Float.parseFloat(mNum2.getText().toString());

                        Result = Num1 + Num2;

                        mResultText.setText(String.valueOf(Result));

                        if(!mSend.isEnabled()){
                            mSend.setEnabled(true);
                        }
                    }else {
                        Toast.makeText(getApplicationContext(), "Enter Valid Numbers", Toast.LENGTH_LONG).show();
                        if(mSend.isEnabled()){
                            mSend.setEnabled(false);
                        }
                    }
                break;

            case R.id.butmul:
                if(!TextUtils.isEmpty(mNum1.getText()) && !TextUtils.isEmpty(mNum2.getText())){
                    Num1 = Float.parseFloat(mNum1.getText().toString());
                    Num2 = Float.parseFloat(mNum2.getText().toString());

                    Result = Num1 * Num2;

                    mResultText.setText(String.valueOf(Result));
                    if(!mSend.isEnabled()){
                        mSend.setEnabled(true);
                    }
                }else {
                    Toast.makeText(getApplicationContext(), "Enter Valid Numbers", Toast.LENGTH_LONG).show();
                    if(mSend.isEnabled()){
                        mSend.setEnabled(false);
                    }
                }
                break;

            case R.id.butsub:
                if(!TextUtils.isEmpty(mNum1.getText()) && !TextUtils.isEmpty(mNum2.getText())){
                    Num1 = Float.parseFloat(mNum1.getText().toString());
                    Num2 = Float.parseFloat(mNum2.getText().toString());

                    Result = Num1 - Num2;

                    mResultText.setText(String.valueOf(Result));
                    if(!mSend.isEnabled()){
                        mSend.setEnabled(true);
                    }
                }else {
                    Toast.makeText(getApplicationContext(), "Enter Valid Numbers", Toast.LENGTH_LONG).show();
                    if(mSend.isEnabled()){
                        mSend.setEnabled(false);
                    }
                }
                break;

            case R.id.butdiv:
                if(!TextUtils.isEmpty(mNum1.getText()) && !TextUtils.isEmpty(mNum2.getText())){
                    Num1 = Float.parseFloat(mNum1.getText().toString());
                    Num2 = Float.parseFloat(mNum2.getText().toString());

                    Result = Num1 / Num2;

                    mResultText.setText(String.valueOf(Result));

                    if(!mSend.isEnabled()){
                        mSend.setEnabled(true);
                    }
                }else {
                    Toast.makeText(getApplicationContext(), "Enter Valid Numbers", Toast.LENGTH_LONG).show();
                    if(mSend.isEnabled()){
                        mSend.setEnabled(false);
                    }
                }
                break;

            case R.id.sendButton:
                sendMessage();
                break;

        }

    }

    private void sendMessage() {

        Message message = new  Message(String.valueOf(Result),"Name");
        mMessagesDatabaseReference.push().setValue(message);
        mResultText.setText("");
        mNum1.setText("");
        mNum2.setText("");

        if(mSend.isEnabled()){
            mSend.setEnabled(false);
        }
    }

}
