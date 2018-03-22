package com.jiangdg.stragety;

import android.util.Log;

/**出行策略具体实现类，骑行出行
 * Created by jianddongguo on 2018/3/18.
 */

public class BikeSearchStragety implements ISearchStragety {

    @Override
    public void searchRouteWay(String startPlaceName, String endPlaceName) {
        Log.i("tag","搜索骑行出行结果");
    }
}
