package com.londonappbrewery.destini;

/**
 * Created by Gareth on 30/05/2017.
 */

public class StoryText {

    private int mStoryID;

    public StoryText(int storyResourceID){

        mStoryID = storyResourceID;

    }

    public int getStoryID() {
        return mStoryID;
    }

    public void setStoryID(int storyID) {
        mStoryID = storyID;
    }
}
