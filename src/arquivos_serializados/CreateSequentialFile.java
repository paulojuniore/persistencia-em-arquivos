package arquivos_serializados;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CreateSequentialFile 
{
	
	private static ObjectOutputStream output; // gera a saída de dados no arquivo.

	public static void main(String[] args) 
	{
		openFile();
		addRecords();
		closeFile();
	}
	
	// abre o arquivo clients.dat
	public static void openFile()
	{
		try
		{
			output = new ObjectOutputStream(Files.newOutputStream(Paths.get("clients.dat")));
		}
		catch (IOException ioException)
		{
			System.err.println("Erro ao abrir o arquivo. Encerrando.");
			System.exit(1);
		}
	}
	
	// adiciona registros ao arquivo
	public static void addRecords() 
	{
		Scanner input = new Scanner(System.in);
		
		System.out.println("Entre com o número da conta, nome, sobrenome e saldo.\nInsira o indicador de fim de "
				+ "linha para encerrar a entrada.");
		
		while(input.hasNext())
		{
			try
			{
				// cria novo registro, aqui supomos uma entrada válida.
				Account conta = new Account(input.nextInt(), input.next(), input.next(), input.nextDouble());
				
				// serializa o objeto em um arquivo
				output.writeObject(conta);
			}
			catch (NoSuchElementException elementException)
			{
				System.err.println("Entrada inválida. Por favor tente novamente.");
				input.nextLine();
			}
			catch (IOException ioException)
			{
				System.err.println("Erro ao escrever no arquivo. Encerrando.");
				break;
			}
			
			System.out.print("? ");
		}
	}
	
	// fecha o arquivo e termina o aplicativo.
	public static void closeFile()
	{
		try
		{
			if(output != null)
				output.close();
		}
		catch (IOException ioException)
		{
			System.err.println("Erro ao fechar arquivo. Encerrando.");
		}
	}

}
