package arquivos;

import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CreateTextFile 
{
	private static Formatter output; // envia uma saída de texto para um arquivo.
	
	public static void main(String[] args) 
	{
		openFile();
		addRecords();
		closeFile();
	}
	
	// abre o arquivo clients.txt
	public static void openFile()
	{
		try
		{
			output = new Formatter("clients.txt"); // abre o arquivo
		}
		catch (SecurityException securityException)
		{
			System.err.println("Permissão de escrita negada. Encerrando.");
			System.exit(1); // termina o programa.
		}
		catch (FileNotFoundException fileNotFoundException)
		{
			System.err.println("Erro ao abrir o arquivo. Encerrando.");
			System.exit(1); // termina o programa
		}
	}
	
	// adiciona registros ao arquivo
	public static void addRecords()
	{
		Scanner input = new Scanner(System.in);
		System.out.print("Entre com o numero de conta, nome, sobrenome e saldo.\nInsira o fim de linha para indicar o fim da entrada.\n");
		
		while(input.hasNext()) // faz um loop até o indicador de fim de arquivo.
		{
			try
			{
				// gera saída do novo registro para o arquivo: supõe entrada válida
				output.format("%d %s %s %.2f%n", input.nextInt(), input.next(), input.next(), input.nextDouble());
			}
			catch (FormatterClosedException formatterClosedException)
			{
				System.err.println("Erro ao escrever no arquivo. Encerrando.");
				break;
			}
			catch (NoSuchElementException elementException)
			{
				System.err.println("Entrada inválida. Tente novamente.");
				input.nextLine(); // descarta entrada para usuário tentar novamente.
			}
			
			System.out.print("? ");
		}
	}
	
	// fecha o arquivo
	public static void closeFile()
	{
		if (output != null)
			output.close();
	}

}
