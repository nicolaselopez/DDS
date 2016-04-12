package vista;

import modelo.Barrio;

public class listObject{
	
	public Barrio[] getlistBarrio(){
		Barrio[] barrios;
				barrios = Barrio.consultarBarrios();
		return barrios;
	}

}
