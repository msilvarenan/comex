package br.com.alura.comex;

public class Main {

  public static void main(String[] args) {
	  System.out.println("fazendo commit");
    Pedido[] pedidos = ProcessadorDeCsv.processaArquivo("pedidos.csv");
  }
}
