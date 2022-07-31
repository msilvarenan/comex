package br.com.alura.comex;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
	
	public static void main(String[] args) {  
				
		ArrayList<Pedido> pedidos = ProcessadorDeCsv.processaArquivo("pedidos.csv");
		ArrayList<String> listaCategoria = new ArrayList<>();
		
		//Gerando a lista de categoria sem duplicações
		for (Pedido pedido : pedidos) {
			 if(!listaCategoria.contains(pedido.getCategoria())) {
			 listaCategoria.add(pedido.getCategoria()); }
			 
		}
		
		//adicionando a quantidade de Pedidos por categoria
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



