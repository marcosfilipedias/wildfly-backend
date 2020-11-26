package br.gov.mg.pmmg.challenge.analista.test;

import javax.ejb.EJB;

import org.jboss.arquillian.junit.Arquillian;
import org.junit.runner.RunWith;

import br.gov.mg.pmmg.challenge.analista.service.ClientBean;

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
