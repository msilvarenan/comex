package br.com.alura.comex;

import java.util.ArrayList;

public class Main {
	
	public static void main(String[] args) {  
		ArrayList<Pedido> pedidos = ProcessadorDeCsv.processaArquivo("pedidos.csv");
		//for (Pedido pedido : pedidos) {
		//	System.out.println(pedido.getCliente());
		//}
		Pedido primeiroPedido = pedidos.get(0);
		System.out.println("Primeiro pedido: " + primeiroPedido);
		Pedido ultimoPedido = pedidos.get(pedidos.size() -1);
		System.out.println("Último pedido: " + ultimoPedido);
		
				
		//System.out.println("Numero de pedidos: " + pedidos.size());
	}
}



//Primeiro pedido: Pedido{categoria='INFORMÁTICA', produto='Notebook Samsung', cliente='ANA', preco=3523.00, quantidade=1, data=2022-01-01}`
//Ultimo pedido: Pedido{categoria='INFORMÁTICA', produto='Galaxy Tab S8', cliente='BIA', preco=5939.10, quantidade=4, data=2022-01-02}