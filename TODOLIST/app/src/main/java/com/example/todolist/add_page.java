package com.example.todolist;

import android.view.View;
import android.widget.Button;


import androidx.appcompat.app.AppCompatActivity;


public class add_page extends AppCompatActivity {
    private EditText editText_date;
    private EditText editText_topic;
    private EditText editText_schedule;

    class InputText{
        String inputText_date;
        String inputText_topic;
        String inputText_schedule;
    }
    InputText inputText=new InputText();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_);
        Button add=(Button)findViewById(R.id.add_Success);
        editText_date=(editText)findViewById(R.id.data);
        editText_topic=(editText)findViewById(R.id.topic);
        editText_schedule=(editText)findViewById(R.id.schedule);


        @Override
        public void onclick(View v, InputText inputText){
            switch(v.getId()){
                case R.id.add:
                    inputText.inputText_date=editText_date.getText().toString();
                    inputText.inputText_topic=editText_topic.getText().toString();
                    inputText.inputText_schedule=editText_schedule.getText().toString();
                    /*获取editText中的输入内容*/
                    break;
                default:
                    break;
            }
        }


        /*将数据存入名字为data的文件中（利用SharedPreferences） 只用来存储一些简单的数据和键值*/
        /*add.setOnClickListener(new view.OnClickListener(){
            @Override
            public void onClick(View v){
                SharedPreferences.Editor editor=grtSharedPreferences("data",MODE_PRIVATE).edit();
                editor.putStirng("date",inputText.inputText_date);
                editor.putStirng("topic",inputText.inputText_topic);
                editor.putStirng("schedule",inputText.inputText_schedule);
                editor.apply();
            }
        });*/

        add.setOnClickListener(new View.OnClickListener(){
            @Override
                    public void onClick(View v){
                Toast.makeTsxr(add_page.this,"Succeed",Toast.LENGTH_SHORT).show();
            }
            /*Toast makeText()要求传入三个参数，上下文，显示的文本内容，显示时长——Toast.LENGTH_SHORT,Toast.LENGTH_LONG*/
        });

        Button add_Success=(Button)findViewById(R.id.add_Success);
        Button add_Success.setOnClickListener(new View.OnClickListener){
            /*点击add_new的button触发add_page的activity*/
            @override
            public void onClick(View v,InputText inputText){


                /*将数据返回上一个activity*/
                Intent intent_date=new Intent();
                Intent intent_topic=new Intent();
                Intent intent_schedule=new Intent();
                intent_date.putExtra("date_return",inputText.inputText_date);
                intent_topic.putExtra("topic_return",inputText.inputText_topic);
                intent_schedule.putExtra("schedule_return",inputText.inputText_schedule);
                setResult(RESULT_OK,intent2);

                Intent intent=new Intent(add_page.this,Mainactivity.class)
                startActivity(intent);
                finish();
            }
        }
    }


}