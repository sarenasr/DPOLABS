package modelo;

import java.util.List;

public class Combo implements Producto{
	
	private double descuento;
	private String nombreCombo;
	private List<ProductoMenu> itemsCombo;
	
	public Combo(double disc, String name)
	{
		this.descuento = disc;
		this.nombreCombo = name;
		
		
	}
	
	public void  agregarItemACombo(ProductoMenu item)
	{
		itemsCombo.add(item);
	}
	
	public int getPrecio()
	{
		return (int)Math.round(descuento);
	}
	
	public String generarTextoFactura()
	{
		return nombreCombo + " Tiene un costo de: ";
	}
	
	public String getNombre()
	{
		return this.nombreCombo;
	}
}
