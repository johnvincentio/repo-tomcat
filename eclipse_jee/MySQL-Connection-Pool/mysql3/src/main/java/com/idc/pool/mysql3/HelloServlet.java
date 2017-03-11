package com.idc.pool.mysql3;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet(value="/hello", name="helloServlet")
public class HelloServlet extends GenericServlet {
	private static final long serialVersionUID = -5657559627412714052L;

	@Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        res.getWriter().println("Hello world!!");
    }
}
