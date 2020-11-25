package br.gov.mg.pmmg.challenge.analista.rest;

import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import br.gov.mg.pmmg.challenge.analista.model.Ficha;
import br.gov.mg.pmmg.challenge.analista.service.FichaBean;

@Path("/ficha")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FichaResource {

	@EJB
	private FichaBean fichaBean;

	@POST
	@Path("/save")
	@RolesAllowed("/analista/rest/ficha/save")
	public Response salvar(Ficha f) {
		try {
			this.fichaBean.save(f);
		} catch (Exception e) {
			return Response.status(Status.CONFLICT).entity(e).build();
		}
		return Response.ok(f).build();
	}

	@GET
	@Path("/buscarPorId/{id}")
	@RolesAllowed("/analista/rest/ficha/buscarPorId")
	public Response buscarPorId(@PathParam("id") Long id) {
		try {
			this.fichaBean.getFichaById(id);
		} catch (Exception e) {
			return Response.status(Status.CONFLICT).entity(e).build();
		}
		return Response.noContent().build();
	}

	@PUT
	@Path("/atualizar")
	@RolesAllowed("/analista/rest/ficha/atualizar")
	public Response atualizar(Ficha f) {
		try {
			this.fichaBean.save(f);
		} catch (Exception e) {
			return Response.status(Status.CONFLICT).entity(e).build();
		}
		return Response.noContent().build();
	}

	@DELETE
	@Path("/excluir/{id}")
	@RolesAllowed("/analista/rest/ficha/excluir")
	public Response excluir(@PathParam("id") final Long id) {
		this.fichaBean.delete(id);
		return Response.noContent().build();
	}
}
