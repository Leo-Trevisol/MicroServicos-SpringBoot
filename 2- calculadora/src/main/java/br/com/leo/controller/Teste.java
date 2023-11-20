package br.com.leo.controller;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Teste {
	
	public static void main(String[] args) {
		
		Transaction transaction = null;
    	try {
    		Session session = ConexaoBD.getSessionFactory().openSession();
    		transaction = (Transaction) session.beginTransaction();
    		
    		DbUsuarios pess = new DbUsuarios();
    		
    		pess.setNome("leozin2");
    		pess.setEmail("leozin@gmail2.com");
    		pess.setSenha("545454545");
    		pess.setNascimento(new Date());
    		
    		session.persist(pess);
    		
    		transaction.commit();
    		
    		
    	}catch(Exception e) {
    		System.out.println("Erro ao cadastrar pessoa: " + e.getMessage());
    	}
		
	}

}
