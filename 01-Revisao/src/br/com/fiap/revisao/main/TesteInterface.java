package br.com.fiap.revisao.main;

import br.com.fiap.revisao.dao.CarroDao;
import br.com.fiap.revisao.dao.CarroOracleDao;
import br.com.fiap.revisao.model.Carro;

//  View (JSP) <-> Controller(Servlet) (CarroDao) <-> DAO <-> Banco de Dados

public class TesteInterface {
	
	public static void main(String[] args) {
		//Instanciar um objeto do tipo CarroDao
		CarroDao dao = new CarroOracleDao();
		//Chamar o método cadastrar
		dao.cadastrar(new Carro("Pegeout", 2019, false));
	}
	
}