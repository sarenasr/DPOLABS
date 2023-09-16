package consola;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import modelo.*;


public class Aplicacion {
	
	private Restaurante restaurant;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Aplicacion app = new Aplicacion();
		app.ejecutarAplicacion();
		
	}

	public void ejecutarAplicacion()
	{
		System.out.println("Sistema Restaurante\n");
		
		boolean continuar = true;
		while(continuar)
		{
			try
			{
				mostrarMenu();
				int option = Integer.parseInt(input("Por favor seleccione una opción"));
				if (option == 1)
					ejecutarCargarInfo();
				else if (option == 2)
					showMenu();
				else if (option == 3)
					addItem();
				else if (option == 4)
					getOrder();
				else if (option == 5)
					closeOrder();
					continuar = false;

				
			}
			catch (NumberFormatException e)
			{
				System.out.println("Debe seleccionar uno de los números de las opciones.");
			}
		}
	}
	
	public void mostrarMenu()
	{
		System.out.println("\nOpciones de la aplicacion\n");
		System.out.println("1. Cargar Informacion del Restaurante");
		System.out.println("2. Mostrar Menu");
		System.out.println("3. Iniciar nuevo pedido");
		System.out.println("4. Consultar info de pedido");
		System.out.println("5. Cerrar pedido y guardar factura");
		
	}
	
	private void ejecutarCargarInfo()
	{
		System.out.println("\n" + "Cargar archivos de restaurante"+"\n");
		
		String ingredientsFile = input("Por favor ingrese el nombre del archivo CSV con los ingredientes");
		String menuFile = input("Por favor ingrese el nombre del archivo CSV con el menu");
		String comboFile = input("Por favor ingrese el nombre del archivo CSV con los combos");
		File ing = new File(ingredientsFile);
		File menu = new File(menuFile);
		File combo = new File(comboFile);
		try
		{
			restaurant.cargarInformacion(ing,menu,combo);
			System.out.println("Se cargo la informacion correctamente");
			
		}
		catch (FileNotFoundException e)
		{
			System.out.println("ERROR: el archivo indicado no se encontró.");
		}
		catch (IOException e)
		{
			System.out.println("ERROR: hubo un problema leyendo el archivo.");
			System.out.println(e.getMessage());
		}
	}
	
	private void showMenu()
	{
		 System.out.println( restaurant.getMenuBase());
	}
	
	private void addItem()
	{
		
	}
	
	private void closeOrder()
	{
		
	}
	
	private void getOrder()
	{
		int id = Integer.parseInt(input("Ingrese id"));
		ArrayList<Pedido> orders = restaurant.getOrders();
		for (Pedido order : orders)
		{
			if (id == order.getIdPedido())
			{
				System.out.println(order);
			}
		}
	}
	
	
	
	public String input(String mensaje)
	{
		try
		{
			System.out.print(mensaje + ": ");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			return reader.readLine();
		}
		catch (IOException e)
		{
			System.out.println("Error leyendo de la consola");
			e.printStackTrace();
		}
		return null;
	}

}
