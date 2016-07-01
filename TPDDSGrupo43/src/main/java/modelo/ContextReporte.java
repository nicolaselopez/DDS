package modelo;

import java.util.Date;

public class ContextReporte
{
	private GenerarReporte reporte;
	private String fecha;
	private int total;
	private int id;

	public String getFecha()
	{
		return fecha;
	}
	public int getTotal()
	{
		return total;
	}
	public int getId()
	{
		return id;
	}
	public void setFecha(String date)
	{
		fecha = date; 
	}
	public void setId(int date)
	{
		id = date; 
	}
	public ContextReporte(GenerarReporte reporte, int idRep, String date, int tot)
	{
		this.reporte = reporte;
		this.fecha = date;
		this.total = tot;
		this.id = idRep;
	}
	public ContextReporte()
	{
		super();
	}

	public ContextReporte[] ejecutar()
	{
		return reporte.generarInformeBusqueda();
	}
}
