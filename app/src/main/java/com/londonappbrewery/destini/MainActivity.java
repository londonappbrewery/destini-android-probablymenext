package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    Button mButtonTop;
    Button mButtonBottom;
    TextView mStoryText;
    int mIndex;
    int mStory;
    int mButtonTopIndex;
    int mButtonBottomIndex;
    int mButtonTopNum;
    int mButtonBottomNum;


    private StoryText[] mStoryBank = new StoryText[]  {

            new StoryText(R.string.T1_Story),
            new StoryText(R.string.T2_Story),
            new StoryText(R.string.T3_Story),
            new StoryText(R.string.T4_End),
            new StoryText(R.string.T5_End),
            new StoryText(R.string.T6_End)

    };

    private ButtonTop[] mButtonTopBank = new ButtonTop[]{

            new ButtonTop(R.string.T1_Ans1),
            new ButtonTop(R.string.T2_Ans1),
            new ButtonTop(R.string.T3_Ans1),
            new ButtonTop(3)

    };

    private ButtonBottom[] mButtonBottomBank = new ButtonBottom[]{

            new ButtonBottom(R.string.T1_Ans2),
            new ButtonBottom(R.string.T2_Ans2),
            new ButtonBottom(R.string.T3_Ans2),
            new ButtonBottom(3)

    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null){

            mIndex = savedInstanceState.getInt("IndexKey");
            mButtonTopIndex = savedInstanceState.getInt("ButtonTop");
            mButtonBottomIndex = savedInstanceState.getInt("ButtonBottom");


        } else {

            mIndex = 0;

        }

        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        mButtonTop = (Button) findViewById(R.id.buttonTop);
        mButtonBottom = (Button) findViewById(R.id.buttonBottom);
        mStoryText = (TextView) findViewById(R.id.storyTextView);


        updateStory();


        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        mButtonTop.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

               if(mIndex == 0){

                   //mButtonTop.setText(R.string.T3_Ans1);
                   mButtonTopIndex = 2;
                   //mButtonBottom.setText(R.string.T3_Ans2);
                   mButtonBottomIndex = 2;
                   mIndex = 2;
                   updateStory();

               }
                else if (mIndex == 1){

                   //mButtonTop.setText(R.string.T3_Ans1);
                   mButtonTopIndex = 2;
                   //mButtonBottom.setText(R.string.T3_Ans2);
                   mButtonBottomIndex = 2;
                   mIndex = 2;
                   updateStory();

               }else if(mIndex == 2){

                   //mButtonTop.setAlpha(0.0f);
                   mButtonTopIndex = 3;
                  // mButtonBottom.setAlpha(0.0f);
                   mButtonBottomIndex = 3;
                   mIndex = 5;
                   updateStory();
                }

            }


        });



        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        mButtonBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(mIndex == 0){

                    //mButtonTop.setText(R.string.T2_Ans1);
                    mButtonTopIndex = 1;
                    //mButtonBottom.setText(R.string.T2_Ans2);
                    mButtonBottomIndex = 1;
                    mIndex = 1;
                    updateStory();

                }
                else if (mIndex == 1){

                    //mButtonTop.setAlpha(0.0f);
                    mButtonTopIndex = 3;
                    //mButtonBottom.setAlpha(0.0f);
                    mButtonTopIndex = 3;
                    mIndex = 3;
                    updateStory();

                }else if(mIndex == 2){
                   // mButtonTop.setAlpha(0.0f);
                    mButtonTopIndex = 3;
                   // mButtonBottom.setAlpha(0.0f);
                    mButtonTopIndex = 3;
                    mIndex = 4;
                    updateStory();
                }

            }
        });

    }
        private void updateStory(){

            mStory = mStoryBank[mIndex].getStoryID();
            mStoryText.setText(mStory);

           if (mButtonTopIndex == 3 || mButtonBottomIndex == 3){

               mButtonTop.setAlpha(0.0f);
               mButtonBottom.setAlpha(0.0f);
           }else{

               mButtonTopNum = mButtonTopBank[mButtonTopIndex].getButtonTopID();
               mButtonTop.setText(mButtonTopNum);
               mButtonBottomNum = mButtonBottomBank[mButtonBottomIndex].getButtonBottomID();
               mButtonBottom.setText(mButtonBottomNum);

           }


        }


    @Override
    public void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);

        outState.putInt("IndexKey", mIndex);
        outState.putInt("ButtonTop", mButtonTopIndex);
        outState.putInt("ButtonBottom", mButtonBottomIndex);
    }

}


