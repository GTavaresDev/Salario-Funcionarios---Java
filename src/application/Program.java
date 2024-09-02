import java.util.Locale;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class Program {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner dados = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Enter department name: ");
        String departmentName = dados.nextLine();

        System.out.println("Enter worker data:");
        System.out.print("Name: ");
        String workerName = dados.nextLine();
        System.out.print("Level: ");
        String workerLevel = dados.nextLine();
        System.out.print("Base salary: ");
        double baseSalary = dados.nextDouble();

      //Criando o objeto worker e passando seus parametros 
      // Criando instancia que pega a string e transformar em valor 
      // Criando um objeto Departament associado ao Worker (Composição de Objetos)
      Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), baseSalary, new Department(departmentName));      


       System.out.print("How many contracts to this worker? ");
       int quantityContracts = dados.nextInt();
       dados.nextLine(); // Consome a nova linha após a entrada de número

      // Laço de leitura dos dados dos contratos 
      for(int i = 0; i < quantityContracts; i++){
        System.out.printf("Enter contract #%d data: ", i + 1);
        System.out.print("Date (DD/MM/YYYY): ");
        Date contractDate = sdf.parse(dados.next()); // Leitura da data que o usuario escrever 
        System.out.print("Value per hour: ");
        double valuePerHour = dados.nextDouble();
        System.out.print("Duration (hours): ");
        int hours = dados.nextInt();
        dados.nextLine(); // Consome a nova linha após a entrada de número

        HourContract contract = new HourContract (contractDate, valuePerHour, hours);
        // Para associar o nosso contrato com o trabalhador 
        worker.addContract(contract);
      } 

        System.out.println();
        System.out.print("Enter month and year to calculate income (MM/YYYY): ");
        String monthAndYear = dados.next();
        int month = Integer.parseInt(monthAndYear.substring(0, 2)); // Recorta a string para pegar os dois primeiros dígitos
        int year = Integer.parseInt(monthAndYear.substring(3));

        System.out.println("Name: " + worker.getName());
        System.out.println("Department: " + worker.getDepartment().getName());
        System.out.println("Income for " + monthAndYear + ": " + String.format("%.2f", worker.income(year, month)));

        dados.close();
		}
}