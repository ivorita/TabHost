package com.antelope.android.tabhost;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TabHost mTabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTabHost = findViewById(R.id.tabHost);
        mTabHost.setup();//初始化TabHost

        for (int i = 0; i < 4; i++){
            View view = LayoutInflater.from(this).inflate(R.layout.myindicator,null,false);
            TextView textView = view.findViewById(R.id.tv_indicator);
            ImageView imageView = view.findViewById(R.id.iv_indicator);

            switch (i){
                case 0:
                    textView.setText(R.string.weixin);
                    imageView.setImageResource(R.drawable.weixin);
                    mTabHost.addTab(mTabHost.newTabSpec("1").setIndicator(view).setContent(R.id.tvOne));
                    break;
                case 1:
                    textView.setText(R.string.txl);
                    imageView.setImageResource(R.drawable.txl);
                    mTabHost.addTab(mTabHost.newTabSpec("2").setIndicator(view).setContent(R.id.tvTwo));
                    break;
                case 2:
                    textView.setText(R.string.fx);
                    imageView.setImageResource(R.drawable.fx);
                    mTabHost.addTab(mTabHost.newTabSpec("3").setIndicator(view).setContent(R.id.tvThree));
                    break;
                case 3:
                    textView.setText(R.string.Me);
                    imageView.setImageResource(R.drawable.me);
                    mTabHost.addTab(mTabHost.newTabSpec("4").setIndicator(view).setContent(R.id.tvFour));
                    break;
            }
        }

        mTabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                for (int i = 0; i < 4; i++){
                    ((TextView)mTabHost.getTabWidget().getChildTabViewAt(i).findViewById(R.id.tv_indicator))
                            .setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                }

                if (mTabHost.getCurrentTabTag() == tabId){
                    ((TextView)mTabHost.getCurrentTabView().findViewById(R.id.tv_indicator))
                            .setTextColor(getResources().getColor(R.color.colorAccent));
                }
            }
        });

        ((TextView)mTabHost.getCurrentTabView().findViewById(R.id.tv_indicator))
                .setTextColor(getResources().getColor(R.color.colorAccent));

    }
}
