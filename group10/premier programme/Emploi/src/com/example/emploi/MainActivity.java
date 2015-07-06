package com.example.emploi;

import java.util.StringTokenizer;
import java.util.Vector;

import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

import com.example.emploi.VoiroffreActivity.Downloader;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity {
	
	static String[] items2;
	String candidat;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	
	


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public boolean onOptionsItemSelected(MenuItem item) {
		
if(item.getItemId()==R.id.Ajoutoffre){
	Intent intent=new Intent(MainActivity.this, AjoutoffreActivity.class);
	startActivity(intent);
		}
		
else if(item.getItemId()==R.id.Voiroffre){
	
		Intent intent=new Intent(MainActivity.this, VoiroffreActivity.class);
		startActivity(intent);
			
}
else if(item.getItemId()==R.id.postulant){

	candidat="1";
	
	String url="http://10.0.2.2/android8/postule.php?candidat="+candidat;
	Downloader d=new Downloader();
	d.execute(url);
		
}
		
		
		
		
		return super.onOptionsItemSelected(item);
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
                items2 = new String[v.size()];
for (int i = 0; i < v.size(); i++) {
				items2[i] = v.elementAt(i).toString();
				Log.v("Chaine=", v.elementAt(i).toString());
				
				Intent intent=new Intent(MainActivity.this, PostuleActivity.class);
				startActivity(intent);
			}


		}

		
	}
	
}
