## Módulo 4 - Gerenciando Exeções, IO e Dependências em Java

### Exceptions

* Entendendo Exeções:

Exceções em Java são eventos inesperados que interrompem o fluxo normal do programa, representadas por objetos que herdam da classe `Throwable`. Para garantir a robustez do sistema, utiliza-se blocos `try-catch` para capturar e tratar erros, `finally` para limpeza de recursos, e `throw/throws` para propagar exceções.

**Principais Conceitos de Exceptions:**
* **Try/Catch/Finally:** O bloco `try` isola o código arriscado, o `catch` trata a exceção lançada, e o `finally` executa código de finalização (como fechar conexões) independentemente de erro.
* **Checked vs. Unchecked Exceptions vs. Error:** 
  * **Checked (Verificadas):** Herdadas de Exception. O compilador obriga o tratamento (ex: IOException, SQLException).
  * **Unchecked (RuntimeException):** Herdadas de RuntimeException. O compilador não obriga tratamento, indicando falhas de lógica (ex: NullPointerException, ArrayIndexOutOfBoundsException).
  * **Error:** Problemas graves da JVM, como OutOfMemoryError, que não devem ser capturados.
* **Hierarquia:** Todas herdam de Throwable, dividindo-se entre Exception (recuperável) e Error (grave, falha da JVM).

**Exemplo prático:**
```java
    try {
        // Código que pode gerar erro
        int resultado = 10 / 0;
    } catch (ArithmeticException e) {
        // Tratamento específico
        System.out.println("Erro: Divisão por zero.");
    } finally {
        // Executado sempre
        System.out.println("Finalizando operação.");
    }
```

### Debugging e aprofundamento em exceções:
Debugging em Java envolve usar IDEs (como IntelliJ/Eclipse) para pausar a execução com breakpoints, inspecionar variáveis e analisar o fluxo de código. Exceções como citado anteriormente são objetos Throwable (Checked ou Unchecked) que representam erros, gerenciados com try-catch-finally para garantir a robustez e evitar interrupções inesperadas no programa.

* **Debugging em Java:** A depuração (debugging) é o processo de encontrar e corrigir erros.
  * **Breakpoints:** Clique na margem lateral da IDE para marcar a linha onde o código deve pausar.
  * **Debug Mode:** Inicie a aplicação com o ícone de inseto (Debug) para analisar variáveis em tempo real.
  * **Step Over/Into:** Navegue linha por linha para entender o fluxo de execução.
  * **Evaluate Expression:** Avalie expressões ou altere valores de variáveis em tempo de execução sem reiniciar o app.


* **Mais de Exeções - Principais Exeções comuns:** As principais exceções em Java, frequentemente encontradas, incluem `NullPointerException` (referência nula), `ArrayIndexOutOfBoundsException` (índice de array inválido), `ArithmeticException` (erro matemático), `ClassCastException` (conversão de tipo inválida) e `IllegalArgumentException` (argumento inválido). Dividindo-as em unchecked (tempo de execução) e checked (checadas pelo compilador) como foi dito.


* **Exceções Não Checadas (Unchecked / RuntimeException):** Ocorrem em tempo de execução, geralmente por bugs de lógica, e não precisam ser declaradas ou capturadas obrigatoriamente.
  * **NullPointerException (NPE):** Tentar usar uma referência de objeto que está null.
  * **ArrayIndexOutOfBoundsException:** Acessar um índice de array que não existe (ex: índice -1 ou maior que o tamanho).
  * **ArithmeticException:** Operações matemáticas ilegais, como divisão por zero.
  * **ClassCastException:** Tentar converter um objeto para uma subclasse da qual ele não é uma instância.
  * **IllegalArgumentException:** Passar um argumento inadequado para um método.
  * **NumberFormatException:** Subclasse de IllegalArgumentException, ocorre ao tentar converter uma string para um tipo numérico, mas a string não tem o formato correto.
  
  
* **Exceções Checadas (Checked Exceptions)**:O compilador obriga o tratamento `(try-catch)` ou a declaração `(throws)` porque representam situações previsíveis que o programa deve recuperar.
  * **IOException:** Erros de entrada/saída, como falha na leitura ou escrita de arquivos.
  * **FileNotFoundException:** Tentativa de acessar um arquivo que não existe.
  * **SQLException:** Erros relacionados ao acesso a banco de dados.
  * **ClassNotFoundException:** Tentar carregar uma classe que não é encontrada no classpath.
    

