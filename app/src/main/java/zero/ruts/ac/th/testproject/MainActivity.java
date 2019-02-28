package zero.ruts.ac.th.testproject;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Map;

public class MainActivity extends AppCompatActivity {

    public FirebaseDatabase fireebaseDatabase;
    public DatabaseReference LED1,LED2,LED3,LED4,Refer,Refer2;
    //public static final String TAG ="LEDs control";
    public Button Switch,Switch2,Switch3,Switch4;
    public Integer Value1,Value0,Value2,Value3,Value4;
    public TextView Tname,text1,text2,text3,text4;
    public String Data;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //เรียก database Referrences ให้ตรงกับที่อยู่บน firebase
        fireebaseDatabase = FirebaseDatabase.getInstance();
        LED1 = fireebaseDatabase.getReference("SWITCH_LED1");
        LED2 = fireebaseDatabase.getReference("SWITCH_LED2");
        LED3 = fireebaseDatabase.getReference("SWITCH_LED3");
        LED4 = fireebaseDatabase.getReference("SWITCH_LED4");
        //LED = firebaseDatabase.getReference("Dev/switch");

        Refer = fireebaseDatabase.getReference();
        Refer2 = fireebaseDatabase.getReference();

        Switch = (Button) findViewById(R.id.Led1);

        Tname = (TextView) findViewById(R.id.tname);
        text1 = (TextView) findViewById(R.id.t2);
        text2 = (TextView) findViewById(R.id.t3);
        text3 = (TextView) findViewById(R.id.t4);
        text4 = (TextView) findViewById(R.id.t5);

        Refer.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Map map = (Map) dataSnapshot.getValue();
                Data = String.valueOf(map.get("NAME"));
                Tname.setText(Data);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        Refer2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Map map = (Map) dataSnapshot.getValue();
                Data = String.valueOf(map.get("SWITCH_LED1"));
                text1.setText(Data);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        Refer2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Map map = (Map) dataSnapshot.getValue();
                Data = String.valueOf(map.get("SWITCH_LED2"));
                text2.setText(Data);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        Refer2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Map map = (Map) dataSnapshot.getValue();
                Data = String.valueOf(map.get("SWITCH_LED3"));
                text3.setText(Data);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        Refer2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Map map = (Map) dataSnapshot.getValue();
                Data = String.valueOf(map.get("SWITCH_LED4"));
                text4.setText(Data);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        Switch = (Button) findViewById(R.id.Led1);
        LED1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
               Value1 = dataSnapshot.getValue(Integer.class);
               //Log.d(TAG,"Value is"+Value1);
               if (Value1==1){
                   Switch.setText("LED1_ON");
                   Value0=0;
               }
               else {
                   Switch.setText("LED1_OFF");
                   Value0=1;
               }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            //Log.w(TAG,"Failed", databaseError.toException());
            }
        });
        Switch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LED1.setValue(Value0);

            }
    });
        Switch2 = (Button) findViewById(R.id.Led2);
        LED2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Value1 = dataSnapshot.getValue(Integer.class);
                //Log.d(TAG,"Value is"+Value1);
                if (Value1==1){
                    Switch2.setText("LED2_ON");
                    Value2=0;
                }
                else {
                    Switch2.setText("LED2_OFF");
                    Value2=1;
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                //Log.w(TAG,"Failed", databaseError.toException());
            }
        });
        Switch2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LED2.setValue(Value2);

            }
        });

        Switch3 = (Button) findViewById(R.id.Led3);
        LED3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Value1 = dataSnapshot.getValue(Integer.class);
                //Log.d(TAG,"Value is"+Value1);
                if (Value1==1){
                    Switch3.setText("LED3_ON");
                    Value3=0;
                }
                else {
                    Switch3.setText("LED3_OFF");
                    Value3=1;
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                //Log.w(TAG,"Failed", databaseError.toException());
            }
        });
        Switch3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LED3.setValue(Value3);

            }
        });

        Switch4 = (Button) findViewById(R.id.Led4);
        LED4.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Value1 = dataSnapshot.getValue(Integer.class);
                //Log.d(TAG,"Value is"+Value1);
                if (Value1==1){
                    Switch4.setText("LED4_ON");
                    Value4=0;
                }
                else {
                    Switch4.setText("LED4_OFF");
                    Value4=1;
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                //Log.w(TAG,"Failed", databaseError.toException());
            }
        });
        Switch4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LED4.setValue(Value4);

            }
        });
    }
}
