package com.example.emploi;

import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class InscriptionActivity extends Activity {

	
	EditText txtnom, txtprenom,txtadresse,txttel,txtlogin,txtpwd;
	RadioButton btfemme;
	Button valider,retour;
	String nom,prenom,adresse,tel,login,pwd,genre;
	RadioGroup Rg;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_inscription);

	
	txtnom=(EditText)findViewById(R.id.txtnom);
	txtprenom=(EditText)findViewById(R.id.txtprenom);
	txtadresse=(EditText)findViewById(R.id.txtadresse);
	txttel=(EditText)findViewById(R.id.txttel);
	txtlogin=(EditText)findViewById(R.id.txtlogin);
	txtpwd=(EditText)findViewById(R.id.txtpwd);
	btfemme=(RadioButton)findViewById(R.id.btfeme);	
	 Rg= (RadioGroup)findViewById(R.id.radioGroup5);
	retour=(Button)findViewById(R.id.btback);	
	valider=(Button)findViewById(R.id.btinscrire);	
	
    Rg.setOnCheckedChangeListener(
   		 new RadioGroup.OnCheckedChangeListener() {
   		 @Override
   		 public void onCheckedChanged(RadioGroup group, int checkedId) {
   		 // On affiche le choix de l’utilisateur
   			 ((RadioButton)findViewById(checkedId)).getText();
   			 //recuperation du nom du bouton choisi
   			  genre= (String)((RadioButton)findViewById(checkedId)).getText();
   			 
   			 
   			 String chaine= genre +" a éte selectionne";
   			 
   			 
				Toast.makeText(InscriptionActivity.this, chaine , Toast.LENGTH_LONG).show();			
   			 
   			 
   		 }
   		  
   		 });
	valider.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			
			
			nom=txtnom.getText().toString();	
			prenom=txtprenom.getText().toString();	
			adresse=txtadresse.getText().toString();	
			tel=txttel.getText().toString();	
			login=txtlogin.getText().toString();	
			pwd=txtpwd.getText().toString();
			
			//if(btfemme.isChecked())
				//genre="FEMME";
			//else
				//genre="HOMME";
			
			nom=Uri.encode(nom, "utf-8");
			prenom=Uri.encode(prenom, "utf-8");
			adresse=Uri.encode(adresse, "utf-8");
			tel=Uri.encode(tel, "utf-8");
			login=Uri.encode(login, "utf-8");
			pwd=Uri.encode(pwd, "utf-8");
			genre=Uri.encode(genre, "utf-8");
			
		String url="http://10.0.2.2/android8/insertcandidat.php?nom="+nom+"&prenom="+prenom+"" +
					"&adresse="+adresse+"&tel="+tel+"&login="+login+"&pwd="+pwd+"&genre="+genre;
			
			
			

			Downloader d=new Downloader();
			d.execute(url);
			
		}
	});
	
	
	
	
	}
	


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.inscription, menu);
		return true;
	}
	
	protected class Downloader extends AsyncTask<String, Void, String>

	{
		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
		}
		
		@Override
		protected String doInBackground(String... url) {
			 
			try {
	HttpClient client=new DefaultHttpClient();
	HttpGet get=new HttpGet(url[0]);
	ResponseHandler<String> tunnel=new BasicResponseHandler();
	String result=client.execute(get, tunnel);

	return result;
				
			} catch (Exception e) {
			}
			
			return null;
		}
		
		@Override
		protected void onPostExecute(String result) {
			
			if(result.contains("succes")){
			 
	 Toast.makeText(InscriptionActivity.this, result, Toast.LENGTH_LONG ).show();
	 
	 Intent it = new Intent(InscriptionActivity.this,LoginActivity.class);
	  startActivity(it);
			}
			
			else {
				Toast.makeText(InscriptionActivity.this,
						"¨ECHEC DE L'ENREGISTREMENT ",
								Toast.LENGTH_LONG).show();


			}
		}
		
	}
}
