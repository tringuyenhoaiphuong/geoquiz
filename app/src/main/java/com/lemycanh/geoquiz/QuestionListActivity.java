package com.lemycanh.geoquiz;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import org.greenrobot.greendao.database.Database;

import java.util.List;

public class QuestionListActivity extends AppCompatActivity {

    @BindView(R.id.lv_questionlist)
    ListView mLvQuestionList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_list);
        ButterKnife.bind(this);

        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this,"users-db"); //The users-db here is the name of our database.
        Database db = helper.getWritableDb();
        DaoSession daoSession = new DaoMaster(db).newSession();
        QuestionDao questionDao = daoSession.getQuestionDao();
        List<Question> questions = questionDao.loadAll();

        QuestionListAdapter adapter = new QuestionListAdapter(questions);
        mLvQuestionList.setAdapter(adapter);
    }

    public static Intent createIntent(Context context) {
        Intent startIntent = new Intent(context, QuestionListActivity.class);
        return startIntent;
    }
}
