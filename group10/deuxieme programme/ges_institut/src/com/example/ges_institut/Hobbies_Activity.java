package com.example.ges_institut;

import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

import com.example.ges_institut.Langue_Activity.Traitement;

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

public class Hobbies_Activity extends Activity {
	   private final static int ID_NORMAL_DIALOG = 1; 
	EditText txthobie ;
	Button btsavehobbie;
	
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_hobbies_);
		
		
		
		btsavehobbie= (Button)findViewById(R.id.bt_save_hobbie);
		txthobie=(EditText)findViewById(R.id.txt_hobbie);
		
		
		btsavehobbie.setOnClickListener( new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				
				String hobbie = txthobie.getText().toString();
				
				if (hobbie.equals("")    )
				{
					Toast.makeText(Hobbies_Activity.this,
									"Veuillez renseigner tous les champs",
											Toast.LENGTH_LONG).show();

						}else{

							hobbie=Uri.encode(hobbie, "utf-8");
							
							
							 
									

	String url="http://10.0.2.2/android/inscription_hobbie.php?hobbie="+hobbie;      
									
										
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
		getMenuInflater().inflate(R.menu.hobbies_, menu);
		return true;
	}

	
	protected Dialog onCreateDialog(int id) {
		Dialog dialoge = null ;
		AlertDialog.Builder  builder =  new AlertDialog.Builder(this);
		switch(id){
		case  ID_NORMAL_DIALOG:
			
			builder.setMessage("cette Hobbie a etait enregistrer avec succee voulez vous en enregistrer une autre")
			.setPositiveButton("Oui", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface arg0, int arg1) {
					// TODO Auto-generated method stub
					Toast.makeText(Hobbies_Activity.this, " yes" , Toast.LENGTH_LONG).show();
					txthobie.setText("");
					
					
					
					
				}
			} )
			.setNegativeButton(" No ", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface arg0, int arg1) {
					// TODO Auto-generated method stub
					Toast.makeText(Hobbies_Activity.this, " No" , Toast.LENGTH_LONG).show();
					
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
			Hobbies_Activity.this.showDialog(ID_NORMAL_DIALOG);
		     	
		     	

			}
		
    	
    }
	
	
	
}
