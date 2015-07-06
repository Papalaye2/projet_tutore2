package com.example.ges_institut;



import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class Compo_cv_Activity extends Activity {

	
	 ListView mListchoix = null;
	  String[] tabchoix = null; 
	@Override
	
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_compo_cv_);
		
		 mListchoix = (ListView) findViewById(R.id.list_choix);
		
		
		  tabchoix = new String[]{"PERSONAL DETAIL","PROFILE","WORK EXPERIENCES","EDUCATION","LANGAGUES","HOBBIES"};
		
		  
		  
		  
		  mListchoix.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, tabchoix)); 
		  
		  
		  mListchoix.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> arg0, View arg1, int i,
						long arg3) {
					
					if(tabchoix[i]=="PROFILE")
					{
						Intent intent= new Intent(Compo_cv_Activity.this,Edit_profil_Activity.class);
                        startActivity(intent);
						
					}
					
					if(tabchoix[i]=="WORK EXPERIENCES")
					{
						Intent intent= new Intent(Compo_cv_Activity.this,Work_Expe_Activity.class);
                        startActivity(intent);
						
					}
					
					if(tabchoix[i]=="LANGAGUES")
					{
						Intent intent= new Intent(Compo_cv_Activity.this,Langue_Activity.class);
                        startActivity(intent);
						
					}
					if(tabchoix[i]=="HOBBIES")
					{
						Intent intent= new Intent(Compo_cv_Activity.this,Hobbies_Activity.class);
                        startActivity(intent);
						
					}

					if(tabchoix[i]=="EDUCATION")
					{
						Intent intent= new Intent(Compo_cv_Activity.this,Education_Activity.class);
                        startActivity(intent);
						
					}
					
					/*
					
					String chaine=tabchoix[i]+" a éte selectionne";
					Toast.makeText(Compo_cv_Activity.this, chaine , Toast.LENGTH_LONG).show();				
					// TODO Auto-generated method stub
					
					*/
				}
			});
	        
		  
		  
		  
		  
		  
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.compo_cv_, menu);
		return true;
	}

}
