package com.antixuni.learnbsl;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.firebase.ui.storage.images.FirebaseImageLoader;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import static com.antixuni.learnbsl.R.id.imageView;

public class TranslatorActivity extends AppCompatActivity implements View.OnClickListener{

    FirebaseStorage storageReference = FirebaseStorage.getInstance();

    private EditText mUserText;
    private Button mTranslate;
    private ImageView mImageView;

    Context mContext = this;

    StorageReference storageRef = storageReference.getReferenceFromUrl("gs://learnbsl-32df7.appspot.com/");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translator);

        //Get UI elements
        mUserText = (EditText)findViewById(R.id.UserText);
        mTranslate = (Button)findViewById(R.id.Translate);
        mImageView = (ImageView)findViewById(imageView);
        mTranslate.setOnClickListener(this);

        StorageReference pathReference = storageRef.child("blankImage.jpeg");
        Glide.with(mContext)
                .using(new FirebaseImageLoader())
                .load(pathReference)
                .into(mImageView);
    }

    @Override
    protected void onStart() {
        super.onStart();

    }


    public void onClick(View view){
        String content = mUserText.getText().toString();

        //if(content.length()<=1) {
        //    content.toLowerCase();
        //}
        //else{
        //    content=content.substring(0,1).toLowerCase()+content.substring(1);
        //}

        StorageReference pathReference = storageRef.child(content +".png");
        Glide.with(mContext)
                .using(new FirebaseImageLoader())
                .load(pathReference)
                .into(mImageView);
    }
}
