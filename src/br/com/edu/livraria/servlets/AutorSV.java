package br.com.edu.livraria.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonParseException;

import br.com.edu.livraria.dao.AutorDAO;
import br.com.edu.livraria.entity.Autor;

/**
 * Servlet implementation class AutorSV
 */
@WebServlet("/AutorControl.do")
public class AutorSV extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AutorSV() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<String> autores = new ArrayList<String>();
		AutorDAO dao = new AutorDAO();
		for(Autor a: dao.selectAll()){
			autores.add(a.getNomeAutor());
		}
		String json = "";
		try {
			json = new Gson().toJson(autores);
			response.setContentType("application/json");
			response.getWriter().write(json);
		} catch (JsonParseException e) {
			PrintWriter writer = response.getWriter();
			writer.write(json.toString());
			writer.write(e.getMessage());
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
