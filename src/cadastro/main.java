package cadastro;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.time.format.DateTimeFormatter;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.util.Map;
import java.util.HashMap;
import java.util.Collections;
import java.util.Comparator;
import java.math.RoundingMode;



public class main {
	
	
	public static void removerFuncionario(List<Funcionario>funcionarios, String elemento ) {
		 Iterator<Funcionario> iterator = funcionarios.iterator();
	        while (iterator.hasNext()) {
	            Funcionario funcionario = iterator.next();
	            if (funcionario.getNome().toLowerCase().equals(elemento.toLowerCase())) {
	                iterator.remove();
	                System.out.println("\nFuncionário "+elemento+" removido com sucesso! \n");
	                
	                System.out.println("======================  Lista de funcionarios após remoção =========================");
	                exibirDados(funcionarios);
	                
	            }
	        }
	 
	       
		
	}
	
	public static void exibirDados(List<Funcionario>funcionarios) {
		// Formatador de data
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        // Formatador de números (ponto para milhar e vírgula para decimal)
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.getDefault());
        symbols.setDecimalSeparator(',');
        symbols.setGroupingSeparator('.');
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00", symbols);
		
		for (Funcionario funcionario : funcionarios) {
            String dataFormatada = funcionario.getDataNascimento().format(dateFormatter);
            String salarioFormatado = decimalFormat.format(funcionario.getSalario());

            System.out.println("Nome: " + funcionario.getNome());
            System.out.println("Data de Nascimento: " + dataFormatada);
            System.out.println("Salário: " + salarioFormatado);
            System.out.println("Função: " + funcionario.getFuncao());
            System.out.println("-----------------------------");
        }
		
		
	}
	
	public static Funcionario getByName(List<Funcionario>funcionarios, String name ) {
		 Iterator<Funcionario> iterator = funcionarios.iterator();
	        while (iterator.hasNext()) {
	            Funcionario funcionario = iterator.next();
	            if (funcionario.getNome().toLowerCase().equals(name.toLowerCase())) {
	            	return funcionario;
	            	
	            }
	        }
	        
	        return null;
		
	}
	
	public static void listaFuncionariosPorDataAniversario(List<Funcionario>funcionarios) {
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        // Formatador de números (ponto para milhar e vírgula para decimal)
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.getDefault());
        symbols.setDecimalSeparator(',');
        symbols.setGroupingSeparator('.');
        
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00", symbols);
		 System.out.println("\nFuncionários que fazem aniversário nos meses 10 e 12:");
	        for (Funcionario funcionario : funcionarios) {
	            int mesNascimento = funcionario.getDataNascimento().getMonthValue();
	            if (mesNascimento == 10 || mesNascimento == 12) {
	                String dataFormatada = funcionario.getDataNascimento().format(dateFormatter);
	                String salarioFormatado = decimalFormat.format(funcionario.getSalario());

	                System.out.println("Nome: " + funcionario.getNome());
	                System.out.println("Data de Nascimento: " + dataFormatada);
	                System.out.println("Salário: " + salarioFormatado);
	                System.out.println("Função: " + funcionario.getFuncao());
	                System.out.println("-----------------------------");
	            }
	        }
	}
	
	public static void totalSalarioMinimo(List<Funcionario> funcionarios) {
     DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.getDefault());
     symbols.setDecimalSeparator(',');
     symbols.setGroupingSeparator('.');
     BigDecimal salarioMinimo = new BigDecimal("1212.00");
     DecimalFormat decimalFormat = new DecimalFormat("#,##0.00", symbols);

	System.out.println("\nQuantos salários mínimos cada funcionário ganha:");
	for (Funcionario funcionario : funcionarios) {
	    // Calculando a quantidade de salários mínimos
	    BigDecimal salariosMinimos = funcionario.getSalario().divide(salarioMinimo, 2, RoundingMode.HALF_UP);
	    
	    // Formatando o valor
	    String salariosMinimosFormatado = decimalFormat.format(salariosMinimos);

	    // Exibindo o resultado
	    System.out.println("Nome: " + funcionario.getNome());
	    System.out.println("Salário: " + decimalFormat.format(funcionario.getSalario()));
	    System.out.println("Salários mínimos: " + salariosMinimosFormatado);
	    System.out.println("-----------------------------");
	}
	}
	
	public static void exibirGroupByFuncao(Map<String, List<Funcionario>> funcionarios) {
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.getDefault());
        symbols.setDecimalSeparator(',');
        symbols.setGroupingSeparator('.');
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00", symbols);
		for (Map.Entry<String, List<Funcionario>> entry : funcionarios.entrySet()) {
            String funcao = entry.getKey();
            List<Funcionario> listaFuncionarios = entry.getValue();	

            System.out.println("\nFunção: " + funcao);
            for (Funcionario funcionario : listaFuncionarios) {
                String dataFormatada = funcionario.getDataNascimento().format(dateFormatter);
                String salarioFormatado = decimalFormat.format(funcionario.getSalario());

                System.out.println("  Nome: " + funcionario.getNome());
                System.out.println("  Data de Nascimento: " + dataFormatada);
                System.out.println("  Salário: " + salarioFormatado);
                System.out.println("  -----------------------------");
            }
        }
	}
	
	public static void exibirMaiorIdade(List<Funcionario> funcionarios) {
        Iterator<Funcionario> iterator = funcionarios.iterator();
   
        Funcionario maisVelho=iterator.next();
        while (iterator.hasNext()) {
            Funcionario funcionario = iterator.next();
            if (funcionario.getDataNascimento().getYear()< maisVelho.getDataNascimento().getYear()) {
            	maisVelho=funcionario;
            }
            
            
        }
        
        System.out.println("=================== Funcionario com maior Idade ======================");
        int idade = LocalDate.now().getYear()-maisVelho.getDataNascimento().getYear();
        System.out.println("  Nome: " + maisVelho.getNome());
        System.out.println("  Idade: " + idade);
        System.out.println("  -----------------------------");
		
		
	}

	public static void groupByFuncao(List<Funcionario> funcionarios) {
		Map<String, List<Funcionario>> funcionariosPorFuncao = new HashMap<>();
        for (Funcionario funcionario : funcionarios) {
            String funcao = funcionario.getFuncao();
            // Se a função ainda não existe no Map, cria uma nova lista
       
            if (!funcionariosPorFuncao.containsKey(funcao)) {
                funcionariosPorFuncao.put(funcao, new ArrayList<>());
            }
            // Adiciona o funcionário à lista correspondente à sua função
            funcionariosPorFuncao.get(funcao).add(funcionario);
        }
        
        exibirGroupByFuncao(funcionariosPorFuncao);
		
	}
	
	public static void aumentarSalario(List<Funcionario>funcionarios, String valor, String f) {
		
		if( f !=null){
			
			 Funcionario funcionario=getByName(funcionarios, f);
			 BigDecimal salarioAtual = funcionario.getSalario();
	         BigDecimal aumento = salarioAtual.multiply(new BigDecimal(valor));    // Calcula 10% de aumento
	         BigDecimal novoSalario = salarioAtual.add(aumento);                   // Adiciona o aumento ao salário atual
	         funcionario.setSalario(novoSalario);                                  // Atualiza o salário do funcionário
			
		}else {
		
		
			for (Funcionario funcionario : funcionarios) {
	            BigDecimal salarioAtual = funcionario.getSalario();
	            BigDecimal aumento = salarioAtual.multiply(new BigDecimal(valor));     // Calcula 10% de aumento
	            BigDecimal novoSalario = salarioAtual.add(aumento);                    // Adiciona o aumento ao salário atual
	            funcionario.setSalario(novoSalario);                                   // Atualiza o salário do funcionário
	        }
		}
		
		System.out.println("======================  Lista de funcionarios após promoção =========================");
		exibirDados(funcionarios);
	}
	
	
	public static void ordenarPorAfalbeto(List<Funcionario> funcionarios) {
		Collections.sort(funcionarios, new Comparator<Funcionario>() {
		    @Override
		    public int compare(Funcionario f1, Funcionario f2) {
		        return f1.getNome().compareTo(f2.getNome());
		    }
		});
		
		System.out.println("=================================== Exibindo dados de funcionarios  em ordem alfabetica ========================");
		exibirDados(funcionarios);
		
	}
	
	public static void totalSalarios(List<Funcionario> funcionarios) {
		BigDecimal totalSalarios = BigDecimal.ZERO;
		DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.getDefault());
        symbols.setDecimalSeparator(',');
        symbols.setGroupingSeparator('.');
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00", symbols);
		for (Funcionario funcionario : funcionarios) {
		    totalSalarios = totalSalarios.add(funcionario.getSalario());
		}

		String totalFormatado = decimalFormat.format(totalSalarios);

		System.out.println("\nTotal dos salários dos funcionários: " + totalFormatado);
		
	}
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		 List<Funcionario> funcionarios = new ArrayList<>();
		 funcionarios.add(new Funcionario("Maria", LocalDate.of(2000, 10, 18), new BigDecimal("2509.44"),"Operador"));
		 funcionarios.add(new Funcionario("João", LocalDate.of(1990, 05, 12), new BigDecimal("2284.38"),"Operador"));
		 funcionarios.add(new Funcionario("Caio", LocalDate.of(1961, 05, 02), new BigDecimal("9836.14"),"Coordenador"));
		 funcionarios.add(new Funcionario("Miguel", LocalDate.of(1988, 10, 14), new BigDecimal("19119.88"),"Diretor"));
		 funcionarios.add(new Funcionario("Alice", LocalDate.of(1995, 01, 05), new BigDecimal("2234.68"),"Recepcionista"));
		 funcionarios.add(new Funcionario("Heitor", LocalDate.of(1999, 11, 19), new BigDecimal("1582.72"),"Operador"));
		 funcionarios.add(new Funcionario("Athur", LocalDate.of(1993, 03, 31), new BigDecimal("4071.84"),"Contador"));
		 funcionarios.add(new Funcionario("Laura", LocalDate.of(1994, 07, 8), new BigDecimal("3017.45"),"Gerente"));
		 funcionarios.add(new Funcionario("Heloísa", LocalDate.of(2003, 05, 24), new BigDecimal("1606.85"),"Eletricista"));
		 funcionarios.add(new Funcionario("Helena", LocalDate.of(1996, 9, 02), new BigDecimal("2799.93"),"Gerente"));
		 
		 
		 exibirDados(funcionarios);
		 removerFuncionario(funcionarios, "joão");
		 
	/**
     * A função foi aprimorada para oferecer mais flexibilidade no aumento salarial.
     * Inicialmente, o requisito era aumentar o salário de todos os funcionários em 10%.
     * Agora, se o último parâmetro for passado como `null`, todos os funcionários terão 
     * seus salários aumentados pelo percentual especificado no segundo parâmetro.
     * 
     * Caso um nome específico seja informado, a função buscará esse funcionário na lista 
     * e aplicará o aumento apenas a ele.
     * 
     * Assinatura do método:
     * aumentarSalario(List<Funcionario> funcionarios, String valorAumento, String nomeFuncionarioOpcional)
     * 
     * Exemplo de chamada do método:
     * aumentarSalario(funcionarios, "0.10", "João");
     * */
		
		 aumentarSalario(funcionarios, "0.10", null);
		 
		 groupByFuncao(funcionarios);
		 listaFuncionariosPorDataAniversario(funcionarios);
		 exibirMaiorIdade(funcionarios);
		 ordenarPorAfalbeto(funcionarios);
		 totalSalarios(funcionarios);
		 totalSalarioMinimo(funcionarios);
		
		 
	}
	

}
