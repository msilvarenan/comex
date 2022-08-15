package br.com.alura.comex;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.Dom4JDriver;

public class ProcessadorDeXML {
	
	public static List<Pedido> processaArquivoXML(String nomeArquivo) throws URISyntaxException {
        try {
            XStream xstream = new XStream(new Dom4JDriver());
            xstream.alias("pedido", ArrayList.class);
           //xStream.processAnnotations(Pedido.class);
           
           //String xml = xstream.toXML(pedido);
           
            
            
            URL recursoCSV = ClassLoader.getSystemResource(nomeArquivo);
    	    Path caminhoDoArquivo = Path.of(recursoCSV.toURI());
    	    File file = new File(caminhoDoArquivo.toString());
    	    
    	    //Pedido pedidoTeste = (Pedido)xstream.fromXML(file);
    	    
    	    BufferedReader xml = new BufferedReader(new FileReader(file));
            

            //BufferedReader input = new BufferedReader(new FileReader("enderecos.xml"));
            List<Pedido> pedidos = (ArrayList) xstream.fromXML(xml);
            xml.close();

            for (Pedido pedido : pedidos) {
                System.out.println("Categorias: " + pedido.getCategoria());
            }
            return pedidos;
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        List<Pedido> pedidos = (List<Pedido>) new Pedido(nomeArquivo, nomeArquivo, nomeArquivo, null, 0, null);
		return pedidos;
       
    }
	
	
	/*
	 * public static List<Pedido> processaArquivoXML(String nomeArquivo) throws
	 * URISyntaxException, IOException{ //private XStream xCon;
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * URL recursoCSV = ClassLoader.getSystemResource(nomeArquivo); Path
	 * caminhoDoArquivo = Path.of(recursoCSV.toURI()); File file = new
	 * File(caminhoDoArquivo.toString());
	 * 
	 * BufferedReader arquivo = new BufferedReader(new FileReader(file));
	 * StringBuffer sb = new StringBuffer(); String line = ""; while ((line =
	 * arquivo.readLine()) != null) { sb.append(line); } arquivo.close();
	 * 
	 * List<Pedido> pedidos = new ArrayList(); //almacen.clear();
	 * 
	 * //XStream xstream = new XStream();
	 * 
	 * //Object myObject2 = xstream.fromXML(xml); // deserialize from XML
	 * 
	 * //pedidos = (List<Pedido>) xstream.fromXML(caminhoDoArquivo.toString());
	 * //logger.info(pedidos); //xs.alias("pedido", Pedido.class);
	 * //xs.alias("ListaPedidos", pedidos); //pedidos = (List<Pedido>)
	 * xs.fromXML(new FileInputStream("pedidos.xml")); return pedidos;
	 * 
	 * }
	 */
	
	

}
