package br.gov.mg.pmmg.challenge.analista.rest;

import java.util.Date;

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

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.gov.mg.pmmg.challenge.analista.json.JsonDateDesealize;
import br.gov.mg.pmmg.challenge.analista.model.Cliente;
import br.gov.mg.pmmg.challenge.analista.service.ClienteBean;

@Path("/client")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ClientResource {
	
	@EJB
	private ClienteBean clientBean;

	@POST
	@Path("/save")
	@RolesAllowed("/analista/rest/client/save")
	public Response salvar(String jsonClient) {
		try {
			//Client client = new Gson().fromJson(jsonClient, Client.class);
			Gson gson = new GsonBuilder().registerTypeAdapter(Date.class, new JsonDateDesealize()).create();
			Cliente client = gson.fromJson(jsonClient, Cliente.class);
			this.clientBean.save(client);
			return Response.ok(client).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Status.CONFLICT).entity(e).build();
		}
	}

	@GET
	@Path("/buscarPorId/{id}")
	@RolesAllowed("/analista/rest/client/buscarPorId")
	public Response buscarPorId(@PathParam("id") Long id) {
		try {
			this.clientBean.getClientById(id);
		} catch (Exception e) {
			return Response.status(Status.CONFLICT).entity(e).build();
		}
		return Response.noContent().build();
	}

	@PUT
	@Path("/atualizar")
	@RolesAllowed("/analista/rest/client/atualizar")
	public Response atualizar(String jsonClient) {
		try {
			Gson gson = new GsonBuilder().registerTypeAdapter(Date.class, new JsonDateDesealize()).create();
			Cliente client = gson.fromJson(jsonClient, Cliente.class);
			this.clientBean.save(client);
			return Response.ok(client).build();
		} catch (Exception e) {
			return Response.status(Status.CONFLICT).entity(e).build();
		}
	}

	@DELETE
	@Path("/excluir/{id}")
	@RolesAllowed("/analista/rest/client/excluir")
	public Response excluir(@PathParam("id") final Long id) {
		this.clientBean.delete(id);
		return Response.noContent().build();
	}
	
	@GET
	@Path("")
	@RolesAllowed("/analista/rest/client")
	public Response buscar() {
		try {
			return Response.ok(this.clientBean.getAllClients()).build();
		} catch (Exception e) {
			return Response.status(Status.CONFLICT).entity(e).build();
		}
		
	}
}