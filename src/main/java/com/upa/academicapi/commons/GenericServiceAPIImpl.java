package com.upa.academicapi.commons;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public abstract class GenericServiceAPIImpl<T, ID extends Serializable> implements GenericServiceAPI<T, ID> {

    @Override
    public T save(T entity) {
        return getDao().save(entity);
    }

    @Override
    public void delete(ID id) {
        getDao().deleteById(id);
    }

    @Override
    public T getOne(ID id) {
        Optional<T> obj = getDao().findById(id);

        if (obj.isPresent())
            return obj.get();

        return null;
    }

    @Override
    public List<T> getAll() {
        List<T> retunList = new ArrayList<>();
        getDao().findAll().forEach(obj -> retunList.add(obj));
        return retunList;
    }

    /**
     * Set the Dao of the CRUD (Any Entity that extendes)
     * @return the DAO
     */
    public abstract CrudRepository<T, ID> getDao();

}
