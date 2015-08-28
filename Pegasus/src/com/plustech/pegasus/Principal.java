package com.plustech.pegasus;

import com.plustech.pegasus.listeners.UtilizadorListener;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;

public class Principal extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.principal);
		
		Button refresh = (Button) findViewById(R.id.refresh);
		
		refresh.setOnClickListener(new UtilizadorListener(this));
	
	}

}
