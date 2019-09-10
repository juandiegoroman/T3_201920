package controller;

import java.util.Scanner;

import model.data_structures.IComparable;
import model.data_structures.IListaIterador;
import model.logic.MVCModelo;
import model.logic.UBERTrip;
import view.MVCView;

public class Controller {

    public final static String DATOS_PRIMER_SEMESTRE = "./data/bogota-cadastral-2018-2-All-HourlyAggregate.csv";


    /* Instancia del Modelo*/
    private MVCModelo modelo;

    /* Instancia de la Vista*/
    private MVCView view;

    /**
     * Crear la vista y el modelo del proyecto
     */
    public Controller() {
        view = new MVCView();
        modelo = new MVCModelo();
    }

    public void run() {
        Scanner lector = new Scanner(System.in);
        boolean fin = false;


        int horaConsulta = -1;

        while (!fin) {
            view.printMenu();

            int option = lector.nextInt();
            switch (option) {
                case 1:
                    modelo.cargarDatos(DATOS_PRIMER_SEMESTRE);

                    System.out.println("Para el primer semestre del 2018 se leyeron las siguientes cantidades de viajes por hora: " + modelo.darDatos().tamano());
                    System.out.println();
                    System.out.println("Primer viaje: Origen: " + modelo.darDatos().primero().darIdOrigen() + ", Destino: " + modelo.darDatos().primero().darIdDestino() + ", Hora: " + modelo.darDatos().primero().darHora() + ", Tiempo promedio: " + modelo.darDatos().primero().darTiempoPromedio());
                    System.out.println();
                    System.out.println("Ultimo viaje: Origen: " + modelo.darDatos().ultimo().darIdOrigen() + ", Destino: " + modelo.darDatos().ultimo().darIdDestino() + ", Hora: " + modelo.darDatos().ultimo().darHora() + ", Tiempo promedio: " + modelo.darDatos().ultimo().darTiempoPromedio());
                    System.out.println();
                    break;


                case 2:
                    try {

                        System.out.println("--------- \nIngresar el n�mero de la hora de consulta: ");

                        try {
                            horaConsulta = lector.nextInt();
                        } catch (Exception e) {
                            System.out.println("Debe ingresar un numero");
                        }

                        System.out.println("Se hallaron " + modelo.viajesPorHora(horaConsulta).length + " viajes para la hora seleccionada.");


                    } catch (Exception e) {

                        e.printStackTrace();
                        System.out.print("No se han cargado los datos.\n");
                    }

                    break;

                case 3:

                    if (horaConsulta == -1) {
                        System.out.println("Debe ingresar una hora de consulta.");

                        break;

                    }

                    IComparable[] arr = modelo.viajesPorHora(horaConsulta);

                    System.out.println("El algoritmo QuickSort se tardo : " + modelo.duracionQuickSort(arr) + " segundos. \n");

                    System.out.println("Estos son los primeros diez viajes resultados del ordenamiento QuickSort: \n");
                    printList(modelo.darPrimerosDiezViajes(arr).iterador());
                    System.out.println();

                    System.out.println("Estos son los ultimos diez viajes resultados del ordenamiento QuickSort: \n");
                    printList(modelo.darUltimosDiezViajes(arr).iterador());
                    System.out.println();

                    break;

                case 4:


                    if (horaConsulta == -1) {
                        System.out.println("Debe ingresar una hora de consulta.");

                        break;

                    }

                    arr = modelo.viajesPorHora(horaConsulta);

                    System.out.println("El algoritmo MergeSort se tardo : " + modelo.duracionMErgeSort(arr) + " segundos. \n");

                    System.out.println("Estos son los primeros diez viajes resultados del ordenamiento MergeSort: \n");
                    printList(modelo.darPrimerosDiezViajes(arr).iterador());
                    System.out.println();

                    System.out.println("Estos son los ultimos diez viajes resultados del ordenamiento MergeSort: \n");
                    printList(modelo.darUltimosDiezViajes(arr).iterador());
                    System.out.println();

                    break;


                case 5:

                    if (horaConsulta == -1) {
                        System.out.println("Debe ingresar una hora de consulta.");

                        break;

                    }

                    arr = modelo.viajesPorHora(horaConsulta);

                    System.out.println("El algoritmo ShellSort se tardo : " + modelo.duracionShellSort(arr) + " segundos. \n");

                    System.out.println("Estos son los primeros diez viajes resultados del ordenamiento ShellSort: \n");
                    printList(modelo.darPrimerosDiezViajes(arr).iterador());
                    System.out.println();

                    System.out.println("Estos son los ultimos diez viajes resultados del ordenamiento ShellSort: \n");
                    printList(modelo.darUltimosDiezViajes(arr).iterador());
                    System.out.println();
                    break;

                default:
                    System.out.println("--------- \n Opcion Invalida !! \n---------");
                    break;
            }
        }

    }

    private void printList(IListaIterador<UBERTrip> iter) {
        UBERTrip actual;
        System.out.println("-----------------------------------------------------------------------------");
        System.out.printf("%10s %10s  %20s  %20s", "Hora", "Origen", "Destino", "Tiempo promedio");
        System.out.println();
        System.out.println("-----------------------------------------------------------------------------");
        while (iter.haySiguiente()) {
            actual = iter.siguiente();
            System.out.format("%10s %10s  %20s  %20s", actual.darHora(), actual.darIdOrigen(), actual.darIdDestino(), actual.darTiempoPromedio());
            System.out.println();
        }
    }
}
