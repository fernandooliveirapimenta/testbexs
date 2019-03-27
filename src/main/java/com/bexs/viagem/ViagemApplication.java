package com.bexs.viagem;

import com.bexs.viagem.file.LoadFile;
import com.bexs.viagem.file.ReadFile;
import com.bexs.viagem.file.WriteFile;
import com.bexs.viagem.model.Route;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.*;
import java.math.BigDecimal;
import java.util.Scanner;
import java.util.Set;

@SpringBootApplication
public class ViagemApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext ctx = SpringApplication.run(ViagemApplication.class, args);

		String fileName = args.length > 0 ? args[0] : null;


		try {
			File file = LoadFile.load(fileName);
			ReadFile read = new ReadFile();
			Set<String> read1 = read.read(file);
			System.out.println(read1);

			WriteFile write = new WriteFile();
			Route r = new Route("CDG","HEI", BigDecimal.valueOf(88L));
			write.writeNewLine(r.csv(), file);
			read1 = read.read(file);
			System.out.println(read1);
			Scanner ler = new Scanner(System.in);
			int i, n;

			System.out.print("Informe o número para a tabuada:\n");
			n = ler.nextInt();

		} catch (Exception e) {
			System.err.println(e.getMessage());
			exit(ctx);
		}

	}

	public static void exit( ConfigurableApplicationContext ctx){
		int exitCode = SpringApplication.exit(ctx, new ExitCodeGenerator() {
			@Override
			public int getExitCode() {
				// no errors
				return 0;
			}
		});
		System.exit(exitCode);
	}

}
