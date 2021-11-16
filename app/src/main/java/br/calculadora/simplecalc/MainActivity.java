package br.calculadora.simplecalc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int i = 0; //indice de numeros para operacao
    int count = 0;// qtde de caracteres de numeros. max 7
    int[] result; // array dos numeros digitados
    int total;
    static int INVALID = 9999999; // constante de erro
    String operacao; // variavel de controle de operacao

    Button btn00, btn01, btn02, btn03, btn04, btn05, btn06, btn07, btn08, btn09;
    Button btnSoma, btnSub, btnMult, btnDiv, btnIgual, btnLimp;

    TextView RESULTSCREEN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result = new int[2]; //Result[0] Result[1]

        RESULTSCREEN = (TextView) findViewById(R.id.RESULTSCREEN);
        btn00 = (Button) findViewById(R.id.button0);
        btn01 = (Button) findViewById(R.id.button1);
        btn02 = (Button) findViewById(R.id.button2);
        btn03 = (Button) findViewById(R.id.button3);
        btn04 = (Button) findViewById(R.id.button4);
        btn05 = (Button) findViewById(R.id.button5);
        btn06 = (Button) findViewById(R.id.button6);
        btn07 = (Button) findViewById(R.id.button7);
        btn08 = (Button) findViewById(R.id.button8);
        btn09 = (Button) findViewById(R.id.button9);

        btnSoma = (Button) findViewById(R.id.buttonsoma);
        btnSub = (Button) findViewById(R.id.buttonsub);
        btnDiv = (Button) findViewById(R.id.buttondiv);
        btnMult = (Button) findViewById(R.id.buttonmult);
        btnLimp = (Button) findViewById(R.id.buttonLimpar);
        btnIgual = (Button) findViewById(R.id.buttonigual);

        btn00.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                 if (count > 7){
                     result[i] = (result[i] * 10);
                     count++;
                }
                 exibirResultado();
                 total = 0;
            }
        });
        btn01.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(count < 7){
                    result[i] = (result[i] * 10) + 1;
                    count++;
                }
                exibirResultado();
                total = 0;
            }
        });
        btn02.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(count < 7){
                    result[i] = (result[i] * 10) + 2;
                    count++;
                }
                exibirResultado();
                total = 0;
            }
        });

        btn03.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(count < 7){
                    result[i] = (result[i] * 10) + 3;
                    count++;
                }
                exibirResultado();
                total = 0;
            }
        });

        btn04.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(count < 7){
                    result[i] = (result[i] * 10) + 4;
                    count++;
                }
                exibirResultado();
                total = 0;
            }
        });

        btn05.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(count < 7){
                    result[i] = (result[i] * 10) + 5;
                    count++;
                }
                exibirResultado();
                total = 0;
            }
        });

        btn06.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(count < 7){
                    result[i] = (result[i] * 10) + 6;
                    count++;
                }
                exibirResultado();
                total = 0;
            }
        });

        btn07.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(count < 7){
                    result[i] = (result[i] * 10) + 7;
                    count++;
                }
                exibirResultado();
                total = 0;
            }
        });

        btn08.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(count < 7){
                    result[i] = (result[i] * 10) + 8;
                    count++;
                }
                exibirResultado();
                total = 0;
            }
        });

        btn09.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(count < 7){
                    result[i] = (result[i] * 10) + 9;
                    count++;
                }
                exibirResultado();
                total = 0;
            }
        });
        btnSoma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operacao = "soma";
                proximoNumero();
            }
        });
        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operacao = "sub";
                proximoNumero();
            }
        });
        btnMult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operacao = "mult";
                proximoNumero();
            }
        });
        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operacao = "div";
                proximoNumero();
            }
        });

        btnIgual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcular();
                exibirResultado();// trocar resultado na tela
                total = 0;//zerar o valor total
                count = 0;//zerar o contador
            }
        });
        btnLimp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                limpar();
            }
        });
    }
    private void exibirResultado(){
        String tela = "";
        if (total != 0 && total < INVALID){
            //Se o valor for valido
            tela = String.valueOf(total);
        } else if (total > INVALID){
            //Se o valor for invalido
            tela = "ERRO";
        }else{
            //Se o valor nao foi calculado
            tela = String.valueOf(result[i]);
        }
        RESULTSCREEN.setText(tela);
    }
    private void proximoNumero(){
        count = 0;
        i = 1;
    }
    private void limpar(){
        i = 0;
        result[0] = 0;
        result[1] = 0;
        total = 0;
        count = 0;
        exibirResultado();
    }
    private void calcular() {
        double value;
        switch (operacao) {
            //Executa as operações e sai do switch
            case "soma":
                total = (result[0] + result[1]);
                break;
            case "sub":
                total = (result[0] - result[1]);
                break;
            case "mult":
                total = (result[0] * result[1]);
                break;
            case "div":
                total = (result[0] / result[1]);
                break;
        }
        //se for um valor inválido:
        if (total < INVALID) {
            result[0] = total; //Para executar mais operações
            result[1] = 0;     //Passa para o segundo valor
            i = 1;
        }
    }
}