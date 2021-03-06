package com.sinan.movieArchive.api.REST;


import com.sinan.movieArchive.dao.entity.BaseEntity;
import com.sinan.movieArchive.service.BaseService;
import com.sinan.movieArchive.service.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.persistence.MappedSuperclass;

/**
 * Some basic endpoints such as list all([GET] /), add new([POST] /), update([PUT] /) and delete([DELETE] /)
 * to be available in all extended REST APIs
 */
@MappedSuperclass
public abstract class BaseREST<E extends BaseEntity, S extends BaseService> {

	@Autowired
	S service;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public Page<E> listAll(Pageable pageable) {
		return service.findAll(pageable);
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public E addNew(@RequestBody E entity) throws ServiceException {
		return (E) service.addNew(entity);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public E update(@PathVariable("id") Integer id,
	                @RequestBody E entity) throws ServiceException {
		return (E) service.update(id, entity);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") Integer id) throws ServiceException {
		service.delete(id);
	}
}
