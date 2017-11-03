package com.starcompany.pianist;

import android.os.Bundle;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.MotionEvent;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private GestureDetectorCompat gestDetect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        gestDetect = new GestureDetectorCompat(this, mOnGestureListener);

    }
    private static final int SWIPE_MIN_DISTANCE = 120;
    private static final int SWIPE_MAX_OFF_PATH = 250;
    private static final int SWIPE_THRESHOLD_VELOCITY = 200;


    // タッチイベントのリスナー
    private final GestureDetector.SimpleOnGestureListener mOnGestureListener = new GestureDetector.SimpleOnGestureListener() {

        // フリックイベント
        @Override
        public boolean onFling(MotionEvent event1, MotionEvent event2, float velocityX, float velocityY) {

            try {

                // 移動距離・スピードを出力
                float distance_x = Math.abs((event1.getX() - event2.getX()));
                float velocity_x = Math.abs(velocityX);
                //textView1.setText("横の移動距離:" + distance_x + " 横の移動スピード:" + velocity_x);

                // Y軸の移動距離が大きすぎる場合
                if (Math.abs(event1.getY() - event2.getY()) > SWIPE_MAX_OFF_PATH) {
                  //  textView2.setText("縦の移動距離が大きすぎ");
                }
                // 開始位置から終了位置の移動距離が指定値より大きい
                // X軸の移動速度が指定値より大きい
                else if  (event1.getX() - event2.getX() > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
                    //textView2.setText("右から左");

                }
                // 終了位置から開始位置の移動距離が指定値より大きい
                // X軸の移動速度が指定値より大きい
                else if (event2.getX() - event1.getX() > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
                  //  textView2.setText("左から右");
                }

            } catch (Exception e) {
                // TODO
            }

            return false;
        }
    };



}
