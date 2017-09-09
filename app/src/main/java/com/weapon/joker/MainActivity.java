package com.weapon.joker;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;

import com.weapon.joker.lib.mvvm.common.BaseActivity;

/**
 * MainActivity 创建首页所有的 fragment，以及
 * 启动模式 singleTask
 * author:张冠之
 * time: 2017/9/9 下午3:19
 * e-mail: guanzhi.zhang@sojex.cn
 */

public class MainActivity extends BaseActivity {

    private TabLayout mTabLayout;

    /********** Fragment 相关 **********/
    private Fragment mHomeFragment;
    private Fragment mMessageFragment;
    private Fragment mMineFragment;
    //当前 fragment
    private Fragment mCurrentFragment;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        initTabLayout();

    }

    /**
     * 初始化 TabLayout
     */
    private void initTabLayout() {
        mTabLayout = (TabLayout) findViewById(R.id.tab_layout);

        //设置 TabLayout 初始图像和字样
        mTabLayout.addTab(mTabLayout.newTab().setText(getResources().getString(R.string.home)).setIcon(R.mipmap.comui_tab_home));
        mTabLayout.addTab(mTabLayout.newTab().setText(getResources().getString(R.string.message)).setIcon(R.mipmap.comui_tab_message));
        mTabLayout.addTab(mTabLayout.newTab().setText(getResources().getString(R.string.mine)).setIcon(R.mipmap.comui_tab_mine));

        mTabLayout.addOnTabSelectedListener(new TabSelectedListener());
    }

    private class TabSelectedListener implements TabLayout.OnTabSelectedListener {

        @Override
        public void onTabSelected(TabLayout.Tab tab) {
            onTabSelect(tab);
        }

        @Override
        public void onTabUnselected(TabLayout.Tab tab) {
            onTabUnSelect(tab);
        }

        @Override
        public void onTabReselected(TabLayout.Tab tab) {

        }
    }

    private void onTabSelect(TabLayout.Tab tab) {
        int position = tab.getPosition();
        switch (position) {
            case 0:
                mTabLayout.getTabAt(position).setIcon(R.mipmap.comui_tab_home_selected);
                break;
            case 1:
                mTabLayout.getTabAt(position).setIcon(R.mipmap.comui_tab_message_selected);
                break;
            case 2:
                mTabLayout.getTabAt(position).setIcon(R.mipmap.comui_tab_mine_selected);
                break;
        }
    }

    private void onTabUnSelect(TabLayout.Tab tab) {
        int position = tab.getPosition();
        switch (position) {
            case 0:
                mTabLayout.getTabAt(position).setIcon(R.mipmap.comui_tab_home);
                break;
            case 1:
                mTabLayout.getTabAt(position).setIcon(R.mipmap.comui_tab_message);
                break;
            case 2:
                mTabLayout.getTabAt(position).setIcon(R.mipmap.comui_tab_mine);
                break;
        }
    }
}
