package modelo;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Restaurante {
	
	private Pedido pedidoEnCurso;
	private List<Pedido> pedidos;
	private List<ProductoMenu> menuBase;
	private List<Ingrediente> ingredientes;
	private List<Combo> combos;
	
	public Restaurante()
	{
		
	}
	
	public void iniciarPedido(String name, String address)
	{
		Pedido order = new Pedido(name,address);
		pedidos.add(order);
		pedidoEnCurso = order;
	}
	
	public void cerrarYGuardarPedido()
	{
		this.pedidoEnCurso = new Pedido();
	}
	
	public Pedido getPedidoEnCurso()
	{
		return this.pedidoEnCurso;
	}
	
	public ArrayList<ProductoMenu> getMenuBase()
	{
		return (ArrayList<ProductoMenu>) this.menuBase;
	}
	
	public ArrayList<Ingrediente> getIngredienteBase()
	{
		return (ArrayList<Ingrediente>) this.ingredientes;
	}
	
	public ArrayList<Pedido> getOrders()
	{
		return (ArrayList<Pedido>) this.pedidos; 
	}
	
	public void cargarInformacion(File ingFile, File menuFile, File comboFile) throws FileNotFoundException, IOException
	{
		cargarIngredientes(ingFile);
		cargarMenu(menuFile);
		cargarCombos(comboFile);
	}
	
	private void cargarIngredientes(File ingFile) throws FileNotFoundException, IOException
	{
		
		BufferedReader br = new BufferedReader(new FileReader(ingFile));
		String linea = br.readLine(); // La primera línea del archivo se ignora porque únicamente tiene los títulos de
										// las columnas
		linea = br.readLine();
		while (linea != null) // Cuando se llegue al final del archivo, linea tendrá el valor null
		{
			String[] parts = linea.split(";");
			String name = parts[0];
			int price = Integer.parseInt(parts[1]);
			
			Ingrediente ing = new Ingrediente(name,price);
			this.ingredientes.add(ing);
			
		}
		
		br.close();
		
	}
	
	private void cargarMenu(File menuFile) throws FileNotFoundException, IOException
	{
		
		BufferedReader br = new BufferedReader(new FileReader(menuFile));
		String linea = br.readLine(); // La primera línea del archivo se ignora porque únicamente tiene los títulos de
										// las columnas
		linea = br.readLine();
		while (linea != null) // Cuando se llegue al final del archivo, linea tendrá el valor null
		{
			String[] parts = linea.split(";");
			String name = parts[0];
			int price = Integer.parseInt(parts[1]);
			
			ProductoMenu ing = new ProductoMenu(name,price);
			this.menuBase.add(ing);
			
		}
		
		br.close();
		
	}
	
	private void cargarCombos(File comboFile) throws FileNotFoundException, IOException
	{
		
		BufferedReader br = new BufferedReader(new FileReader(comboFile));
		String linea = br.readLine(); // La primera línea del archivo se ignora porque únicamente tiene los títulos de
										// las columnas
		linea = br.readLine();
		while (linea != null) // Cuando se llegue al final del archivo, linea tendrá el valor null
		{
			String[] parts = linea.split(";");
			String name = parts[0];
			String disc = parts[1];
			String discount = disc.replaceAll("[^0-9]", "");
			Double desc = Double.valueOf(discount);
			
			Combo comb = new Combo(desc,name);
			this.combos.add(comb);

			
		}
		
		br.close();
		
	}
	
}
