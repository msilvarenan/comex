package br.com.alura.comex;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
	
	public static void main(String[] args) {  
		ArrayList<Pedido> pedidos = ProcessadorDeCsv.processaArquivo("pedidos.csv");
		
		//Pedido primeiroPedido = pedidos.get(0);
		//System.out.println("Primeiro pedido: " + primeiroPedido);
		//Pedido ultimoPedido = pedidos.get(pedidos.size() -1);
		//System.out.println("Último pedido: " + ultimoPedido);
		
				
		ArrayList<String> listaCategoria = new ArrayList<>();
		for (Pedido pedido : pedidos) {
			listaCategoria.add(pedido.getCategoria());
		}
		//System.out.println(listaCategoria);
		//for (String cliente : listaClientes) {
		//	System.out.println(cliente);
			
		//}
		
		/*
		 * var comparator = new PrecoPedidoComparator(); pedidos.sort(comparator);
		 * 
		 * for (Pedido pedido : pedidos) { System.out.println(pedido.getPreco()); }
		 */
		List<String> newList = listaCategoria.stream().distinct().collect(Collectors.toList());
		for (String categoria : newList) {
			System.out.println(categoria); 
		}
		// Print the ArrayList with duplicates removed
		//System.out.println(newList);
		
		
		
	}
}



