package cadastro;
import java.time.LocalDate;
import java.util.Date;

public class Pessoa {
	private String nome;
	private LocalDate dataNascimento;
	
	 Pessoa(){
		 
	 }
	 public Pessoa(String nome, LocalDate dataNascimento) {
	        this.nome = nome;
	        this.dataNascimento = dataNascimento;
	   }
	
	public String getNome() {
		return this.nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public LocalDate getDataNascimento() {
		return this.dataNascimento;
	}
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	
		
	
}
