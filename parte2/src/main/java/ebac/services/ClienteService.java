package ebac.services;

import ebac.dao.IClienteDAO;
import ebac.domain.Cliente;
import ebac.exception.TipoChaveNotFound;
import ebac.services.generic.GenericService;

public class ClienteService extends GenericService<Cliente, Long> implements IClienteService {

    private IClienteDAO clienteDAO;

    public ClienteService(IClienteDAO clienteDAO) {
        super(clienteDAO);
        this.clienteDAO = clienteDAO;
    }

    @Override
    public Boolean salvar(Cliente cliente) throws TipoChaveNotFound {
        return clienteDAO.cadastrar(cliente);
    }

    @Override
    public Cliente buscarPorCpf(long cpf) {
        return this.dao.consultar(cpf);
    }

    @Override
    public void excluir(long cpf) {

    }

    @Override
    public void atualizar(Cliente cliente) {

    }
}
