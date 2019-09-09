package model.logic;

public class UBERTrip implements Comparable<UBERTrip>
{

	private int idOrigen;

    private int idDestino;

    private int hora;

    private double tiempoPromedio;

    private double desviacionEstandar;

    private double promedioGeometrico;

    private double desviacionGeometrica;

    public UBERTrip(int idOrigen, int idDestino, int hora, double tiempoPromedio, double desviacionEstandar, double promedioGeometrico, double desviacionGeometrica) {
        this.idOrigen = idOrigen;
        this.idDestino = idDestino;
        this.hora = hora;
        this.tiempoPromedio = tiempoPromedio;
        this.desviacionEstandar = desviacionEstandar;
        this.promedioGeometrico = promedioGeometrico;
        this.desviacionGeometrica = desviacionGeometrica;
    }
    

    public int darHora()
    {
    	return hora;
    }

    public int darIdOrigen()
    {
    	return idOrigen;
    }

    public int darIdDestino() {
        return idDestino;
    }

    public double darTiempoPromedio() {
        return tiempoPromedio;
    }

    public double darDesviacionEstandar() {
        return desviacionEstandar;
    }

    public double darPromedioGeometrico() {
        return promedioGeometrico;
    }

    public double darDesviacionGeometrica() {
        return desviacionGeometrica;
    }
	
	
	@Override
	public int compareTo(UBERTrip v) {

        int respuesta;

        if (tiempoPromedio == v.darTiempoPromedio()) {

            respuesta = compararPorDesviacionEstandar(v);
        }

        else if (tiempoPromedio > v.darTiempoPromedio())
        {
            respuesta = 1;
        }

        else {
            respuesta = -1;
        }

        return  respuesta;

	}

    public int compararPorDesviacionEstandar(UBERTrip v) {

        int respuesta;

        if (desviacionEstandar == v.darDesviacionEstandar()) {

            respuesta = 0;
        }

        else if (desviacionEstandar > v.darDesviacionEstandar())
        {
            respuesta = 1;
        }

        else {
            respuesta = -1;
        }

        return  respuesta;

    }


	   public String toString(){

	        return "" + idOrigen;
	    }
}
