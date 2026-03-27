## Módulo 4 - Gerenciando Exeções, IO e Dependências em Java

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

