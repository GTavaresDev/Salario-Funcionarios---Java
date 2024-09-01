import java.util.Locale;
import java.util.Scanner;

// 67836.43, 36678.66, 29229.88, 27165.48, 19849.53
class Relatorio {
  private String nome;
  private double faturamento;

  public Relatorio(String nome,double faturamento){
    this.nome = nome;
    this.faturamento = faturamento;
  }
  public String getNome(){
    return nome;
  }
  public void setNome(String nome){
    this.nome = nome;
  }
   public double getFaturamento(){
    return faturamento;
  }
  public void setFaturamento(double faturamento){
    this.faturamento = faturamento;
  }
  public void faturamento(double faturamento){
    double soma = 0.0;
    faturamento = this.faturamento;
    soma += faturamento;
  }
  public String toString() {
		return "Estado: " + nome + ", Faturamento: " + faturamento;
	}

}


public class Distribuidora {
  
    public static void main(String[] args) {
        Scanner dados = new Scanner(System.in);
        Locale.setDefault(Locale.US);
        double somaTotal = 0.0;

        
        System.out.println("Quantos valores serão passados: ");
        int qtdEstados = dados.nextInt();
        dados.nextLine();
        for(int i = 0; i<qtdEstados; i++){
          System.out.println("Nome do Estado: ");
          String nome = dados.nextLine();
          System.out.println("Faturamento: ");
          double faturamento = dados.nextDouble();
          dados.nextLine();

          Relatorio relatorio = new Relatorio(nome, faturamento);
          relatorio.faturamento(faturamento);
          somaTotal += relatorio.getFaturamento(); 
          System.out.println(relatorio);
        }
        
       
        System.out.println("Faturamento Total: " + somaTotal);

        dados.close();
    }
}