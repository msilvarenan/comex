package br.com.alura.comex;

public class Main {

  public static void main(String[] args) {
	  System.out.println("fazendo um teste para a branch semana 1");
    Pedido[] pedidos = ProcessadorDeCsv.processaArquivo("pedidos.csv");
  }
}
