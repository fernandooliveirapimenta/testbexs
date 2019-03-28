package com.bexs.viagem;

import com.bexs.viagem.dao.RouteDAO;
import com.bexs.viagem.file.LoadFile;
import com.bexs.viagem.util.BestRouteImpl;
import com.bexs.viagem.util.BestRouteInterface;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
public class ViagemApplication {


	public static void main(String[] args) {

		ConfigurableApplicationContext ctx = SpringApplication.run(ViagemApplication.class, args);

		String fileName = args.length > 0 ? args[0] : null;

		try {
			// carregando arquivo
			LoadFile.load(fileName);
			// iniciando console
			Console console = new Console(new BestRouteImpl(new RouteDAO(LoadFile.getFile())));
			console.init();
		} catch (Exception e) {
			System.err.println(e.getMessage());
			exit(ctx);
		}

	}

	public static void exit( ConfigurableApplicationContext ctx){
		int exitCode = SpringApplication.exit(ctx, (ExitCodeGenerator) () -> 0);
		System.exit(exitCode);
	}

}
