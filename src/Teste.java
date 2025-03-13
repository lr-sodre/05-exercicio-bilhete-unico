import java.util.Random;

public class Teste {

    public static void main(String[] args) {

        int[] num = new int[10];
        carregadarDados(num);
        imprimir(num);
    }

    public static void carregadarDados(int[] num){

        Random random = new Random();

        for(int i=0; i<num.length; i++){
             num[i] = random.nextInt(15);
        }
    }

    public static void imprimir(int[] num){

        for(int i : num){
            System.out.println(i);
        }
    }
}
