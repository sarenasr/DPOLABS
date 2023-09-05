package modelo;

import java.util.List;

public class Pedido {
	
	private static int numeroPedidos;
	private int idPedido;
	private String nombreCliente;
	private String direccionCliente;
	private List<ProductoMenu> itemsPedido;
	
	public Pedido(String name, String address)
	{
		this.nombreCliente = name;
		this.direccionCliente = address;
		this.idPedido += 1;
		Pedido.numeroPedidos += 1;
	}
	
	public Pedido() {
		// TODO Auto-generated constructor stub
	}

	public int getIdPedido()
	{
		return this.idPedido;
	}
	
	public void agregarProducto(ProductoMenu item)
	{
		itemsPedido.add(item);
	}
	
	private int getPrecioNetoPedido()
	{
		int price = 0;
		for(ProductoMenu item:itemsPedido)
		{
			price += item.getPrecio();
			
		}
		return price;
	}
	
	private int getPrecioTotalPedido()
	{
		return getPrecioNetoPedido()+getPrecioIVAPedido();
	}
	
	private int getPrecioIVAPedido()
	{
		return (int) Math.round(getPrecioNetoPedido() * 0.19);
	}
	
	public String generarTextoFactura()
	{
		return String.valueOf(this.idPedido) + this.nombreCliente +this.direccionCliente+ itemsPedido.toString() + " " + String.valueOf(getPrecioTotalPedido());
	}
}
