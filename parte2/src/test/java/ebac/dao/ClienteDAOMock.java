package ebac.dao;

import ebac.domain.Cliente;
import ebac.exception.TipoChaveNotFound;

import java.util.Collection;
import java.util.List;

public class ClienteDAOMock implements IClienteDAO {

    @Override
    public Boolean cadastrar(Cliente entity) throws TipoChaveNotFound {
        return true;
    }

    @Override
    public void excluir(Long valor) {

    }

    @Override
    public void atualizar(Cliente entity) throws TipoChaveNotFound {

    }

    @Override
    public Cliente consultar(Long valor) {
        Cliente cliente = new Cliente();
        cliente.setCpf(valor);
        return cliente;
    }

    @Override
    public Collection<Cliente> buscarTodos() {
        return null;
    }
}
