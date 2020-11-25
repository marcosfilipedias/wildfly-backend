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

import br.gov.mg.pmmg.challenge.analista.model.Procedimento;
import br.gov.mg.pmmg.challenge.analista.service.ProcedimentoBean;

@Path("/procedimento")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProcedimentoResource {

	@EJB
	private ProcedimentoBean procedimentoBean;
	

	@POST
	@Path("/save")
	@RolesAllowed("/analista/rest/procedimento/save")
	public Response salvar(Procedimento p) {
		try {
			this.procedimentoBean.save(p);
		} catch (Exception e) {
			return Response.status(Status.CONFLICT).entity(e).build();
		}
		return Response.ok(p).build();
	}

	@GET
	@Path("/buscarPorId/{id}")
	@RolesAllowed("/analista/rest/procedimento/buscarPorId")
	public Response buscarPorId(@PathParam("id") Long id) {
		try {
			return Response.ok(this.procedimentoBean.getProcedimentoById(id)).build();
		} catch (Exception e) {
			return Response.status(Status.CONFLICT).entity(e).build();
		}
	}

	@PUT
	@Path("/atualizar")
	@RolesAllowed("/analista/rest/procedimento/atualizar")
	public Response atualizar(Procedimento p) {
		try {
			this.procedimentoBean.save(p);
		} catch (Exception e) {
			return Response.status(Status.CONFLICT).entity(e).build();
		}
		return Response.noContent().build();
	}

	@DELETE
	@Path("/excluir/{id}")
	@RolesAllowed("/analista/rest/procedimento/excluir")
	public Response excluir(@PathParam("id") final Long id) {
		this.procedimentoBean.delete(id);
		return Response.noContent().build();
	}
}
