package entidade;

import java.util.Date;

public class ContratoHora {
	
	private Date date;
	private Double valueHour;
	private Integer hours;
	
	public ContratoHora() {
	}

	public ContratoHora(Date date, Double valueHour, Integer hours) {
		this.date = date;
		this.valueHour = valueHour;
		this.hours = hours;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getValueHour() {
		return valueHour;
	}

	public void setValueHour(Double valueHour) {
		this.valueHour = valueHour;
	}

	public Integer getHours() {
		return hours;
	}

	public void setHours(Integer hours) {
		this.hours = hours;
	}
	
	public double totalValue() {
		return valueHour * hours;
	}
	
	

}
