package entidade;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entidade.enums.WorkerLevel;

public class Worker {

	private String name;
	private WorkerLevel level;
	private Double baseSalary;
	
	private Departamento departamento;
	private List<ContratoHora> contracts = new ArrayList<>();
	
	public Worker() {
	}

	public Worker(String name, WorkerLevel level, Double baseSalary, Departamento departamento) {
		this.name = name;
		this.level = level;
		this.baseSalary = baseSalary;
		this.departamento = departamento;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public WorkerLevel getLevel() {
		return level;
	}

	public void setLevel(WorkerLevel level) {
		this.level = level;
	}

	public Double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(Double baseSalary) {
		this.baseSalary = baseSalary;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public List<ContratoHora> getContracts() {
		return contracts;
	}
	
	public void addContract(ContratoHora contract) {
		contracts.add(contract);
	}
	public void removeContract(ContratoHora contract) {
		contracts.remove(contract);
	}
	
	public double income(int year, int month) {
		double soma = baseSalary;
		Calendar cal = Calendar.getInstance();
		
		for (ContratoHora c : contracts) {
			cal.setTime(c.getDate());
			int c_year = cal.get(Calendar.YEAR);
			int c_month = 1 + cal.get(Calendar.MONTH);
			
			if (year == c_year && month == c_month) {
				soma += c.totalValue();
			}
		}
		return soma;
		
	}
}
