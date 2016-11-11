package bwie.recyclerviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> list;
    private RecyclerView rlv;
    private adapter ad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //获得控件
//        rlv=(RecyclerView)findViewById(R.id.rlv);
        //添加数据
        initdata();
        System.out.println("----------"+list.size());
        //添加适配器
        ad=new adapter(list,MainActivity.this);
        //获得布局管理器对象
        LinearLayoutManager manager=new LinearLayoutManager(this);

        //设置布局管理器
//        rlv.setLayoutManager(manager);//listview
      //  rlv.setLayoutManager(new LinearLayoutManager(this));//listview

//        rlv.setLayoutManager(new GridLayoutManager(this,4));//gridview
        rlv.setLayoutManager(new StaggeredGridLayoutManager(4,StaggeredGridLayoutManager.HORIZONTAL));
        //设置垂直布局
        manager.setOrientation(OrientationHelper.VERTICAL);
        //设置adapter
        rlv.setAdapter(ad);


        //设置分割线

        //listview形式
//        rlv.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL_LIST));

        //gridview形式
//        rlv.addItemDecoration(new DividerGridItemDecoration(this));

    }

    public void initdata() {
        list=new ArrayList<String>();
        for (int i = 0; i < 57; i++) {
            list.add("item "+i);
        }
    }
}
