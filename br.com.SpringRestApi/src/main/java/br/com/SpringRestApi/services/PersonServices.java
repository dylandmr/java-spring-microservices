package br.com.SpringRestApi.services;

import br.com.SpringRestApi.models.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class PersonServices {
    private final AtomicLong counter = new AtomicLong();

    public Person create(Person person) {
        return person;
    }

    public Person update(Person person) {
        return person;
    }

    public void delete(String id) {
        //Deletion mock
    }

    public Person findById (String id) {
        var person = new Person();

        person.setId(counter.incrementAndGet());
        person.setFirstName("Dylan");
        person.setLastName("Rodrigues");
        person.setAddress("Blumenau/SC - Brasil");
        person.setGender("Male");

        return person;
    }

    public List<Person> findAll () {
        var personList = new ArrayList<Person>();

        for (int i = 0; i < 8; i ++)
            personList.add(getPersonMock(i));

        return personList;
    }

    public Person getPersonMock(int i) {
        var person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Person " + i);
        person.setLastName("Random surname " + i);
        person.setAddress("Some random place " + i);
        person.setGender("Random gender");
        return person;
    }
}
