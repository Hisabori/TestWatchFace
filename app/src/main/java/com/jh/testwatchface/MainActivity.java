
package com.jh.testwatchface;


//1.
//import androidx.appcompat.app.AppCompatActivity -->
//Android Application 에서 사용자 인터 페이스 (User Interface ,UI)를 만들기 위해 사용 한다.
//AppCompatActivity 는 기존 Activity 클래스를 확장 한 클래스로, 다음과 같은 차이점이 존재 한다.
//1. 기존 Activity class 와 달리, Action Bar 를 기본 지원한다.
//2. 머터리얼 디자인을 지원한다. (기존 Activity 의 경우, 1번 처럼 직접 구현해야 함)
//3. AndroidX 라이브러리의 일부인 AppCompatActivity는, 기존 class에 비해서 이전 Android Version 과의 호환성이 좋다.
//4. 초기화 method 인 onCreate() 같이, 기존에 없던 신규 메소드를 제공, 수명주기 이벤트 처리가 단순해 진다.
//5. 위와 같은 많은 추가 편의 기능을 지원해, 기존 버전 보다 개발에 더 많은 시간을 쓸 수 있도록 해준다.


//2.
//import android.os.Bundle -->
//android.os.Bundle 은, Android 애플리케이션에서 데이터를 전달/저장 하기 위해 사용하는 클래스로,
//lntent 객체를 통해 activity 간 data 를 전달하거나, activity의 수명 주기 (Life Cycle) 에서,
//임시로 data를 저장해 두고, 다시 복원할 때 사용 한다.


//3.
//import android.view.View -->
//앱에서 UI (User Interface) 요소를 표시하는 기본 클래스 중 하나로,
//버튼, 텍스트뷰, 이미지뷰 등의 모든 UI 요소가 View로 부터 상속 받는다.
//하위 클래스로는 TextView (텍스트를 표시함) 등이 있다.


//4.
//java.text.SimpleDataFormat -->
//java에서 날짜/시간을 다루는 클래스로, 주어진 형식의 문자열을 Date 객체로 파싱 하거나.
//Date 객체를 주어진 형식의 문자열로 포맷팅 하는 데 사용 된다.


//5.
//java.util.Date -->
//시스템의 현제 시간을 Date 객체로 가져 오거나, Date 객체를 다루는 데 사용한다.
//tip: Date 객체는 UNIX 타임 스템프 기반으로 1970.1.1 부터 초 단위로 생성 되어,
//특정 시간을 초 단위로 표현 할 수가 있다.



//1
import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

//2
import android.os.Bundle;

//3
import android.view.View;

//4
import java.text.SimpleDateFormat;

//5
import java.util.Date;


public class MainActivity extends AppCompatActivity
    implements View.OnClickListener {
    //app에서 View 클릭 시, 이벤트를 처리함
    //변수 (var) 선언: 디자인

    private TextView timeTextView;
    private TextView dateTextView;
    private TextView weatherTextView;
    private TextView notificationTextView;
    private TextView heartRateTextView;
    private TextView stepCountTextView;


    private void ininViews() {
        dateTextView = findViewById(R.id.date_text_view);
        timeTextView = findViewById(R.id.time_text_view);
    }

    private void updateClock() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE, MMM. d");
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");

        String date = dateFormat.format(new Date());
        String time = timeFormat.format(new Date());

        dateTextView.setText(date);
        dateTextView.setText(time);
    }

    private void initViews() {
        weatherTextView = findViewById(R.id.weather_text_view);
        notificationTextView = findViewById(R.id.notification_text_view);
        heartRateTextView = findViewById(R.id.heart_rate_text_view);
        stepCountTextView = findViewById(R.id.step_count_text_view);
    }

    //weather data 수신
    private void updateWeather() {
        String weather = getWeather();

        //Te
        weatherTextView.setText(weather);
    }

    //notification data 수신
    private void updateNotification() {
        String notification = getNotification();

        notificationTextView.setText(notification);
    }

    //심박수 수신
    private void updateHeartRate() {
        String heartRate = getHeartRate();

        heartRateTextView.setText(heartRate);
    }

    //걸음수 수신
    private void updateStepCount() {
        String stepCount = getStepCount();

        stepCountTextView.setText(stepCount);
    }

    //receive
    private String getWeather(){
        return "맑은날";
    }

    private String getNotification(){
        return "신규 알림이 있습니다";
    }

    private String getHeartRate(){
        return "72 bpm";
    }

    private String getStepCount(){
        return "7,234 보";
    }

    private static final long UPDATE_INTERVAL_MS = 100;


    //메소드 제정의
    @Override

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //주기적으로 업데이트 진행
        final Handler handler = new Handler(Looper.getMainLooper());
        final Runnable runnable = new Runnable() {

            //메소드 제정의
            @Override

            public void run() {
                handler.postDelayed(this, UPDATE_INTERVAL_MS);
            }
        };
        handler.post(runnable);
    }

    @Override
    public void onClick(View view) {

    }
}