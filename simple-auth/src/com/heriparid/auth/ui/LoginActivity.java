package com.heriparid.auth.ui;

import javax.inject.Inject;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.heriparid.auth.BaseActivity;
import com.heriparid.auth.R;
import com.heriparid.auth.ui.controller.ILoginController;
import com.heriparid.auth.ui.controller.response.ILoginResponse;

public class LoginActivity extends BaseActivity implements ILoginResponse {

	@Inject
	ILoginController mController;
	
	@Override
	protected void onCreateActivity(Bundle savedInstance) {
		
		setContentView(R.layout.login_layout);
		
		final TextView username = (TextView) findViewById(R.id.txt_username);
		final TextView password = (TextView) findViewById(R.id.txt_password); 
		
		findViewById(R.id.btn_login).setOnClickListener(new View.OnClickListener() {			
			@Override
			public void onClick(View v) {
				mController.onRequestLogin(username.getText().toString(), password.getText().toString());
			}
		});
	}

	@Override
	public void onLoginResponse(String value) {
		Toast.makeText(LoginActivity.this, "Login OK " + value, Toast.LENGTH_SHORT).show();
	}
	
	
	@Override
	protected void onResume() {
		super.onResume();
		mController.register(this);		
	}
	
	@Override
	protected void onPause() {
		super.onPause();
		mController.unregister(this);
	}

}
