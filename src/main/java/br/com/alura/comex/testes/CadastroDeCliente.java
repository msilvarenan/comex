package br.com.alura.comex.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.comex.modelo.Cliente;

public class CadastroDeCliente {

	public static void main(String[] args) {
		Cliente cliente = new Cliente("Renan Mattos Silva", 228228228, 12341234, "rmsilva@brq.com", "desenvolvedor", "ATIVO");
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("comex");
		EntityManager em = factory.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(cliente);
		em.getTransaction().commit();
		em.close();

	}

}
