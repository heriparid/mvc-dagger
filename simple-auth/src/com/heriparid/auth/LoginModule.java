package com.heriparid.auth;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.inject.Singleton;

import com.heriparid.auth.ui.LoginActivity;
import com.heriparid.auth.ui.controller.ILoginController;
import com.heriparid.auth.ui.controller.LoginController;

import android.os.Handler;
import android.os.Looper;
import dagger.Module;
import dagger.Provides;

@Module(
	injects = {
		LoginActivity.class
	},
	complete = false
)
public class LoginModule {

	@Provides 
	@Singleton 
	ExecutorService provideExecutorService(){
		return Executors.newCachedThreadPool();
	}
	
	@Provides
	@Singleton
	Handler provideHandler(){
		return new Handler(Looper.getMainLooper());
	}
	
	@Provides
	ILoginController provideLoginController(LoginController controller){
		return controller;
	}
	
}
