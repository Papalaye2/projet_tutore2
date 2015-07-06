package com.example.ges_institut;

import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;


import android.app.Activity;
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

public class Ins_can_Activity extends Activity {
	
	EditText txtnom ,txtprenom,txttel,txtage,txtsex,txtadresse,txtlogin,txtmdp;
	Button btValider,btAnnuler;
	RadioGroup Rg;
	String sexe;
    String m;

	@Override
	

	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ins_can);
		
		
		
		  btValider= (Button)findViewById(R.id.bt_incrire2); 
	      btAnnuler= (Button)findViewById(R.id.bt_annuler);
          txtnom=(EditText)findViewById(R.id.txt_non);
          txtprenom=(EditText)findViewById(R.id.txt_prenom);
          txttel=(EditText)findViewById(R.id.txt_tel);
          txtage=(EditText)findViewById(R.id.txt_age);
          txtadresse=(EditText)findViewById(R.id.txt_adresse);
          txtlogin=(EditText)findViewById(R.id.txt_login_c);
          txtmdp=(EditText)findViewById(R.id.txt_mdp_c);
          Rg= (RadioGroup)findViewById(R.id.radioGroup1);
          
          Rg.setOnCheckedChangeListener(
	        		 new RadioGroup.OnCheckedChangeListener() {
	        		 @Override
	        		 public void onCheckedChanged(RadioGroup group, int checkedId) {
	        		 // On affiche le choix de l’utilisateur
	        			 ((RadioButton)findViewById(checkedId)).getText();
	        			 //recuperation du nom du bouton choisi
	        			  m= (String)((RadioButton)findViewById(checkedId)).getText();
	        			 
	        			 
	        			 String chaine= m +" a éte selectionne";
	        			 
	        			 sexe=m;
	     				Toast.makeText(Ins_can_Activity.this, chaine , Toast.LENGTH_LONG).show();			
	        			 
	        			 
	        		 }
	        		  
	        		 });
          
		
		
		btValider.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
					String login = txtlogin.getText().toString();
					String nom = txtnom.getText().toString();
					String prenom = txtprenom.getText().toString();
					String age = txtage.getText().toString();
					String adresse = txtadresse.getText().toString();
				    String tel= txttel.getText().toString();
					String mdp = txtmdp.getText().toString();
				
				
				if (login.equals("") || nom.equals("") || prenom.equals("") || age.equals("") || adresse.equals("") || tel.equals("") || mdp.equals("") )
				{
					Toast.makeText(Ins_can_Activity.this,
									"Veuillez renseigner tous les champs",
											Toast.LENGTH_LONG).show();

						}
						else{

						 prenom=Uri.encode(prenom, "utf-8");
						 nom=Uri.encode(nom, "utf-8");
						 age=Uri.encode(age, "utf-8");
						 adresse=Uri.encode(adresse, "utf-8");
						 tel=Uri.encode(tel, "utf-8");
						 mdp=Uri.encode(mdp, "utf-8");
						 login=Uri.encode(login, "utf-8");
								

String url="http://10.0.2.2/android/inscription_candidat.php?prenom="+prenom+"&nom="+nom+"&age="+age+"&adresse="+adresse+"&tel="+tel+"&login="+login+"&mdp="+mdp+"&sexe="+sexe;      
								
									
				//String url="http://10.0.2.2:88/android/connexion.php?login="+login+"&password="+password;
				Traitement d=new Traitement();
				d.execute(url);

									
									
								}
			
			}
		});

		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.ins_can_, menu);
		return true;
	}

	
	
	protected class Traitement extends AsyncTask<String,Void, String>
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

				 Toast.makeText(Ins_can_Activity.this, " vous etes enregitrer ", Toast.LENGTH_LONG).show();	

			}
		
    	
    }
	
	
}
