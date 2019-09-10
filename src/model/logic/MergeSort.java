package model.logic;

import model.data_structures.IComparable;

public class MergeSort {
    private static IComparable[] aux;

    public static void ordenar(IComparable[] a)
    {
        aux = new IComparable[a.length];
        ordenar(a, 0, a.length - 1);
    }

    public static void unir(IComparable[] a, int inf, int med, int sup)
    {
        int i = inf, j = med+1;

        for (int k = inf; k <= sup; k++) aux[k] = a[k];

        for (int k = inf; k <= sup; k++) {

            if (i > med) a[k] = aux[j++];

            else if (j > sup) a[k] = aux[i++];

            else if (esMenor(aux[j], aux[i])) a[k] = aux[j++];

            else a[k] = aux[i++];
        }
    }

    private static boolean esMenor(IComparable v, IComparable w)
    { return v.compararCon(w) < 0; }

    private static void ordenar(IComparable[] a, int inf, int sup)
    {
        if (sup <= inf) return;
        int mid = inf + (sup - inf)/2;
        ordenar(a, inf, mid);
        ordenar(a, mid+1, sup);
        unir(a, inf, mid, sup);
    }
}
