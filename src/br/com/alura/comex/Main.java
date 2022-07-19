package br.com.alura.comex;

public class Main {

  public static void main(String[] args) {
    Pedido[] pedidos = ProcessadorDeCsv.processaArquivo("pedidos.csv");
  }
}
