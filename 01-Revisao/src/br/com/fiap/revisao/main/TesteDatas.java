package br.com.fiap.revisao.main;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class TesteDatas {

	public static void main(String[] args) {
		
		//Instanciar um objeto de data com a data atual
		Calendar hoje = Calendar.getInstance(); //Obtem a instância com a data atual
		
		//Instanciar um objeto com a data da entrega da challenge
		Calendar challenge = new GregorianCalendar(2021, Calendar.MAY, 15);
		
		//Objeto para formatar a data
		SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		//Exibir a data
		System.out.println(formatador.format(hoje.getTime()));
		
		System.out.println(formatador.format(challenge.getTime()));
		
	}
	
}