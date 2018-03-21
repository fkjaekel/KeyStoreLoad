package com.test;

import java.io.IOException;
import java.security.KeyStore;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet(urlPatterns = "/TestServlet")
public class TestServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public TestServlet()
	{
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException
	{
		final String certPath = "/5100.p12";
		final String certPasswd = "unipgua@081";

		try
		{
			final KeyStore ks = KeyStore.getInstance(KeyStore.getDefaultType());
			ks.load(getClass().getResourceAsStream(certPath), certPasswd.toCharArray());

			response.getWriter().append("KeyStore: ").append(ks.toString());
		}
		catch(final Exception e)
		{
			e.printStackTrace();
			response.getWriter().append(e.getMessage());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
