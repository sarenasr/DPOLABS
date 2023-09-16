package modelo;

public class ProductoMenu implements Producto{
	private String nombre;
	private int precioBase;
	
	public ProductoMenu(String name, int cost)
	{
		this.nombre = name;
		this.precioBase = cost;
		
	}
	
	public String getNombre()
	{
		return this.nombre;
	}
	
	public int getPrecio()
	{
		return this.precioBase;
	}
	
	public String generarTextoFactura()
	{
		return nombre + Integer.toString(precioBase);
	}
}
