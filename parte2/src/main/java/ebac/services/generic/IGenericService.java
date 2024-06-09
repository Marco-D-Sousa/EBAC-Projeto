package ebac.services.generic;

import ebac.dao.Persistente;
import ebac.exception.TipoChaveNotFound;

import java.io.Serializable;
import java.util.Collection;

public interface IGenericService <T extends Persistente, E extends Serializable>{

    public Boolean cadastrar(T entity) throws TipoChaveNotFound;
    public void excluir(E valor);
    public void alterar(T entity) throws TipoChaveNotFound;
    public T consultar(E valor);
    public Collection<T> buscarTodos();
}
