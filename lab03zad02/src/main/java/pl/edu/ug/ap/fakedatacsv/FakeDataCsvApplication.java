package pl.edu.ug.ap.fakedatacsv;
import com.opencsv.exceptions.CsvException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;
import pl.edu.ug.ap.fakedatacsv.domain.Person;
import pl.edu.ug.ap.fakedatacsv.service.PersonService;

import java.io.IOException;


@SpringBootApplication
@ImportResource("classpath:beans.xml")
public class FakeDataCsvApplication {
	public static void main(String[] args) throws IOException, CsvException {
		ApplicationContext applicatioonContext =  SpringApplication.run(FakeDataCsvApplication.class, args);

		PersonService service = applicatioonContext.getBean(PersonService.class);

		Person prezes = service.getPrezes();
		Person wiceprezes = service.getWiceprezes();
		Person sekretarz = service.getSekretarz();

		Object emiliwilliams = applicatioonContext.getBean("emilyWilliams", Person.class);
		Object michealJohnson = applicatioonContext.getBean("michaelJohnson",Person.class);

		System.out.println(prezes);
		System.out.println(wiceprezes);
		System.out.println(sekretarz);
		System.out.println(emiliwilliams);
		System.out.println(michealJohnson);



	}




}
