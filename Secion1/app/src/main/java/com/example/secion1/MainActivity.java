package com.example.secion1;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    TextView Prueba;
    EditText Nombre;
    EditText Correo;
    EditText Cuenta;
    Button mBtnFec;
    Button mBTnPros;


    int mes;
    int dia;
    int an;

    Calendar c;
    DatePickerDialog dpd;

    //validacion
    Pattern par = Pattern
            .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Nombre = findViewById(R.id.nombre);
        Correo = findViewById(R.id.correo);
        Cuenta = findViewById(R.id.cuenta);
        mBTnPros = (Button) findViewById(R.id.Procesar);
        Prueba = (TextView) findViewById(R.id.Fecha);
        mBtnFec = (Button) findViewById(R.id.calcular);
        mBtnFec.setOnClickListener( new View.OnClickListener(){

            public void onClick(View view){
                    c= Calendar.getInstance();
                    dia = c.get(Calendar.DAY_OF_MONTH);
                    mes = c.get(Calendar.MONTH);
                     an = c.get(Calendar.YEAR);

                    dpd = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener(){
                        public void onDateSet(DatePicker datePicker, int mAn,int mMes, int mDia){
                            Prueba.setText("Fecha de nacimiento: "+mAn+"/"+(mMes)+"/"+mDia);
                            an=mAn;
                            mes=mMes;
                            dia=mDia;
                    }
                },dia,mes,an);
                dpd.show();
            }
        }
        );
        final String Signo = calcularSigno(an,mes,dia);
        String nombreV= Nombre.getText().toString();
        mBTnPros.setOnClickListener( new View.OnClickListener() {
                public void onClick(View view) {
                    if (!Nombre.getText().toString().isEmpty()&&dia!=0&&mes!=0&&an!=0&&!Correo.getText().toString().isEmpty()&&!Cuenta.getText().toString().isEmpty()) {
                        if((2019-an)<80 &&(2019-an)>10) {
                            Matcher mather = par.matcher(Correo.getText().toString());

                            if (mather.find() == true) {
                                if(Cuenta.getText().toString().length()==10) {

                                    Intent i = new Intent(MainActivity.this, RespuestaActivity.class);
                                    i.putExtra("Nombre", Nombre.getText().toString());
                                    i.putExtra("Edad", String.valueOf(2019 - an));
                                    i.putExtra("Signo", Signo);
                                    startActivity(i);
                                }else{
                                    Toast.makeText(MainActivity.this, "numero de cuenta invalido", Toast.LENGTH_SHORT).show();
                                }
                            }else{
                                Toast.makeText(MainActivity.this, "Correo invalido", Toast.LENGTH_SHORT).show();
                            }
                        }else{
                            Toast.makeText(MainActivity.this, "Edad invalida", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(MainActivity.this, "Completar datos", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        );
    }

    public String  calcularSigno(int anV,int mesV, int diaV) {
        if ((2019 - an) < 80) {
            return "Perro –Metal";
        }else if ((((2019 - an) > 61)||(mesV >1)) && (((2019 - an) > 62)||(mesV >0))){ return "Perro –Tierra";
        }else if ((((2019 - an) > 60)||(mesV >1)) && (((2019 - an) > 61)||(mesV >0))){ return "Cerdo –Tierra";
        }else if ((((2019 - an) > 59)||(mesV >1)) && (((2019 - an) > 60)||(mesV >0))){ return "Rata –Metal";
        }else if ((((2019 - an) > 58)||(mesV >1)) && (((2019 - an) > 59)||(mesV >0))){ return "Buey –Metal";
        }else if ((((2019 - an) > 57)||(mesV >1)) && (((2019 - an) > 58)||(mesV >0))){ return "Tigre –Agua";
        }else if ((((2019 - an) > 56)||(mesV >1)) && (((2019 - an) > 57)||(mesV >0))){ return "Conejo –Agua";
        }else if ((((2019 - an) > 55)||(mesV >1)) && (((2019 - an) > 56)||(mesV >0))){ return "Dragón –Madera";
        }else if ((((2019 - an) > 54)||(mesV >1)) && (((2019 - an) > 55)||(mesV >0))){ return "Serpiente –Madera";
        }else if ((((2019 - an) > 53)||(mesV >1)) && (((2019 - an) > 54)||(mesV >0))){ return "Caballo –Fuego";
        }else if ((((2019 - an) > 52)||(mesV >1)) && (((2019 - an) > 53)||(mesV >0))){ return "Cabra –Fuego";
        }else if ((((2019 - an) > 51)||(mesV >1)) && (((2019 - an) > 52)||(mesV >0))){ return "Mono –Tierra";
        }else if ((((2019 - an) > 50)||(mesV >1)) && (((2019 - an) > 51)||(mesV >0))){ return "Gallo –Tierra";
        }else if ((((2019 - an) > 49)||(mesV >1)) && (((2019 - an) > 50)||(mesV >0))){ return "Perro –Metal";
        }else if ((((2019 - an) > 48)||(mesV >1)) && (((2019 - an) > 49)||(mesV >0))){ return "Cerdo –Metal";
        }else if ((((2019 - an) > 47)||(mesV >1)) && (((2019 - an) > 48)||(mesV >0))){ return "Rata –Agua";
        }else if ((((2019 - an) > 46)||(mesV >1)) && (((2019 - an) > 47)||(mesV >0))){ return "Buey –Agua";
        }else if ((((2019 - an) > 45)||(mesV >1)) && (((2019 - an) > 46)||(mesV >0))){ return "Tigre –Madera";
        }else if ((((2019 - an) > 44)||(mesV >1)) && (((2019 - an) > 45)||(mesV >0))){ return "Conejo –Madera";
        }else if ((((2019 - an) > 43)||(mesV >1)) && (((2019 - an) > 44)||(mesV >0))){ return "Dragón –Fuego";
        }else if ((((2019 - an) > 42)||(mesV >1)) && (((2019 - an) > 43)||(mesV >0))){ return "Serpiente –Fuego";
        }else if ((((2019 - an) > 41)||(mesV >1)) && (((2019 - an) > 42)||(mesV >0))){ return "Caballo –Tierra";
        }else if ((((2019 - an) > 40)||(mesV >1)) && (((2019 - an) > 41)||(mesV >0))){ return "Cabra –Tierra";
        }else if ((((2019 - an) > 39)||(mesV >1)) && (((2019 - an) > 40)||(mesV >0))){ return "Mono –Metal";
        }else if ((((2019 - an) > 38)||(mesV >1)) && (((2019 - an) > 39)||(mesV >0))){ return "Gallo –Metal";
        }else if ((((2019 - an) > 37)||(mesV >1)) && (((2019 - an) > 38)||(mesV >0))){ return "Perro –Agua";
        }else if ((((2019 - an) > 36)||(mesV >1)) && (((2019 - an) > 37)||(mesV >0))){ return "Cerdo –Agua";
        }else if ((((2019 - an) > 35)||(mesV >1)) && (((2019 - an) > 36)||(mesV >0))){ return "Rata –Madera";
        }else if ((((2019 - an) > 34)||(mesV >1)) && (((2019 - an) > 35)||(mesV >0))){ return "Buey –Madera";
        }else if ((((2019 - an) > 33)||(mesV >1)) && (((2019 - an) > 34)||(mesV >0))){ return "Tigre –Fuego";
        }else if ((((2019 - an) > 32)||(mesV >1)) && (((2019 - an) > 33)||(mesV >0))){ return "Conejo –Fuego";
        }else if ((((2019 - an) > 31)||(mesV >1)) && (((2019 - an) > 32)||(mesV >0))){ return "Dragón –Tierra";
        }else if ((((2019 - an) > 30)||(mesV >1)) && (((2019 - an) > 31)||(mesV >0))){ return "Serpiente –Tierra";
        }else if ((((2019 - an) > 29)||(mesV >1)) && (((2019 - an) > 30)||(mesV >0))){ return "Caballo –Metal";
        }else if ((((2019 - an) > 28)||(mesV >1)) && (((2019 - an) > 29)||(mesV >0))){ return "Cabra –Metal";
        }else if ((((2019 - an) > 27)||(mesV >1)) && (((2019 - an) > 28)||(mesV >0))){ return "Mono –Agua";
        }else if ((((2019 - an) > 26)||(mesV >1)) && (((2019 - an) > 27)||(mesV >0))){ return "Gallo –Agua";
        }else if ((((2019 - an) > 25)||(mesV >1)) && (((2019 - an) > 26)||(mesV >0))){ return "Perro –Madera";
        }else if ((((2019 - an) > 24)||(mesV >1)) && (((2019 - an) > 25)||(mesV >0))){ return "Cerdo –Madera";
        }else if ((((2019 - an) > 23)||(mesV >1)) && (((2019 - an) > 24)||(mesV >0))){ return "Rata –Fuego";
        }else if ((((2019 - an) > 22)||(mesV >1)) && (((2019 - an) > 23)||(mesV >0))){ return "Buey –Fuego";
        }else if ((((2019 - an) > 21)||(mesV >1)) && (((2019 - an) > 22)||(mesV >0))){ return "Tigre –Tierra";
        }else if ((((2019 - an) > 20)||(mesV >1)) && (((2019 - an) > 21)||(mesV >0))){ return "Conejo –Tierra";
        }else if ((((2019 - an) > 19)||(mesV >1)) && (((2019 - an) > 20)||(mesV >0))){ return "Dragón –Metal";
        }else if ((((2019 - an) > 18)||(mesV >1)) && (((2019 - an) > 19)||(mesV >0))){ return "Serpiente –Metal";
        }else if ((((2019 - an) > 17)||(mesV >1)) && (((2019 - an) > 18)||(mesV >0))){ return "Caballo –Agua";
        }else if ((((2019 - an) > 16)||(mesV >1)) && (((2019 - an) > 17)||(mesV >0))){ return "Cabra –Agua";
        }else if ((((2019 - an) > 15)||(mesV >1)) && (((2019 - an) > 16)||(mesV >0))){ return "Mono –Madera";
        }else if ((((2019 - an) > 14)||(mesV >1)) && (((2019 - an) > 15)||(mesV >0))){ return "Gallo –Madera";
        }else if ((((2019 - an) > 13)||(mesV >1)) && (((2019 - an) > 14)||(mesV >0))){ return "Perro –Fuego";
        }else if ((((2019 - an) > 12)||(mesV >1)) && (((2019 - an) > 13)||(mesV >0))){ return "Cerdo –Fuego";
        }else if ((((2019 - an) > 11)||(mesV >1)) && (((2019 - an) > 12)||(mesV >0))){ return "Rata – Tierra";
        }else if ((((2019 - an) > 10)||(mesV >1)) && (((2019 - an) > 11)||(mesV >0))){ return "Buey – Tierra";
        }else if ((((2019 - an) > 9)||(mesV >1)) && (((2019 - an) > 10)||(mesV >0))){ return "Tigre – Metal";
        }else if ((((2019 - an) > 8)||(mesV >1)) && (((2019 - an) > 9)||(mesV >0))){ return "Conejo-Metal";
        }else if ((((2019 - an) > 7)||(mesV >1)) && (((2019 - an) > 8)||(mesV >0))){ return "Dragón -Agua";
        }else if ((((2019 - an) > 6)||(mesV >1)) && (((2019 - an) > 7)||(mesV >0))){ return "Serpiente -Agua";
        }else if ((((2019 - an) > 5)||(mesV >1)) && (((2019 - an) > 6)||(mesV >0))){ return "Caballo -Madera";
        }else if ((((2019 - an) > 4)||(mesV >1)) && (((2019 - an) > 5)||(mesV >0))){ return "Cabra -Madera";
        }else if ((((2019 - an) > 3)||(mesV >1)) && (((2019 - an) > 4)||(mesV >0))){ return "Mono -Fuego";
        }else if ((((2019 - an) > 2)||(mesV >1)) && (((2019 - an) > 3)||(mesV >0))){ return "Gallo -Fuego";
        }else if ((((2019 - an) > 1)||(mesV >1)) && (((2019 - an) > 2)||(mesV >0))){ return "Perro -Tierra";
        }else if ((((2019 - an) > 0)||(mesV >1)) && (((2019 - an) > 1)||(mesV >0))) {
            return "Cerdo -Tierra";
        }
            return "";
    }



}
