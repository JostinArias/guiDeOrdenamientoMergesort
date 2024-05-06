public class App {
    public static void mergesort(int[] arr, int left, int right) {
        if (left < right) {
            //encuentre el punto medio del arreglo 
            int mid = (left + right) / 2;
            //ordena recursivamente la mita izquierda 
            mergesort(arr, left, mid);
            //ordena recursivamente la mitad derecha
            mergesort(arr, mid + 1, right);
            //combinar las dos mitades ordenadas 
            merge(arr, left, mid, right);
        } 
    }
    private static void merge(int[] arr, int left, int mid, int right) {
        //tamaño de los arreglos a fucionar   
        int sizeleft = mid - left + 1;
        int sizeright = right - mid;
        //arreglos temporales para almacenar los sub arreglos
        int[] templeft = new int[sizeleft];
        int[] tempright = new int[sizeright];
        //copia datos a los arreglos temporales
        for (int i = 0; i < sizeleft; i++) {
            templeft[i] = arr[left + i];
        }
        for (int j = 0; j < sizeright; j++) {
            tempright[j] = arr[mid + 1 + j];
        }
        //fucionas los subarrglos temporales en el arreglo original
        int i = 0, j = 0;
        int k = left; //indice incial para el arreglo fusiando
        while (i < sizeleft && j < sizeright) {
            if (templeft[i] <= tempright[j]) {
                arr[k] = templeft[i];
                i++;
            } else {
            arr[k] = tempright[j];
            j++;
        }
        k++;
    }
        //copia los elementos restantes de templeft[] si los hay
        while (i < sizeleft) {
            arr[k] = templeft[i];
            i++;
            k++;
        }
        //copia los elementos restantes de tempright[] si los hay
        while (j < sizeright) {
            arr[k] = tempright[j];
            j++;
            k++;
        }
    }
    public static void main(String[] args) throws Exception {
        int[] arr = {38, 27, 43, 3, 9, 82, 10};
        int n = arr.length;
        System.out.println("arreglo original:");
        for ( int num : arr) {
            System.out.println(num + " ");
        }
     
        mergesort(arr, 0, n - 1); // llamada al metodo de ordenamiento mergesort
        System.out.println("arreglo ordenado:");
        for ( int num : arr) {
            System.out.println(num + " ");
        }
    }
}