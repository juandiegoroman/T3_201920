package model.data_structures;

import java.util.Random;

public class QuickSort {


    private static void mezclar(Object[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {

            Random random = new Random();
            int r = i + random.nextInt(n - i);
            Object temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
    }


    private static int dividir(IComparable[] a, int inferior, int superior)
    {
        int i = inferior, j = superior + 1;
        IComparable v = a[inferior];
        while (true)
        {
            while (esMenor(a[++i], v)) if (i == superior) break;
            while (esMenor(v, a[--j])) if (j == inferior) break;
            if (i >= j) break;
            intercambiar(a, i, j);
        }
        intercambiar(a, inferior, j);
        return j;
    }

    private static void intercambiar(IComparable[] arreglo, int i, int j) {
        IComparable temp = arreglo[i];
        arreglo[i] = arreglo[j];
        arreglo[j] = temp;
    }

    private static boolean esMenor(IComparable elemento1, IComparable elemento2){
        return elemento1.compareTo(elemento2) < 0;
    }


    private static void ordenar(IComparable[] arr, int inf, int sup) {
        if (inf < sup) {
            int pi = dividir(arr, inf, sup);
            ordenar(arr, inf, pi - 1);
            ordenar(arr, pi + 1, sup);
        }

    }

    public static void quickSort(IComparable[] arr){
        mezclar(arr);
        ordenar(arr, 0, arr.length -1);
    }
}
