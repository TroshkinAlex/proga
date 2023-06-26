package worker;

import json_control.FileDespatcher;
import json_control.Parser;
import models.Person;

import java.util.Collection;
import java.util.Objects;
import java.util.concurrent.ConcurrentSkipListSet;

public class PersonStorage {
    private static Collection<Person> persons = new ConcurrentSkipListSet<>();

    public static Collection<Person> getPersons() {
        return persons;
    }

    public static void clearPeople() {
        persons.clear();
    }

    @Deprecated
    public static void removePerson(Person person) {
        persons.remove(person);
    }

    public static Person getById(Integer id) {
        return persons.stream().filter(person -> person.getId().equals(id)).findFirst().orElseThrow();
    }

    @Deprecated
    public static void initialState() {
//        String jsonFile = FileDespatcher.readFile(DEFAULT_FILE_PATH);
        String jsonFile = null;
        try {
            jsonFile = FileDespatcher.readFile(System.getenv("LAB5_JSON"));
        } catch (NullPointerException excException) {
            System.err.println("No file for reading and writing info.");
            System.exit(-1);
        }

        if (Parser.jsonToPersons(jsonFile) == null) return;
        try {
            persons = Objects.requireNonNull(Parser.jsonToPersons(jsonFile)).getCollection();
            Person.setCurrentLastId(persons.stream().mapToInt(Person::getId).max().orElse(0) + 1);
        } catch (NullPointerException ignore) {
            System.err.println("Error in file with data");
        }
    }

    public void initializeStateFromDb() {

    }


}