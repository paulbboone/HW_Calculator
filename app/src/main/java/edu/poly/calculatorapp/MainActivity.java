package edu.poly.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    private TextView text_view;
    private String input, answer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text_view=(TextView) findViewById(R.id.text_view);
    }

    public void ButtonClick(View view){
        Button button=(Button) view;
        String data=button.getText().toString();

        switch (data){
            case "AC":
                input="";
                break;
            case "C":
                if(input.length()>0){
                    String newText=input.substring(0,input.length()-1);
                    input=newText;
                }

                break;
            case "=":
                Calculate();
                answer=input;
                break;
            case "X":
                Calculate();
                input+="*";
                break;
            default:
                if(input==null){
                    input="";
                }
                if(data.equals("+") || data.equals("-") ||data.equals("/") ){
                    //in ra ket qua
                    Calculate();

                }
                input+=data;
        }
        text_view.setText(input);
    }

    public void Calculate(){

        if(input.split("\\*").length==2){
            String number[] = input.split("\\*");
            try{
                double mul = Double.parseDouble(number[0])*Double.parseDouble(number[1]);
                input = mul+"";
            }catch (Exception e){

            }}
            if(input.split("\\/").length==2){
                String number[] = input.split("\\/");
                try{
                    double div = Double.parseDouble(number[0])/Double.parseDouble(number[1]);
                    input = div+"";
                }catch (Exception e){

                }
            }
            if(input.split("\\+").length==2){
                String number[] = input.split("\\+");
                try{
                    double sum = Double.parseDouble(number[0])+Double.parseDouble(number[1]);
                    input = sum+"";
                }catch (Exception e){

                }
            }
            if(input.split("\\-").length==2){
                String number[] = input.split("\\-");
                try{
                    double sub = Double.parseDouble(number[0])-Double.parseDouble(number[1]);
                    input = sub+"";
                }catch (Exception e){

                }
            }

            String n[] = input.split("\\.");
            if (n.length > 1){
                if (n[1].equals("0")){
                    input = n[0];
                }
            }

    }
}