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
import android.widget.Toast;

public class AjoutoffreActivity extends Activity {

	
	EditText txtentreprise, txtprofil,txtcontact,txtlibell,txtdomaine;
	Button btpublier,btcancel;
	
	String entreprise,profil,contact,libelle,domaine;
	
	;
	String date="decembre";
	String id= LoginActivity.matricule;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_offre);
		
		txtentreprise=(EditText)findViewById(R.id.txtentreprise);
		txtprofil=(EditText)findViewById(R.id.txtprofil);
		txtcontact=(EditText)findViewById(R.id.txtcontact);
		txtlibell=(EditText)findViewById(R.id.txtlibell);
		txtdomaine=(EditText)findViewById(R.id.txtdomaine);
		
		btpublier=(Button)findViewById(R.id.btpublier);	
		btpublier.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				
				entreprise=txtentreprise.getText().toString();	
				profil=txtprofil.getText().toString();	
				contact=txtcontact.getText().toString();	
				libelle=txtlibell.getText().toString();	
				domaine=txtdomaine.getText().toString();	
				
				
				entreprise=Uri.encode(entreprise, "utf-8");
				profil=Uri.encode(profil, "utf-8");
				contact=Uri.encode(contact, "utf-8");
				libelle=Uri.encode(libelle, "utf-8");
				domaine=Uri.encode(domaine, "utf-8");
				
				String url="http://10.0.2.2/android8/insert.php?entreprise="+entreprise+"&profil="+profil+"" +
						"&contact="+contact+"&id="+id+"&date="+date+"&domaine="+domaine+"&libelle="+libelle;
				
				
				

				Downloader d=new Downloader();
				d.execute(url);
				
			}
		});
		
		
		
		
		
		
	}
	
	
	
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.offre, menu);
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
			 
	 Toast.makeText(AjoutoffreActivity.this, result, Toast.LENGTH_LONG ).show(); 
	 
		Intent intent=new Intent(AjoutoffreActivity.this, AjoutoffreActivity.class
				);
		startActivity(intent);
			
			}
			
			else {
				Toast.makeText(AjoutoffreActivity.this,
						"¨ECHEC DE L'ENREGISTREMENT ",
								Toast.LENGTH_LONG).show();


			}
		}
		
	}
	
}
