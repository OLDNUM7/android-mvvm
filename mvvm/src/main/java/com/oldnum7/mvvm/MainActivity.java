package com.oldnum7.mvvm;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.oldnum7.mvvm.databinding.ActivityMainBinding;

/**
 * 1. 消除下空指针
 */
public class MainActivity extends AppCompatActivity {
    //4. 调用Activity中的变量
    public  String mName = "MM";
    private User user;
    private ActivityMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
//        If you are using data binding items inside a ListView or RecyclerView adapter, you may prefer to use:
//        ListItemBinding binding = ListItemBinding.inflate(layoutInflater, viewGroup, false);
//        ListItemBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.list_item, viewGroup, false);
        //1. 设置文本
        User user = new User("Test", "User");
        mBinding.setUser(user);
        //2. 显示图片...
        mBinding.setImageUrl("url");
        //3. 点击事件1...
        mBinding.setMainActivity(this);
        //3. 点击事件2...
        mBinding.setHandle(new MyHandler());
        //5. 数据改变时更新UI
        delay();
    }

    //参数View必须有，必须是public，参数View不能改成对应的控件，只能是View，否则编译不通过
    public void onClick(View view) {
        Toast.makeText(this, "点击事件", Toast.LENGTH_LONG).show();
    }

    /**
     * 两秒后改变firstName
     */
    private void delay() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                user.setFirstName("Com");
                mBinding.setUser(user);
            }
        }, 2000);
    }



}
