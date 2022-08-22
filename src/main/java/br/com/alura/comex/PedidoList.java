package br.com.alura.comex;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class PedidoList {
	private List<Pedido> pedidos;
	
	public PedidoList() {
		pedidos = new ArrayList<Pedido>();
		
	}
	
	public void add(Pedido p) {
		pedidos.add(p);
	}
	public List<Pedido> getPedidos() {
		return pedidos;
	}
	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
	public List<String> listarClienteDosPedidos(){
		List<String> listaClientePedidos = new ArrayList();
		for (Pedido pedido : this.pedidos) {
			listaClientePedidos.add(pedido.getCliente());
		}
		return listaClientePedidos;
	}
	public TreeSet<String> listarCategoriaDosPedidosSemDuplicacao(){
		TreeSet<String> categoriaSemDuplicacao = new TreeSet<>(new NomeComparator());
		pedidos.forEach(pedido -> categoriaSemDuplicacao.add(pedido.getCategoria()));
		//categoriaSemDuplicacao.forEach(cliente -> {System.out.println(cliente);});
		return categoriaSemDuplicacao;
	}
}
