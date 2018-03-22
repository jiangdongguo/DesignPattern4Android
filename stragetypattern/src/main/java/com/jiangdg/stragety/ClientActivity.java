package com.jiangdg.stragety;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ClientActivity extends AppCompatActivity {
    private ISearchStragety mSearchStragety;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onBikeSearchClick(View view) {
        setStragety(new BikeSearchStragety());
        mSearchStragety.searchRouteWay("大学城南","南沙天后宫");
    }

    public void onWalkSearchClick(View view) {
        setStragety(new WalkSearchStragety());
        mSearchStragety.searchRouteWay("大学城南","南沙天后宫");
    }

    // 设置出行策略
    private void setStragety(ISearchStragety mSearchStragety) {
        this.mSearchStragety = mSearchStragety;
    }

    // 执行搜索策略
    private void searchRouteWay(String startPlace,String endPlace) {
        mSearchStragety.searchRouteWay(startPlace,endPlace);
    }
}
