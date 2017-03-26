package com.example.hp_pc.tinderswipe;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by hp-pc on 3/25/2017.
 */

public class SwipeView extends Activity
{
    ImageView imageView;
    TextView name, category;
    FloatingActionButton reject, accept;
    static int cardIndex, defaultValue;
    String names[], categorys[];
    private static TypedArray img;
    private FrameLayout container;
    private LinearLayout linearLayout;

    TextView acceptTv, rejectTv;

    private int MAX_ARRAY = 5;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.swipe_view);

        /*if(savedInstanceState == null)
        {
            getFragmentManager().beginTransaction().add(R.id.container, new CardFrontFragment()).commit();
        }*/

        cardIndex = 0;
        defaultValue = 0;

        /*acceptTv = (TextView) findViewById(R.id.choose_tv);
        rejectTv = (TextView) findViewById(R.id.reject_tv);

        acceptTv.setVisibility(View.INVISIBLE);
        rejectTv.setVisibility(View.INVISIBLE);*/

        imageView = (ImageView) findViewById(R.id.profile_pic);
        reject = (FloatingActionButton) findViewById(R.id.floatingActionButton1);
        accept = (FloatingActionButton) findViewById(R.id.floatingActionButton2);
        name = (TextView) findViewById(R.id.name);
        category = (TextView) findViewById(R.id.category);

        //imageView.

        reject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if(cardIndex < MAX_ARRAY) cardIndex++;
                //rejectTv.setVisibility(View.VISIBLE);
                img = getResources().obtainTypedArray(R.array.images);
                imageView.setBackgroundResource(img.getResourceId(cardIndex, defaultValue));
                name.setText(names[cardIndex]);
                category.setText(categorys[cardIndex]);
                //rejectTv.setVisibility(View.INVISIBLE);
            }
        });

        accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if(cardIndex < MAX_ARRAY) cardIndex++;
                //acceptTv.setVisibility(View.VISIBLE);
                img = getResources().obtainTypedArray(R.array.images);
                imageView.setBackgroundResource(img.getResourceId(cardIndex, defaultValue));
                name.setText(names[cardIndex]);
                category.setText(categorys[cardIndex]);
                //acceptTv.setVisibility(View.INVISIBLE);
            }
        });



        names = getResources().getStringArray(R.array.names_list);
        categorys = getResources().getStringArray(R.array.category);
        img = getResources().obtainTypedArray(R.array.images);
        imageView.setBackgroundResource(img.getResourceId(cardIndex, defaultValue));
        name.setText(names[0]);
        category.setText(categorys[0]);
    }

    public static class CardFrontFragment extends Fragment
    {
        //--------------Front of Card----------------//
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState)
        {
            //----------------CREATE FRAGMENT FRONT VIEW------------------//
            View mainView = inflater.inflate(R.layout.front_card_view, container, false);
            ImageView imageView = (ImageView) mainView.findViewById(R.id.profile_pic);
            img = getResources().obtainTypedArray(R.array.images);
            imageView.setBackgroundResource(img.getResourceId(cardIndex, defaultValue));
            //imageView.setBackgroundResource(img.getResourceId(cardIndex, defaultValue));

            return mainView;
        }

        @Override
        public void onDestroyView() {
            super.onDestroyView();
        }

        //--------------Front of Card----------------//
    }

    public static class CardBackFragment extends Fragment
    {
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState)
        {
            //----------------CREATE FRAGMENT BACK VIEW------------------//
            View mainView = inflater.inflate(R.layout.back_card_view, container, false);
            //ImageView imageView = (ImageView) mainView.findViewById(R.id.profile_pic);
            return mainView;
        }
    }

    /*public static class CardFrontFragment extends Fragment
    {
        Button flip_button;
        ImageView mainPic;

        //--------------Front of Card----------------//
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState)
        {
            //----------------CREATE FRAGMENT FRONT VIEW------------------//
            View mainView = inflater.inflate(R.layout.front_card_view, container, false);

            mainPic = (ImageView) mainView.findViewById(R.id.image2);
            flip_button = (Button) mainView.findViewById(R.id.flip_button);

            flip_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getFragmentManager()
                            .beginTransaction()

                            // Replace the default fragment animations with animator resources
                            // representing rotations when switching to the back of the card, as
                            // well as animator resources representing rotations when flipping
                            // back to the front (e.g. when the system Back button is pressed).
                            .setCustomAnimations(
                                    R.animator.card_flip_right_in,
                                    R.animator.card_flip_right_out,
                                    R.animator.card_flip_left_in,
                                    R.animator.card_flip_left_out)

                            // Replace any fragments currently in the container view with a
                            // fragment representing the next page (indicated by the
                            // just-incremented currentPage variable).
                            .replace(R.id.container, new CardBackFragment())

                            // Add this transaction to the back stack, allowing users to press
                            // Back to get to the front of the card.
                            .addToBackStack(null)

                            // Commit the transaction.
                            .commit();
                }
            });

            return mainView;
        }

        //--------------Front of Card----------------//

    }

    //--------------BACK OF CARD----------------//

    public static class CardBackFragment extends Fragment
    {
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState)
        {
            //----------------CREATE FRAGMENT BACK VIEW------------------//
            return inflater.inflate(R.layout.fragment_card_back, container, false);
        }
    }*/



}
