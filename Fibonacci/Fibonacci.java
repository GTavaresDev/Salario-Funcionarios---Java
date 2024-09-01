import java.util.Scanner;

public class Fibonacci{

    public static void main(String[] args) {
        Scanner dados = new Scanner(System.in);
        
        System.out.print("Digite um número: ");
        int numero = dados.nextInt();
        
        if (isFibonacci(numero)) {
            System.out.println("O número " + numero + " pertence à sequência de Fibonacci.");
        } else {
            System.out.println("O número " + numero + " NÃO pertence à sequência de Fibonacci.");
        }
        
        scanner.close();
    }

    // Função para verificar se um número pertence à sequência de Fibonacci
    public static boolean isFibonacci(int num) {
        if (num == 0 || num == 1) {
            return true;
        }
        
        int a = 0;
        int b = 1;
        int c = a + b;
        
        while (c <= num) {
            if (c == num) {
                return true;
            }
            a = b;
            b = c;
            c = a + b;
        }
        
        return false;
  }
}