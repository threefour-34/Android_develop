package com.example.todolist;

import android.os.Bundle;
import android.view.View;
import android.widge.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.BundleCompat;
import androidx.core.app.ShareCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.awt.Button;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.swing.text.AbstractDocument;
import javax.swing.text.View;


public class MainActivity extends AppCompatActivity {
    public class Schedule{
        public String data;
        public String schedule;
        public String topic;
    }

    RecyclerView mRecyclerView;
    MyAdapter mMyAdapter;
    List<Schedule> mScheduleList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button=findViewById(R.id.add_new);
        mRecyclerView=findViewById(R.id.recyclerview);

        /*构造一些数据*/
        for(int i=0;i<10;i++){
            Schedule schedule=new Schedule();
            schedule.data="2021.4."+(9+i);
            schedule.schedule="跑"+(i+1)+"千米";
            schedule.topic="锻炼";
            mScheduleList.add(schedule);
        }
        mMyAdapter=new MyAdapter();
        mRecyclerView.setAdapter(mMyAdapter);
        LinearLayoutManager layoutManager= new LinearLayoutManager(MainActivity.this);
        mRecyclerView.setLayoutManager(layoutManager);

        class MyAdapter extends RecyclerView.Adapter<MyViewHoder>{
            @Override
            public MyViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
                View view =View.inflate(MainActivity.this,R.layout.Item_recyclerview,null);
                MyViewHoder myViewHoder=new MyViewHoder(view);
                return myViewHoder;
            }
            public void oBindViewHolder(@NonNull MyViewHoder holder,int potision){
                Schedule schedule=mScheduleList.get(potision);
                holder.mDate.setText(schedule.date);
                holder.mTopic.setText(schedule.topic);
                holder.mSchedule.setText(schedule.schedule);
            }
            public int getItemCount(){
                return mScheduleList.size();
            }
        }

        class MyViewHoder extends RecyclerView.ViewHolder{
            TextView mDate;
            TextView mTopic;
            TextView mSchedule;

            public MyViewHoder(@NonNull View itemView){
                super(itemView);
                mDate=itemView.findViewById(R.id.textView);
                mTopic=itemView.findViewById(R.id.textView2);
                mSchedule=itemView.findViewById(R.id.textView3);
            }
        }




        Button add_new=(Button)findViewById(R.id.add_new)
        add_new.setOnClickListener(new View.OnClickListener){
        /*点击add_new的button触发add_page的activity*/
        @Override
        public void onClick(View v){
            Intent intent=new Intent(MainActivity.this, com.example.todolist.add_page.add_page.class);
            startActivityForResult(intent,1);
        }

        /*将add_page中的data返回给MainActivity*/
        @Override
        protected void onActivityResult(int requestCode,int resultCode,Intent intent_date,Intent intent_topic,Intent intent_schedule){
            switch (requestCode){
                case 1:
                    if(resultCode==RESULT_OK){
                        String returnedDate=intent_date.getStringExtra("data_return");
                        String returnedTopic=intent_topic.getStringExtra("topic_return");
                        String returnedSchedule=intent_schedule.getStringExtra("schedule_return");

                        /*怎样使用这些数据*/
                        Log_d("MainActivity",returnedDate);
                    }
                    break;
                default:
            }
            }
    }
    }

    /*删除前弹出AlertDialog*/
    @Override
    public void onClick(View v){
        switch(v.getId()){
            case R.id.delete_schedule:
                AlertDialog.Builder dialog=new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("Delete");
                dialog.setMessage("ARE YOU SURE TO DELETE THIS SCHEDULE???");
                dialog.setCancelable(false);
                dialog.setPositiveButton("Ok",new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog,int which){
                    }
                });
                dialog.setNegativeButton("Cancel",new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                dialog.show();
                break;
            default:
                break;
        }
    }




    public class MyDatabaseHelper extends SQLiteOpenHelper{
        public static final String CREATE_BOOK="create schedule Book("
                + "id text primary key autoincrement,"
                +"date text,"
                +"topic text,"
                +"schedule text)";
        private Context mContext;

        public MyDatabaseHelper(Context context,
                                String name,SQLiteDatabase.CursorFactory factory,int version){
            super(context,name,factory,version);
            mContext=context;
        }

        @Override
        public void onCreate(SQLiteDatabase db){
            db.execSQL(CREATE_BOOK);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db,int oldVeirion,int newVersion){

        }
    }
    private MyDatabaseHelper dbHelper;


    dbHelper = new MyDatabaseHelper(this,"Schedule.db",null,1);
    Button add_new=(Button) findViewById(R.id.add_new);

    add_new.setOnClickListener(new View.OnClickListener(){
        @Override
                public void onClick(View v){
            dbHelper.getWritableDatabase();
        }
    });


}