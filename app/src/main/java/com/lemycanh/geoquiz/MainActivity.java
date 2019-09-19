package com.lemycanh.geoquiz;

import android.os.Bundle;
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
        Toast.makeText(getApplicationContext(), R.string.traloidung, Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.traloisai)
    void onTraLoiSaiClick(View v) {
        Toast.makeText(getApplicationContext(), R.string.traloisai, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        loadQuestion();
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
