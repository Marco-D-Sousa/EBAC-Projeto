package ClienteTeste;

import ebac.dao.ClienteDAO;
import ebac.dao.IClienteDAO;
import ebac.domain.Cliente;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ClienteTeste {
	
	private IClienteDAO clienteDAO;
	
	@Test
	public void cadastrarTeste() throws Exception {
		clienteDAO = new ClienteDAO();
		
		Cliente cliente = new Cliente();
		cliente.setCodigo("10");
		cliente.setNome("Xunda");
		
		Integer countCad = clienteDAO.cadastrar(cliente);
		Assertions.assertEquals(1, (int) countCad);
		
		Cliente clienteBD = clienteDAO.buscar("10");
		Assertions.assertNotNull(clienteBD);
		Assertions.assertEquals(cliente.getCodigo(), clienteBD.getCodigo());
		Assertions.assertEquals(cliente.getNome(), clienteBD.getNome());
		
		Integer countDel = clienteDAO.excluir(clienteBD);
		Assertions.assertEquals(1, (int) countDel);
	}
	
	@Test
	public void buscarTeste() throws Exception {
		clienteDAO = new ClienteDAO();
		
		Cliente cliente = new Cliente();
		cliente.setCodigo("10");
		cliente.setNome("Xunda Buscar");
		Integer countCad = clienteDAO.cadastrar(cliente);
		Assertions.assertEquals(1, (int) countCad);
		
		Cliente clienteBD = clienteDAO.buscar("10");
		Assertions.assertNotNull(clienteBD);
		Assertions.assertEquals(cliente.getCodigo(), clienteBD.getCodigo());
		Assertions.assertEquals(cliente.getNome(), clienteBD.getNome());
		
		Integer countDel = clienteDAO.excluir(clienteBD);
		Assertions.assertEquals(1, (int) countDel);
	}
	
	@Test
	public void excluirTeste() throws Exception {
		clienteDAO = new ClienteDAO();
		
		Cliente cliente = new Cliente();
		cliente.setCodigo("10");
		cliente.setNome("Xunda Excluir");
		Integer countCad = clienteDAO.cadastrar(cliente);
		Assertions.assertEquals(1, (int) countCad);
		
		Cliente clienteBD = clienteDAO.buscar("10");
		Assertions.assertNotNull(clienteBD);
		Assertions.assertEquals(cliente.getCodigo(), clienteBD.getCodigo());
		Assertions.assertEquals(cliente.getNome(), clienteBD.getNome());
		
		Integer countDel = clienteDAO.excluir(clienteBD);
		Assertions.assertEquals(1, (int) countDel);
	}
	
	@Test
	public void buscarTodosTeste() throws Exception {
		clienteDAO = new ClienteDAO();
		
		Cliente cliente1 = new Cliente();
		cliente1.setCodigo("10");
		cliente1.setNome("Xunda Todos");
		Integer countCad1 = clienteDAO.cadastrar(cliente1);
		Assertions.assertEquals(1, (int) countCad1);
		
		Cliente cliente2 = new Cliente();
		cliente2.setCodigo("20");
		cliente2.setNome("Fulano Todos");
		Integer countCad2 = clienteDAO.cadastrar(cliente2);
		Assertions.assertEquals(1, (int) countCad2);
		
		List<Cliente> list = clienteDAO.buscarTodos();
		Assertions.assertNotNull(list);
		Assertions.assertEquals(2, list.size());
		
		clienteDAO.excluir(cliente1);
		clienteDAO.excluir(cliente2);
	}
	
	@Test
	public void atualizarTeste() throws Exception {
		clienteDAO = new ClienteDAO();
		
		Cliente cliente = new Cliente();
		cliente.setCodigo("10");
		cliente.setNome("Rodrigo Pires");
		Integer countCad = clienteDAO.cadastrar(cliente);
		Assertions.assertTrue(countCad == 1);
		
		Cliente clienteBD = clienteDAO.buscar("10");
		Assertions.assertNotNull(clienteBD);
		Assertions.assertEquals(cliente.getCodigo(), clienteBD.getCodigo());
		Assertions.assertEquals(cliente.getNome(), clienteBD.getNome());
		
		clienteBD.setCodigo("20");
		clienteBD.setNome("Outro nome");
		Integer countUpdate = clienteDAO.atualizar(clienteBD);
		Assertions.assertTrue(countUpdate == 1);
		
		Cliente clienteBD1 = clienteDAO.buscar("10");
		Assertions.assertNull(clienteBD1);
		
		Cliente clienteBD2 = clienteDAO.buscar("20");
		Assertions.assertNotNull(clienteBD2);
		Assertions.assertEquals(clienteBD.getId(), clienteBD2.getId());
		Assertions.assertEquals(clienteBD.getCodigo(), clienteBD2.getCodigo());
		Assertions.assertEquals(clienteBD.getNome(), clienteBD2.getNome());
		
		List<Cliente> list = clienteDAO.buscarTodos();
		for (Cliente cli : list) {
			clienteDAO.excluir(cli);
		}
	}
}
