package ebac.services;

import ebac.domain.Cliente;
import ebac.exception.TipoChaveNotFound;

public interface IClienteService {

    Boolean salvar(Cliente cliente) throws TipoChaveNotFound;

    Cliente buscarPorCpf(long cpf);

    void excluir(long cpf);

    void atualizar(Cliente cliente);
}
