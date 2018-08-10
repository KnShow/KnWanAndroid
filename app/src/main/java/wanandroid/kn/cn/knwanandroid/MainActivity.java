package wanandroid.kn.cn.knwanandroid;

import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger2.itcast.cn.flycotablayout.CommonTabLayout;
import dagger2.itcast.cn.flycotablayout.OnTabSelectListener;
import dagger2.itcast.cn.flycotablayout.listener.CustomTabEntity;
import wanandroid.kn.cn.knwanandroid.adapter.MainViewPagerAdapter;
import wanandroid.kn.cn.knwanandroid.bean.MainTabEntity;
import wanandroid.kn.cn.knwanandroid.contract.MainContract;
import wanandroid.kn.cn.knwanandroid.presenter.MainPresenter;
import wanandroid.kn.cn.knwanandroid.temp.FindFragment;
import wanandroid.kn.cn.knwanandroid.temp.HomeFragment;
import wanandroid.kn.cn.knwanandroid.temp.OtherFragment;
import wanandroid.kn.cn.knwanandroid.temp.VideoFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, OnTabSelectListener, MainContract.View {
    @BindView(R.id.main_navigation)
    NavigationView navigationView;
    @BindView(R.id.vp_home)
    ViewPager vp_home;
    @BindView(R.id.tabLayout)
    CommonTabLayout commonTabLayout;
    @BindView(R.id.setting)
    TextView setting;
    @BindView(R.id.exit_App)
    TextView exit_App;
    List<CustomTabEntity> customTabEntities = new ArrayList();
    private String[] mTitles = {"首页", "发现", "视屏", "其他"};
    private int[] mIconSelectIds = {R.mipmap.tab_home_select, R.mipmap.tab_contact_select, R.mipmap.tab_speech_select, R.mipmap.tab_more_select};
    private int[] mIconUnSelectIds = {R.mipmap.tab_home_unselect, R.mipmap.tab_contact_unselect, R.mipmap.tab_speech_unselect, R.mipmap.tab_more_unselect};
    private MainContract.Presenter presenter = new MainPresenter(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initData();
        initView();
        initTabLayout();
    }



    private void initData() {
        //设置tab的标题、选中图标、未选中图标
        for (int i = 0; i < mTitles.length; i++) {
            customTabEntities.add(new MainTabEntity(mTitles[i], mIconSelectIds[i], mIconUnSelectIds[i]));
        }

    }

    private void initView() {
        setting.setOnClickListener(this);
        exit_App.setOnClickListener(this);
        commonTabLayout.setOnTabSelectListener(this);
        initViewPager();
    }

    private void initTabLayout() {
        ArrayList<CustomTabEntity> tabEntity = presenter.getTabEntity();
        commonTabLayout.setTabData(tabEntity);
    }

    private void initViewPager() {
        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(FragmentFactory.getInstance().getHomeFragment());
        fragmentList.add(FragmentFactory.getInstance().getFindFragment());
        fragmentList.add(FragmentFactory.getInstance().getVideoFragment());
        fragmentList.add(FragmentFactory.getInstance().getOtherFragment());
        vp_home.setAdapter(new MainViewPagerAdapter(getSupportFragmentManager(), fragmentList));
        vp_home.setCurrentItem(0);
        vp_home.setOffscreenPageLimit(4);
        vp_home.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                commonTabLayout.setCurrentTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }


    @Override
    public void onClick(View v) {

    }

    @Override
    public void onTabSelect(int position) {
        vp_home.setCurrentItem(position);
    }

    @Override
    public void onTabReselect(int position) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
