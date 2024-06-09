package ebac.services.generic;

import ebac.dao.Persistente;
import ebac.dao.generics.IGenericDAO;
import ebac.exception.TipoChaveNotFound;

import java.io.Serializable;
import java.util.Collection;

public abstract class GenericService <T extends Persistente, E extends Serializable> implements IGenericService<T, E>{

    protected IGenericDAO<T,E> dao;

    public GenericService(IGenericDAO<T,E> dao) {
        this.dao = dao;
    }

    @Override
    public Boolean cadastrar(T entity) throws TipoChaveNotFound {
        return this.dao.cadastrar(entity);
    }

    @Override
    public void excluir(E valor) {
        this.dao.excluir(valor);
    }

    @Override
    public void alterar(T entity) throws TipoChaveNotFound {
        this.dao.atualizar(entity);
    }

    @Override
    public T consultar(E valor) {
        return this.dao.consultar(valor);
    }

    @Override
    public Collection<T> buscarTodos() {
        return this.dao.buscarTodos();
    }
}
