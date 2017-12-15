package com.heshiqi.widget.ninegridview;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;


import com.heshiqi.widget.ninegrid.OnNineGridViewItemClickListener;
import com.heshiqi.widget.ninegridview.adapter.NinePicAdapter;
import com.heshiqi.widget.ninegridview.core.contract.MainContract;
import com.heshiqi.widget.ninegridview.core.presenter.MainPresenter;
import com.heshiqi.widget.ninegridview.core.repository.MainRepository;
import com.heshiqi.widget.ninegridview.entity.MainEntity;

import java.util.List;


public class MainActivity extends AppCompatActivity implements MainContract.View,OnNineGridViewItemClickListener {

    /**
     * 实现了加载更多功能
     */
    private RecyclerView recyclerView;

    private NinePicAdapter adapter;

    private MainContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new MainPresenter(this, new MainRepository());
        initView();
        initData();
        initListener();

    }

    private void initView() {

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        //设置item之间的分隔线
        DividerItemDecoration decoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        decoration.setDrawable(ContextCompat.getDrawable(this, R.drawable.transparent_divider_1dip));
        recyclerView.addItemDecoration(decoration);
    }

    private void initData() {
        adapter = new NinePicAdapter(this, presenter,this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(adapter);
        //开始加载数据
        presenter.loadDatas(false);

    }

    private void initListener() {


    }

    @Override
    public void onResultData(List<MainEntity> datas, boolean isSuccess, boolean isLoadMore) {
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onItemClicked(View view, int parentPosition, int position) {
        Toast.makeText(this,"点击第"+(parentPosition+1)+"个item,第"+(position+1)+"张图片",Toast.LENGTH_SHORT).show();
    }
}
