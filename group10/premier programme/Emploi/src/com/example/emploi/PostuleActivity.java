package com.example.emploi;

import java.util.StringTokenizer;
import java.util.Vector;

import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class PostuleActivity extends ListActivity {

	String[] items2= MainActivity.items2;
	String choix= VoiroffreActivity.choix;
	String libelle;
	//String candidat=LoginActivity.matricule;
	// String entreprise;

	
	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		setContentView(R.layout.activity_postule);
		setListAdapter(new ArrayAdapter<String>(PostuleActivity.this,
				android.R.layout.simple_list_item_1, items2));
		
		
		
		final ListView listView = getListView();

		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int i,
					long arg3) { 
				
				
				//final String entreprise= listView.getItemAtPosition(i).toString();

				//final String entreprise= "ORANGE";
					//Toast.makeText(PostuleActivity.this,entreprise,Toast.LENGTH_LONG).show();
					
	
	}
});
	
/*dialog.setNegativeButton("Annuler", new OnClickListener() {
	
	public void onClick(DialogInterface arg0, int arg1) {
		Intent intent=new Intent(ListeActivity.this, MainActivity.class
				);
		startActivity(intent);
	}
});*/



}
		
		
	
	

	

		
	}

