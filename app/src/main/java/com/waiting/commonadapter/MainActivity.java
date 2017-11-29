package com.waiting.commonadapter;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.waiting.commonadapter.databinding.ActivityMainBinding;
import com.waiting.commonadapter.databinding.Item1Binding;
import com.waiting.commonadapter.databinding.Item2Binding;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mMainBinding;
    private List<Message> mMessageList = Arrays.asList(new Message("消息一"), new Message("消息二"), new Message("消息三"), new Message("消息四"));
    private List<User> mUserList = Arrays.asList(new User("张三"), new User("李四"), new User("王五"), new User("赵得柱"));
    private boolean isMessageModel = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mMainBinding.recyclerView.setAdapter(new CommonAdapter<Message, Item1Binding>(R.layout.item1, mMessageList));

        mMainBinding.changeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (isMessageModel) {
                    mMainBinding.recyclerView.setAdapter(new CommonAdapter<User, Item2Binding>(R.layout.item2, mUserList));
                } else {
                    mMainBinding.recyclerView.setAdapter(new CommonAdapter<Message, Item1Binding>(R.layout.item1, mMessageList));
                }
                isMessageModel = !isMessageModel;

                mMainBinding.recyclerView.getAdapter().notifyDataSetChanged();
            }
        });

    }
}
