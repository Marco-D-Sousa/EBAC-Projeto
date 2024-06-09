import ebac.dao.ClienteDAO;
import ebac.dao.ClienteDAOMock;
import ebac.dao.IClienteDAO;
import ebac.domain.Cliente;
import ebac.exception.TipoChaveNotFound;
import ebac.services.ClienteService;
import ebac.services.IClienteService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

public class ClienteDAOTest {

    private Cliente cliente;
    private IClienteDAO clienteDAO;

    public ClienteDAOTest(){
        clienteDAO = new ClienteDAO();
    }

    @BeforeEach
    public void init() throws TipoChaveNotFound {
        cliente = new Cliente();
        cliente.setCpf(12312312312L);
        cliente.setNome("Rodrigo");
        cliente.setCidade("São Paulo");
        cliente.setEndereco("End");
        cliente.setEstado("SP");
        cliente.setTelefone(1199999999L);

        clienteDAO.cadastrar(cliente);
    }

    @Test
    public void pesquisarCliente() {

        Cliente clienteConsultado = clienteDAO.consultar(cliente.getCpf());
        Assertions.assertNotNull(clienteConsultado);
    }

    @Test
    public void salvarCliente() throws TipoChaveNotFound {
        cliente.setCpf(56565656565L);
        Boolean retorno = clienteDAO.cadastrar(cliente);
        assertTrue(retorno);
    }

    @Test
    public void excluirCliente() {

        clienteDAO.excluir(cliente.getCpf());
    }

    @Test
    public void atualizarCliente() throws TipoChaveNotFound {

        cliente.setNome("Rodrigo Pires");
        clienteDAO.atualizar(cliente);
        Assertions.assertEquals("Rodrigo Pires", cliente.getNome());
    }

    @Test
    public void buscarTodos() {
        Collection<Cliente> list = clienteDAO.buscarTodos();
        assertNotNull(list);
        assertEquals(2, list.size());
    }
}
