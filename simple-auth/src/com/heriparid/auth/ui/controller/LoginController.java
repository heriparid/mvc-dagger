package com.heriparid.auth.ui.controller;

import java.util.concurrent.ExecutorService;

import javax.inject.Inject;

import android.os.Handler;

import com.heriparid.auth.ui.controller.response.IControllerResponse;
import com.heriparid.auth.ui.controller.response.ILoginResponse;

public class LoginController implements ILoginController {

	private final Handler mHandler;
	private final ExecutorService mExecutorService;
	
	private ILoginResponse mResponse;
		
	@Inject
	public LoginController(Handler handler, ExecutorService executorService) {
		mHandler = handler;
		mExecutorService = executorService;
	}	
	
	@Override
	public void onRequestLogin(final String username, final String password) {
		if(mResponse == null){
			return;
		}
		
		mExecutorService.execute(new Runnable() {			
			@Override
			public void run() {
				mHandler.post(new Runnable() {
					@Override
					public void run() {
						mResponse.onLoginResponse(username + password);
					}
				});
			}
		});
	}

	@Override
	public void register(IControllerResponse response) {
		mResponse = (ILoginResponse) response;
	}

	@Override
	public void unregister(IControllerResponse response) {
		mResponse = null;
	}

}
