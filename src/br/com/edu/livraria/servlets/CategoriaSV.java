package br.com.edu.livraria.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonParseException;

import br.com.edu.livraria.dao.CategoriaDAO;

@WebServlet("/CategoriaControl.do")
public class CategoriaSV extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CategoriaSV() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<String> categorias = new CategoriaDAO().selectAll();
		String json = "";
		try {
			json = new Gson().toJson(categorias);
			response.setContentType("application/json");
			response.getWriter().write(json);
		} catch (JsonParseException e) {
			PrintWriter writer = response.getWriter();
			writer.write(json.toString());
			writer.write(e.getMessage());
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
