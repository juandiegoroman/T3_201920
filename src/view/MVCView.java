package view;

import model.logic.MVCModelo;

public class MVCView 
{
	    /**
	     * Metodo constructor
	     */
	    public MVCView()
	    {
	    	
	    }
	    
		public void printMenu()
		{
			System.out.println("1. Cargar los viajes agregados por hora de el primer semestre");
			System.out.println("2. Ingresar una hora de consulta");
			System.out.println("3. Ordenar datos de viajes de consulta por QuickSort: ");
			System.out.println("4. Ordenar datos de viajes de consulta por MergeSort: ");
			System.out.println("5. Ordenar datos de viajes de consulta por ShellSort: \n");
		}
		public void printMessage(String mensaje) {

			System.out.println(mensaje);
		}		
		
}
