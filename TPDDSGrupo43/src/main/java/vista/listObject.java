package vista;

import modelo.Barrio;
import modelo.Rubro;
import modelo.TipoPoi;

public class listObject{
	
	public Barrio[] getlistBarrio(){
		Barrio[] barrios;
				barrios = Barrio.consultarBarrios();
		return barrios;
	}
	
	public Rubro[] getlistRubro(){
		Rubro[] rubros;
				rubros = Rubro.consultarRubros();
		return rubros;
	}

	public TipoPoi[] getlistTipoPoi(){
		TipoPoi[] tipoPoi;
		tipoPoi = TipoPoi.consultarTipoPois();
		return tipoPoi;
	}

}
