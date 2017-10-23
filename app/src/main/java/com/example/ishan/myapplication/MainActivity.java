package com.example.ishan.myapplication;

/*
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
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

*/
public class MainActivity //extends AppCompatActivity {

{
   /*
    Button buttonadd , buttondiv , buttonsub , buttonmul;

    float mValueOne ,mValueTwo ;

    boolean mAddition , mSubtract ,mMultiplication ,mDivision;
    private ListView mMessageListView;
    private MessageAdapter mMessageAdapter;
    private EditText num1;
    private EditText num2;
    private TextView answert;
    private Button mSendButton;
    private String mUsername;
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mMessagesDatabaseReference;
    private ChildEventListener mChildEventListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttondiv =  findViewById(R.id.butdiv);
        buttonadd =  findViewById(R.id.butadd);
        buttonsub =  findViewById(R.id.butsub);
        buttonmul =  findViewById(R.id.butmul);
        mSendButton= findViewById(R.id.sendButton);

        Toast.makeText(this, "Welcome to Calconn", Toast.LENGTH_LONG).show();
        mUsername="Name";

        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mMessagesDatabaseReference = mFirebaseDatabase.getReference().child("messages");
        mMessageListView =  findViewById(R.id.messageListView);


        List<Message> Messages = new ArrayList<>();
        mMessageAdapter = new MessageAdapter(this, R.layout.item,Messages);
        mMessageListView.setAdapter(mMessageAdapter);


        num1= findViewById(R.id.number2);
        num2 = findViewById(R.id.number1);
        answert=findViewById(R.id.answertext);

        mSendButton = findViewById(R.id.sendButton);


        buttonadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mValueOne = Float.parseFloat(num1.getText().toString());
                mValueTwo=Float.parseFloat(num2.getText().toString());

                mAddition = true;
            }
        });

        buttonsub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mValueOne = Float.parseFloat(num1.getText().toString());
                mValueTwo=Float.parseFloat(num2.getText().toString());
                mSubtract = true ;

            }
        });

        buttonmul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mValueOne = Float.parseFloat(num1.getText().toString());
                mValueTwo=Float.parseFloat(num2.getText().toString());
                mMultiplication = true ;

            }
        });

        buttondiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mValueOne = Float.parseFloat(num1.getText().toString());
                mValueTwo=Float.parseFloat(num2.getText().toString());
                mDivision = true ;
            }
        });

        mSendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mAddition){
                    answert.setText((int) (mValueOne + mValueTwo));
                    mAddition=false;

                    num1.setText("");
                }
                if (mSubtract){
                    answert.setText((int) (mValueOne - mValueTwo));
                    mSubtract=false;
                    num1.setText("");
                }

                if (mMultiplication){
                    answert.setText((int) (mValueOne * mValueTwo));
                    mMultiplication=false;
                    num1.setText("");
                }
                if (mDivision){
                    answert.setText((int) (mValueOne / mValueTwo));
                    mDivision=false;
                    num1.setText("");
                }

                Message message = new  Message(answert.getText().toString(),"Name");
                mMessagesDatabaseReference.push().setValue(message);
                answert.setText("");

            }
        });

        // Send button sends a message and clears the EditText
        mSendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Message message = new Message(answert.getText().toString(), mUsername);
                mMessagesDatabaseReference.push().setValue(message);

                answert.setText("");
            }
        });
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
    */
}
