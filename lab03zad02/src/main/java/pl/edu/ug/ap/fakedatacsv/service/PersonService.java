package pl.edu.ug.ap.fakedatacsv.service;

import pl.edu.ug.ap.fakedatacsv.domain.Person;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class PersonService {

    private final Person prezes;
    private final Person wiceprezes;
    private final Person sekretarz;

    public PersonService(
            @Qualifier("prezes") Person prezes,
            @Qualifier("wiceprezes") Person wiceprezes,
            @Qualifier("sekretarz") Person sekretarz
    ) {
        this.prezes = prezes;
        this.wiceprezes = wiceprezes;
        this.sekretarz = sekretarz;
    }

    public Person getPrezes() {
        return prezes;
    }

    public Person getWiceprezes() {
        return wiceprezes;
    }

    public Person getSekretarz() {
        return sekretarz;
    }

}
