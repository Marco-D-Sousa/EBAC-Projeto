package ProdutoTeste;

import ebac.dao.IProdutoDAO;
import ebac.dao.ProdutoDAO;
import ebac.domain.Produto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ProdutoTeste {
	
	private IProdutoDAO produtoDAO;
	
	@Test
	public void cadastrarTeste() throws Exception {
		produtoDAO = new ProdutoDAO();
		
		Produto produto = new Produto();
		produto.setNome("Primeiro Produto");
		produto.setCodigo("111");
		produto.setDescricao("Descricao de Teste");
		
		Integer countCAD = produtoDAO.cadastrar(produto);
		Assertions.assertEquals(1, (int) countCAD);
	}
	
	@Test
	public void buscarTeste() throws Exception {
		produtoDAO = new ProdutoDAO();
		
		Produto produto = new Produto();
		produto.setNome("Primeiro Produto");
		produto.setCodigo("123");
		produto.setDescricao("Descricao de Teste");
		
		produtoDAO.cadastrar(produto);
		
		Produto produtoBD = produtoDAO.buscar("123");
		Assertions.assertNotNull(produtoBD);
		Assertions.assertEquals(produto.getNome(), produtoBD.getNome());
		Assertions.assertEquals(produto.getCodigo(), produtoBD.getCodigo());
		Assertions.assertEquals(produto.getDescricao(), produtoBD.getDescricao());
	}
	
	@Test
	public void excluirTeste() throws Exception {
		produtoDAO = new ProdutoDAO();
		
		Produto produto = new Produto();
		produto.setNome("Primeiro Produto");
		produto.setCodigo("123");
		produto.setDescricao("Descricao de Teste");
		
		produtoDAO.cadastrar(produto);
		
		Produto produtoBD = produtoDAO.buscar("123");
		
		Integer countDel = produtoDAO.excluir(produtoBD);
		Assertions.assertEquals(1, (int) countDel);
	}
	
	@Test
	public void buscarTodosTeste() throws Exception {
		produtoDAO = new ProdutoDAO();
		
		Produto produto1 = new Produto();
		produto1.setNome("Produto 1");
		produto1.setCodigo("123");
		produto1.setDescricao("Desc. Produto 1");
		produtoDAO.cadastrar(produto1);
		
		Produto produto2 = new Produto();
		produto2.setNome("Produto 2");
		produto2.setCodigo("456");
		produto2.setDescricao("Desc. Produto 2");
		produtoDAO.cadastrar(produto2);
		
		List<Produto> produtos = produtoDAO.buscarTodos();
		Assertions.assertNotNull(produtos);
		Assertions.assertEquals(2, produtos.size());
		
		produtoDAO.excluir(produto1);
		produtoDAO.excluir(produto2);
	}
	
	@Test
	public void atualizarTeste() throws Exception {
		produtoDAO = new ProdutoDAO();
		
		Produto produto = new Produto();
		produto.setNome("Nome Original");
		produto.setCodigo("000");
		produto.setDescricao("Desc. Original");
		produtoDAO.cadastrar(produto);
		
		Produto produtoA = produtoDAO.buscar("000");
		
		produtoA.setNome("Nome Alterado");
		produtoA.setDescricao("Desc. Alterada");
		produtoA.setCodigo("111");
		produtoDAO.atualizar(produtoA);
		
		Produto produtoB = produtoDAO.buscar("111");
		Assertions.assertNotNull(produtoB);
		Assertions.assertEquals(produtoA.getNome(), produtoB.getNome());
		Assertions.assertEquals(produtoA.getCodigo(), produtoB.getCodigo());
		Assertions.assertEquals(produtoA.getDescricao(), produtoB.getDescricao());
		
		List<Produto> produtos = produtoDAO.buscarTodos();
		for (Produto p : produtos) {
			produtoDAO.excluir(p);
		}
	}
}
