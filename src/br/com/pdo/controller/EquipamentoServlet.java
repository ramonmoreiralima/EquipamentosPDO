package br.com.pdo.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.pdo.dao.EquipamentoDAO;
import br.com.pdo.dao.Equipamento2DAO;
import br.com.pdo.model.Equipamento;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;

@WebServlet(name="EquipamentoServlet",urlPatterns="/equipamento")
public class EquipamentoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// private Equipamento2DAO equipamento2DAO;
	// https://www.codejava.net/coding/jsp-servlet-jdbc-mysql-create-read-update-delete-crud-example
	// https://www.devmedia.com.br/introducao-jstl-java/23582
	private EquipamentoDAO equipamentoDAO;
	private String entidade = "Equipamento";
	// private Equipamento equipamento;
	
	public void init() {
		/*String jdbcURL = getServletContext().getInitParameter("jdbc:mysql://localhost:3306/equipamentos_pdo");
		String jdbcUsername = getServletContext().getInitParameter("root");
		String jdbcPassword = getServletContext().getInitParameter("");
		equipamento2DAO = new Equipamento2DAO(jdbcURL, jdbcUsername, jdbcPassword);*/
		equipamentoDAO = new EquipamentoDAO();
	}
	
	
	/*protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		String action = request.getServletPath();
		System.out.println(action);
		if (action.equals("/cadastrar")){
			request.getRequestDispatcher("cadastrar_equipamento.jsp").forward(request, response); 
			//response.sendRedirect("equipamento.jsp");
		}
		if (action.equals("/listar")){
			// request.getRequestDispatcher("listar_equipamento.jsp").forward(request, response); 
			// response.sendRedirect("equipamento.jsp");
			try {
				listEquipemanto(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
           
		}
		
	}*/
	 protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        doGet(request, response);
	 }
	 
	 protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // String action = request.getServletPath();
        String op = request.getParameter("op");

        try {
            switch (op) {
            case "new":
                showNewForm(request, response);
                break;
            case "insert":
                insertEquipamento(request, response);
                break;
            case "delete":
            	deleteEquipamento(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "update":
            	updateEquipamento(request, response);
                break;
            case "list":
            	listEquipemanto(request, response);
                break;
            case "home":
            	showHome(request, response);
                break;
            default:
            	message(request, response);
                break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	 
	 private void message(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
		 	String action = request.getServletPath();
		 	String op = request.getParameter("op");
		 	request.setAttribute("title","Home");
		 	request.setAttribute("msg","Path Inválido: "+action+"/"+op);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
	        dispatcher.forward(request, response);
	 }
	 private void showHome(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
		 	// String action = request.getServletPath();
		 	request.setAttribute("title","Home");
		 	request.setAttribute("texto","Pagina de Cadastro de Equipamentos do PortalDO.");
	        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
	        dispatcher.forward(request, response);
	 }
/*	 private void confirmExclusao(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException, SQLException { 	
			response.setContentType("text/html;charset=UTF-8");
			try( PrintWriter out = response.getWriter()){
				PrintWriter imprimir = response.getWriter();
				// imprimir.println("<html><body>");
				// imprimir.println("<script>confirm('Deseja Realmete Realizar a Operação?');</script>");
				// imprimir.println("</body></html>");
				imprimir.println("<script type='text/javascript>if(confirm('Confirma?')){alert('ok');}else{alert('cancel');}</script>");
			}	
			deleteEquipamento(request, response);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("equipamento?op=list");
	        dispatcher.forward(request, response);
	 }*/
	 
	 private void showNewForm(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
		 	request.setAttribute("title","Cadastrado de "+entidade);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("cadastrarEquipamento.jsp");
	        dispatcher.forward(request, response);
	 }
	 
	 private void listEquipemanto(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
		 
		 EquipamentoDAO equipamentoDAO = new EquipamentoDAO();
		 
		 /*for(Equipamento equip : equipamentoDAO.getEquipamentos()){
			 // System.out.println("NOME: " + c.getNome());
			 response.setContentType("text/html;charset=UTF-8");
			 	try( PrintWriter out = response.getWriter()){
				PrintWriter imprimir = response.getWriter();
			        imprimir.println("<html><body>");
			        imprimir.println("hostname: "+ equip.getHostname() +"</br>");
			        imprimir.println("descricao: "+ equip.getDescricao() +"</br>");
			        imprimir.println("IP1 : "+ equip.getIp1() +"</br>");
			        imprimir.println("IP2 : "+ equip.getIp2() +"</br>");
			        imprimir.println("mascara: "+ equip.getMascara() +"</br>");
			        imprimir.println("gateway: "+ equip.getGateway() +"</br>");
			        imprimir.println("tipo: "+ equip.getTipo() +"</br>");
			        imprimir.println("batismo: "+ equip.getBatismo() +"</br>");
			        imprimir.println("serialNumber: "+ equip.getSerialNumber() +"</br>");
			        imprimir.println("servico: "+ equip.getServico() +"</br>");
			        imprimir.println("Sucesso!");
			        imprimir.println("</body></html>");
			       // req.getRequestDispatcher("index.html").forward(req, resp);
				}	
		 }*/
		 
		// List<Equipamento> listEquipamento = equipamento2DAO.listAllEquipamentos();
		List<Equipamento> listEquipamento = equipamentoDAO.getEquipamentos();
		request.setAttribute("listEquipamento", listEquipamento);
		request.setAttribute("title","Lista de "+entidade);
		RequestDispatcher dispatcher = request.getRequestDispatcher("listarEquipamento.jsp");
		dispatcher.forward(request, response);
	 }
	 

	private void insertEquipamento(HttpServletRequest request, HttpServletResponse response)
	            throws SQLException, ServletException, IOException {
		String hostname = request.getParameter("inputHostname");
		String descricao = request.getParameter("inputDescricao");
		String ip1 = request.getParameter("inputIp1");
		String ip2 = request.getParameter("inputIp2");
		String mascara = request.getParameter("inputMascara");
		String gateway = request.getParameter("inputGateway");
		String tipo = request.getParameter("inputTipo");
		String batismo = request.getParameter("inputBatismo");
		String serialNumber = request.getParameter("inputSerialNumber");
		String servico = request.getParameter("inputServico");
		//float price = Float.parseFloat(request.getParameter("price"));

	        try {
	        	Equipamento newEquipamento = new Equipamento(hostname,descricao,ip1,ip2,mascara,gateway,tipo,batismo,serialNumber,servico);
		        // System.out.println(newEquipamento);
		        equipamentoDAO.save(newEquipamento);
		       
		        request.setAttribute("msg",entidade+" Cadastrado.");
	  		  	request.getRequestDispatcher("equipamento?op=list").
	  		    	         forward(request, response);
	  		  	// response.sendRedirect("equipamento?op=list");
	  		}catch(Exception ex) {
	  			ex.printStackTrace();
	  			 request.setAttribute("err","Dados Invalidos : error" + ex.getMessage());
	  	    	  request.getRequestDispatcher("index.jsp").
	  	    	         forward(request, response);
	  		}

	    }
		private void deleteEquipamento(HttpServletRequest request, HttpServletResponse response)
	            throws SQLException, IOException, ServletException {
			int id = Integer.parseInt(request.getParameter("id"));
			// String op = request.getParameter("op");
			// System.out.println(id+" - "+op);
	        try {
	        	equipamentoDAO.removeById(id);
		        request.setAttribute("msg",entidade+" Excluido.");
	  		  	request.getRequestDispatcher("equipamento?op=list").
	  		    	         forward(request, response);
	  		  	// response.sendRedirect("equipamento?op=list");
	  			}catch(Exception ex) {
	  				ex.printStackTrace();
	  				request.setAttribute("err","Dados Invalidos : error" + ex.getMessage());
	  				request.getRequestDispatcher("index.jsp").
	  	    	         forward(request, response);
	  			}
	    }
		private void updateEquipamento(HttpServletRequest request, HttpServletResponse response)
	            throws SQLException, IOException, ServletException {
	        int id = Integer.parseInt(request.getParameter("inputId"));	        
	        String hostname = request.getParameter("inputHostname");
			String descricao = request.getParameter("inputDescricao");
			String ip1 = request.getParameter("inputIp1");
			String ip2 = request.getParameter("inputIp2");
			String mascara = request.getParameter("inputMascara");
			String gateway = request.getParameter("inputGateway");
			String tipo = request.getParameter("inputTipo");
			String batismo = request.getParameter("inputBatismo");
			String serialNumber = request.getParameter("inputSerialNumber");
			String servico = request.getParameter("inputServico");

	        try{
	        	Equipamento equipamento = new Equipamento(id,hostname,descricao,ip1,ip2,mascara,gateway,tipo,batismo,serialNumber,servico);
		        System.out.println(equipamento);
	        	equipamentoDAO.update(equipamento);
		        request.setAttribute("msg",entidade+" Atualizado.");
	  		  	request.getRequestDispatcher("equipamento?op=list").
	  		    	         forward(request, response);
		        
	        }catch(Exception ex) {
	  			ex.printStackTrace();
	  			 request.setAttribute("err","Dados Invalidos : error" + ex.getMessage());
	  	    	  request.getRequestDispatcher("index.jsp").
	  	    	         forward(request, response);
	  		}
	    }
	
		private void showEditForm(HttpServletRequest request, HttpServletResponse response)
	            throws Exception {
	        int id = Integer.parseInt(request.getParameter("id"));
	        // List<Equipamento> equipamento = equipamentoDAO.getEquipamento(id);
	        Equipamento equipamento = equipamentoDAO.getEquipamentoById(id);
	
	        RequestDispatcher dispatcher = request.getRequestDispatcher("editarEquipamento.jsp");
	        request.setAttribute("title","Edicao de "+entidade);
	        request.setAttribute("equipamento", equipamento);
	        dispatcher.forward(request, response);
	    }
		
}

