package com.antixuni.learnbsl;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class CardFragment extends Fragment {

    private CardView mCardView;
    private Button mbuttonQuiz;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_adapter, container, false);
        mCardView = (CardView) view.findViewById(R.id.cardView);
        mCardView.setMaxCardElevation(mCardView.getCardElevation()
                * CardAdapter.MAX_ELEVATION_FACTOR);

        TextView title = (TextView) view.findViewById(R.id.title);
        title.setText(String.format("Card %d", getArguments().getInt("position")));
        mbuttonQuiz = (Button) view.findViewById(R.id.buttonQuiz);

        mbuttonQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view2){
                openQuizActivity();
                Toast.makeText(getActivity(), "Button in Card " + getArguments().getInt("position")
                        + "Clicked!", Toast.LENGTH_SHORT).show();
            }
        });

        return view;

    }
    public void openQuizActivity(){
    Intent intent = new Intent(mbuttonQuiz.getContext(), QuizActivity.class);
    startActivity(intent);
    }
    public CardView getCardView() {
        return mCardView;
    }
}
