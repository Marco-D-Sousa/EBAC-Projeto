package ebac.dao.generics;

import ebac.dao.Persistente;
import ebac.exception.TipoChaveNotFound;

import java.io.Serializable;
import java.util.Collection;

public interface IGenericDAO <T extends Persistente, E extends Serializable>{

    public Boolean cadastrar(T entity) throws TipoChaveNotFound;

    public void excluir(E valor);

    public void atualizar(T entity) throws TipoChaveNotFound;

    public T consultar(E valor);

    public Collection<T> buscarTodos();
}
