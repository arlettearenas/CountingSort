/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CountSort;
import java.util.*;
/**
 *
 * @author Noena
 */
public class countSort {
    // Clasificación de conteo que toma numeros positivos

        //agregamos el metodo countSort 
	static void countSort(int[] arr)
	{
                //establecemos las variables que nos ayudaran
		int max = Arrays.stream(arr).max().getAsInt();
		int min = Arrays.stream(arr).min().getAsInt();
                
                //variable range que es igual a las variables max - min +1;
		int range = max - min + 1;
                //arreglo que es igual a el arreglo de range
		int count[] = new int[range];
                //arreglo produccion que es igual a lo largo de arreglo
		int output[] = new int[arr.length];
                //ciclo for inicializamos a i con 0, si i es menor al largo de arr, i se incrementa
		for (int i = 0; i < arr.length; i++) {
                        //se almacena en contar con el arr i - min y se incrementa
			count[arr[i] - min]++;
		}
                
                //otro ciclo for inicalizamos a i con 1, si i es menos a el largo de contar entonces i se incrementa
		for (int i = 1; i < count.length; i++) {
                        //si contar es mayor o igual a i -1
			count[i] += count[i - 1];
		}
                
                //ciclo for donde ahora inicializamos a i con el largo de arr -1 ,si i es mayor o igual a o entonces i se decrementa
		for (int i = arr.length - 1; i >= 0; i--) {
                        //produccion es igual al arr de i
			output[count[arr[i] - min] - 1] = arr[i];
			count[arr[i] - min]--;
		}

		for (int i = 0; i < arr.length; i++) {
			arr[i] = output[i];
		}
	}

	static void printArray(int[] arr)
	{
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println("");
	}

	// llamado 
	public static void main(String[] args)
	{
		int[] arr = { 5, 10, 0, 3, 8, 5, 1, 13 };
		countSort(arr);
		printArray(arr);
	}
}




