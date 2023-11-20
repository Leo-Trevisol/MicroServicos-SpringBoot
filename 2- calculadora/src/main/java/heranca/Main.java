package heranca;

import java.util.Calendar;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import conexao.ConexaoBD;

public class Main {
	
	public static void main(String[] args) {
		
		Transaction transaction = null;
    	try {
    		Session session = ConexaoBD.getSessionFactory().openSession();
    		transaction = (Transaction) session.beginTransaction();
    		
    		DbUsuarios pess = new DbUsuarios();
    		
    		pess.setNome("leozin");
    		pess.setEmail("leozin@gmail.com");
    		pess.setSenha("54984081674");
    		pess.setNascimento(new Date());
    		
    		session.persist(pess);
    		
    		transaction.commit();
    		
    		
    	}catch(Exception e) {
    		System.out.println("Erro ao cadastrar pessoa: " + e.getMessage());
    	}
	}

}
