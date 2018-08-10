package wanandroid.kn.cn.knwanandroid.presenter;

import android.app.Activity;
import android.content.res.TypedArray;

import java.util.ArrayList;
import java.util.List;

import dagger2.itcast.cn.flycotablayout.listener.CustomTabEntity;
import wanandroid.kn.cn.knwanandroid.R;
import wanandroid.kn.cn.knwanandroid.bean.MainTabEntity;
import wanandroid.kn.cn.knwanandroid.contract.MainContract;

public class MainPresenter implements MainContract.Presenter{
    private MainContract.View mView;
    private Activity activity;
    public MainPresenter(MainContract.View androidView) {
        this.mView = androidView;
        this.activity = (Activity) androidView;
    }
    @Override
    public void subscribe() {

    }

    @Override
    public void unSubscribe() {

    }

    @Override
    public ArrayList<CustomTabEntity> getTabEntity() {
        ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();
        TypedArray mIconUnSelectIds = activity.getResources().obtainTypedArray(R.array.main_tab_un_select);
        TypedArray mIconSelectIds = activity.getResources().obtainTypedArray(R.array.main_tab_select);
        String[] mainTitles = activity.getResources().getStringArray(R.array.main_title);
        for (int i = 0; i < mainTitles.length; i++) {
            int unSelectId = mIconUnSelectIds.getResourceId(i, R.mipmap.tab_home_unselect);
            int selectId = mIconSelectIds.getResourceId(i, R.mipmap.tab_home_select);
            mTabEntities.add(new MainTabEntity(mainTitles[i],selectId , unSelectId));
        }
        mIconUnSelectIds.recycle();
        mIconSelectIds.recycle();
        return mTabEntities;
    }
}
