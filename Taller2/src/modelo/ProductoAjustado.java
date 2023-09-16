package modelo;

public class ProductoAjustado implements Producto{
	
	private ProductoMenu base;
	
	public ProductoAjustado(ProductoMenu base)
	{
		this.base = base;
	}
	
	public String getNombre()
	{
		return base.getNombre();
	}
	
	public int getPrecio()
	{
		return base.getPrecio();
	}
	
	public String generarTextoFactura()
	{
		return base.generarTextoFactura();
	}

}
