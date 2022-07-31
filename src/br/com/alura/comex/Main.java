package br.com.alura.comex;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
	
	public static void main(String[] args) {  
		ArrayList<Pedido> pedidos = ProcessadorDeCsv.processaArquivo("pedidos.csv");
						
		ArrayList<String> listaCategoria = new ArrayList<>();
		
		for (Pedido pedido : pedidos) {
			if(!listaCategoria.contains(pedido.getCategoria())) {
				listaCategoria.add(pedido.getCategoria());
			}
			
		}
		
		for (String Categoria: listaCategoria) {
			System.out.println(Categoria);
		}
	}
}



