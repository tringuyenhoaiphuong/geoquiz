package com.lemycanh.geoquiz;

/**
 * Created by lemycanh on 19/9/2019.
 */

public class Question {
    String mContent;
    boolean mIsTrue;

    public Question(String mContent, boolean mIsTrue) {
        this.mContent = mContent;
        this.mIsTrue = mIsTrue;
    }

    public String getContent() {
        return mContent;
    }

    public boolean IsTrue() {
        return mIsTrue;
    }
}
