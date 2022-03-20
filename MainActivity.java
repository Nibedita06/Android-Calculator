package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView ip, op;
    double res = 0.0, num = 0.0;
    double fact = 1.0;
    char lstopr = '+';
    double adj = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ip = findViewById(R.id.txtIp);
        op = findViewById(R.id.txtOp);
    }
    private void reset() {
        num = 0.0;
        fact = 1;
        adj = 1;
    }
    private void nextPos() {
        if (fact < 1)   fact /= 10.0;
    }
    public void btnOne(View vi1) {
        ip.append("1");
        num = (num * adj * 10.0) + (fact * 1);
        nextPos();
    }
    public void btnTwo(View vi2) {
        ip.append("2");
        num = (num * adj * 10.0) + (fact * 2);
        nextPos();
    }
    public void btnThree(View vi3) {
        ip.append("3");
        num = (num * adj * 10.0) + (fact * 3);
        nextPos();
    }
    public void btnFour(View vi4) {
        ip.append("4");
        num = (num * adj * 10.0) + (fact * 4);
        nextPos();
    }
    public void btnFive(View vi5) {
        ip.append("5");
        num = (num * adj * 10) + (fact * 5);
        nextPos();
    }
    public void btnSix(View vi6) {
        ip.append("6");
        num = (num * adj * 10) + (fact * 6);
        nextPos();
    }
    public void btnSeven(View vi7) {
        ip.append("7");
        num = (num * adj * 10.0) + (fact * 7);
        nextPos();
    }
    public void btnEight(View vi8) {
        ip.append("8");
        num = (num * adj * 10.0) + (fact * 8);
        nextPos();
    }
    public void btnNine(View vi9) {
        ip.append("9");
        num = (num * adj * 10.0) + (fact * 9);
        nextPos();
    }
    public void btnZero(View vi0) {
        ip.append("0");
        num = (num * adj * 10) + 0;
        if (fact < 1)   fact /= 10.0;
    }
    public void  btnAdd(View viAdd) {
        System.out.println(lstopr);
        ip.append("+");
        if (res == 0)   {
            System.out.println("#");
            res = num;
            lstopr = '+';
        }
        else if (lstopr == '+') {
            res += num;
            lstopr = '+';
        }
        else if (lstopr == '-')  {
            res -= num;
            lstopr = '+';
        }
        else if (lstopr == 'x')  {
            lstopr = '+';
            res *= num;

        }
        else if (lstopr == '/') {
            lstopr = '+';
            res /= num;
        }
        reset();
    }
    public void btnSub(View viSub) {
        ip.append("-");
        if (res == 0) {
            res = num;
            lstopr = '-';
        }
        else if (lstopr == '+') {
            res += num;
            lstopr = '-';
        }
        else if (lstopr == '-')  {
            res -= num;
            lstopr = '-';
        }
        else if (lstopr == 'x')  {
            lstopr = '-';
            res *= num;

        }
        else if (lstopr == '/') {
            lstopr = '-';
            res /= num;
        }
        reset();
    }
    public void btnMul(View viMul) {
        ip.append("x");
        if (res == 0) {
            lstopr = 'x';
            res = num;
        }
        else if (lstopr == '+') {
            res += num;
            lstopr = 'x';
        }
        else if (lstopr == '-')  {
            res -= num;
            lstopr = 'x';
        }
        else if (lstopr == 'x')  {
            lstopr = 'x';
            res *= num;
        }
        else if (lstopr == '/') {
            lstopr = 'x';
            res /= num;
        }
        reset();
    }
    public void btnDiv(View viDel) {
        ip.append("/");
        if (res == 0)   {
            res = num;
            lstopr = '/';
        }
        else if (lstopr == '+') {
            res += num;
            lstopr = '/';
        }
        else if (lstopr == '-')  {
            res -= num;
            lstopr = '/';
        }
        else if (lstopr == 'x')  {
            lstopr = '/';
            res *= num;

        }
        else if (lstopr == '/') {
            lstopr = '/';
            res /= num;
        }
        reset();
    }
    public void btnEq(View viEq) {

        if (res == 0.0) op.setText(String.valueOf(num));
        if (lstopr == '+')   res += num;
        else if (lstopr == '-')  res -= num;
        else if (lstopr == 'x')  {
            res *= num;

        }
        else if (lstopr == '/') res /= num;
        op.setText(String.valueOf(((long)((res * 10000) + 0.5))/10000.0));
        btnClr(viEq);
        res = 0.0;
        reset();
    }
    public void btnDec(View viDec) {
        if (fact < 0)   return;
        fact = 0.1;
        adj = 0.1;
        ip.append(".");
    }
    public void btnClr(View viClr) {
        reset();
        res = 0;
        lstopr = '+';
        ip.setText(null);
    }
    public void Bs(View viBs) {
        res = 0;
        lstopr = '+';
        reset();
        op.setText(null);
    }
}
