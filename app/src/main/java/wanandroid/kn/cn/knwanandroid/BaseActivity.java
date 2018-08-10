package wanandroid.kn.cn.knwanandroid;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import wanandroid.kn.cn.knwanandroid.presenter.IBasePresenter;

public class BaseActivity <T extends IBasePresenter>extends AppCompatActivity{

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);

    }
}
