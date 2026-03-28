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

**Exemplos práticos:**

* **Ex 01** Tratamento Básico `(try-catch)` - Captura de um erro de divisão por zero.
```java
    try {
        int resultado = 10 / 0; // Gera ArithmeticException
    } catch (ArithmeticException e) {
        System.out.println("Erro: Divisão por zero não permitida! " + e.getMessage());
    }
```

* **Ex 02** Múltiplos Catch e Finally - Tratando diferentes tipos de exceção e garantindo o fechamento de recursos.

```java
    try {
        int[] numeros = {1, 2, 3};
        System.out.println(numeros[10]); // ArrayIndexOutOfBoundsException
    } catch (ArrayIndexOutOfBoundsException e) {
        System.out.println("Erro: Índice inexistente.");
    } catch (Exception e) {
        System.out.println("Erro genérico: " + e.getMessage());
    } finally {
        System.out.println("Este bloco sempre é executado.");
    }
```

* **Ex 03** Lançando uma Exceção (throw e throws) - Lançando uma exceção personalizada ao validar uma regra de negócio.
```java
    public void sacar(double valor) throws Exception {
        if (valor > 500) {
            throw new Exception("Saldo insuficiente ou valor excede o limite.");
        }
    }
```
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

### Java NIO

O pacote java.nio (introduzido no Java 1.4 e expandido no Java 7 como NIO.2) é uma API de Entrada e Saída alternativa ao java.io. Enquanto o java.io trabalha com fluxos de dados sequenciais (Streams) e é bloqueante, o java.nio trabalha com Buffers e Channels, sendo focado em alta performance e escalabilidade. Ele é ideal para lidar com grandes volumes de dados e operações de arquivos complexas de forma mais eficiente.

**Principais Classes e Conceitos:**
* **Path:** Substitui a classe File. Representa o caminho para um arquivo ou diretório no sistema de forma mais moderna.
* **Paths / Path.of():** Classe utilitária para obter instâncias de Path.
* **Files:** A "faz-tudo" do NIO. Possui métodos estáticos para criar, copiar, mover, deletar e ler arquivos em poucas linhas.
* **Channel:** Como um "canal" de comunicação. Ao contrário do Stream (que é unidirecional), um Channel pode ler e gravar dados.
* **Buffer:** Um bloco de memória onde os dados são colocados temporariamente antes de serem movidos pelo Channel.
* **StandardOpenOption:** Enumerações para definir como abrir um arquivo (ex: APPEND, CREATE, READ).

### Exemplos Práticos

**Gerenciando Caminhos com `Path:`**
```java
    import java.nio.file.Path;
    import java.nio.file.Paths;
    
    Path caminho = Paths.get("dados.txt"); 
    // Ou na versão mais recente: Path caminho = Path.of("dados.txt");
    
    System.out.println("Nome do arquivo: " + caminho.getFileName());
    System.out.println("Caminho absoluto: " + caminho.toAbsolutePath());
```

**Escrevendo em Arquivos (Forma Rápida):**
```java
    import java.nio.file.Files;
    import java.nio.file.Path;
    import java.nio.file.StandardOpenOption;
    import java.util.List;
    
    Path path = Path.of("texto.txt");
    String conteudo = "Aprendendo Java NIO!";
    
    // Escreve direto no arquivo (cria se não existir)
    Files.writeString(path, conteudo); 
    
    // Para adicionar sem sobrescrever (Append):
    Files.writeString(path, "\nNova linha", StandardOpenOption.APPEND);
```

**Lendo Arquivos:**
```java
    import java.nio.file.Files;
    import java.nio.file.Path;
    import java.util.List;
    
    Path path = Path.of("texto.txt");
    
    // Ler todas as linhas de uma vez como uma Lista
    List<String> linhas = Files.readAllLines(path);
    for (String l : linhas) {
        System.out.println(l);
    }
    
    // Ou ler tudo como uma única String (Java 11+)
    String tudo = Files.readString(path);
```

**Copiando e Movendo Arquivos:**
```java
    Path origem = Path.of("original.txt");
    Path destino = Path.of("copia.txt");
    
    Files.copy(origem, destino); // Copia
    Files.move(origem, Path.of("pasta/novo_nome.txt")); // Move ou Renomeia
    Files.deleteIfExists(destino); // Deleta com segurança
```

### Exemplos completos

**Exemplo 01: Manipulação de Arquivo e Diretório(NIO.2)**
```java
    import java.nio.file.*;
    import java.io.IOException;
    
    public class ExemploNioBasico {
        public static void main(String[] args) {
            Path pasta = Path.of("meu_projeto");
            Path arquivo = pasta.resolve("notas.txt"); // Cria o caminho meu_projeto/notas.txt
    
            try {
                // Criando diretório se não existir
                if (Files.notExists(pasta)) {
                    Files.createDirectory(pasta);
                }
    
                // Escrevendo
                Files.writeString(arquivo, "Estudando Full Stack!");
    
                // Lendo
                String conteudo = Files.readString(arquivo);
                System.out.println("Conteúdo: " + conteudo);
    
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
```

**Ex 02: Comparação Direta (Escrita e Leitura Rápida)**

```java
    import java.nio.file.*;
    import java.util.Arrays;
    import java.util.List;
    
    public class ExemploNioRapido {
        public static void main(String[] args) throws Exception {
            Path path = Path.of("lista.txt");
            List<String> itens = Arrays.asList("Java", "Spring", "NIO", "PostgreSQL");
    
            // 1. Escrita simplificada de uma lista
            Files.write(path, itens);
    
            // 2. Leitura usando Streams do Java 8+ (Muito eficiente para arquivos grandes)
            System.out.println("--- Lendo com Files.lines ---");
            Files.lines(path)
                 .filter(s -> s.startsWith("J")) // Filtra só o que começa com J
                 .forEach(System.out::println);
        }
    }
```

