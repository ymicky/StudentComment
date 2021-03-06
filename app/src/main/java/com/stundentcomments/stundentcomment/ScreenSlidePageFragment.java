package com.stundentcomments.stundentcomment;

/**
 * Created by yannick.mickler on 02.06.2017.
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ScreenSlidePageFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.stundent_comment_activity, container, false);

        fillList();

        tv = (TextView) rootView.findViewById(R.id.textview_student_comment);
        iv = (ImageView) rootView.findViewById(R.id.imageview_stundent_pic);

        setContent();
        return rootView;
    }

    ArrayList<Content> conList = new ArrayList<Content>();
    public static int index;
    private TextView tv;
    private ImageView iv;

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tv = (TextView) view.findViewById(R.id.textview_student_comment);
        iv = (ImageView) view.findViewById(R.id.imageview_stundent_pic);

        setContent();
    }

    public void fillList(){
        conList.add(new Content("TestText", R.drawable.pic_1));
        conList.add(new Content("xxx223", R.drawable.pic_2));
    }

    private void setContent(){
        iv.setImageResource(conList.get(index).iPic);

        tv.setText(conList.get(index).comment);
    }
}