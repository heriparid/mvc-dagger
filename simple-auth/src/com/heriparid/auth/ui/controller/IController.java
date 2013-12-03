package com.heriparid.auth.ui.controller;

import com.heriparid.auth.ui.controller.response.IControllerResponse;

public interface IController {
	void register(IControllerResponse response);
	void unregister(IControllerResponse response);
}
