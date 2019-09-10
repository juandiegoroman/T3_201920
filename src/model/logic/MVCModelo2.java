package model.logic;


import com.opencsv.CSVReader;
import controller.Controller;
import model.data_structures.Cola;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;


/**
 * Definicion del modelo del mundo
 */
public class MVCModelo2 {
    /**
     * Atributos del modelo del mundo
     */

    private Cola<UBERTrip> datosCola;

    /**
     * Constructor del modelo del mundo con capacidad predefinida
     */
    public MVCModelo2() {
               datosCola = new Cola();
    }

    /**
     * Constructor del modelo del mundo con capacidad dada
     *
     * @param tamano
     */


    public Cola<UBERTrip> clusterMayor(int hora) {
        Cola<UBERTrip> temp = new Cola<>();
        Cola<UBERTrip> mayor = new Cola<>();

        while (datosCola.tamano() > 0) {
            if (datosCola.darPrimero().valor().darHora() < hora) {
                datosCola.dequeue();

            } else {

                temp.enqueu(datosCola.dequeue());

                while (datosCola.tamano() > 0 && temp.darUltimo().valor().darHora() < datosCola.darPrimero().valor().darHora()) {

                    temp.enqueu(datosCola.dequeue());
                }

                if (temp.tamano() > mayor.tamano()) {
                    mayor = temp;
                }

            }

        }
        return mayor;
    }


    public void cargarDatos(String ruta) {
        CSVReader reader = null;
        try {

            reader = new CSVReader(new FileReader(ruta));

            Iterator iter = reader.iterator();

            iter.next();

            while (iter.hasNext()) {

                String[] parametros = (String[]) iter.next();

                UBERTrip v = crearViaje(parametros);

                agregar(v);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }


    }





    /**
     * Requerimiento de agregar dato
     *
     * @param dato
     */
    public void agregar(UBERTrip dato) {
        datosCola.enqueu(dato);
    }

    public UBERTrip crearViaje(String[] datos) {
        return new UBERTrip(Integer.valueOf(datos[0]), Integer.valueOf(datos[1]), Integer.valueOf(datos[2]), Double.valueOf(datos[3]), Double.valueOf(datos[4]), Double.valueOf(datos[5]), Double.valueOf(datos[6]));
    }

    public Cola<UBERTrip> darDatosCola() {
        return datosCola;
    }

    public static void main(String[] args)
    {
        MVCModelo2 m = new MVCModelo2();
        m.cargarDatos(Controller.DATOS_PRIMER_SEMESTRE);
    }

}
