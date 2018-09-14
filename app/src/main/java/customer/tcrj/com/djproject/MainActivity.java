package customer.tcrj.com.djproject;


import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.pm.ActivityInfo;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.githang.statusbar.StatusBarCompat;
import com.pgyersdk.javabean.AppBean;
import com.pgyersdk.update.PgyUpdateManager;
import com.pgyersdk.update.UpdateManagerListener;

import customer.tcrj.com.djproject.DJFregment.DJFragment;
import customer.tcrj.com.djproject.Utils.AppManager;
import customer.tcrj.com.djproject.Utils.DialogHelper;
import customer.tcrj.com.djproject.Utils.Utils;
import customer.tcrj.com.djproject.mine.MineFragment;
import customer.tcrj.com.djproject.setting.SettingFragment;
import customer.tcrj.com.djproject.sy.FirstFragment;
import customer.tcrj.com.djproject.widget.BottomNavigationViewHelper;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private FragmentManager fragmentManager;
    private MineFragment mineFragment;
    private FirstFragment newsFragment;
    private SettingFragment settingFragment;
    private DJFragment djFragment;

    private TextView poiat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mLoadingDialog = DialogHelper.getLoadingDialog(this);
        init();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        StatusBarCompat.setStatusBarColor(this, getResources().getColor(R.color.red), true);
        AppManager.getAppManager().addActivity(this);
        initview();

    }


    private void init() {
        showLoadingDialog("正在检测更新..");
        PgyUpdateManager.register(this,
                new UpdateManagerListener() {

                    @Override
                    public void onUpdateAvailable(final String result) {

                        hideLoadingDialog();
                        // 将新版本信息封装到AppBean中
                        final AppBean appBean = getAppBeanFromString(result);
                        new AlertDialog.Builder( MainActivity.this)
                                .setTitle("更新")
                                .setMessage(appBean.getReleaseNote())
                                .setNegativeButton(
                                        "确定",
                                        new DialogInterface.OnClickListener() {

                                            @Override
                                            public void onClick(



                                                    DialogInterface dialog,
                                                    int which) {
                                                startDownloadTask(
                                                        MainActivity.this,
                                                        appBean.getDownloadURL());
                                            }
                                        }).show();
                    }

                    @Override
                    public void onNoUpdateAvailable() {
                        hideLoadingDialog();

//                        Toast.makeText(MainActivity.this, "当前为最新版本", Toast.LENGTH_LONG).show();

                    }
                });
    }

    private void initview() {

        fragmentManager = getSupportFragmentManager();
        BottomNavigationView navigationView = (BottomNavigationView) findViewById(R.id.bnve);
        BottomNavigationViewHelper.disableShiftMode(navigationView);
//        //获取整个的NavigationView
//        BottomNavigationMenuView menuView = (BottomNavigationMenuView) navigationView.getChildAt(0);

//        //这里就是获取所添加的每一个Tab，
//        View tab = menuView.getChildAt(1);
//        BottomNavigationItemView itemView = (BottomNavigationItemView) tab;
//
//        //加载我们的角标View，新创建的一个布局
//        View badge = LayoutInflater.from(this).inflate(R.layout.menu_badge, menuView, false);
//        poiat = (TextView) badge.findViewById(R.id.tv_msg_count);
//        //添加到Tab上
//        itemView.addView(badge);

        navigationView.setOnNavigationItemSelectedListener(this);

        setTabSelection(0);
    }

    private int num = -1;
    private void setTabSelection(int index) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        hideFragments(transaction);
        switch (index) {
            case 0:
                if (newsFragment == null) {
                    newsFragment = new FirstFragment();
                    transaction.add(R.id.contentContainer, newsFragment);
                } else {
                    transaction.show(newsFragment);
                }


                break;
            case 1:
                if (djFragment == null) {
                    djFragment = new DJFragment();
                    transaction.add(R.id.contentContainer, djFragment);
                } else {
                    transaction.show(djFragment);
                }
                break;
            case 2:
                if (mineFragment == null) {
                    mineFragment = new MineFragment();
                    transaction.add(R.id.contentContainer, mineFragment);
                } else {
                    transaction.show(mineFragment);
                }
                break;

            case 3:
                if (settingFragment == null) {
                    settingFragment = new SettingFragment();
                    transaction.add(R.id.contentContainer, settingFragment);
                } else {
                    transaction.show(settingFragment);
                }
                break;

        }
        transaction.commit();
    }

    private void hideFragments(FragmentTransaction transaction) {
        if (mineFragment != null) {
            transaction.hide(mineFragment);
        }
        if (newsFragment != null) {
            transaction.hide(newsFragment);
        }
        if (settingFragment != null) {
            transaction.hide(settingFragment);
        }
        if (djFragment != null) {
            transaction.hide(djFragment);
        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_music:

                if(num != 0){
                    setTabSelection(0);
                }

                num = 0;
                return true;

            case R.id.menu_backup:

//              poiat.setVisibility(View.GONE);
                if(num != 1) {
                    setTabSelection(1);
                }
                num = 1;

                return true;

            case R.id.menu_friends:
                if(num != 2) {
                    setTabSelection(2);
                }
                num = 2;

                return true;

            case R.id.menu_set:
                if(num != 3) {
                    setTabSelection(3);
                }
                num = 3;

                return true;
        }
        return false;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mHandler.removeCallbacksAndMessages(null);
        AppManager.getAppManager().finishActivity(this); //从栈中移除
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exit();
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }

    private void exit() {
        if (!isExit) {
            isExit = true;
            Toast.makeText(getApplicationContext(), "再按一次退出程序",
                    Toast.LENGTH_SHORT).show();
            // 利用handler延迟发送更改状态信息

            mHandler.sendEmptyMessageDelayed(0, 2000);
        } else {
            finish();
//          System.exit(0);
        }
    }

    //定义一个变量，
    //来标识是否退出
    private static boolean isExit = false;
    Handler mHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            isExit = false;
        }
    };

    protected Dialog mLoadingDialog = null;
    protected void showLoadingDialog(String str) {
        if (mLoadingDialog != null) {
            TextView tv = (TextView) mLoadingDialog.findViewById(R.id.tv_load_dialog);
            tv.setText(str);
            mLoadingDialog.show();
        }
    }

    protected void hideLoadingDialog() {
        if (mLoadingDialog != null && mLoadingDialog.isShowing()) {
            mLoadingDialog.dismiss();
        }
    }
}
