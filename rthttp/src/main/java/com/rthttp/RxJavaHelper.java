package com.rthttp;
/*
 * Author: 张
 * Email: 1271396448@qq.com
 * Date: 2018/12/14.
 *
 * Rxjava2线程切换操作封装
 */

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class RxJavaHelper {

    public static ObservableTransformer observeOnMainThread(){
        return new ObservableTransformer() {
            @Override
            public ObservableSource apply(Observable upstream) {
                return upstream.subscribeOn(Schedulers.io())
                        .unsubscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }

}
