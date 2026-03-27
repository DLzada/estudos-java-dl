## Módulo 4 - Gerenciando Exeções, IO e Dependências em Java

### Java.io
O pacote java.io no Java é a API padrão para operações de Entrada e Saída (Input/Output), permitindo ler e gravar dados em arquivos, diretórios, rede ou memória através de fluxos de bytes ou caracteres (streams). Ele facilita a interação do programa com o sistema de arquivos, essencial para ler/gravar arquivos .txt, .csv ou binários.

**Principais Classes e Conceitos:**
* **File:** Representa um arquivo ou diretório para gerenciar informações (criar, excluir, listar).
* **FileInputStream/FileOutputStream:** Lê/grava dados em formato de bytes (arquivos binários, imagens).
* **FileReader/FileWriter:** Lê/grava dados em formato de caracteres (arquivos de texto).
* **BufferedReader/BufferedWriter:** Otimiza a leitura/escrita, utilizando um buffer na memória para aumentar a performance.

**Exemplo prático:**

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

