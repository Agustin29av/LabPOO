package tp3.exercise4;
import java.util.Arrays;

public class Exercise4 {
    
    public static class IntegerArray {
        private int[] numbers = {4,2,3,8,1};
        
        public int countElements(){
            return numbers.length;
        }

        public int finxMax(){ //buscar el maximo
            int max = numbers[0]; //initialized with the first element 
            for (int num : numbers){
                if(num>max) max = num;
            }
            return max;
        }

        public double calculateAverage(){ // calcularPromedio
            int sum = 0;
            for (int num : numbers) sum += num;
            return (double) sum / numbers.length;
        }
        
        public int[] sortAscending(){ //ordenarAscendente
            int[] copy = Arrays.copyOf(numbers, numbers.length);
            Arrays.sort(copy);
            return copy;
        }
        public int[] sortDescending(){ // ordenar Descendente
            int[] copy = sortAscending(); //ordeno ascendente primero
            //ahora lo invierto
            for (int i=0; i < copy.length / 2; i++){
                int temp = copy[i];
                copy[i] = copy[copy.length - 1 -i];
                copy[copy.length - 1 - i] = temp;
            }
            return copy;
        }
    }

}
