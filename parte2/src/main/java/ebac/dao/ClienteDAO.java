package ebac.dao;

import ebac.dao.generics.GenericDAO;
import ebac.domain.Cliente;

public class ClienteDAO extends GenericDAO<Cliente, Long> implements IClienteDAO{

    public ClienteDAO(){
        super();
    }

    @Override
    public Class<Cliente> getTipoClasse() {
        return Cliente.class;
    }

    @Override
    public void atualizaDados(Cliente entity, Cliente entityCadastrado) {

    }
}
