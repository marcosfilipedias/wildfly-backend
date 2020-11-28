package br.gov.mg.pmmg.challenge.analista.test;

import java.io.File;

import javax.ejb.EJB;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.junit.InSequence;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.gov.mg.pmmg.challenge.analista.model.Cliente;
import br.gov.mg.pmmg.challenge.analista.service.ClienteBean;

@RunWith(Arquillian.class)
public class ClienteBeanTest {

	@Deployment
	public static Archive<?> createTestArchive() {
        File[] files = Maven.resolver().loadPomFromFile("pom.xml")
                .importRuntimeDependencies().resolve().withTransitivity().asFile();
        
		return ShrinkWrap.create(WebArchive.class).addPackages(true, "br.gov.mg.pmmg.challenge.analista.model")
				.addAsResource("META-INF/test-persistence.xml", "META-INF/persistence.xml")
				.addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml")
				.addAsWebInfResource("test-ds.xml")
				.addAsLibraries(files);
	}
	
	@EJB
	private ClienteBean clienteService;

	@Test @InSequence(1)
	public void testeSalvar() {        
		Cliente cliente = new Cliente();
		cliente.setNome("João");
		cliente.setCpf("11111111111");
		clienteService.save(cliente);
		Assert.assertNotNull(cliente.getId());
	}

}
