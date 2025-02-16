package cadastro;
import java.time.LocalDate;
import java.util.Date;

public class Pessoa {
	private String Nome;
	private LocalDate dataNascimento;
	
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	
	
	
}
