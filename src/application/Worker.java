import java.text.ParseException;
import java.util.List;
import java.util.ArrayList;
import java.util.List;
import java.util.Calendar;

public class Worker{
  private String name;
  private WorkerLevel level;
  private Double baseSalary;

  // Criando as associações do Worker
  private Department department;
  // A lista tem que ser instanciada 
  private List<HourContract> contracts = new ArrayList<>(); //Como pode ter varios contratos, temos que criar uma lista. 

  public Worker(){
  }
  public Worker(String name, WorkerLevel level, Double baseSalary, Department department){
    this.name = name;
    this.level = level;
    this.baseSalary = baseSalary;
    this.department = department;
  }
  public String getName(){
    return name;
  }
  public WorkerLevel getLevel(){
    return level;
  }
  public Double getBaseSalary(){
    return baseSalary;
  }
  public Department getDepartment(){
    return department;
  }
  public List<HourContract> getContracts(){
    return contracts;
  }
  public void setName(String name){
    this.name = name;
  }
  public void setLevel(WorkerLevel level){
    this.level = level;
  }
  public void setBaseSalary(Double baseSalary){
    this.baseSalary = baseSalary;
  }
  public void setDepartment(Department department){
    this.department = department;
  }

  public void addContract(HourContract contract){
    // Vai pegara lista de contratos (contracts) e adicionar o contrato que veio como argumento 
    contracts.add(contract);
  }
  public void removeContract(HourContract contract){
    contracts.remove(contract);
  }
  public double income(int year, int month){
    double sum = baseSalary;
    Calendar cal = Calendar.getInstance();
    // Para cada contrato c na lista de contrato, caso ele seja do mes, sera add a soma
    for (HourContract c : contracts){
      cal.setTime(c.getDate()); //Estou pegando a data do meu contrato e fazendo virar a data do calendario
      int cYear = cal.get(Calendar.YEAR);
      int cMonth = 1 + cal.get(Calendar.MONTH);
      // Se o valor desse contrato for desse mes e ano ele entra na soma 
      if(year == cYear && month == cMonth){
        sum += c.totalValue();
      }
    }
    return sum; 
  }
 
} 