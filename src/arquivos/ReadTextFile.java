package arquivos;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ReadTextFile 
{
	private static Scanner input;
	
	public static void main(String[] args) 
	{
		openFile();
		readRecords();
		closeFile();
	}
	
	// abre o arquivo clients.txt
	public static void openFile()
	{
		try
		{
			input = new Scanner(Paths.get("clients.txt"));
		}
		catch (IOException ioException)
		{
			System.err.println("Erro ao abrir o arquivo. Encerrando");
			System.exit(1);
		}
	}
	
	// lê o registro no arquivo
	public static void readRecords()
	{
		System.out.printf("%-10s%-12s%-12s%10s%n", "Conta", "Nome", "Sobrenome", "Saldo");
		
		try
		{
			while(input.hasNext())
			{
				// exibe o conteúdo de registro
				System.out.printf("%-10d%-12s%-12s%10.2f%n", input.nextInt(), input.next(), input.next(), input.nextDouble());
			}
		}
		catch (NoSuchElementException elementException)
		{
			System.err.println("Arquivo formado impropriamente. Encerrando");
		}
		catch (IllegalStateException stateExcetion)
		{
			System.err.println("Erro ao ler dados do arquivo. Encerrando.");
		}
	}
	
	// fecha o arquivo e termina o aplicativo
	public static void closeFile()
	{
		if (input != null)
			input.close();
	}

}
