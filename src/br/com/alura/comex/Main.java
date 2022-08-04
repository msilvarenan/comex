package br.com.alura.comex;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class Main {
	
	public static void main(String[] args) {  
		List<Pedido> pedidos = ProcessadorDeCsv.processaArquivo("pedidos.csv");
		//pedidos.stream().distinct().collect(Collectors.toList());
		//List<Pedido> novaLista = pedidos.stream().distinct().sorted().collect(Collectors.toList());
		//novaLista.forEach(pedido -> {System.out.println(pedido.getCategoria());});
		
		
		//Exercício 1: Lista de categorias sem duplicações
		Collection<String> listaMutavel = new HashSet<>(); 
		pedidos.forEach(pedido -> listaMutavel.add(pedido.getCategoria()));
		listaMutavel.forEach(categoria -> {System.out.println(categoria);});
			
	}
}



