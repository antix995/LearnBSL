package com.antixuni.learnbsl;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.firebase.ui.storage.images.FirebaseImageLoader;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.lang.reflect.Array;

import static com.antixuni.learnbsl.R.id.imageView;

public class QuizActivity extends AppCompatActivity {

    FirebaseStorage storageReference = FirebaseStorage.getInstance();
    private QuestionLibrary mQuestionLibrary = new QuestionLibrary();

    private TextView mScoreView;
    private ImageView mquestionImage;
    private TextView mQuestionView;
    private Button mButtonChoice1;
    private Button mButtonChoice2;
    private Button mButtonChoice3;

    private String mAnswer;
    private int mScore = 0;
    private int mQuestionNumber = 0;

    private int imageNumber = 0;


    StorageReference storageRef = storageReference.getReferenceFromUrl("gs://learnbsl-32df7.appspot.com/Quiz Pictures");

    Context mContext = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        mScoreView = (TextView) findViewById(R.id.score);
        mQuestionView = (TextView) findViewById(R.id.question);
        mButtonChoice1 = (Button) findViewById(R.id.choice1);
        mButtonChoice2 = (Button) findViewById(R.id.choice2);
        mButtonChoice3 = (Button) findViewById(R.id.choice3);
        Button quit = (Button) findViewById(R.id.quit);
        mquestionImage = (ImageView) findViewById(R.id.questionImage);

        StorageReference pathReference = storageRef.child("image"+imageNumber+".png");
        Glide.with(mContext)
                .using(new FirebaseImageLoader())
                .load(pathReference)
                .into(mquestionImage);

        quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(QuizActivity.this, MainActivity.class));
            }
        });

        updateQuestion();

        //Start of Button Listener for Button1
        mButtonChoice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //My logic for Button goes in here

                if (mButtonChoice1.getText() == mAnswer) {
                    mScore = mScore + 1;
                    updateScore(mScore);
                    updateQuestion();
                    //This line of code is optional
                    Toast.makeText(QuizActivity.this, "correct", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(QuizActivity.this, "wrong", Toast.LENGTH_SHORT).show();
                    updateQuestion();
                }
            }
        });

        //End of Button Listener for Button1

        //Start of Button Listener for Button2
        mButtonChoice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //My logic for Button goes in here

                if (mButtonChoice2.getText() == mAnswer) {
                    mScore = mScore + 1;
                    updateScore(mScore);
                    updateQuestion();
                    //This line of code is optional
                    Toast.makeText(QuizActivity.this, "correct", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(QuizActivity.this, "wrong", Toast.LENGTH_SHORT).show();
                    updateQuestion();
                }
            }
        });

        //End of Button Listener for Button2


        //Start of Button Listener for Button3
        mButtonChoice3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //My logic for Button goes in here

                if (mButtonChoice3.getText() == mAnswer) {
                    mScore = mScore + 1;
                    updateScore(mScore);
                    updateQuestion();
                    //This line of code is optional
                    Toast.makeText(QuizActivity.this, "correct", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(QuizActivity.this, "wrong", Toast.LENGTH_SHORT).show();
                    updateQuestion();
                }
            }
        });

        //End of Button Listener for Button3

    }

    private void updateQuestion() {
        if (mQuestionNumber < mQuestionLibrary.getLength()) {
            mQuestionView.setText(mQuestionLibrary.getQuestion(mQuestionNumber));
            mButtonChoice1.setText(mQuestionLibrary.getChoice1(mQuestionNumber));
            mButtonChoice2.setText(mQuestionLibrary.getChoice2(mQuestionNumber));
            mButtonChoice3.setText(mQuestionLibrary.getChoice3(mQuestionNumber));

            mAnswer = mQuestionLibrary.getCorrectAnswer(mQuestionNumber);
            mQuestionNumber++;
            imageNumber++;
            updateImage();
        } else {
            Toast.makeText(QuizActivity.this, "Test is Over", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(QuizActivity.this, MainActivity.class);
            Bundle bundle = new Bundle();
            bundle.putInt("Final Score", mScore);
            i.putExtras(bundle);
            QuizActivity.this.finish();
            startActivity(i);
        }
    }


    private void updateScore(int point) {
        mScoreView.setText("" + mScore);
    }

    private void updateImage() {

        StorageReference pathReference = storageRef.child("image"+imageNumber+".png");
        Glide.with(mContext)
                .using(new FirebaseImageLoader())
                .load(pathReference)
                .into(mquestionImage);
    }
}

