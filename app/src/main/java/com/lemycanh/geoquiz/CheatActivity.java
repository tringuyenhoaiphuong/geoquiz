package com.lemycanh.geoquiz;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CheatActivity extends AppCompatActivity {

    private static final String CHEAT_INTENT_QUESTION_CONTENT = "CHEAT_INTENT_QUESTION_CONTENT";
    @BindView(R.id.question_content)
    TextView mTvQuestionContent;

    @OnClick(R.id.btn_showanswer)
    void onBtnShowAnswerClick(View v) {
        setResult(RESULT_OK);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);
        ButterKnife.bind(this);

        String questionContent = getIntent().getStringExtra(CHEAT_INTENT_QUESTION_CONTENT);
        mTvQuestionContent.setText(questionContent);
    }

    public static Intent getIntent(Context context, String questionContent) {
        Intent startCheatIntent = new Intent(context, CheatActivity.class);
        startCheatIntent.putExtra(CHEAT_INTENT_QUESTION_CONTENT, questionContent);
        return startCheatIntent;
    }
}
