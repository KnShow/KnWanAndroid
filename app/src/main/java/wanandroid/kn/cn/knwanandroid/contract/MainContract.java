package wanandroid.kn.cn.knwanandroid.contract;

import java.util.ArrayList;
import java.util.List;

import dagger2.itcast.cn.flycotablayout.listener.CustomTabEntity;
import wanandroid.kn.cn.knwanandroid.BaseView;
import wanandroid.kn.cn.knwanandroid.presenter.IBasePresenter;

public class MainContract {
    public interface View extends BaseView{

    }

   public interface Presenter extends IBasePresenter{
       ArrayList<CustomTabEntity> getTabEntity();
    }
}
