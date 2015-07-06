package com.example.ges_institut;


import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;

public class Presen_Activity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_presen_);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.presen_, menu);
		return true;
	}
	
	
	
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		
		if(item.getItemId()== R.id.MenuEditioncv)	
		{
			
Intent intent= new Intent(Presen_Activity.this,Compo_cv_Activity.class);
	        
	        startActivity(intent);
	   
		}
		
		
		return super.onOptionsItemSelected(item);
	}


}
