package br.com.edu.livraria.test;

import static org.junit.Assert.fail;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.edu.livraria.dao.LivroDAO;

public class UTC_LivroDao {
	private static LivroDAO dao;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		dao = new LivroDAO();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void getTodosLivro() {
		Assert.assertTrue(dao.selectAll().size() > 0);
	}

}
