package com.heriparid.auth;

import dagger.ObjectGraph;
import android.app.Activity;
import android.app.Application;

public class AuthApplication extends Application {

	private ObjectGraph mGraph;
	
	@Override
	public void onCreate() {
		super.onCreate();
		mGraph = ObjectGraph.create(new LoginModule());
	}
	
	public void injectMembers(Activity activity){
		mGraph.inject(activity);
	}
}
