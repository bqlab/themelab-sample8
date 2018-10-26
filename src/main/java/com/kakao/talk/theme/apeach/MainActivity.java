package com.kakao.talk.theme.apeach;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
    private static final String KAKAOTALK_SETTINGS_THEME_URI = "kakaotalk://settings/theme/";
    private static final String MARKET_URI = "market://details?id=";
    private static final String KAKAO_TALK_PACKAGE_NAME = "com.kakao.talk";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        init();
    }

    public void init() {
        Toast.makeText(this,"테마가 적용되는 중이니 잠시만 기다려주세요.", Toast.LENGTH_LONG).show();
        try {
            getPackageManager().getPackageInfo(KAKAO_TALK_PACKAGE_NAME, 0);
            final Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(KAKAOTALK_SETTINGS_THEME_URI + getPackageName()));
            startActivity(intent);
            finish();
        } catch (NameNotFoundException e) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(MARKET_URI + KAKAO_TALK_PACKAGE_NAME));
            startActivity(intent);
            finish();
        }
    }
}
