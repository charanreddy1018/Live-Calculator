package com.example.my_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.lang.Math;

import java.util.Scanner;

public class MainActivity extends AppCompatActivity {
    Scanner sc = new Scanner(System.in);
    float x=0,dec=0;
    float y=0;
    int l=0;//count for determining operators
    int m=0;
    boolean z=true;//for determining x and y
    boolean h=true;//for dot function
    int k=0;//count for dot
    String str1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn1,btn4,btn5,btn6,btn7,btn8,btn9,btn10,btn11,btn12,btn13,btn14,btn15,btn16,btn17,btn18,btn20;
        final TextView text1,text2;
        text1 = (TextView) findViewById(R.id.Text1);
        text2 = (TextView) findViewById(R.id.Text2);
        btn1 = (Button) findViewById(R.id.button_c);
        btn4 = (Button) findViewById(R.id.button_div);
        btn5 = (Button) findViewById(R.id.button_7);
        btn6 = (Button) findViewById(R.id.button_8);
        btn7 = (Button) findViewById(R.id.button_9);
        btn8 = (Button) findViewById(R.id.button_X);
        btn9 = (Button) findViewById(R.id.button_4);
        btn10 = (Button) findViewById(R.id.button_5);
        btn11 = (Button) findViewById(R.id.button_6);
        btn12 = (Button) findViewById(R.id.button_sub);
        btn13 = (Button) findViewById(R.id.button_1);
        btn14 = (Button) findViewById(R.id.button_2);
        btn15 = (Button) findViewById(R.id.button_3);
        btn16 = (Button) findViewById(R.id.button_add);
        btn17 = (Button) findViewById(R.id.button_dot);
        btn18 = (Button) findViewById(R.id.button_0);
        btn20 = (Button) findViewById(R.id.button_sol);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (z == true)
                {
                    x = (x - (x%10))/10;
                    text1.setText(String.valueOf((int) x));
                }
                else
                {
                    if(y==0)
                    {
                            if(x==0)
                            {
                                z=true;
                                l=0;
                                y=0;
                            }
                        text1.setText(String.valueOf(x));
                        text2.setText(String.valueOf(x));
                        x = (x - (x%10))/10;

                    }
                    else
                        {
                            y = (y - (y%10))/10;
                            switch (l)
                            {
                                case 1: {
                                    text1.setText(String.valueOf(x) + "/" + String.valueOf((int) y));
                                    text2.setText(String.valueOf(x/y));
                                    break;
                                }
                                case 2: {
                                    text1.setText(String.valueOf((int) x) + "x" + String.valueOf((int) y));
                                    text2.setText(String.valueOf(x*y));
                                    break;
                                }
                                case 3: {
                                    text1.setText(String.valueOf((int) x) + "-" + String.valueOf((int) y));
                                    text2.setText(String.valueOf(x-y));
                                    break;
                                }
                                case 4: {
                                    text1.setText(String.valueOf((int) x) + "+" + String.valueOf((int) y));
                                    text2.setText(String.valueOf(x+y));
                                    break;
                                }
                            }
                        }
                }



            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                m++;
                if (h == true) {
                    text1.setText(String.valueOf(x) + "/");
                    if (z == true) {
                        z = false;
                    }
                    if (m >= 2) {
                        switch (l) {
                            case 1: {
                                x = x / y;
                                text1.setText(String.valueOf(x) + "/");
                                break;
                            }
                            case 2: {
                                x = x * y;
                                text1.setText(String.valueOf(x) + "/");
                                break;
                            }
                            case 3: {
                                x = x - y;
                                text1.setText(String.valueOf(x) + "/");
                                break;
                            }
                            case 4: {
                                x = x + y;
                                text1.setText(String.valueOf(x) + "/");
                                break;
                            }
                        }
                        y = 0;
                    }
                    l = 1;
                }
                else {
                    h = true;
                    x = dec;
                    l=1;
                    z=false;
                    text1.setText(String.valueOf(x) + "/");
                }
            }
        });
        btn5.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {

                if (h == true)
                {
                    if (z == true)
                    {
                        x = (10 * x) + 7;
                        text1.setText(String.valueOf((int) x));
                    }
                    else {
                        y = (10 * y) + 7;
                    }
                    switch (l) {
                        case 0: {
                            break;
                        }
                        case 1: {
                            text1.setText(String.valueOf(x) + "/" + String.valueOf((int) y));
                            text2.setText(String.valueOf(x / y));
                            break;
                        }
                        case 2: {
                            text1.setText(String.valueOf(x) + "x" + String.valueOf((int) y));
                            text2.setText(String.valueOf(x * y));
                            break;
                        }
                        case 3: {
                            text1.setText(String.valueOf(x) + "-" + String.valueOf((int) y));
                            text2.setText(String.valueOf(x - y));
                            break;
                        }
                        case 4: {
                            text1.setText(String.valueOf(x) + "+" + String.valueOf((int) y));
                            text2.setText(String.valueOf(x + y));
                            break;
                        }
                    }

                }
                else {
                    x = (10 * x) + 7;
                    k++;
                    dec = (float) (x/Math.pow(10,k));
                    text1.setText(String.valueOf(dec));
                }
            }

        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(h==true)
                {
                if(z==true)
                {
                    x = (10 * x) + 8;
                    text1.setText(String.valueOf((int) x));
                }
                 else
                {
                    y = (10 * y) + 8;
                }

                switch (l)
                {
                    case 1: {
                        text1.setText(String.valueOf(x) + "/" + String.valueOf((int) y));
                        text2.setText(String.valueOf(x/y));
                        break;
                    }
                    case 2: {
                        text1.setText(String.valueOf(x) + "x" + String.valueOf((int) y));
                        text2.setText(String.valueOf(x*y));
                        break;
                    }
                    case 3: {
                        text1.setText(String.valueOf(x) + "-" + String.valueOf((int) y));
                        text2.setText(String.valueOf(x-y));
                        break;
                    }
                    case 4: {
                        text1.setText(String.valueOf(x) + "+" + String.valueOf((int) y));
                        text2.setText(String.valueOf(x+y));
                        break;
                    }
                }

            }
                else
                {
                    x = (10 * x) + 8;
                    k++;
                    dec = (float) (x/Math.pow(10,k));
                    text1.setText(String.valueOf(dec));
                }
                }

        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (h == true) {
                    if (z == true) {
                        x = (10 * x) + 9;
                        text1.setText(String.valueOf((int) x));
                    } else {
                        y = (10 * y) + 9;
                    }

                    switch (l) {
                        case 1: {
                            text1.setText(String.valueOf(x) + "/" + String.valueOf((int) y));
                            text2.setText(String.valueOf(x / y));
                            break;
                        }
                        case 2: {
                            text1.setText(String.valueOf(x) + "x" + String.valueOf((int) y));
                            text2.setText(String.valueOf(x * y));
                            break;
                        }
                        case 3: {
                            text1.setText(String.valueOf(x) + "-" + String.valueOf((int) y));
                            text2.setText(String.valueOf(x - y));
                            break;
                        }
                        case 4: {
                            text1.setText(String.valueOf(x) + "+" + String.valueOf((int) y));
                            text2.setText(String.valueOf(x + y));
                            break;
                        }
                    }

                } else {
                    x = (10 * x) + 9;
                    k++;
                    dec = (float) (x / Math.pow(10, k));
                    text1.setText(String.valueOf(dec));
                }
            }

        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                m++;
                if (h == true) {
                    text1.setText(String.valueOf(x) + "x");
                    if (z == true) {
                        z = false;
                    }
                    m++;
                    if (m >= 2) {
                        switch (l) {
                            case 1: {
                                x = x / y;
                                text1.setText(String.valueOf(x) + "x");
                                break;
                            }
                            case 2: {
                                x = x * y;
                                text1.setText(String.valueOf(x) + "x");
                                break;
                            }
                            case 3: {
                                x = x - y;
                                text1.setText(String.valueOf(x) + "x");
                                break;
                            }
                            case 4: {
                                x = x + y;
                                text1.setText(String.valueOf(x) + "x");
                                break;
                            }
                        }
                        y = 0;
                    }
                    l = 2;
                } else {
                    h = true;
                    x = dec;
                    l = 2;
                    z = false;
                    text1.setText(String.valueOf(x) + "x");
                }
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                    if (h == true) {
                        if (z == true) {
                            x = (10 * x) + 4;
                            text1.setText(String.valueOf((int) x));
                        } else {
                            y = (10 * y) + 4;
                        }

                        switch (l) {
                            case 1: {
                                text1.setText(String.valueOf(x) + "/" + String.valueOf((int) y));
                                text2.setText(String.valueOf(x / y));
                                break;
                            }
                            case 2: {
                                text1.setText(String.valueOf(x) + "x" + String.valueOf((int) y));
                                text2.setText(String.valueOf(x * y));
                                break;
                            }
                            case 3: {
                                text1.setText(String.valueOf(x) + "-" + String.valueOf((int) y));
                                text2.setText(String.valueOf(x - y));
                                break;
                            }
                            case 4: {
                                text1.setText(String.valueOf(x) + "+" + String.valueOf((int) y));
                                text2.setText(String.valueOf(x + y));
                                break;
                            }
                        }

                    } else {
                        x = (10 * x) + 4;
                        k++;
                        dec = (float) (x / Math.pow(10, k));
                        text1.setText(String.valueOf(dec));
                    }
                }

        });
        btn10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (h == true) {
                    if (z == true) {
                        x = (10 * x) + 5;
                        text1.setText(String.valueOf((int) x));
                    } else {
                        y = (10 * y) + 5;
                    }

                    switch (l) {
                        case 1: {
                            text1.setText(String.valueOf(x) + "/" + String.valueOf((int) y));
                            text2.setText(String.valueOf(x / y));
                            break;
                        }
                        case 2: {
                            text1.setText(String.valueOf(x) + "x" + String.valueOf((int) y));
                            text2.setText(String.valueOf(x * y));
                            break;
                        }
                        case 3: {
                            text1.setText(String.valueOf(x) + "-" + String.valueOf((int) y));
                            text2.setText(String.valueOf(x - y));
                            break;
                        }
                        case 4: {
                            text1.setText(String.valueOf(x) + "+" + String.valueOf((int) y));
                            text2.setText(String.valueOf(x + y));
                            break;
                        }
                    }

                } else {
                    x = (10 * x) + 5;
                    k++;
                    dec = (float) (x / Math.pow(10, k));
                    text1.setText(String.valueOf(dec));
                }
            }

        });

        btn11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (h == true) {
                    if (z == true) {
                        x = (10 * x) + 6;
                        text1.setText(String.valueOf((int) x));
                    } else {
                        y = (10 * y) + 6;
                    }

                    switch (l) {
                        case 1: {
                            text1.setText(String.valueOf(x) + "/" + String.valueOf((int) y));
                            text2.setText(String.valueOf(x / y));
                            break;
                        }
                        case 2: {
                            text1.setText(String.valueOf(x) + "x" + String.valueOf((int) y));
                            text2.setText(String.valueOf(x * y));
                            break;
                        }
                        case 3: {
                            text1.setText(String.valueOf(x) + "-" + String.valueOf((int) y));
                            text2.setText(String.valueOf(x - y));
                            break;
                        }
                        case 4: {
                            text1.setText(String.valueOf(x) + "+" + String.valueOf((int) y));
                            text2.setText(String.valueOf(x + y));
                            break;
                        }
                    }

                } else {
                    x = (10 * x) + 6;
                    k++;
                    dec = (float) (x / Math.pow(10, k));
                    text1.setText(String.valueOf(dec));
                }
            }

        });

        btn12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                m++;
                if (h == true) {
                    text1.setText(String.valueOf(x) + "-");
                    if (z == true) {
                        z = false;
                    }
                    m++;
                    if (m >= 2) {
                        switch (l) {
                            case 1: {
                                x = x / y;
                                text1.setText(String.valueOf(x) + "-");
                                break;
                            }
                            case 2: {
                                x = x * y;
                                text1.setText(String.valueOf(x) + "-");
                                break;
                            }
                            case 3: {
                                x = x - y;
                                text1.setText(String.valueOf(x) + "-");
                                break;
                            }
                            case 4: {
                                x = x + y;
                                text1.setText(String.valueOf(x) + "-");
                                break;
                            }
                        }
                        y = 0;
                    }
                    l = 3;
                } else
                    {
                    h = true;
                    x = dec;
                    l = 3;
                    z = false;
                    text1.setText(String.valueOf(x) + "-");
                    }
            }
        });

        btn13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (h == true) {
                    if (z == true) {
                        x = (10 * x) + 1;
                        text1.setText(String.valueOf((int) x));
                    } else {
                        y = (10 * y) + 1;
                    }

                    switch (l) {
                        case 1: {
                            text1.setText(String.valueOf(x) + "/" + String.valueOf((int) y));
                            text2.setText(String.valueOf(x / y));
                            break;
                        }
                        case 2: {
                            text1.setText(String.valueOf(x) + "x" + String.valueOf((int) y));
                            text2.setText(String.valueOf(x * y));
                            break;
                        }
                        case 3: {
                            text1.setText(String.valueOf(x) + "-" + String.valueOf((int) y));
                            text2.setText(String.valueOf(x - y));
                            break;
                        }
                        case 4: {
                            text1.setText(String.valueOf(x) + "+" + String.valueOf((int) y));
                            text2.setText(String.valueOf(x + y));
                            break;
                        }
                    }

                } else {
                    x = (10 * x) + 1;
                    k++;
                    dec = (float) (x / Math.pow(10, k));
                    text1.setText(String.valueOf(dec));
                }
            }

        });
        btn14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (h == true) {
                    if (z == true) {
                        x = (10 * x) + 2;
                        text1.setText(String.valueOf((int) x));
                    } else {
                        y = (10 * y) + 2;
                    }

                    switch (l) {
                        case 1: {
                            text1.setText(String.valueOf(x) + "/" + String.valueOf((int) y));
                            text2.setText(String.valueOf(x / y));
                            break;
                        }
                        case 2: {
                            text1.setText(String.valueOf(x) + "x" + String.valueOf((int) y));
                            text2.setText(String.valueOf(x * y));
                            break;
                        }
                        case 3: {
                            text1.setText(String.valueOf(x) + "-" + String.valueOf((int) y));
                            text2.setText(String.valueOf(x - y));
                            break;
                        }
                        case 4: {
                            text1.setText(String.valueOf(x) + "+" + String.valueOf((int) y));
                            text2.setText(String.valueOf(x + y));
                            break;
                        }
                    }

                } else {
                    x = (10 * x) + 2;
                    k++;
                    dec = (float) (x / Math.pow(10, k));
                    text1.setText(String.valueOf(dec));
                }
            }

        });
        btn15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (h == true) {
                    if (z == true) {
                        x = (10 * x) + 3;
                        text1.setText(String.valueOf((int) x));
                    } else {
                        y = (10 * y) + 3;
                    }

                    switch (l) {
                        case 1: {
                            text1.setText(String.valueOf(x) + "/" + String.valueOf((int) y));
                            text2.setText(String.valueOf(x / y));
                            break;
                        }
                        case 2: {
                            text1.setText(String.valueOf(x) + "x" + String.valueOf((int) y));
                            text2.setText(String.valueOf(x * y));
                            break;
                        }
                        case 3: {
                            text1.setText(String.valueOf(x) + "-" + String.valueOf((int) y));
                            text2.setText(String.valueOf(x - y));
                            break;
                        }
                        case 4: {
                            text1.setText(String.valueOf(x) + "+" + String.valueOf((int) y));
                            text2.setText(String.valueOf(x + y));
                            break;
                        }
                    }

                } else {
                    x = (10 * x) + 3;
                    k++;
                    dec = (float) (x / Math.pow(10, k));
                    text1.setText(String.valueOf(dec));
                }
            }

        });

        btn16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                m++;
                if (h == true) {
                    text1.setText(String.valueOf(x) + "+");
                    if (z == true) {
                        z = false;
                    }
                    m++;
                    if (m >= 2) {
                        switch (l) {
                            case 1: {
                                x = x / y;
                                text1.setText(String.valueOf(x) + "+");
                                break;
                            }
                            case 2: {
                                x = x * y;
                                text1.setText(String.valueOf(x) + "+");
                                ;
                                break;
                            }
                            case 3: {
                                x = x - y;
                                text1.setText(String.valueOf(x) + "+");
                                break;
                            }
                            case 4: {
                                x = x + y;
                                text1.setText(String.valueOf(x) + "+");
                                break;
                            }
                        }
                        y = 0;
                    }
                    l = 4;
                } else
                    {
                    h = true;
                    x = dec;
                    l = 4;
                    z = false;
                    text1.setText(String.valueOf(x) + "+");
                    }
            }
        });

        btn17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if(h==true)
               {
                   h=false;
               }
               text1.setText(String.valueOf((int)x)+".");
                }
        });

        btn18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (h == true) {
                    if (z == true) {
                        x = (10 * x);
                        text1.setText(String.valueOf((int) x));
                    } else {
                        y = (10 * y);
                    }

                    switch (l) {
                        case 1: {
                            text1.setText(String.valueOf(x) + "/" + String.valueOf((int) y));
                            text2.setText(String.valueOf(x / y));
                            break;
                        }
                        case 2: {
                            text1.setText(String.valueOf(x) + "x" + String.valueOf((int) y));
                            text2.setText(String.valueOf(x * y));
                            break;
                        }
                        case 3: {
                            text1.setText(String.valueOf(x) + "-" + String.valueOf((int) y));
                            text2.setText(String.valueOf(x - y));
                            break;
                        }
                        case 4: {
                            text1.setText(String.valueOf(x) + "+" + String.valueOf((int) y));
                            text2.setText(String.valueOf(x + y));
                            break;
                        }
                    }

                } else {
                    x = (10 * x);
                    k++;
                    dec = (float) (x / Math.pow(10, k));
                    text1.setText(String.valueOf(dec));
                }
            }

        });
        btn20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });






    }
}
