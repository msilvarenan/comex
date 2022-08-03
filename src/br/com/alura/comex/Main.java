package br.com.alura.comex;

import java.util.ArrayList;
import java.util.List;

public class Main {
	
	public static void main(String[] args) {  
		//Exercício 1: usando o Array List
		List<Pedido> pedidos = ProcessadorDeCsv.processaArquivo("pedidos.csv");
		
		//Exercício 2: Número de pedidos
		//System.out.println("Número de pedidos: "+pedidos.size());
		
		
		//Exercício 3: Imprima informações do primeiro e do último pedidos
		//System.out.println("Primeiro pedido: " + pedidos.get(0));
		//System.out.println("Último pedido: " + (pedidos.get(pedidos.size() - 1)));
		
		//Exercício 4: Lista com nomes dos clientes
		//for (Pedido pedido : pedidos) {
			//System.out.println(pedido.getCliente());
		//}
		
		//Exercício 5: Lista ordenada de preços
		//var comparator = new PrecoPedidoComparator();
		//pedidos.sort(comparator);

		//for (Pedido pedido : pedidos) {
			//System.out.println(pedido.getPreco());
		//
		//}
		
		//Exercício 6:Lista de categorias sem duplicações
		/*List<String> listaCategoria = new ArrayList<>();
		for (Pedido pedido : pedidos) {
			if(!listaCategoria.contains(pedido.getCategoria())) {
				listaCategoria.add(pedido.getCategoria());
				System.out.println(pedido.getCategoria());
			} 
		}*/
		
		//Exercício 7: Lista ordenada de clientes sem duplicações
		/*List<String> listaCliente = new ArrayList<>();
		for (Pedido pedido : pedidos) {
			if(!listaCliente.contains(pedido.getCliente())) {
				listaCliente.add(pedido.getCliente());
			} 
		}
		var comparator = new NomeComparator();
		listaCliente.sort(comparator);
		for (String nome : listaCliente) {
			System.out.println(nome);
		}*/
		
		// Exercício 8: Relatório de número de pedidos por categoria
		List<String> listaCategoria = new ArrayList<>();
		for (Pedido pedido : pedidos) {
			if(!listaCategoria.contains(pedido.getCategoria())) {
				listaCategoria.add(pedido.getCategoria());
			} 
		}
		for (String categoria : listaCategoria) {
			int quantidadePedidos = 0;
			for (Pedido pedido : pedidos) {
				if (pedido.getCategoria().equals(categoria)) {
					quantidadePedidos++;
				}
			}
			System.out.println(categoria + ": " + quantidadePedidos); 
		}
		
	}
}



