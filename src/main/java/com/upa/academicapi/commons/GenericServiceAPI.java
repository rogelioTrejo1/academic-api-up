package com.upa.academicapi.commons;

import java.io.Serializable;
import java.util.List;

/**
 * Since we will be doing a "CRUD", we will establish the basic methods that
 * will take care of each one of the controllers to simplify some code.
 */
public interface GenericServiceAPI<T, ID extends Serializable> {

    /**
     * Save a new Entity (in this case, is the entity that we extends) in the Data Base
     * 
     * @param entity The Entity (Can be any Object)
     * @return the new Entity
     */
    T save(T entity);

    /**
     * Delete a specific entity
     * @param id Entity's ID
     */
    void delete(ID id);

    /**
     * Get an One Entity
     * @param id Entity's ID
     * @return The specific entity
     */
    T getOne(ID id);

    /**
     * Get all Entities in the Data Base
     * @return all Entities
     */
    List<T> getAll();

}
