package com.example.emploi;

import java.awt.Button;
import java.util.StringTokenizer;
import java.util.Vector;

import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class LoginActivity extends Activity {
	EditText txtLogin, txtPassword;
	ImageButton  btvalider; 
	
	
	
	Button btinscription;
	RadioGroup Rg;
	String choix;
    String m;
	public static String matricule="";
	String url;
	RadioButton candidat,employeur;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		
		
		txtLogin = (EditText) findViewById(R.id.txtlogin2);
		txtPassword = (EditText) findViewById(R.id.txtpassword2);
		btvalider = (ImageButton) findViewById(R.id.btvalider);
		candidat = (RadioButton) findViewById(R.id.candidat);
		employeur = (RadioButton) findViewById(R.id.employeur);
	//	btinscription = (Button) findViewById(R.id.inscrire);
		  Rg= (RadioGroup)findViewById(R.id.radioGroup9);
		  
		  
		  
		  
		  
		  Rg.setOnCheckedChangeListener(
	        		 new RadioGroup.OnCheckedChangeListener() {
	        		 @Override
	        		 public void onCheckedChanged(RadioGroup group, int checkedId) {
	        		 // On affiche le choix de l’utilisateur
	        			 ((RadioButton)findViewById(checkedId)).getText();
	        			 //recuperation du nom du bouton choisi
	        			  m= (String)((RadioButton)findViewById(checkedId)).getText();
	        			 
	        			 
	      			 String chaine= m +" a éte selectionne";
	        			 
	        			 choix=m;
	     				Toast.makeText(LoginActivity.this, chaine , Toast.LENGTH_LONG).show();			
	        			 
	        			 
	        		 }
	        		  
	        		 });
	/*	btinscription.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				Intent intent=new Intent(LoginActivity.this, InscriptionActivity.class
						);
				startActivity(intent);
			}
		});*/

		btvalider.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {

final String login = txtLogin.getText().toString();
final String password = txtPassword.getText().toString();


				if (login.equals("") || password.equals("")) {
	Toast.makeText(LoginActivity.this,
					"Veuillez renseigner tous les champs",
							Toast.LENGTH_LONG).show();
				}
				else {
					if(candidat.isChecked()){
 url="http://10.0.2.2/android8/connexion2.php?login="+login+"&password="+password+"&choix="+choix;
 
 Downloader d=new Downloader();
 d.execute(url);		
					}
					else  {url="http://10.0.2.2/android8/connexion.php?login="+login+"&password="+password+"&choix="+choix;

					Downloader2 d=new Downloader2();
					 d.execute(url);	
					
					}
					
					
				}

			}
		});
		
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
		
			
			if(result.contains("OK")){
				

				Vector v = new Vector();
				StringTokenizer st = new StringTokenizer(result, "|");
				
				while (st.hasMoreTokens()) {
					v.add(st.nextToken());
					
				}
				String tab[] = new String[v.size()];
	for (int i = 0; i < v.size(); i++) {
		tab[i] = v.elementAt(i).toString();
					Log.v("Chaine=", v.elementAt(i).toString());
					
				}
	matricule=tab[1];
				Toast.makeText(LoginActivity.this,
						"ID= "+matricule,
								Toast.LENGTH_LONG).show();
				
	Intent intent=new Intent(LoginActivity.this, AjoutoffreActivity.class
			);
	startActivity(intent);

			}
			else {
				Toast.makeText(LoginActivity.this,
						"¨Paramétres incorrects ",
								Toast.LENGTH_LONG).show();


			}
		}
		
	}
		
	protected class Downloader2 extends AsyncTask<String, Void, String>

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
		
			
			if(result.contains("OK")){
				

				Vector v = new Vector();
				StringTokenizer st = new StringTokenizer(result, "|");
				
				while (st.hasMoreTokens()) {
					v.add(st.nextToken());
					
				}
				String tab[] = new String[v.size()];
	for (int i = 0; i < v.size(); i++) {
		tab[i] = v.elementAt(i).toString();
					Log.v("Chaine=", v.elementAt(i).toString());
					
				}
	matricule=tab[1];
				Toast.makeText(LoginActivity.this,
						"ID= "+matricule,
								Toast.LENGTH_LONG).show();
				
	Intent intent=new Intent(LoginActivity.this, MainActivity.class
			);
	startActivity(intent);

			}
			else {
				Toast.makeText(LoginActivity.this,
						"¨Paramétres incorrects ",
								Toast.LENGTH_LONG).show();


			}
		}
		
	}

	
	
	
	public static String[] split(String text, String sep) {

		if (text == null || text.trim().equals("")) {
			return null;
		}
		text = text.trim();

		StringTokenizer st = new StringTokenizer(text.trim(), sep);
		int nbtoken = st.countTokens();
		if (nbtoken != 0) {
			String[] tmp = new String[nbtoken];
			int i = 0;
			while (st.hasMoreTokens()) {
				tmp[i] = st.nextToken();
				i++;
			}
			return tmp;
		}

		return null;
	}

}
