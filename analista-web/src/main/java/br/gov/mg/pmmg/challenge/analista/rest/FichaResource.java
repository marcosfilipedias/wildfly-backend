package br.gov.mg.pmmg.challenge.analista.rest;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.gov.mg.pmmg.challenge.analista.service.FichaBean;

@Path("/ficha")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FichaResource {

	@EJB
	private FichaBean fichaBean;
	
}
