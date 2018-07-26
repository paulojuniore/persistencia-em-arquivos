package arquivos_serializados;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadSequentialFile 
{
	
	private static ObjectInputStream input;

	public static void main(String[] args) 
	{
		openFile();
		readRecords();
		closeFile();
	}
	
	// abre o arquivo.
	public static void openFile() 
	{
		try
		{
			input = new ObjectInputStream(Files.newInputStream(Paths.get("clients.dat")));
		}
		catch(IOException ioException)
		{
			System.err.println("Erro ao abrir o arquivo. Encerrando.");
			System.exit(1);
		}
	}
	
	// lê o registro do arquivo
	public static void readRecords() 
	{
		System.out.printf("%-10s%-12s%-12s%10s%n", "Conta", "Nome", "Sobrenome", "Saldo");
		
		try
		{
			while (true) // faz um loop até ocorrer uma EOFException
			{
				Account conta = (Account) input.readObject(); 
				
				// exibe o contéudo de registro.
				System.out.printf("%-10d%-12s%-12s%10.2f%n", conta.getConta(), conta.getNome(), 
						conta.getSobrenome(), conta.getSaldo());
			}
		}
		catch (EOFException eofException)
		{
			System.err.println("Não há mais registros.");
		}
		catch (ClassNotFoundException notFoundException)
		{
			System.err.println("Tipo de objeto inválido. Encerrando.");
		}
		catch (IOException ioException)
		{
			System.err.println("Erro ao ler do arquivo. Encerrando");
		}
	}
	
	// fecha o arquivo
	public static void closeFile()
	{
		try
		{
			if (input != null)
				input.close();
		}
		catch (IOException ioException)
		{
			System.err.println("Erro ao fechar o arquivo. Encerrando.");
			System.exit(1);
		}
	}

}
