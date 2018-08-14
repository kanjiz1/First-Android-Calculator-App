package com.example.oforkanjiodekpe.calculator_coursework;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.fathzer.soft.javaluator.*;

import java.util.Iterator;

public class MainActivity extends AppCompatActivity {

    private Button button1, button2, button3, button4, button5, button6, button7, button8, button9;
    private Button button0, buttonSine, buttonCosine, buttonTan, buttonOpenBracket, buttonExp;
    private Button buttonCloseBracket, buttonLog, buttonSqrt, buttonSq, buttonClear, buttonEnter;
    private Button buttonBackSpace, buttonChangeSign, buttonAdd, buttonSubtract, buttonMultiply;
    private Button buttonDivide, buttonDecimal;
    private TextView result, info;

    public static final Function SQRT = new Function("sqrt", 1);
    public static final Function SQUARE = new Function("sq", 1);
    public static final Function SINE = new Function("sin", 1);
    public static final Function COSINE = new Function("cos", 1);
    public static final Function TANGENT = new Function("tan", 1);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupUIView();

        Parameters params = DoubleEvaluator.getDefaultParameters();
        params.add(SQRT);
        params.add(SQUARE);
        params.addExpressionBracket(BracketPair.BRACKETS);

        final DoubleEvaluator evaluator = new DoubleEvaluator(params) {
            @Override
            protected Double evaluate(Function function, Iterator<Double> arguments, Object evaluationContext) {
                if (function == SQRT) {
                    return Math.sqrt(arguments.next());
                } else if(function == SQUARE){
                    return Math.pow(arguments.next(), 2);
                }else if(function == SINE){
                    return Math.sin(Math.toRadians(arguments.next()));
                } else if (function == COSINE){
                    return Math.cos(Math.toRadians(arguments.next()));
                } else if (function == TANGENT){
                    return Math.tan(Math.toRadians(arguments.next()));
                }
                else {
                    return super.evaluate(function, arguments, evaluationContext);
                }
            }
        };

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString() + "0");
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString() + "1");
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString() + "2");
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString() + "3");
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString() + "4");
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString() + "5");
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString() + "6");
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString() + "7");
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString() + "8");
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString() + "9");
            }
        });

        buttonDecimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!info.getText().toString().contains(".")){
                    info.setText(info.getText().toString() + ".");
                }
            }
        });

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString()+ "+");
            }
        });

        buttonSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString()+ "-");
            }
        });

        buttonDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString()+ "/");
            }
        });

        buttonMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString()+ "*");
            }
        });

        buttonBackSpace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(info.getText().length() > 0){
                    CharSequence name = info.getText().toString();
                    info.setText(name.subSequence(0, name.length() - 1));
                } else {
                    info.setText(null);
                }
            }
        });

        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(null);
                result.setText(null);
            }
        });

        buttonSine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString() + "sin");
            }
        });

        buttonCosine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString() + "cos");
            }
        });

        buttonTan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString()+ "tan");
            }
        });

        buttonOpenBracket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString() + "(");
            }
        });

        buttonExp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString() + "^");
            }
        });


        buttonCloseBracket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText()+ ")");
            }
        });

        buttonLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString() + "ln");
            }
        });

        buttonSqrt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString()+ "sqrt");
            }
        });

        buttonSq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString() + "sq");
            }
        });

        buttonChangeSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(info.getText().length() > 0) {
                    if (info.getText().toString().contains("-")) {
                        StringBuilder name = new StringBuilder(info.getText().toString());
                        name.deleteCharAt(0);
                        info.setText(name);
                    } else {
                        StringBuilder name = new StringBuilder(info.getText().toString());
                        name.insert(0, "-");
                        info.setText(name);
                    }
                }
                else {
                    info.setText(info.getText().toString() + "-");
                }
            }
        });

        buttonEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double answer = evaluator.evaluate(info.getText().toString());
                result.setText(String.valueOf(answer));
            }
        });

    }

    private void setupUIView(){
        button0 = (Button)findViewById(R.id.button0);
        button1 = (Button)findViewById(R.id.button1);
        button2 = (Button)findViewById(R.id.button2);
        button3 = (Button)findViewById(R.id.button3);
        button4 = (Button)findViewById(R.id.button4);
        button5 = (Button)findViewById(R.id.button5);
        button6 = (Button)findViewById(R.id.button6);
        button7 = (Button)findViewById(R.id.button7);
        button8 = (Button)findViewById(R.id.button8);
        button9 = (Button)findViewById(R.id.button9);
        buttonSine = (Button)findViewById(R.id.buttonSine);
        buttonChangeSign = (Button)findViewById(R.id.buttonChangeSign);
        buttonCosine = (Button)findViewById(R.id.buttonCosine);
        buttonTan = (Button)findViewById(R.id.buttonTan);
        buttonOpenBracket = (Button)findViewById(R.id.buttonOpenBracket);
        buttonCloseBracket = (Button)findViewById(R.id.buttonCloseBracket);
        buttonClear = (Button)findViewById(R.id.buttonClear);
        buttonEnter = (Button)findViewById(R.id.buttonEnter);
        buttonExp = (Button)findViewById(R.id.buttonExp);
        buttonLog = (Button)findViewById(R.id.buttonLog);
        buttonSqrt = (Button)findViewById(R.id.buttonSqrt);
        buttonSq = (Button)findViewById(R.id.buttonSquare);
        buttonBackSpace = (Button)findViewById(R.id.buttonBackSpace);
        buttonAdd = (Button)findViewById(R.id.buttonAdd);
        buttonSubtract = (Button)findViewById(R.id.buttonSubtract);
        buttonMultiply = (Button)findViewById(R.id.buttonMultiply);
        buttonDecimal = (Button)findViewById(R.id.buttonDecimal);
        buttonDivide = (Button)findViewById(R.id.buttonDivide);
        result = (TextView)findViewById(R.id.resultTextView);
        info = (TextView) findViewById(R.id.infoTextView);
    }

}
