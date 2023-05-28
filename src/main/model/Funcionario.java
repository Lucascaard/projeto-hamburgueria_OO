package main.model;
import java.time.LocalDate;
import java.time.LocalTime;

public class Funcionario extends Pessoa {
	
		private LocalDate dataAdmissao;
		private LocalTime horarioEntrada;
		private LocalTime horarioSaida;
		
		public Funcionario(String nome, Integer CPF, String sexo, LocalDate dataAdmissao, LocalTime horarioEntrada, LocalTime horarioSaida) {
			super(nome, CPF, sexo);
			this.dataAdmissao = dataAdmissao;
			this.horarioEntrada = horarioEntrada;
			this.horarioSaida = horarioSaida;
		}
		
		public void setDataAdmissao(LocalDate dataAdmissao) {
			this.dataAdmissao = dataAdmissao;
		}
		
		public void setHorarioEntrada(LocalTime horarioEntrada) {
			this.horarioEntrada = horarioEntrada;
		}
		
		public void setHorarioSaida(LocalTime horarioSaida) {
			this.horarioSaida = horarioSaida;
		}
		
		public LocalDate getDataAdmissao() {
			return dataAdmissao;
		}
		
		public LocalTime getHorarioEntrada() {
			return horarioEntrada;
		}
		
		public LocalTime getHorarioSaida() {
			return horarioSaida;
		}

		@Override
		public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
		}
	}	