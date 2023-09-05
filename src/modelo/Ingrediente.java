package modelo;

public class Ingrediente {
	
	private String nombre;
	private int costoAdicional;
	
	public Ingrediente(String name, int cost)
	{
		this.nombre = name;
		this.costoAdicional = cost;
		
	}
	
	public String getNombre()
	{
		return this.nombre;
	}
	
	public int getCostoAdicional()
	{
		return this.costoAdicional;
	}
}
