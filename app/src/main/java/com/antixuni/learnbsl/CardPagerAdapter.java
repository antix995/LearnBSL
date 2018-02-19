package com.antixuni.learnbsl;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CardPagerAdapter extends PagerAdapter implements CardAdapter {
    private Button btn_click;
    private List<CardView> mViews;
    private List<CardItem> mData;
    private float mBaseElevation;
    private Context mContext;

    //instantiate arrays to be passed to views
    public CardPagerAdapter(MainActivity mainActivity) {
        mData = new ArrayList<>();
        mViews = new ArrayList<>();
        mContext = mainActivity;
    }
    //adds blank views and then inputs the data into them using adapters
    public void addCardItem(CardItem item) {
        mViews.add(null);
        mData.add(item);
    }

    public float getBaseElevation() {
        return mBaseElevation;
    }

    @Override
    public CardView getCardViewAt(int position) {
        return mViews.get(position);
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        View view = LayoutInflater.from(container.getContext())
                .inflate(R.layout.adapter, container, false);
        container.addView(view);
        bind(mData.get(position), view);
        final CardView cardView = (CardView) view.findViewById(R.id.cardView);

        if (mBaseElevation == 0) {
            mBaseElevation = cardView.getCardElevation();
        }

                cardView.setMaxCardElevation(mBaseElevation * MAX_ELEVATION_FACTOR);
        mViews.set(position, cardView);
        btn_click.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                     openQuizActivity();
                }
            });

        return view;
    }

    public void openQuizActivity(){
        Intent intent = new Intent(btn_click.getContext(), QuizActivity.class);
        mContext.startActivity(intent);
    }

    public void openQuizActivity2(){
        Intent intent = new Intent(btn_click.getContext(), QuizActivity2.class);
        mContext.startActivity(intent);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
        mViews.set(position, null);
    }

    private void bind(CardItem item, View view) {
        TextView titleTextView = (TextView) view.findViewById(R.id.titleTextView);
        TextView contentTextView = (TextView) view.findViewById(R.id.contentTextView);
        btn_click = (Button) view.findViewById(R.id.btn_click);

        titleTextView.setText(item.getTitle());
        contentTextView.setText(item.getText());
    }
}
