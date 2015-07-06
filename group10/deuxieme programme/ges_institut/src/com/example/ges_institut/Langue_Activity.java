package com.example.ges_institut;

import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

import com.example.ges_institut.Education_Activity.Traitement;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Langue_Activity extends Activity {
    private final static int ID_NORMAL_DIALOG = 1; 
	EditText txtlangue ,txtniveau;
	Button btsavelangue;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_langue_);
		
		
		btsavelangue= (Button)findViewById(R.id.bt_save_langue2);
		
		txtlangue=(EditText)findViewById(R.id.txt_langue_langue1);
		txtniveau=(EditText)findViewById(R.id.txt_niveau_langue);
		
		
		btsavelangue.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				
				
				String langue = txtlangue.getText().toString();
				String niveau = txtniveau.getText().toString();
				if (langue.equals("") || langue.equals("")   )
				{
					Toast.makeText(Langue_Activity.this,
									"Veuillez renseigner tous les champs",
											Toast.LENGTH_LONG).show();

						}else{

							langue=Uri.encode(langue, "utf-8");
							niveau=Uri.encode(niveau, "utf-8");
							
							 
									

	String url="http://10.0.2.2/android/inscription_langue.php?langue="+langue+"&niveau="+niveau;      
									
										
					//String url="http://10.0.2.2:88/android/connexion.php?login="+login+"&password="+password;
				Traitement d=new Traitement();
				d.execute(url);

								
									}
	
				
			}
		});
		
		
	}
	
	
	
	protected Dialog onCreateDialog(int id) {
		Dialog dialoge = null ;
		AlertDialog.Builder  builder =  new AlertDialog.Builder(this);
		switch(id){
		case  ID_NORMAL_DIALOG:
			
			builder.setMessage("cette Langue a etait enregistrer avec succee voulez vous en enregistrer une autre")
			.setPositiveButton("Oui", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface arg0, int arg1) {
					// TODO Auto-generated method stub
					Toast.makeText(Langue_Activity.this, " yes" , Toast.LENGTH_LONG).show();
					txtlangue.setText("");
					txtniveau.setText("");
					
					
					
				}
			} )
			.setNegativeButton(" No ", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface arg0, int arg1) {
					// TODO Auto-generated method stub
					Toast.makeText(Langue_Activity.this, " No" , Toast.LENGTH_LONG).show();
					
				}
			} )
			.setCancelable(false);
			dialoge=builder.create();
		break;
		}
		
		return dialoge;
				
		
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
			Langue_Activity.this.showDialog(ID_NORMAL_DIALOG);
		     	
		     	

			}
		
    	
    }
	
	
	
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.langue_, menu);
		return true;
	}

}
