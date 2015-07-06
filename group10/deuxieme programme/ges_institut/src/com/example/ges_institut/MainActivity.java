package com.example.ges_institut;


import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	EditText txtlogin, txtmdp;
	Button btconnect, btinscrire;

    @Override
   protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btconnect= (Button)findViewById(R.id.bt_connect); 
        btinscrire= (Button)findViewById(R.id.bt_inscrire);
        
        txtlogin= (EditText)findViewById(R.id.txt_login);
        txtmdp= (EditText)findViewById(R.id.txt_mdp);
        btconnect.setOnClickListener(new  OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
                final String login = txtlogin.getText().toString();
				final String password = txtmdp.getText().toString();
                if (login.equals("") || password.equals("")) {
					Toast.makeText(MainActivity.this,
									"Veuillez renseigner tous les champs",
											Toast.LENGTH_LONG).show();

								}
								else{
									Intent intent= new Intent(MainActivity.this,Presen_Activity.class);
                                    startActivity(intent);
			                    }

			}
		});
        
         btinscrire.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				Intent intent= new Intent(MainActivity.this,Ins_can_Activity.class);
                startActivity(intent);	
				
			}
		});
        
        
        
    }
      

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
