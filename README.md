## Documentação do Projeto de Gerenciamento de Funcionários

Este projeto é uma aplicação Java que gerencia uma lista de funcionários, permitindo a execução de diversas operações, como adicionar, remover, atualizar e consultar informações dos funcionários. Abaixo estão detalhadas as funcionalidades e como o código foi implementado.

## Tabela de Conteúdos

- [Sobre](#sobre)
- [Tecnologias](#tecnologias)
- [Estrutura das Classes](#estrutura)
- [Detalhamento das Operações](#operacoes)
- [Execução](#execucao)
- [Estrutura do Projeto](#estrutura)
- [Infraestrutura](#infraestrutura)



<div id='sobre'/>


## Tecnologias
<div style="display: flex">
 <img align="center" alt="Java" height="50" width="100" src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/java/java-original.svg"/>
 <img align="center" alt="Eclipse" height="50" width="100"  width="80" src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/eclipse/eclipse-original.svg"/>
 <img  align="center" alt="GIT" height="50" width="100" src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/git/git-original-wordmark.svg" /> 

          
</div>

<div id='tecnologias'/>



## Estrutura das classes

#### Classe Pessoa
Representa uma pessoa com os atributos:

    nome (String): Nome da pessoa.

    dataNascimento (LocalDate): Data de nascimento no formato yyyy-MM-dd.

```java
package cadastro;
import java.time.LocalDate;
import java.util.Date;

public class Pessoa {
	private String nome;
	private LocalDate dataNascimento;
	
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


```

#### Classe Funcionario
Estende a classe Pessoa e adiciona os atributos:

    salario (BigDecimal): Salário do funcionário.

    funcao (String): Função do funcionário.

```java
package cadastro;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;

public class Funcionario extends Pessoa{
	 private BigDecimal salario;
	 private String funcao;
	 
	 

	 public Funcionario(String nome, LocalDate dataNascimento, BigDecimal salario, String funcao) {
	        super(nome, dataNascimento);
	        this.salario = salario;
	        this.funcao = funcao;
	    }

	public BigDecimal getSalario() {
		return this.salario;
	}
	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}
	public String getFuncao() {
		return funcao;
	}
	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}
	
	
  @Override
    public String toString() {
        return "Funcionario{" +
                "nome='" + getNome() + '\'' +
                ", dataNascimento=" + getDataNascimento() +
                ", salario=" + salario +
                ", funcao='" + funcao + '\'' +
                '}';
    }


}

```

<div id='estrutura'/>


## Operações Implementadas:

- Inserir funcionários: Adiciona funcionários à lista.

- Remover funcionário: Remove um funcionário específico da lista (exemplo: "João").

- Aumento de salário: Aplica um aumento de 10% no salário de todos os funcionários.

- Agrupar por função: Agrupa os funcionários em um Map, onde a chave é a função e o valor é a lista de funcionários.

- Filtrar aniversariantes: Filtra e exibe os funcionários que fazem aniversário nos meses 10 (outubro) e 12 (dezembro).

- Exibe o funcionario mais de maior idade na lista.

- Ordenar alfabeticamente: Ordena e exibe os funcionários em ordem alfabética pelo nome.

- Total dos salários: Calcula e exibe a soma de todos os salários dos funcionários.

- Salários mínimos: Calcula e exibe quantos salários mínimos (R$ 1212,00) cada funcionário ganha.

<div id='operacoes'/>
	
### Detalhamento do código:

Inserir Funcionários:

Os funcionários são adicionados manualmente à lista funcionarios usando o construtor da classe Funcionario.

```java
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
```


Remover Funcionário:

Um funcionário é removido da lista usando um Iterator.
    
```java

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
```


Aumento de Salário:

Um aumento de 10% é aplicado ao salário de cada funcionário, ou caso seja passado um funcionario especifico na chamada da fução é aplicado um aumento de 10% apenas naquele funcionario

```java
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

```

Nesse ponto também foi criado uma funcao auxiliar para buscar os dados do funcionario pelo nome, e exibir os dados, buscando modularizar um pouco o código e deixar mais organizado.

essas são as funções auxiliares:

Exibir dados

```java
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

```

E buscar dado por nome

```java

public static Funcionario getByName(List<Funcionario>funcionarios, String name ) {
    Iterator<Funcionario> iterator = funcionarios.iterator();
	while (iterator.hasNext()) {
	    Funcionario funcionario = iterator.next();
	    if (funcionario.getNome().toLowerCase().equals(name.toLowerCase())) {
		return funcionario;
		
	    }
	}
	
	return null;
```
    

Agrupar por Função:

Os funcionários são agrupados em um Map, onde a chave é a função e o valor é a lista de funcionários. Essa funcionalidade foi dividida em duas funcoes, uma para agrupar e outra para listar.


```java
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
```

Listar o agrupamento

```java
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
```



Filtrar Aniversariantes:

Funcionários que fazem aniversário nos meses 10 e 12 são filtrados e exibidos.

```java
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

```

Ordenar Alfabeticamente:

A lista de funcionários é ordenada pelo nome usando Collections.sort.
```java
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

```

Exbir funcionario de maior idade

É preciso fazer apenas um calculo entre o ano de nascimento dos funcionarios e verificar qual o menor.

```java
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

```

Total dos Salários:

O total dos salários é calculado somando os salários de todos os funcionários.

```java
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
```


Salários Mínimos:

Para cada funcionário, calcula quantos salários mínimos (R$ 1212,00) ele ganha.

```java
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
```



### Como Executar o Projeto

Requisitos:

Java Development Kit (JDK) 8 ou superior.

Um ambiente de desenvolvimento Java (IDE como IntelliJ, Eclipse ou VS Code) ou terminal.

Passos:

 - Copie o código para um arquivo chamado main.java.
 - Compile o código usando o comando:

```sh 
    bash javac main.java
    
```
Execute o código usando o comando:

```sh
    bash java Principal
```

<div id='execucao'/>
exemplo de saída:

```sh
    Nome: Maria
Data de Nascimento: 18/10/2000
Salário: 2.509,44
Função: Operador
-----------------------------
Nome: João
Data de Nascimento: 12/05/1990
Salário: 2.284,38
Função: Operador
-----------------------------


======================  Lista de funcionarios após remoção =========================
Nome: Maria
Data de Nascimento: 18/10/2000
Salário: 2.509,44
Função: Operador
-----------------------------
Nome: Caio
Data de Nascimento: 02/05/1961
Salário: 9.836,14
Função: Coordenador
-----------------------------

======================  Lista de funcionarios após promoção =========================
Nome: Maria
Data de Nascimento: 18/10/2000
Salário: 2.760,38
Função: Operador
-----------------------------
Nome: Caio
Data de Nascimento: 02/05/1961
Salário: 10.819,75
Função: Coordenador


Função: Operador
  Nome: Maria
  Data de Nascimento: 18/10/2000
  Salário: 2.760,38
  -----------------------------
  Nome: Heitor
  Data de Nascimento: 19/11/1999
  Salário: 1.740,99
  -----------------------------


Funcionários que fazem aniversário nos meses 10 e 12:
Nome: Maria
Data de Nascimento: 18/10/2000
Salário: 2.760,38
Função: Operador
-----------------------------
Nome: Miguel
Data de Nascimento: 14/10/1988
Salário: 21.031,87
Função: Diretor
-----------------------------
=================== Funcionario com maior Idade ======================
  Nome: Caio
  Idade: 64
  -----------------------------
=================================== Exibindo dados de funcionarios  em ordem alfabetica ========================
Nome: Alice
Data de Nascimento: 05/01/1995
Salário: 2.458,15
Função: Recepcionista
-----------------------------
Nome: Athur
Data de Nascimento: 31/03/1993
Salário: 4.479,02
Função: Contador
-----------------------------


Total dos salários dos funcionários: 51.456,82

Quantos salários mínimos cada funcionário ganha:
Nome: Alice
Salário: 2.458,15
Salários mínimos: 2,03
-----------------------------
Nome: Athur
Salário: 4.479,02
Salários mínimos: 3,70
-----------------------------
Nome: Caio
Salário: 10.819,75
Salários mínimos: 8,93
-----------------------------
Nome: Heitor
Salário: 1.740,99
Salários mínimos: 1,44
-----------------------------
Nome: Helena
Salário: 3.079,92
Salários mínimos: 2,54
-----------------------------
Nome: Heloísa
Salário: 1.767,54
Salários mínimos: 1,46
-----------------------------
Nome: Laura
Salário: 3.319,20
Salários mínimos: 2,74
-----------------------------
Nome: Maria
Salário: 2.760,38
Salários mínimos: 2,28
-----------------------------
Nome: Miguel
Salário: 21.031,87
Salários mínimos: 17,35
-----------------------------

```
