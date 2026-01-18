package pl.edu.ug.ap.fakedatacsv.config;
import com.opencsv.exceptions.CsvException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import pl.edu.ug.ap.fakedatacsv.domain.Person;
import pl.edu.ug.ap.fakedatacsv.service.CsvFileReader;
import java.io.IOException;

@Configuration
public class MyAppConfig {

    @Bean
    public CsvFileReader readCsvPersons() throws IOException, CsvException {
        System.out.println("Wczytuję dane");
        String pathFile = "src/main/resources/Data.csv";
        CsvFileReader data= new CsvFileReader();
        data.parseCSVFile(pathFile);
        return data;
    }
    @Bean
    @Scope("prototype")
    public Person person() throws IOException, CsvException {
       String[] person =  this.readCsvPersons().person();
       if(person != null){
           return new Person(person[0], person[1], person[2], person[3], person[4]);
       }
       return new Person();

    }
    @Bean
    @Qualifier("prezes")
    public Person prezesPerson() {
        return new Person("0", "Jan", "Prezes", "prezes@example.com", "1980");
    }
    @Bean
    @Qualifier("wiceprezes")
    public Person wiceprezesPerson() {
        return new Person("1", "Marek", "Wice", "wc@example.com", "1980");
    }
    @Bean
    @Qualifier("sekretarz")
    public Person sekretarzPerson() {
        return new Person("2", "Anna", "Sekretara", "as@example.com", "1980");
    }




}
