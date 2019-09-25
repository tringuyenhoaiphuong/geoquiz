package com.lemycanh.geoquiz;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    final String TAG = "GeoQuiz";

    ArrayList<Question> mQuestionList;
    int mCurrentQuestionIndex;

    @BindView(R.id.tv_question)
    TextView mTvQuestion;

    @BindView(R.id.traloidung)
    Button mBtnTraLoiDung;

    @BindView(R.id.traloisai)
    Button mBtnTraLoiSai;

    @OnClick(R.id.traloidung)
    void onTraLoiDungClick(View v) {
        answer(true);
    }

    @OnClick(R.id.traloisai)
    void onTraLoiSaiClick(View v) {
        answer(false);
    }

    private void answer(boolean b) {
        Question currentQuestion = mQuestionList.get(mCurrentQuestionIndex);
        if(currentQuestion.IsTrue() == b) {
            Toast.makeText(getApplicationContext(), R.string.traloidung, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), R.string.traloisai, Toast.LENGTH_SHORT).show();
        }
    }

    @OnClick(R.id.btn_previous)
    void OnBtnPreviousClick(View v){
        if(mCurrentQuestionIndex == 0) return;
        mCurrentQuestionIndex--;
        showQuestion();
    }

    @OnClick(R.id.btn_next)
    void OnBtnNextClick(View v){
        if(mCurrentQuestionIndex == mQuestionList.size() - 1) return;
        mCurrentQuestionIndex++;
        showQuestion();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate called");
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        loadQuestion();
        showQuestion();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume called");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(TAG, "onSaveInstanceState called");
        outState.putInt("QuestionIndex", mCurrentQuestionIndex);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d(TAG, "onRestoreInstanceState called");
        mCurrentQuestionIndex = savedInstanceState.getInt("QuestionIndex");
        showQuestion();
    }

    private void showQuestion() {
        Question currentQuestion = mQuestionList.get(mCurrentQuestionIndex);
        mTvQuestion.setText(currentQuestion.getContent());
    }

    private void loadQuestion() {
        mQuestionList = new ArrayList<>();
        mQuestionList.add(new Question(getString(R.string.questionA), true));
        mQuestionList.add(new Question(getString(R.string.questionB), false));
        mQuestionList.add(new Question(getString(R.string.questionC), true));
        mCurrentQuestionIndex = 0;
    }
}
