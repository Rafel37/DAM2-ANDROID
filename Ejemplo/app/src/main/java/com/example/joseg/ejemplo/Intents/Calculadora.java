package com.example.joseg.ejemplo.Intents;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.joseg.ejemplo.R;

public class Calculadora extends AppCompatActivity implements View.OnClickListener {

    Button brad;

    LinearLayout linerLayout = null;

    TextView tv;

    double op1 = 0.0, op2 = 0.0;
    String tag = "", tag2 = "";
    boolean flag1 = true, rad = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table);
        istancias();
        acciones(linerLayout);

    }

    public void acciones(ViewGroup padre){
        View elemento;
        for (int i = 0; i<padre.getChildCount();i++){
            elemento = padre.getChildAt(i);
            if (elemento != null && elemento.isClickable())
                elemento.setOnClickListener(this);
            if (padre.getChildAt(i) instanceof ViewGroup)
                acciones((ViewGroup) padre.getChildAt(i));
        }
    }

    private void istancias() {
        brad = findViewById(R.id.bcrad);
        tv = findViewById(R.id.calcresult);
        linerLayout = findViewById(R.id.Llpadrecalc);
    }

    @Override
    public void onClick(View v) {
        int idPulsado = v.getId();
        double dtemp = 0;
        int itemp = 0;

        if (flag1) {
                tv.setText("");
            flag1 = false;
        }

        switch (idPulsado){
            case R.id.bc0:
                if (tag.equals("resultado") || tv.getText().toString().equals("0")) {
                    tv.setText("");
                    tag = "";
                }
                else if (tag.equals("sctr") || tag2.equals("sctr"))
                    break;
                tv.append("0");
                break;
            case R.id.bc1:
                if (tag.equals("resultado")) {
                    tv.setText("");
                    tag = "";
                }
                else if (tag.equals("sctr") || tag2.equals("sctr"))
                    break;
                tv.append("1");
                break;
            case R.id.bc2:
                if (tag.equals("resultado")) {
                    tv.setText("");
                    tag = "";
                }
                else if (tag.equals("sctr") || tag2.equals("sctr"))
                    break;
                tv.append("2");
                break;
            case R.id.bc3:
                if (tag.equals("resultado")) {
                    tv.setText("");
                    tag = "";
                }
                else if (tag.equals("sctr") || tag2.equals("sctr"))
                    break;
                tv.append("3");
                break;
            case R.id.bc4:
                if (tag.equals("resultado")) {
                    tv.setText("");
                    tag = "";
                }
                else if (tag.equals("sctr") || tag2.equals("sctr"))
                    break;
                tv.append("4");
                break;
            case R.id.bc5:
                if (tag.equals("resultado")) {
                    tv.setText("");
                    tag = "";
                }
                else if (tag.equals("sctr") || tag2.equals("sctr"))
                    break;
                tv.append("5");
                break;
            case R.id.bc6:
                if (tag.equals("resultado")) {
                    tv.setText("");
                    tag = "";
                }
                else if (tag.equals("sctr") || tag2.equals("sctr"))
                    break;
                tv.append("6");
                break;
            case R.id.bc7:
                if (tag.equals("resultado")) {
                    tv.setText("");
                    tag = "";
                }
                else if (tag.equals("sctr") || tag2.equals("sctr"))
                    break;
                tv.append("7");
                break;
            case R.id.bc8:
                if (tag.equals("resultado")) {
                    tv.setText("");
                    tag = "";
                }
                else if (tag.equals("sctr") || tag2.equals("sctr"))
                    break;
                tv.append("8");
                break;
            case R.id.bc9:
                if (tag.equals("resultado")) {
                    tv.setText("");
                    tag = "";
                }
                else if (tag.equals("sctr") || tag2.equals("sctr"))
                    break;
                tv.append("9");
                break;
            case R.id.bcmas:
                if (tv.getText().toString().isEmpty())
                    tv.setText("0");
                else if(!tv.getText().toString().equals("-")){
                    if (!tag.equals("sctr"))
                        op1 = Double.valueOf(tv.getText().toString());
                    tv.append("+");
                    tag = "suma";
                }
                flag1 = true;
                break;
            case R.id.bcmenos:
                if (tv.getText().toString().isEmpty() || tv.getText().toString().equals("0")) {
                    tv.setText("-");
                }
                else if(!tv.getText().toString().equals("-")){
                    if (!tag.equals("sctr"))
                        op1 = Double.valueOf(tv.getText().toString());
                    tv.append("-");
                    tag = "resta";
                    flag1 = true;
                }
                break;
            case R.id.bcX:
                if (tv.getText().toString().isEmpty())
                    tv.setText("0");
                else if(!tv.getText().toString().equals("-")){
                    if (!tag.equals("sctr"))
                        op1 = Double.valueOf(tv.getText().toString());
                    tv.append("*");
                    tag = "multiplicacion";
                }
                flag1 = true;
                break;
            case R.id.bcbarra:
                if (tv.getText().toString().isEmpty())
                    tv.setText("0");
                else if(!tv.getText().toString().equals("-")){
                    if (!tag.equals("sctr"))
                        op1 = Double.valueOf(tv.getText().toString());
                    tv.append("/");
                    tag = "division";
                }
                flag1 = true;
                break;
            case R.id.bcporcentaje:
                if (tv.getText().toString().isEmpty())
                    tv.setText("0");
                else if(!tv.getText().toString().equals("-")){
                    if (!tag.equals("sctr"))
                        op1 = Double.valueOf(tv.getText().toString());
                    tv.append("%");
                    tag = "resto";
                }
                flag1 = true;
                break;
            case R.id.bcsen:
                if (tv.getText().toString().isEmpty() || tv.getText().toString().equals("0") || tv.getText().toString().equals("-")) {
                    tv.setText("0");
                    Toast.makeText(getApplicationContext(),getResources().getString(R.string.nodecimales),Toast.LENGTH_SHORT).show();
                    flag1 = true;
                }
                else if (tag.equals("sctr")){
                    if (rad)
                        op1 = Math.sinh(op1);
                    else
                        op1 = Math.sin(op1);
                    tv.setText(String.valueOf("Sen("+tv.getText().toString()+")"));
                }
                else if (tag2.equals("sctr")){
                    if (rad)
                        op2 = Math.sinh(op2);
                    else
                        op2 = Math.sin(op2);
                    tv.setText(String.valueOf("Sen("+tv.getText().toString()+")"));
                }
                else if (tag.equals("suma") || tag.equals("resta") || tag.equals("multiplicacion") || tag.equals("division") || tag.equals("resto")){
                    if (tv.getText().toString().contains(".")) {
                        dtemp = Double.valueOf(tv.getText().toString());
                        if (rad)
                            op2 = Math.sinh(dtemp);
                        else
                            op2 = Math.sin(dtemp);
                        tv.setText(String.valueOf("Sen("+dtemp+")"));
                    }
                    else {
                        itemp = Integer.valueOf(tv.getText().toString());
                        if (rad)
                            op2 = Math.sinh(itemp);
                        else
                            op2 = Math.sin(itemp);
                        tv.setText(String.valueOf("Sen("+itemp+")"));
                    }
                    tag2 = "sctr";
                }
                else {
                    if (tv.getText().toString().contains(".")) {
                        dtemp = Double.valueOf(tv.getText().toString());
                        if (rad)
                            op1 = Math.sinh(dtemp);
                        else
                            op1 = Math.sin(dtemp);
                        tv.setText(String.valueOf("Sen("+dtemp+")"));
                    }
                    else {
                        itemp = Integer.valueOf(tv.getText().toString());
                        if (rad)
                            op1 = Math.sinh(itemp);
                        else
                            op1 = Math.sin(itemp);
                        tv.setText(String.valueOf("Sen("+itemp+")"));
                    }
                    tag = "sctr";
                }
                break;
            case R.id.bccos1:
                if (tv.getText().toString().isEmpty() || tv.getText().toString().equals("0") || tv.getText().toString().equals("-")) {
                    tv.setText("0");
                    flag1 = true;
                }
                else if (tag.equals("sctr")){
                    if (rad)
                        op1 = Math.cosh(op1);
                    else
                        op1 = Math.cos(op1);
                    tv.setText(String.valueOf("Cos("+tv.getText().toString()+")"));
                }
                else if (tag2.equals("sctr")){
                    if (rad)
                        op2 = Math.cosh(op2);
                    else
                        op2 = Math.cos(op2);
                    tv.setText(String.valueOf("Cos("+tv.getText().toString()+")"));
                }
                else if (tag.equals("suma") || tag.equals("resta") || tag.equals("multiplicacion") || tag.equals("division") || tag.equals("resto")) {
                    if (tv.getText().toString().contains(".")) {
                        dtemp = Double.valueOf(tv.getText().toString());
                        if (rad)
                            op2 = Math.cosh(dtemp);
                        else
                            op2 = Math.cos(dtemp);
                        tv.setText(String.valueOf("Cos(" + dtemp + ")"));
                    } else {
                        itemp = Integer.valueOf(tv.getText().toString());
                        if (rad)
                            op2 = Math.cosh(itemp);
                        else
                            op2 = Math.cos(itemp);
                        tv.setText(String.valueOf("Cos(" + itemp + ")"));
                    }
                    tag2 = "sctr";
                }
                else {
                    if (tv.getText().toString().contains(".")) {
                        dtemp = Double.valueOf(tv.getText().toString());
                        if (rad)
                            op1 = Math.cosh(dtemp);
                        else
                            op1 = Math.cos(dtemp);
                        tv.setText(String.valueOf("Cos("+dtemp+")"));
                    }
                    else {
                        itemp = Integer.valueOf(tv.getText().toString());
                        if (rad)
                            op1 = Math.cosh(itemp);
                        else
                            op1 = Math.cos(itemp);
                        tv.setText(String.valueOf("Cos("+itemp+")"));
                    }
                    tag = "sctr";
                }
                break;
            case R.id.bctag:
                if (tv.getText().toString().isEmpty() || tv.getText().toString().equals("0")|| tv.getText().toString().equals("-")) {
                    tv.setText("0");
                    flag1 = true;
                }
                else if (tag.equals("sctr")){
                    if (rad)
                        op1 = Math.tanh(op1);
                    else
                        op1 = Math.tan(op1);
                    tv.setText(String.valueOf("Tag("+tv.getText().toString()+")"));
                }
                else if (tag2.equals("sctr")){
                    if (rad)
                        op2 = Math.tanh(op2);
                    else
                        op1 = Math.tan(op1);
                    tv.setText(String.valueOf("Tag("+tv.getText().toString()+")"));
                }
                else if (tag.equals("suma") || tag.equals("resta") || tag.equals("multiplicacion") || tag.equals("division") || tag.equals("resto")) {
                    if (tv.getText().toString().contains(".")) {
                        dtemp = Double.valueOf(tv.getText().toString());
                        if (rad)
                            op2 = Math.tanh(dtemp);
                        else
                            op1 = Math.tan(dtemp);
                        tv.setText(String.valueOf("Tag(" + dtemp + ")"));
                    } else {
                        itemp = Integer.valueOf(tv.getText().toString());
                        if (rad)
                            op2 = Math.tanh(itemp);
                        else
                            op2 = Math.tan(itemp);
                        tv.setText(String.valueOf("Tag(" + itemp + ")"));
                    }
                    tag2 = "sctr";
                }
                else {
                    if (tv.getText().toString().contains(".")) {
                        dtemp = Double.valueOf(tv.getText().toString());
                        if (rad)
                            op1 = Math.tanh(dtemp);
                        else
                            op1 = Math.tan(dtemp);
                        tv.setText(String.valueOf("Tag("+dtemp+")"));
                    }
                    else {
                        itemp = Integer.valueOf(tv.getText().toString());
                        if (rad)
                            op1 = Math.tanh(itemp);
                        else
                            op1 = Math.tan(itemp);
                        tv.setText(String.valueOf("Tag("+itemp+")"));
                    }
                    tag = "sctr";
                }
                break;
            case R.id.bcfactorial:
                if (tv.getText().toString().isEmpty() || tv.getText().toString().equals("-")) {
                    tv.setText("0");
                    Toast.makeText(getApplicationContext(),getResources().getString(R.string.nodecimales),Toast.LENGTH_SHORT).show();
                    flag1 = true;
                }
                else if (tag.equals("sctr") || tag.equals("sctr") || tv.getText().toString().contains("."))
                    break;
                else {
                    tv.setText(String.valueOf(factorialInt(Integer.valueOf(tv.getText().toString()))));
                }
                break;
            case R.id.bce:
                tv.setText(String.valueOf(Math.E));
                break;
            case R.id.bcpi:
                tv.setText(String.valueOf(Math.PI));
                break;
            case R.id.bcsqr:
                if (tv.getText().toString().isEmpty() || tv.getText().toString().equals("0")|| tv.getText().toString().equals("-")) {
                    tv.setText("0");
                    flag1 = true;
                }
                else if (tag.equals("sctr")){
                    op1 = Math.sqrt(op1);
                    tv.setText(String.valueOf("SQR("+tv.getText().toString()+")"));
                }
                else if (tag2.equals("sctr")){
                    op2 = Math.sqrt(op2);
                    tv.setText(String.valueOf("SQR("+tv.getText().toString()+")"));
                }
                else if (tag.equals("suma") || tag.equals("resta") || tag.equals("multiplicacion") || tag.equals("division") || tag.equals("resto")) {
                    if (tv.getText().toString().contains(".")) {
                        dtemp = Double.valueOf(tv.getText().toString());
                        op2 = Math.sqrt(dtemp);
                        tv.setText(String.valueOf("SQR(" + dtemp + ")"));
                    } else {
                        itemp = Integer.valueOf(tv.getText().toString());
                        op2 = Math.sqrt(itemp);
                        tv.setText(String.valueOf("SQR(" + itemp + ")"));
                    }
                    tag2 = "sctr";
                }
                else {
                    if (tv.getText().toString().contains(".")) {
                        dtemp = Double.valueOf(tv.getText().toString());
                        op1 = Math.sqrt(dtemp);
                        tv.setText(String.valueOf("SQR("+dtemp+")"));
                    }
                    else {
                        itemp = Integer.valueOf(tv.getText().toString());
                        op1 = Math.sqrt(itemp);
                        tv.setText(String.valueOf("SQR("+itemp+")"));
                    }
                    tag = "sctr";
                }
                break;
            case R.id.bcx2:
                if (tv.getText().toString().isEmpty() || tv.getText().toString().equals("0") || tv.getText().toString().equals("-")) {
                    tv.setText("0");
                    flag1 = true;
                }
                else if (tag.equals("sctr")){
                    tv.setText(String.valueOf(Math.pow(op1,2)));
                }
                else if (tag2.equals("sctr")){
                    tv.setText(String.valueOf(Math.pow(op2,2)));
                }
                else {
                    if (tv.getText().toString().contains("."))
                        tv.setText(String.valueOf(Math.pow(Double.valueOf(tv.getText().toString()),2)));
                    else
                        tv.setText(String.valueOf((int) Math.pow(Integer.valueOf(tv.getText().toString()),2)));
                }
                break;
            case R.id.bcrad:
                if (rad) {
                    rad = false;
                    brad.setBackgroundColor(Color.parseColor("#ffffbb33"));
                    brad.setTextColor(Color.WHITE);
                    brad.setText("RAD");
                }
                else {
                    rad = true;
                    brad.setBackgroundColor(Color.WHITE);
                    brad.setTextColor(Color.BLACK);
                    brad.setText("GRA");
                }
                break;
            case R.id.bcpunto:
                if (tv.getText().toString().contains(".") || tag.equals("resultado") || tag.equals("sctr") || tag2.equals("sctr"))
                    break;
                else {
                    if (tv.getText().toString().isEmpty())
                        tv.append("0.");
                    else{
                        tv.append(".");
                    }
                }
                break;
            case R.id.bcigual:
                if (tv.getText().toString().isEmpty() || tv.getText().toString().equals("0") || tv.getText().toString().equals("-")) {
                    Toast.makeText(getApplicationContext(),getResources().getString(R.string.mensaje2),Toast.LENGTH_SHORT).show();
                    tv.setText("0");
                }
                else {
                    if (!tag.equals("sctr") && !tag2.equals("sctr"))
                        op2 = Double.valueOf(tv.getText().toString());
                    if (tag.equals("suma")){
                        tv.setText(String.valueOf(op1 + op2));
                    }
                    else if (tag.equals("resta")) {
                        tv.setText(String.valueOf(op1 - op2));
                    }
                    else if (tag.equals("division")) {
                        if (op2 == 0)
                            tv.setText("No --> n/0");
                        else {
                            tv.setText(String.valueOf(op1 / op2));
                        }
                    }
                    else if (tag.equals("resto")) {
                        if (op2 == 0)
                            tv.setText("No --> n%0");
                        else {
                            tv.setText(String.valueOf(op1 % op2));
                        }
                    }
                    else if (tag.equals("multiplicacion")) {
                        tv.setText(String.valueOf(op1 * op2));
                    }
                    else if (tag.equals("sctr")){
                        tv.setText(String.valueOf(op1));
                    }
                }
                tag = "resultado";
                tag2 = "";
                break;
            case R.id.bcmasbarramenos:
                if (tv.getText().toString().isEmpty() || tv.getText().toString().equals("0")) {
                    tv.setText("0");
                    flag1 = true;
                }
                else if (tag.equals("sctr")){
                    tv.setText(String.valueOf(op1*-1));
                }
                else if (tag2.equals("sctr")){
                    tv.setText(String.valueOf(op2*-1));
                }
                else {
                    if (tv.getText().toString().contains(".")) {
                        dtemp = Double.valueOf(tv.getText().toString());
                        dtemp *= -1;
                        tv.setText(String.valueOf(dtemp));
                    }
                    else {
                        itemp = Integer.valueOf(tv.getText().toString());
                        itemp *= -1;
                        tv.setText(String.valueOf(itemp));
                    }
                }
                break;
            case R.id.bcac:
                tv.setText("0");
                tag = "";
                flag1 = true;
                break;
        }
    }

    private int factorialInt(int num){
        if (num == 0)
            return 1;
        else
            return num*factorialInt(num-1);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("numero",tv.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        tv.setText(savedInstanceState.getString("numero"));
    }
}
