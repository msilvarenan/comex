package br.com.alura.comex;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
	
	public static void main(String[] args) {  
		ArrayList<Pedido> pedidos = ProcessadorDeCsv.processaArquivo("pedidos.csv");
						
		ArrayList<String> listaCliente = new ArrayList<>();
		for (Pedido pedido : pedidos) {
			listaCliente.add(pedido.getCliente());
		}
		
		List<String> novaLista = listaCliente.stream().distinct().sorted().collect(Collectors.toList());
		for (String nome : novaLista) {
			System.out.println(nome); 
		}
		
		

	}
}



