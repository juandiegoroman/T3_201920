package model.logic;

import com.opencsv.CSVReader;

import model.data_structures.IComparable;
import model.data_structures.IListaIterador;
import model.data_structures.ListaEncadenada;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

/**
 * Definicion del modelo del mundo
 *
 */
public class MVCModelo {
    /**
     * Atributos del modelo del mundo
     */
    private ListaEncadenada<UBERTrip> datos;

    /**
     * Constructor del modelo del mundo con capacidad predefinida
     */
    public MVCModelo()
    {
        datos = new ListaEncadenada();
    }

    public int totalViajesReportados()
    {
        return datos.tamano();
    }


    public IComparable[] viajesPorHora(int hora)
    {

        IListaIterador<UBERTrip> iter = datos.iterador();

        ListaEncadenada<UBERTrip> lista = new ListaEncadenada();

        while(iter.haySiguiente())
        {
            UBERTrip actual = iter.siguiente();
            if (actual.darHora() == hora){
                lista.insertarFinal(actual);
            }
        }

        IComparable[] arr = convertirAArreglo(lista);

        return arr;
    }

    private IComparable[] convertirAArreglo(ListaEncadenada<UBERTrip> lista) {

        IComparable[] arr = new IComparable[lista.tamano()];

        int cont = 0;

        IListaIterador<UBERTrip> iter = lista.iterador();

        while(iter.haySiguiente())
        {
            IComparable actual = iter.siguiente();
            arr[cont] = (IComparable) actual;
            cont++;
        }
        return arr;
    }


    /**
     * Requerimiento de agregar dato
     * @param dato
     */
    public void agregar(UBERTrip dato)
    {
        datos.insertarFinal(dato);
    }



    public void cargarDatos(String ruta){
        CSVReader reader = null;
        try {

            reader = new CSVReader(new FileReader(ruta));

            Iterator iter = reader.iterator();

            iter.next();

            while (iter.hasNext()){

                String[] parametros = (String[]) iter.next();

                UBERTrip v = crearViaje(parametros);

                agregar(v);
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally{
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }


    public class Contador
    {
        private final long inicio;
        public Contador()
        { inicio = System.currentTimeMillis(); }
        public double duracion()
        {
            long actual = System.currentTimeMillis();
            return (actual - inicio) ;
        }
    }

    public ListaEncadenada<UBERTrip> darPrimerosDiezViajes(IComparable[] arr){

        ListaEncadenada<UBERTrip> lista = new ListaEncadenada<>();
        if (arr.length <= 10) {
            return lista.clonar(arr);
        }
        else {

            for (int i = 0; i < 10; i++) {
                lista.insertarFinal((UBERTrip) arr[i]);
            }
        }

        return lista;
    }

    public ListaEncadenada<UBERTrip> darUltimosDiezViajes(IComparable[] arr){

        ListaEncadenada<UBERTrip> lista = new ListaEncadenada<>();
        if (arr.length <= 10) {
            return lista.clonar(arr);
        }
        else {

            for (int i = 0; i < 10; i++) {
                lista.insertarPrimero((UBERTrip) arr[arr.length - 1 - i]);
            }
        }
        return lista;
    }


    public double duracionQuickSort(IComparable[] arr){

        Contador cont = new Contador();

        QuickSort.ordenar(arr);

        return cont.duracion();
    }

    public double duracionMergeSort(IComparable[] arr){

        Contador cont = new Contador();

        MergeSort.ordenar(arr);

        return cont.duracion();
    }

    public double duracionShellSort(IComparable[] arr){

        Contador cont = new Contador();

        ShellSort.ordenar(arr);

        return cont.duracion();
    }




    public UBERTrip crearViaje(String[] datos ){

        return new UBERTrip(Integer.valueOf(datos[0]), Integer.valueOf(datos[1]),Integer.valueOf(datos[2]), Double.valueOf(datos[3]),Double.valueOf(datos[4]), Double.valueOf(datos[5]), Double.valueOf(datos[6]));

    }

    public ListaEncadenada<UBERTrip> darDatos() {
        return datos;
    }
}