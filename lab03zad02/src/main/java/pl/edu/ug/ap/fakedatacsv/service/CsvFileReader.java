package pl.edu.ug.ap.fakedatacsv.service;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import pl.edu.ug.ap.fakedatacsv.domain.Person;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvFileReader {

    public List<String[]> data = new ArrayList<>();

    public List<String[]>parseCSVFile(String filePath) throws IOException, CsvException {
        CSVReader csvReader = new CSVReaderBuilder(new FileReader(filePath)).withSkipLines(1).build();
        this.data.addAll(csvReader.readAll());
        return this.data;
    }
    public String[] person(){
        if(!this.data.isEmpty()){
            String[] person = this.data.get(0);
            this.data.remove(0);
            return person;
        }
        return null;


    }


}
