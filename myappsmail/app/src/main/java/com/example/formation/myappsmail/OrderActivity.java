package com.example.formation.myappsmail;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class OrderActivity extends AppCompatActivity implements View.OnClickListener {

    int coffe=0 ;
    int chantilly = 0;
    int chocolat = 0 ;
    int numberfinal = 0 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        Intent intent = getIntent();

        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        TextView peudoTextDisplayField = (TextView) findViewById(R.id.pseudoDisplayField);

        peudoTextDisplayField.setText(message);


        View layoutcoffe =  (View) findViewById(R.id.coffeLayout);
        Button buttonpluscoffe = (Button) findViewById(R.id.buttonCoffePlus);
        Button buttonmoincoffe = (Button) findViewById(R.id.buttonCoffeMoin);
        Button buttonpluschantilly = (Button) findViewById(R.id.buttonChantillyPlus);
        Button buttonmoinchantilly = (Button) findViewById(R.id.buttonChantillyMoin);
        Button buttonpluschocolat = (Button) findViewById(R.id.buttonChocolatPlus);
        Button buttonmoinchocolat = (Button) findViewById(R.id.buttonChocolatMoin);
        Button commendebutton = (Button) findViewById(R.id.buttonCommander);

        buttonpluscoffe.setOnClickListener(this);
        buttonmoincoffe.setOnClickListener(this);
        buttonpluschantilly.setOnClickListener(this);
        buttonmoinchantilly.setOnClickListener(this);
        buttonpluschocolat.setOnClickListener(this);
        buttonmoinchocolat.setOnClickListener(this);
        commendebutton.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {

        TextView coffenumber = (TextView) findViewById(R.id.numbercoffe);
        TextView chantillynumber = (TextView) findViewById(R.id.numberchantilly);
        TextView chocolatnumber = (TextView) findViewById(R.id.numberchocolat);
        TextView numberfinalcomande = (TextView) findViewById(R.id.numberfinal);



        switch(v.getId()) {

            case R.id.buttonCoffePlus:
                if(coffe<=9) {
                    coffe++;
                    coffenumber.setText("" + coffe);
                    numberfinal= numberfinal+5;
                    numberfinalcomande.setText(""+numberfinal);
                }else{
                    Context context = getApplicationContext();
                    CharSequence text = "en limite a 10 Coffé !";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
                break;

            case R.id.buttonCoffeMoin:
                if (coffe>0) {
                    coffe--;
                    coffenumber.setText("" + coffe);
                    numberfinal= numberfinal-5;
                    numberfinalcomande.setText(""+numberfinal);

                }else{
                    Context context = getApplicationContext();
                    CharSequence text = "en peu pas aller a moin de 0";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
                break;

            case R.id.buttonChantillyPlus:
                if(coffe<chantilly||chantilly>coffe-1) {
                    Context context = getApplicationContext();
                    CharSequence text = "vous aver pas pris de caffé ou pas assé de caffé";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }else{
                    chantilly++;
                    chantillynumber.setText("" + chantilly);
                    numberfinal= numberfinal+1;
                    numberfinalcomande.setText(""+numberfinal);
                }
                break;

            case R.id.buttonChantillyMoin:
                if ( chantilly<=0 ) {
                    Context context = getApplicationContext();
                    CharSequence text = "vous pouver pas prendre moin de 0 chantilly";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }else{
                    chantilly--;
                    chantillynumber.setText("" + chantilly);
                    numberfinal= numberfinal-1;
                    numberfinalcomande.setText(""+numberfinal);
                }
                break;

            case R.id.buttonChocolatPlus:
                if(coffe<chocolat||chocolat>coffe-1) {

                    Context context = getApplicationContext();
                    CharSequence text = "vous aver pas pris de caffé ou pas assé de caffé";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }else{
                    chocolat++;
                    chocolatnumber.setText("" + chocolat);
                    numberfinal= numberfinal+1;
                    numberfinalcomande.setText(""+numberfinal);

                }
                break;

            case R.id.buttonChocolatMoin:
                if ( chocolat<=0 ) {
                    Context context = getApplicationContext();
                    CharSequence text = "vous pouver pas prendre moin de 0 chocolat";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }else{
                    chocolat--;
                    chocolatnumber.setText("" + chocolat);
                    numberfinal= numberfinal-1;
                    numberfinalcomande.setText(""+numberfinal);
                }
                break;

            case R.id.buttonCommander:

                String commande="vous aver pris "+coffe+" coffe avec "+chantilly+" chantilly et "+chocolat+" chocolat  merci de votre achats ";
                envoyerUnMail(commande);

                Context context = getApplicationContext();
                CharSequence text = "Fin de la Commande!";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();

                break;

        }

    }
    public void envoyerUnMail(String commande){
        Intent email = new Intent(Intent.ACTION_SEND);
        email.setType("text/plain");
        email.putExtra(android.content.Intent.EXTRA_EMAIL,"pokemondp19@hotmail.fr");
        email.putExtra(Intent.EXTRA_SUBJECT, "Commande Speciale De Chocolat");
        email.putExtra(Intent.EXTRA_TEXT, commande);
        email.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(Intent.createChooser(email, "Choisir le logiciel"));
    }
}
