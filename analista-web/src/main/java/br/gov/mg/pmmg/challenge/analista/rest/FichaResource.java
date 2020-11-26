package br.gov.mg.pmmg.challenge.analista.rest;

import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import br.gov.mg.pmmg.challenge.analista.service.FichaBean;

@Path("/ficha")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FichaResource {

	@EJB
	private FichaBean fichaBean;

	@GET
	@Path("/marcarProcedimento/cliente/{idCliente}/procedimento/{idProcedimento}")
	@RolesAllowed("/analista/rest/ficha/buscarPorId")
	public Response buscarPorId(@PathParam("idCliente") Long idCliente, @PathParam("idProcedimento") Long idProcedimento) {
		try {
			this.fichaBean.marcarProcedimento(idCliente, idProcedimento);
		} catch (Exception e) {
			return Response.status(Status.CONFLICT).entity(e).build();
		}
		return Response.noContent().build();
	}
}
