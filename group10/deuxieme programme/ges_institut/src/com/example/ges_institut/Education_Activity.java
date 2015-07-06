package com.example.ges_institut;


import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

import com.example.ges_institut.Ins_can_Activity.Traitement;

import android.app.Activity;
import android.app.Dialog;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.app.Activity; 
import android.app.Dialog; 
import android.os.Bundle; 
import android.view.View; 
import android.view.View.OnClickListener; 
import android.widget.Button;

public class Education_Activity extends Activity {
	 private final static int ID_NORMAL_DIALOG = 1; 
	Button btsaveeducation;
	EditText txtanne ,txtetablisement,txtformation;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_education_);
		
		
		btsaveeducation= (Button)findViewById(R.id.bt_save_education);
		
		
	      
		txtanne=(EditText)findViewById(R.id.txt_langue_langue2);
		txtetablisement=(EditText)findViewById(R.id.txt_etablissement_edu);
		txtformation=(EditText)findViewById(R.id.txt_formation_edu);
		
		
		btsaveeducation.setOnClickListener(new View.OnClickListener() {
			
			
			public void onClick(View V) {
				
				
				String anne = txtanne.getText().toString();
				String etablissement = txtetablisement.getText().toString();
				String formation = txtformation.getText().toString();
				
				
				if (anne.equals("") || etablissement.equals("") || formation.equals("")  )
				{
					Toast.makeText(Education_Activity.this,
									"Veuillez renseigner tous les champs",
											Toast.LENGTH_LONG).show();

						}else{

							anne=Uri.encode(anne, "utf-8");
							etablissement=Uri.encode(etablissement, "utf-8");
							formation=Uri.encode(formation, "utf-8");
							 
									

	String url="http://10.0.2.2/android/inscription_education.php?anne="+anne+"&etablissement="+etablissement+"&formation="+formation;      
									
										
					//String url="http://10.0.2.2:88/android/connexion.php?login="+login+"&password="+password;
				Traitement d=new Traitement();
				d.execute(url);

										
										
									}
				
	
				

				//Education_Activity.this.showDialog(ID_NORMAL_DIALOG);

				//Toast.makeText(Education_Activity.this, " yes" , Toast.LENGTH_LONG).show();	
				/*
			  Dialog dialog;
			  AlertDialog.Builder alert = new AlertDialog.Builder(this);
			  dialog.setMessage("cette Education a etait enreguistrer avec succee voulait en enreguistrer une autre")
				*/

			}
		});
		
	}

	protected Dialog onCreateDialog(int id) {
		Dialog dialoge = null ;
		AlertDialog.Builder  builder =  new AlertDialog.Builder(this);
		switch(id){
		case  ID_NORMAL_DIALOG:
			
			builder.setMessage("cette Education a etait enregistrer avec succee voulez vous en enregistrer une autre")
			.setPositiveButton("Oui", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface arg0, int arg1) {
					// TODO Auto-generated method stub
					Toast.makeText(Education_Activity.this, " yes" , Toast.LENGTH_LONG).show();
					txtanne.setText("");
					txtetablisement.setText("");
					txtformation.setText("");
					
					
				}
			} )
			.setNegativeButton(" No ", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface arg0, int arg1) {
					// TODO Auto-generated method stub
					Toast.makeText(Education_Activity.this, " No" , Toast.LENGTH_LONG).show();
					
				}
			} )
			.setCancelable(false);
			dialoge=builder.create();
		break;
		}
		
		return dialoge;
				
		
	}




	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.education_, menu);
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

				// Toast.makeText(Education_Activity.this, " vous etes enregitrer ", Toast.LENGTH_LONG).show();	
		     	Education_Activity.this.showDialog(ID_NORMAL_DIALOG);
		     	
		     	

			}
		
    	
    }

}
