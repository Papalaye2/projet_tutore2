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

public class ListeActivity extends ListActivity {

	String[] items= VoiroffreActivity.items;
	String choix= VoiroffreActivity.choix;
	String libelle;
	// String entreprise;

	
	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		setContentView(R.layout.activity_liste);
		setListAdapter(new ArrayAdapter<String>(ListeActivity.this,
				android.R.layout.simple_list_item_1, items));
		
		
		
		final ListView listView = getListView();

		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int i,
					long arg3) { 
				
				
				//final String entreprise= listView.getItemAtPosition(i).toString();

				final String entreprise= "ORANGE";
					Toast.makeText(ListeActivity.this,entreprise,Toast.LENGTH_LONG).show();
					
					
		String url="http://10.0.2.2/android8/libelle.php?entreprise="+entreprise;
		Downloader d=new Downloader();
		d.execute(url);
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
			StringTokenizer st = new StringTokenizer(result, "|");
				
				while (st.hasMoreTokens()) {
					v.add(st.nextToken());
				
			}
			String tab[] = new String[v.size()];
for (int i = 0; i < v.size(); i++) {
	tab[i] = v.elementAt(i).toString();
				Log.v("Chaine=", v.elementAt(i).toString());
				
			}

libelle=tab[0];
Toast.makeText(ListeActivity.this,
		libelle,
				Toast.LENGTH_LONG).show();
			
AlertDialog dialog=new 
AlertDialog.Builder(ListeActivity.this).create();

dialog.setMessage(libelle);
dialog.setIcon(R.drawable.infos);
dialog.setButton("POSTULER", new DialogInterface.OnClickListener() {
	@Override
	public void onClick(DialogInterface arg0, int arg1) {
	
		
	}
});
dialog.show();
}
		}

		
	}

