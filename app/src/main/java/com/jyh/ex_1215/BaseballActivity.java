package com.jyh.ex_1215;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class BaseballActivity extends AppCompatActivity {

    TextView input_txt, result_txt;
    Button btn_c, btn_start;
    Button[] btns;
    ScrollView scroll;

    //컴퓨터의 각 자리별 난수
    int com1 = 0;
    int com2 = 0;
    int com3 = 0;

    //사용자의 각 자리별 값
    int user1 = 0;
    int user2 = 0;
    int user3 = 0;

    //세글자 이상은 입력받지 못하도록 하는 변수
    int inputCount = 1;

    String inputStr = "";
    String resultStr = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baseball);

        scroll = findViewById(R.id.scroll);
        input_txt = findViewById(R.id.input_txt);
        result_txt = findViewById(R.id.result_txt);
        btn_c = findViewById(R.id.btn_c);
        btn_start = findViewById(R.id.btn_start);

        btns = new Button[9];

        for( int i = 0; i < btns.length; i++ ){
            int getID = getResources().getIdentifier(
                    "btn" + (i+1), "id", "com.jyh.ex_1215");
            btns[i] = findViewById(getID);

            btns[i].setOnClickListener(click);
        }

        btn_c.setOnClickListener(cs);
        btn_start.setOnClickListener(cs);

        setRandom();//컴퓨터 난수발생

    }//onCreate()

    //1 ~ 9버튼 클릭을 감지하는 감지자
    View.OnClickListener click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            if(inputCount <= 3){

                String str = ((Button)view).getText().toString();

                inputStr += str;
                input_txt.setText(inputStr);

                //클릭된 버튼을 비활성화
                view.setEnabled(false);

                inputCount++;
            }else{
                Toast.makeText(BaseballActivity.this,
                        "숫자를 세 개 입력해야 합니다",
                        Toast.LENGTH_SHORT).show();
            }

        }
    };

    //clear와 start 클릭을 감지하는 감지자
    View.OnClickListener cs = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            switch ( view.getId() ){

                case R.id.btn_c:
                    screenInit();
                    break;

                case R.id.btn_start:
                    if( btn_start.getText().toString().equalsIgnoreCase("start") ){

                        if( inputCount > 3 ){

                            scroll.scrollTo(0, result_txt.getHeight());

                            user1 = Integer.parseInt( "" + inputStr.charAt(0) );
                            user2 = Integer.parseInt( "" + inputStr.charAt(1) );
                            user3 = Integer.parseInt( "" + inputStr.charAt(2) );

                            int strike = 0;
                            int ball = 0;

                            if( user1 == com1 ){
                                strike++;
                            }else if( user1 == com2 || user1 == com3 ){
                                ball++;
                            }

                            if( user2 == com2 ){
                                strike++;
                            }else if( user2 == com1 || user2 == com3 ){
                                ball++;
                            }

                            if( user3 == com3 ){
                                strike++;
                            }else if( user3 == com1 || user3 == com2 ){
                                ball++;
                            }

                            //정답!
                            if( strike == 3){
                                inputStr =
                                        input_txt.getText().toString() + " - Homerun!!!";
                                btn_start.setText("retry");
                            }else{
                                if( strike == 0 && ball == 0){
                                    inputStr = input_txt.getText().toString() +
                                            " - OUT!";
                                }else{

                                    inputStr = input_txt.getText().toString() +
                                            " - " + strike + "S, " + ball + "B";
                                }
                            }

                            //result_txt에 현재 상황을 기록
                            resultStr += inputStr + "\n";
                            result_txt.setText(resultStr);
                            screenInit();

                        }else{
                            Toast.makeText(BaseballActivity.this,
                                    "숫자를 세 개 입력해야 합니다",
                                    Toast.LENGTH_SHORT).show();
                        }

                    }else{
                        //게임초기화
                        screenInit();
                        setRandom();
                        result_txt.setText("");
                        resultStr = "";
                        btn_start.setText("START");
                    }
                    break;

            }//switch

        }
    };

    //화면 초기화 메서드
    public void screenInit(){
        inputStr = "";
        input_txt.setText("input number");
        inputCount = 1;

        //모든 버튼 클릭 활성화
        for( int i = 0; i < btns.length; i++ ){
            btns[i].setEnabled(true);
        }
    }

    //컴퓨터의 각 자리에 난수를 생성하는 메서드
    public void setRandom(){
        Random rnd = new Random();

        do{
            //각 자리에 중복되지 않는 난수를 생성
            com1 = rnd.nextInt(9)+1;
            com2 = rnd.nextInt(9)+1;
            com3 = rnd.nextInt(9)+1;

        }while( com1 == com2 || com1 == com3 || com2 == com3 );

    }

}



































































