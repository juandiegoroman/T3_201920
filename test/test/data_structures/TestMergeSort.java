package test.data_structures;




import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;

import model.data_structures.IComparable;
import model.logic.MergeSort;
import model.logic.QuickSort;
import model.logic.UBERTrip;

public class TestMergeSort {

	private IComparable[] arr;

	@Before
	public void setUp1() {
		arr = new IComparable[10];
	}

	public void setUpOrdenadosAscendentemente() {
		
		for(int i =0; i< 10; i++){
			arr[i] = new UBERTrip(0, 0, 0, i, i+1, 0, 0);
		}
	}
	
	public void setUpOrdenadosDescendentemente() {
		
		for(int i =9; i >= 0; i--){
			arr[i] = new UBERTrip(0, 0, 0, i, i+1, 0, 0);
		}
	}

	public void setUpDesordenados() {
		
		setUpOrdenadosAscendentemente();
		mezclar(arr);
	}
	
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
	
	
    @Test
	public void testArregloDesordenado() {
		setUpDesordenados();
		
		MergeSort.ordenar(arr);
		
		for(int i =0; i< 10; i++){
			
			UBERTrip actual = (UBERTrip)arr[i];
			
			assertTrue(actual.darTiempoPromedio() == i);
		}
	}

	@Test
	public void testArregloOrdenadoDescendentemente() {
		setUpOrdenadosDescendentemente();
		
		MergeSort.ordenar(arr);
		
		for(int i =0; i< 10; i++){
			
			UBERTrip actual = (UBERTrip)arr[i];
			
			assertTrue(actual.darTiempoPromedio() == i);
		}
	}

	@Test
	public void testArregloOrdenadoAscendentemente() {
		setUpOrdenadosAscendentemente();
		
		MergeSort.ordenar(arr);
		
		for(int i =0; i< 10; i++){
			
			UBERTrip actual = (UBERTrip)arr[i];
			
			assertTrue(actual.darTiempoPromedio() == i);
		}
	}

	

}
