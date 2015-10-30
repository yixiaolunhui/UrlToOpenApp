package com.sheng00.customuridemo;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	protected void onResume() {
		super.onResume();
		Intent i_getvalue = getIntent();  
		String action = i_getvalue.getAction();  

		if(Intent.ACTION_VIEW.equals(action)){  
			Uri uri = i_getvalue.getData();  
			if(uri != null){  
				String name = uri.getQueryParameter("name");  
				String age= uri.getQueryParameter("age");  
				TextView tv = (TextView) findViewById(R.id.tv);
				tv.append("\n" + name+"------"+age);
			}  
		}
	}


}
