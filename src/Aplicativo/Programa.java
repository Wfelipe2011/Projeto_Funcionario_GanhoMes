package Aplicativo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entidade.ContratoHora;
import entidade.Departamento;
import entidade.Worker;
import entidade.enums.WorkerLevel;

public class Programa {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Entre com nome do Departamento?: ");
		String departamentoName = sc.nextLine();
		System.out.println("Entre com os Dados do Funcionario: ");
		System.out.print("Nome: ");
		String workerName = sc.nextLine();
		System.out.print("Nivel: ");
		String workerLevel = sc.nextLine();
		System.out.print("Salario Base: ");
		double baseSalary = sc.nextDouble();
		System.out.println();
		Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), baseSalary, new Departamento(departamentoName));
	
		System.out.print("Quantos contratos esse Trabalhador teve: ");
		int n = sc.nextInt();
		
		for (int i=1; i<=n; i++) {
			System.out.println("Dados do " + i + "° Contrato");
			System.out.print("Data (DD/MM/YYYY): ");
			Date contractDate = sdf.parse(sc.next());
			System.out.print("Valor por Hora: ");
			double valueHour = sc.nextDouble();
			System.out.print("Duração (hora): ");
			int hours = sc.nextInt();
			
			ContratoHora contract = new ContratoHora(contractDate, valueHour, hours);
			worker.addContract(contract);
			System.out.println();
		}
		System.out.println();
		System.out.print("Entre com Mes e Ano para calcular Salario(MM/YYYY): ");
		String monthAndYear = sc.next();
		int month = Integer.parseInt(monthAndYear.substring(0, 2));
		int year = Integer.parseInt(monthAndYear.substring(3));
		
		System.out.println("Nome: " + worker.getName());
		System.out.println("Departamento: " + worker.getDepartamento().getName());
		System.out.printf("Salario de " + monthAndYear + ": " + String.format("%.2f", worker.receita(year, month)));
		
		
		
		sc.close();
		
		
	}

}
