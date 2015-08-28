package com.plustech.pegasus.listeners;

import com.plustech.pegasus.Principal;
import com.plustech.pegasus.R;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;

public class UtilizadorListener implements OnClickListener {

	private Principal principal;
	
	public UtilizadorListener(Principal principal) {
		this.principal = principal;
	}
	
	@Override
	public void onClick(View v) {
		Dialog dia = new Dialog(this.principal);
		dia.setContentView(R.layout.utlizadoresactivity);
		dia.setTitle("Dados do Utilizador");
		
		dia.show();
	}

}
