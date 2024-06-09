import ebac.dao.ClienteDAOMock;
import ebac.dao.IClienteDAO;
import ebac.domain.Cliente;
import ebac.exception.TipoChaveNotFound;
import ebac.services.ClienteService;
import ebac.services.IClienteService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ClienteServiceTest {

    private IClienteService clienteService;
    private Cliente cliente;

    public ClienteServiceTest() {
        IClienteDAO dao = new ClienteDAOMock();
        clienteService = new ClienteService(dao);
    }

    @BeforeEach
    public void init() {
        cliente = new Cliente();
        cliente.setNome("Xunda");
        cliente.setCidade("Bonn");
        cliente.setCpf(12332112345L);
        cliente.setEstado("Para");
        cliente.setEndereco("Am Fahrweg");
    }

    @Test
    public void pesquisarCliente() {

        Cliente clienteConsultado = clienteService.buscarPorCpf(cliente.getCpf());
        Assertions.assertNotNull(clienteConsultado);
    }

    @Test
    public void salvarCliente() throws TipoChaveNotFound {

        Boolean retorno = clienteService.salvar(cliente);
        Assertions.assertTrue(retorno);
    }

    @Test
    public void excluirCliente() {

        clienteService.excluir(cliente.getCpf());
    }

    @Test
    public void atualizarCliente() {

        cliente.setNome("Nome Alterado");
        clienteService.atualizar(cliente);
        Assertions.assertEquals("Nome Alterado", cliente.getNome());
    }
}
