package com.heriparid.auth;

import android.app.Activity;
import android.os.Bundle;

public abstract class BaseActivity extends Activity {

	protected abstract void onCreateActivity(Bundle savedInstance);
	@Override
	protected void onCreate(Bundle savedInstanceState) {		
		super.onCreate(savedInstanceState);		
		AuthApplication app = (AuthApplication) getApplication();
		app.injectMembers(this);
		onCreateActivity(savedInstanceState);
	}
}
