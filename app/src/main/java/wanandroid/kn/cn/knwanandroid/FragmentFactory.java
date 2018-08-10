package wanandroid.kn.cn.knwanandroid;

import wanandroid.kn.cn.knwanandroid.temp.FindFragment;
import wanandroid.kn.cn.knwanandroid.temp.HomeFragment;
import wanandroid.kn.cn.knwanandroid.temp.OtherFragment;
import wanandroid.kn.cn.knwanandroid.temp.VideoFragment;

public class FragmentFactory {
    private HomeFragment mHomeFragment;
    private FindFragment mFindFragment;
    private VideoFragment mVideoFragment;
    private OtherFragment mOtherFragment;

    private FragmentFactory() {
    }

    public static FragmentFactory getInstance() {
        return FragmentFactoryHolder.sInstance;
    }

    private static class FragmentFactoryHolder {
        private static final FragmentFactory sInstance = new FragmentFactory();
    }

    public HomeFragment getHomeFragment() {
        if (mHomeFragment == null) {
            synchronized (HomeFragment.class) {
                if (mHomeFragment == null)
                    mHomeFragment = new HomeFragment();
            }
        }
        return mHomeFragment;
    }

    public FindFragment getFindFragment() {
        if (mFindFragment == null) {
            synchronized (FindFragment.class) {
                if (mFindFragment == null)
                    mFindFragment = new FindFragment();
            }
        }
        return mFindFragment;
    }

    public VideoFragment getVideoFragment() {
        if (mVideoFragment == null) {
            synchronized (VideoFragment.class) {
                if (mVideoFragment == null)
                    mVideoFragment = new VideoFragment();
            }
        }
        return mVideoFragment;
    }

    public OtherFragment getOtherFragment() {
        if (mOtherFragment == null) {
            synchronized (OtherFragment.class) {
                if (mOtherFragment == null)
                    mOtherFragment = new OtherFragment();
            }
        }
        return mOtherFragment;
    }

}
