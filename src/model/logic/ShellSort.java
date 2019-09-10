package model.logic;

import model.data_structures.IComparable;

public class ShellSort {

    private static boolean esMenor(IComparable v, IComparable w)
    { return v.compararCon(w) < 0; }

    private static void intercambiar(IComparable[] a, int i, int j)
    { IComparable t = a[i]; a[i] = a[j]; a[j] = t; }

    public static void ordenar(IComparable[] a)
    {
        int N = a.length;
        int h = 1;
        while (h < N/3) h = 3*h + 1;
        while (h >= 1)
        {
            for (int i = h; i < N; i++)
            {
                for (int j = i; j >= h && esMenor(a[j], a[j-h]); j -= h)
                    intercambiar(a, j, j-h);
            }
            h = h/3;
        }
    }


}
