package com.upa.academicapi.commons;

import java.io.Serializable;
import java.util.List;

public interface GenericServiceAPI<T, ID extends Serializable> {
    
    /**
     * 
     * @param entity
     * @return
     */
    T save(T entity);

    /**
     * 
     * @param id
     */
    void delete(ID id);

    /**
     * 
     * @param id
     * @return
     */
    T getOne(ID id);

    /**
     * 
     * @return
     */
    List<T> getAll();

}
