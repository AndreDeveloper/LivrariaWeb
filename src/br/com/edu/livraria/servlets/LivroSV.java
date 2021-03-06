package br.com.edu.livraria.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonParseException;

import br.com.edu.livraria.dao.LivroDAO;
import br.com.edu.livraria.entity.Livro;

@WebServlet("/LivroControl.do")
public class LivroSV extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LivroSV() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Livro> livros = new LivroDAO().selectAll();
		String json = "";
		try {
			json = new Gson().toJson(livros);
			response.setContentType("application/json");
			response.getWriter().write(json);
		} catch (JsonParseException e) {
			PrintWriter writer = response.getWriter();
			writer.write(json.toString());
			writer.write(e.getMessage());
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		LivroDAO dao = new LivroDAO();
		BufferedReader reader = request.getReader();
		StringBuffer json = new StringBuffer();
		String linha = "";
		while ((linha = reader.readLine()) != null) {
			json.append(linha);
		}
		System.out.println("resposta:" + json.toString());
		try {
			while ((linha = reader.readLine()) != null) {
				json.append(linha);
			}
			Livro livro = new Gson().fromJson(json.toString(), Livro.class);
			System.out.println("resposta:" + json.toString());
			if (json.toString() != "") {
				if (livro != null) {
					dao.insert(livro);
					System.out.println("resposta:" + json.toString());
					System.out.println("contato" + livro.toString());
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
