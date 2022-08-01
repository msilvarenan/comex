package br.com.alura.comex;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Main {
	
	public static void main(String[] args) {  
		ArrayList<Pedido> pedidos = ProcessadorDeCsv.processaArquivo("pedidos.csv");
						
		ArrayList<String> listaCliente = new ArrayList<>();
		
		
		for (Pedido pedido : pedidos) {
			if(!listaCliente.contains(pedido.getCliente())) {
				listaCliente.add(pedido.getCliente());
			} 

		}
		NomeComparator comparator = new NomeComparator();
		listaCliente.sort(comparator);
		
		for (String nome : listaCliente) {
			System.out.println(nome); 
		}
		
		
		/*ArrayList <String> listaOrdenada = (ArrayList<String>) listaCliente.stream().sorted().collect(Collectors.toList());
		for (String nome : listaOrdenada) {
			System.out.println(nome); 
		}*/
		
		

	}
}