**Qual a principal diferença? - IO, NIO**
* **IO:** É focado em Streams. Se você pede para ler um arquivo, o programa "trava" (fica esperando) até que os dados cheguem.

* **NIO:** É focado em Canais e Seletores. Ele permite lidar com várias conexões ou arquivos simultaneamente sem travar a execução (Non-blocking), sendo muito mais rápido para sistemas web modernos.

Se o Files e o Path que vimos antes são a "casca" (mais fáceis de usar), os `Channels` e `Buffers` são o motor que faz tudo rodar rápido.  Imagine que o Channel é uma pista de corrida e o Buffer é o caminhão que transporta a carga. O dado nunca vai direto para a pista; ele sempre tem que estar dentro do caminhão.

**O que é um Buffer?** Um Buffer é basicamente um bloco de memória (um array turbinado) onde você coloca os dados temporariamente.
* No java.io, você lê byte por byte.
* No java.nio, você enche um "balde" (Buffer) e processa tudo de uma vez.

**Principais estados de um Buffer:**

* **Capacity:** O tamanho total do "balde".
* **Position:** Onde você está lendo ou escrevendo agora.
* **Limit:** Até onde você pode ler/escrever no momento.

**O que é um Channel?** O Channel (Canal) é o substituto dos Streams.

* **Streams (io):** São unidirecionais (ou você só lê com InputStream ou só grava com OutputStream).
* **Channels (nio):** São bidirecionais. O mesmo canal pode ler e gravar, desde que o Buffer esteja pronto.

**Exemplo Prático:** Lendo um arquivo com `Channel` e `Buffer` Este é o modo "raiz" do NIO, usado quando você precisa de performance máxima (como em grandes arquivos de log ou processamento de dados brutos).

```java
    import java.io.RandomAccessFile;
    import java.nio.ByteBuffer;
    import java.nio.channels.FileChannel;
    
    public class ExemploCanalBuffer {
        public static void main(String[] args) throws Exception {
            // 1. Abre um arquivo através do RandomAccessFile para obter o Canal
            RandomAccessFile arquivo = new RandomAccessFile("dados.txt", "r");
            FileChannel canal = arquivo.getChannel();
    
            // 2. Cria um Buffer de 48 bytes (o "caminhão")
            ByteBuffer buffer = ByteBuffer.allocate(48);
    
            // 3. O Canal lê os dados e coloca no Buffer
            int bytesLidos = canal.read(buffer);
    
            while (bytesLidos != -1) {
                System.out.println("Lidos: " + bytesLidos);
    
                // 4. "Gira" o buffer (Prepara para leitura dos dados que entraram)
                // O limit vai para a posição atual e a posição volta para zero.
                buffer.flip();
    
                while(buffer.hasRemaining()){
                    System.out.print((char) buffer.get()); // Lê 1 byte por vez do buffer
                }
    
                // 5. Limpa o buffer para a próxima rodada
                buffer.clear();
                bytesLidos = canal.read(buffer);
            }
            
            arquivo.close();
        }
    }
```

**Por que isso é mais rápido?** A grande vantagem aqui é o Direct Buffers e o Memory Mapped Files.

* **Direct Buffer:** O Java pede memória diretamente para o Sistema Operacional (fora da área comum do Java/JVM). Isso evita que o computador tenha que copiar o dado duas vezes.
* **Mapeamento de Memória (MappedByteBuffer):** Você pode "fingir" que um arquivo gigante é apenas um array na memória. O SO cuida de carregar só as partes que você acessa.

**Exemplo de Mapeamento de Memória (Muito rápido para arquivos imensos):**

```java
    import java.nio.MappedByteBuffer;
    import java.nio.channels.FileChannel;
    import java.nio.file.*;
    
    public class SuperRapido {
        public static void main(String[] args) throws Exception {
            Path path = Path.of("arquivo_gigante.bin");
            
            try (FileChannel canal = FileChannel.open(path, StandardOpenOption.READ)) {
                // Mapeia os primeiros 10MB do arquivo direto na memória RAM
                MappedByteBuffer buffer = canal.map(FileChannel.MapMode.READ_ONLY, 0, 1024 * 1024 * 10);
                
                // Agora você lê o arquivo como se fosse uma variável simples
                if (buffer.hasRemaining()) {
                    byte dado = buffer.get();
                }
            }
        }
    }
```

---

## Gerenciando Dependências - Maven e Grandle

### Maven: Instalar o Maven usando o sdkman. É uma das formas mais eficientes e limpas de gerenciar ambientes Java, especialmente em sistemas baseados em Unix (Linux, macOS, WSL no Windows). O sdkman, permite instalar, alternar e gerenciar diferentes versões do Maven e do Java facilmente.

**Instalando o sdkman** - (se ainda não tiver)**
* **Abra o terminal e execute:** 
```
curl -s "https://get.sdkman.io" | bash
source "$HOME/.sdkman/bin/sdkman-init.sh"
```

**Verifique a instalação:** `sdk version`.

**Instalando o Maven com sdkman**
* Listar versões disponíveis:
    ```sdk list maven```

* Instalar a versão desejada (ex: 3.9.6):
  ``` sdk install maven 3.9.6```

* Definir versão padrão (opcional, caso tenha múltiplas):
  ```sdk default maven 3.9.6```*

* Verificar a instalação:
  ```mvn -version```