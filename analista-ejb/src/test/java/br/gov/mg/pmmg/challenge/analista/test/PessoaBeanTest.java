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
import org.json.simple.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.gov.mg.pmmg.challenge.analista.model.Client;
import br.gov.mg.pmmg.challenge.analista.service.ClientBean;
import br.gov.mg.pmmg.challenge.analista.utils.UtilJson;

@RunWith(Arquillian.class)
public class PessoaBeanTest {

	/*@Deployment
	public static Archive<?> createTestArchive() {
		 // Import Maven runtime dependencies
        File[] files = Maven.resolver().loadPomFromFile("pom.xml")
                .importRuntimeDependencies().resolve().withTransitivity().asFile();
        
		return ShrinkWrap.create(WebArchive.class).addPackages(true, "br.gov.mg.pmmg.challenge.analista.model")
				.addClasses(PessoaBean.class, EstadoBean.class, UtilJson.class)
				.addAsResource("META-INF/test-persistence.xml", "META-INF/persistence.xml")
				.addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml")
				.addAsWebInfResource("test-ds.xml")
				.addAsLibraries(files);		
	}*/
	
	@EJB
	private ClientBean clientService;

	/*@Test @InSequence(1)
	public void testeSalvar() {        
		Cliente pessoa = new Cliente();
		pessoa.setNome("João");
		pessoa.setCpf("11111111111");
		pessoa.setRegistroGeral("11222333");
		pessoaBean.salvar(pessoa);
		Assert.assertNotNull(pessoa.getId());
	}*/

}
