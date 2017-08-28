package com.oldnum7.mvvm;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.Toast;

import com.oldnum7.mvvm.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * 1. 消除下空指针
 */
public class MainActivity extends AppCompatActivity {
    //4. 调用Activity中的变量
    public String mName = "MM";

    private ActivityMainBinding mBinding;
    private User2 mUser2;
    private User mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
//        If you are using data binding items inside a ListView or RecyclerView adapter, you may prefer to use:
//        ListItemBinding binding = ListItemBinding.inflate(layoutInflater, viewGroup, false);
//        ListItemBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.list_item, viewGroup, false);
        //1. 设置文本
        mUser = new User("Test", "User");
        mBinding.setUser(mUser);
        
        //2. 显示图片...
        mBinding.setImageUrl("url");
        //3. 点击事件1...
        mBinding.setMainActivity(this);
        //3. 点击事件2...
        mBinding.setHandle(new MyHandler());

        //5.1 数据改变时更新UI 1....
//        delay01();
        //5.2 BaseObservable
        delay02();
        //5.3 ObservableField
        //ObservableBoolean, ObservableByte, ObservableChar,
        //ObservableShort, ObservableInt, ObservableLong, ObservableFloat,
        //ObservableDouble, 以及 ObservableParcelable

        //ObservableArrayMap和ObservableArrayList。
        mUser2 = new User2();
        mBinding.setUser2(mUser2);
        mUser2.firstName.set("Mr");
        mUser2.lastName.set("Bean");
        mUser2.age.set(20);
        mUser2.isStudent.set(false);

        //6.列表数据
        setListData();

    }

    private void setListData() {
        List<User2> data = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            User2 user2 = new User2();
            user2.age.set(30);
            user2.firstName.set("Micheal " + i);
            user2.lastName.set("Jack " + i);
            data.add(user2);
        }
        LinearLayoutManager layoutManager = new LinearLayoutManager(
                this, LinearLayoutManager.VERTICAL, false);
//        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
//        recyclerView.setLayoutManager(layoutManager);
//        recyclerView.setAdapter(new MyAdapter(data));

        //可以不用findViewById
        mBinding.recyclerView.setLayoutManager(layoutManager);
        mBinding.recyclerView.setAdapter(new MyAdapter(data));
    }

    //参数View必须有，必须是public，参数View不能改成对应的控件，只能是View，否则编译不通过
    public void onClick(View view) {
        Toast.makeText(this, "点击事件", Toast.LENGTH_LONG).show();
    }

    /**
     * 两秒后改变firstName
     */
    private void delay01() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mUser.setFirstName("Com");
                mBinding.setUser(mUser);
            }
        }, 2000);
    }

    private void delay02() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mUser.setFirstName("Com");
            }
        }, 2000);
    }
}