* **Boas Práticas no Tratamento de Exceções**
  * **try-catch-finally:** Utilize o bloco `try` para o código de risco, `catch` para tratar a exceção e `finally` para garantir o fechamento de recursos (como conexões de banco de dados), independente de erro.
  * **Evitar capturar Exception genérica:** Capture exceções específicas para saber exatamente o que falhou.
  * **Unchecked vs Checked:** Use `checked` para erros recuperáveis pelo usuário e `unchecked` para erros de programação.
---

### Java.io
O pacote java.io no Java é a API padrão para operações de Entrada e Saída (Input/Output), permitindo ler e gravar dados em arquivos, diretórios, rede ou memória através de fluxos de bytes ou caracteres (streams). Ele facilita a interação do programa com o sistema de arquivos, essencial para ler/gravar arquivos .txt, .csv ou binários.

**Principais Classes e Conceitos:**
* **File:** Representa um arquivo ou diretório para gerenciar informações (criar, excluir, listar).
* **FileInputStream/FileOutputStream:** Lê/grava dados em formato de bytes (arquivos binários, imagens).
* **FileReader/FileWriter:** Lê/grava dados em formato de caracteres (arquivos de texto).
* **BufferedReader/BufferedWriter:** Otimiza a leitura/escrita, utilizando um buffer na memória para aumentar a performance.

**Exemplos práticos:**
* **Criando e gerenciando arquivos com `File`:**
```java
    import java.io.File;
     
    File arquivo = new File("dados.txt");
     
    if (!arquivo.exists()) {
     arquivo.createNewFile(); // cria um novo arquivo
    }
    //exists() → Verifica se o arquivo já existe.
    //createNewFile() → Cria o arquivo se ele não existir.
```
* **Escrevendo em Arquivos:**
```java
    import java.io.BufferedWriter;
    import java.io.FileWriter;
     
    BufferedWriter writer = new BufferedWriter(new FileWriter("dados.txt"));
    writer.write("Olá, mundo!");
    writer.newLine(); // pula uma linha
    writer.write("Segunda linha");
    writer.close(); // sempre feche após escrever
```

* **Lendo Arquivos:**
```java
    import java.io.BufferedReader;
    import java.io.FileReader;
     
    BufferedReader reader = new BufferedReader(new FileReader("dados.txt"));
    String linha;
    while ((linha = reader.readLine()) != null) {
     System.out.println(linha);
    }
    reader.close();
```

* **Trabalhando com Diretórios:**
```java
    File pasta = new File("meuDiretorio");
     
    if (!pasta.exists()) {
     pasta.mkdir(); // cria um diretório
    }
    Você também pode listar os arquivos de um diretório:
    File[] arquivos = pasta.listFiles();
    for (File f : arquivos) {
     System.out.println(f.getName());
    }
```
**Exemplos completos(Simples):**

* **Ex 01**

```java

    import java.io.*;
    
     
    
    public class ArquivoExemplo {
    
      public static void main(String[] args) throws IOException {
    
          // Escrevendo no arquivo
    
          BufferedWriter writer = new BufferedWriter(new FileWriter("exemplo.txt"));
    
          writer.write("Linha 1");
    
          writer.newLine();
    
          writer.write("Linha 2");
    
          writer.close();
    
     
    
          // Lendo do arquivo
    
          BufferedReader reader = new BufferedReader(new FileReader("exemplo.txt"));
    
          String linha;
    
          while ((linha = reader.readLine()) != null) {
    
              System.out.println(linha);
    
          }
    
          reader.close();
    
      }
```
* **Ex 2**
```java
    import java.io.*;
    
    public class ExemploIO {
        public static void main(String[] args) {
            String arquivo = "exemplo.txt";
    
            // 1. Escrita de arquivo (FileWriter + BufferedWriter)
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(arquivo))) {
                bw.write("Olá, java.io!");
                bw.newLine();
                bw.write("Manipulando arquivos.");
            } catch (IOException e) {
                e.printStackTrace();
            }
    
            // 2. Leitura de arquivo (FileReader + BufferedReader)
            try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
                String linha;
                while ((linha = br.readLine()) != null) {
                    System.out.println(linha);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
```

