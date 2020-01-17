package pt.upacademy.coreFinalProject.controllers;

import java.util.Collection;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import pt.upacademy.coreFinalProject.models.EntityRoot;
import pt.upacademy.coreFinalProject.models.DTOS.EntityDTO;
import pt.upacademy.coreFinalProject.models.converters.EntityConverter;
import pt.upacademy.coreFinalProject.repositories.EntityRepository;
import pt.upacademy.coreFinalProject.services.EntityService;


public abstract class EntityControllerDTO<S extends EntityService<R, E>, R extends EntityRepository<E>, C extends EntityConverter< E, D>, E extends EntityRoot, D extends EntityDTO> {

	
	@Inject
	protected S service;
	
	@Inject
	protected C converter;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<D> get() {
		return service.get().stream().map(E -> converter.toDTO(E)).collect(Collectors.toList());
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public D get(@PathParam("id") long id) {
		return converter.toDTO(service.get(id));
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String create(D user) {
		service.create(converter.toEntity(user));
		return "Create Done!";
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String update(D user) {
		service.update(converter.toEntity(user));
		return "Update Done!";
	}
	
	@DELETE
	@Path("/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public String delete(@PathParam("id") long id) {
		service.delete(id);
		return "Delete Done!";
	}
	
}