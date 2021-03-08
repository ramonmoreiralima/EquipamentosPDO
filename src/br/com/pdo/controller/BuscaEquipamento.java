package br.com.pdo.controller;

import java.io.IOException;
import java.io.PrintWriter;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="BuscaEquipamento",urlPatterns="/buscar")
public class BuscaEquipamento extends HttpServlet  {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
		PrintWriter imprimir = resp.getWriter();
        imprimir.println("<html><body>");
        imprimir.println("Desenvolvimento Aberto - Hello World</br>");
        imprimir.println("</body></html>");
	}
}
