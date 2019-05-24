package frontend.api;

import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;

import frontend.model.Voiture;

/**
 * Interface to implement for interact with a REST API resource.
 */
interface Api<T> {

    /**
     * Get all object
     * @return List object
     */
	T[] getAll();

    /**
     * Get an element by is id
     * @param id : id of the element
     * @return the element
     */
    T get(int id);

    /**
     * Create a new element
     * @param entity : element to create
     * @return the element
     */
    T create(T entity) throws JsonProcessingException;

    /**
     * Edit an element
     * @param entity : element tu update
     * @return the element
     */
    T edit(T entity) throws JsonProcessingException;

    /**
     * Delete an element
     * @param id : id of the element
     * @return the element
     */
    T delete(int id);

	Voiture[] getWithFilters(Map<String, String> filters);


	
}
