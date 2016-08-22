package com.bwf.tuanche.Activity;

import android.support.v4.content.PermissionChecker;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.bwf.tuanche.R;
import com.bwf.tuanche.View.ReScrollView;
import com.bwf.tuanche.View.VersionUpdateDialog;

public class TestActivity extends AppCompatActivity {
    private ReScrollView mScrollView;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        mScrollView = (ReScrollView) findViewById(R.id.test_myScroll);
        mScrollView.setContentResource(R.layout.content_test);
        textView  = (TextView) findViewById(R.id.test_myScroll_tv);
        textView.setText("成功");
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               new VersionUpdateDialog(TestActivity.this);
            }
        });
    }
}
