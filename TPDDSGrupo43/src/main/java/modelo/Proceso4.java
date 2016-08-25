package modelo;

import java.util.ArrayList;
import java.util.List;

public class Proceso4 extends ProcesoStr {
	private List<ProcesoStr> listaProcesos = new ArrayList<ProcesoStr>();
    
    @Override
    public void procesar()
    {
        for(ProcesoStr sh : listaProcesos)
        {
            sh.procesar();
        }
    }
     
    //adding shape to drawing
    public void add(ProcesoStr s)
    {
        this.listaProcesos.add(s);
    }
     
    //removing shape from drawing
    public void remove(ProcesoStr s)
    {
    	listaProcesos.remove(s);
    }
     
    //removing all the shapes
    public void clear()
    {
        this.listaProcesos.clear();
    }

}
