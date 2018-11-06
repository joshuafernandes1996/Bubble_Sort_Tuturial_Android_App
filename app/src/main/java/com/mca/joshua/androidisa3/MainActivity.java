package com.mca.joshua.androidisa3;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    Button next;
    TextView tut,one,two,three,four,five,pass,check,check2,check3,check4,scroll;
    int step=1;
    ImageView left,right,left2,right2,left3,right3,left4,right4,finish,arrow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("Bubble Sort Tutorial");
        getElements();


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                step++;
                if(step==2){
                    tut.setText("Here, algorithm compares the first two elements, and swaps since 5 > 1.");
                    left.setVisibility(View.VISIBLE);
                    right.setVisibility(View.VISIBLE);
                }

                if(step==3){
                    left.setVisibility(View.INVISIBLE);
                    right.setVisibility(View.INVISIBLE);
                    left2.setVisibility(View.VISIBLE);
                    right2.setVisibility(View.VISIBLE);
                    swap(one,two);
                    add(one,two,pass);
                    tut.setText("Here, algorithm compares the next two elements, and swaps since 5 > 4.");

                }

                if(step==4){
                    left2.setVisibility(View.INVISIBLE);
                    right2.setVisibility(View.INVISIBLE);
                    left3.setVisibility(View.VISIBLE);
                    right3.setVisibility(View.VISIBLE);
                    swap(two,three);
                    add(two,three,pass);
                    scroll.setVisibility(View.VISIBLE);
                    arrow.setVisibility(View.VISIBLE);
                    tut.setText("Here, algorithm compares the next two elements, and swaps since 5 > 2.");

                }

                if(step==5){
                    left3.setVisibility(View.INVISIBLE);
                    right3.setVisibility(View.INVISIBLE);
                    swap(three,four);
                    add(three,four,pass);
                    check.setVisibility(View.VISIBLE);
                    tut.setText("Now, since these elements are already in order (8 > 5), algorithm does not swap them.");

                }

                if(step==6){
                    tut.setText("This was the end of First Pass. Click Next to begin the Second Pass");
                }


                if(step==7){
                    pass.setText("Second Pass");
                    tut.setText("......");

                }

                if(step==8){
                    check.setVisibility(View.INVISIBLE);
                    check2.setVisibility(View.VISIBLE);
                    one.setBackgroundColor(Color.GREEN);
                    tut.setText("No Change since (4 > 1), algorithm does not swap them.");
                }

                if(step==9){
                    check2.setVisibility(View.INVISIBLE);
                    left4.setVisibility(View.VISIBLE);
                    right4.setVisibility(View.VISIBLE);
                    tut.setText("Swap since 4 > 2");
                }

                if(step==10){
                    left4.setVisibility(View.INVISIBLE);
                    right4.setVisibility(View.INVISIBLE);
                    check3.setVisibility(View.VISIBLE);
                    swap(two,three);
                    add(two,three,pass);
                    two.setBackgroundColor(Color.GREEN);
                    tut.setText("No Change since (5 > 4), algorithm does not swap them.");
                }

                if(step==11){
                    check3.setVisibility(View.INVISIBLE);
                    check4.setVisibility(View.VISIBLE);
                    three.setBackgroundColor(Color.GREEN);
                    tut.setText("No Change since (8 > 5), algorithm does not swap them.");
                }

                if(step==12){
                    check4.setVisibility(View.INVISIBLE);
                    four.setBackgroundColor(Color.GREEN);
                    five.setBackgroundColor(Color.GREEN);
                    tut.setText("Now, the array is already sorted, but our algorithm does not know if it is completed. The algorithm needs one whole pass without any swap to know it is sorted.");
                }

                if(step==13){
                    pass.setText("Third Pass");
                    tut.setText("Algorithm Repeats the process to see if any swap is needed. Since all the numbers are in order Bubble Sort is Completed");
                }

                if(step==14){
                    tut.setText("Bubble Sort Completed");
                    finish.setVisibility(View.VISIBLE);
                }


            }
        });





    }

    private void add(TextView one, TextView two, TextView pass) {
        LayoutInflater inflator = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        LinearLayout Container = (LinearLayout)findViewById(R.id.cont);
        View v = inflator.inflate(R.layout.single, null);
        TextView a,b,stat;
        a=v.findViewById(R.id.a);
        b=v.findViewById(R.id.b);
        stat=v.findViewById(R.id.stat);
        a.setText(one.getText().toString());
        b.setText(two.getText().toString());
        stat.setText(pass.getText().toString()+" Swapping");
        Container.addView(v);

        ScrollView sv = (ScrollView)findViewById(R.id.scr);
        sv.scrollTo(0, sv.getBottom());


    }

    private void swap(TextView one, TextView two) {
        String v1=one.getText().toString();
        String v2=two.getText().toString();

        one.setText(v2);
        two.setText(v1);
    }

    private void getElements() {
        next=findViewById(R.id.next);
        tut=findViewById(R.id.tut);
        left=findViewById(R.id.left);
        right=findViewById(R.id.right);
        left2=findViewById(R.id.left2);
        right2=findViewById(R.id.right2);
        left3=findViewById(R.id.left3);
        right3=findViewById(R.id.right3);
        left4=findViewById(R.id.left4);
        right4=findViewById(R.id.right4);
        one=findViewById(R.id.one);
        two=findViewById(R.id.two);
        three=findViewById(R.id.three);
        four=findViewById(R.id.four);
        five=findViewById(R.id.five);
        pass=findViewById(R.id.pass);
        check=findViewById(R.id.check);
        check2=findViewById(R.id.check2);
        check3=findViewById(R.id.check3);
        check4=findViewById(R.id.check4);
        finish=findViewById(R.id.finish);
        scroll=findViewById(R.id.scroll);
        arrow=findViewById(R.id.arrow);
    }
}
