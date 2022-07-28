package br.com.alura.comex;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
	
	public static void main(String[] args) {  
		ArrayList<Pedido> pedidos = ProcessadorDeCsv.processaArquivo("pedidos.csv");
						
		ArrayList<String> listaCategoria = new ArrayList<>();
		for (Pedido pedido : pedidos) {
			listaCategoria.add(pedido.getCategoria());
		}
		
		List<String> novaLista = listaCategoria.stream().distinct().sorted().collect(Collectors.toList());
		for (String nome : novaLista) {
			int quantidadePedidos = 0;
			for (Pedido pedido : pedidos) {
				if (pedido.getCategoria().equals(nome)) {
					quantidadePedidos++;
				}
			}
			System.out.println(nome + ": " + quantidadePedidos); 
		}
		
		

	}
}



