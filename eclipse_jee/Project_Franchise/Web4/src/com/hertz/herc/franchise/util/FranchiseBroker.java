package com.hertz.herc.franchise.util;

import javax.servlet.http.HttpServletResponse;

public class FranchiseBroker {
	public static void doErrorPage(HttpServletResponse response) {
		try {
			response.reset();
		} catch (Exception e) {
		}
	}
}
