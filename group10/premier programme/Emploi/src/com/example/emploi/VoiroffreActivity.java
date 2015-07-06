package com.example.emploi;

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
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class VoiroffreActivity extends Activity {

	RadioButton informatique,telecom,marketing,tout;
	Button valider,retour;
	static String choix,choice;
	static String[] tableau; 
	static String[] items;
	String login="pdieye";
	String password="passer";
	RadioGroup Rg;
	//String choix;
    String m;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_voiroffre);
		
		
		
		informatique=(RadioButton)findViewById(R.id.btinformatique);
		telecom=(RadioButton)findViewById(R.id.employeur);
		marketing=(RadioButton)findViewById(R.id.btmarketin);
		tout=(RadioButton)findViewById(R.id.candidat);
		Rg= (RadioGroup)findViewById(R.id.radiogroup6);
		valider= (Button)findViewById(R.id.btvalidervoir);
		retour= (Button)findViewById(R.id.btretour);
		
		
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
	     				Toast.makeText(VoiroffreActivity.this, chaine , Toast.LENGTH_LONG).show();			
	        			 
	        			 
	        		 }
	        		  
	        		 });
		
		
		
		valider.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
					if(tout.isChecked()) {
					
				
					//String url="http://10.0.2.2/android/connexion.php?login="+login+"&password="+password;
					String url="http://10.0.2.2/android8/tri.php";
					Downloader d=new Downloader();
					d.execute(url);
				}
				
				else 	if(informatique.isChecked()) {
					
					String url="http://10.0.2.2/android8/tri3.php";
					Downloader d=new Downloader();
					d.execute(url);
				}
				
				else 	if(marketing.isChecked()) {
				
					String url="http://10.0.2.2/android8/tri2.php ";
					Downloader d=new Downloader();
					d.execute(url);
				}
				
				/*else 	if(telecom.isChecked()) {
					
					String url="http://10.0.2.2/android8/tri.php";
					Downloader d=new Downloader();
					d.execute(url);
				}*/
				
				
				
			
				
			}
		});
		
		
	retour.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				Intent intent=new Intent(VoiroffreActivity.this, MainActivity.class);
				startActivity(intent);
				
			}
		});
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.voiroffre, menu);
		return true;
	}
	
	
	protected class Downloader extends AsyncTask<String, Void, String> {

		@Override
		protected String doInBackground(String... args) {
			 
			try {
	HttpClient client=new DefaultHttpClient();
	HttpGet get=new HttpGet(args[0]);
	ResponseHandler<String> tunnel=new BasicResponseHandler();
	String result=client.execute(get, tunnel);

	return result;
				
			} catch (Exception e) {
			}
			
			return null;
		}

		@Override
		protected void onPostExecute(String result) {
			
		Vector v = new Vector();
		StringTokenizer st = new StringTokenizer(result.substring(0,
				result.indexOf("!")), "|");
			
			while (st.hasMoreTokens()) {
				v.add(st.nextToken());
				
			}
                items = new String[v.size()];
for (int i = 0; i < v.size(); i++) {
				items[i] = v.elementAt(i).toString();
				Log.v("Chaine=", v.elementAt(i).toString());
				
				Intent intent=new Intent(VoiroffreActivity.this, ListeActivity.class);
				startActivity(intent);
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
