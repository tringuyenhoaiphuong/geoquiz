package com.lemycanh.geoquiz;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.greenrobot.greendao.database.Database;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    private static final int CHEAT_INTENT_CODE = 1;
    final String TAG = "GeoQuiz";

    List<Question> mQuestionList;
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

    private DaoSession daoSession;

    @OnClick(R.id.btn_cheat)
    void onBtnCheatClick(View v) {
        Question currentQuestion = mQuestionList.get(mCurrentQuestionIndex);
        Intent startCheatIntent = CheatActivity.getIntent(this, currentQuestion.getContent());
        startActivityForResult(startCheatIntent, CHEAT_INTENT_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == CHEAT_INTENT_CODE) {
            if(resultCode == RESULT_OK) {
                Question currentQuestion = mQuestionList.get(mCurrentQuestionIndex);
                Toast.makeText(getApplicationContext(), getString(R.string.answer_is) + (currentQuestion.getAnswer() == 1), Toast.LENGTH_SHORT).show();
            }
        }

    }

    private void answer(boolean b) {
        Question currentQuestion = mQuestionList.get(mCurrentQuestionIndex);
        if(currentQuestion.getAnswer() == (b ? 1 : 0)) {
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

        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this,"users-db"); //The users-db here is the name of our database.
        Database db = helper.getWritableDb();
        daoSession = new DaoMaster(db).newSession();

        loadQuestion();
        showQuestion();
    }

    public DaoSession getDaoSession() {
        return daoSession;
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
        if(mQuestionList.size() == 0) return;
        Question currentQuestion = mQuestionList.get(mCurrentQuestionIndex);
        mTvQuestion.setText(currentQuestion.getContent());
    }

    private void loadQuestion() {

        QuestionDao questionDao = getDaoSession().getQuestionDao();
        mQuestionList = questionDao.loadAll();
        mCurrentQuestionIndex = 0;
    }

    @OnClick(R.id.btn_questionlist)
    void OnBtnQuestionListClick(View v) {
        Intent startQuestionListIntent = QuestionListActivity.createIntent(this);
        startActivity(startQuestionListIntent);
    }
}
