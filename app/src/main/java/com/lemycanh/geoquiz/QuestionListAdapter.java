package com.lemycanh.geoquiz;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lemycanh on 30/10/2019.
 */

public class QuestionListAdapter extends BaseAdapter {

    List<Question> mQuestions;

    public QuestionListAdapter(List<Question> questions) {
        this.mQuestions = questions;
    }

    @Override
    public int getCount() {
        return mQuestions.size();
    }

    @Override
    public Object getItem(int position) {
        return mQuestions.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            convertView = layoutInflater.inflate(R.layout.questionlist_item, parent, false);
            ButterKnife.bind(viewHolder, convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Question currentQuestion = mQuestions.get(position);
        viewHolder.TvQuestionContent.setText(currentQuestion.getContent());
        viewHolder.TvQuestionAnswer.setText( currentQuestion.getAnswer() == 1 ? "TRUE" : "FALSE");
        return convertView;
    }

    public class ViewHolder {
        @BindView(R.id.tv_question_content)
        public TextView TvQuestionContent;
        @BindView(R.id.tv_question_answer)
        public TextView TvQuestionAnswer;
    }
}
