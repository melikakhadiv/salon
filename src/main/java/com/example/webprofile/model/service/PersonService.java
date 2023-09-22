package com.example.webprofile.model.service;

import com.example.webprofile.controller.exception.NoContentException;
import com.example.webprofile.model.entity.Person;
import com.example.webprofile.model.repository.CrudRepository;
import com.example.webprofile.model.service.impl.ServiceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PersonService implements ServiceImpl<Person,Long> {
    private static PersonService service = new PersonService();

    private PersonService() {
    }

    public static PersonService getService() {
        return service;
    }

    @Override
    public Person save(Person person) throws Exception {
        try(CrudRepository<Person,Long> repository = new CrudRepository<>()){
            repository.insert(person);
            return person;
        }
    }

    @Override
    public Person edit(Person person) throws Exception {
        try(CrudRepository<Person,Long> repository = new CrudRepository<>()){
            repository.update(person);
            return person;
        }
    }

    @Override
    public Person remove(Long id) throws Exception {
        try(CrudRepository<Person,Long> repository = new CrudRepository<>()){
            Person person = repository.selectById(Person.class, id);

            if (person == null){
                throw  new NoContentException("No Person Found");
            }
            person.setDeleted(true);
            repository.update(person);
            return person;
        }
    }

    @Override
    public List<Person> findAll() throws Exception {
        try(CrudRepository<Person,Long> repository = new CrudRepository<>()){
            List<Person> personList = repository.selectAll(Person.class);

            if (personList.size()==0){
                throw  new NoContentException("No Person Found");
            }
            return personList;
        }
    }

    @Override
    public Person findById(Long id) throws Exception {
        try(CrudRepository<Person,Long> repository = new CrudRepository<>()){
            Person person = repository.selectById(Person.class, id);

            if (person == null){
                throw  new NoContentException("No Person Found");
            }
            return person;
        }
    }

    public List<Person> findByFamily(String family) throws Exception {
        try(CrudRepository<Person,Long> repository = new CrudRepository<>()){
            Map<String,Object> params = new HashMap<>();
            params.put("family",family );

            List<Person> personList = repository.getResultList("Person.FindByFamily", params);

            if (personList.size() == 0){
                throw  new NoContentException("No Person Found");
            }
            return personList;
        }
    }


}
