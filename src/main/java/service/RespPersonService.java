package service;

import entity.CodeAmortization;
import entity.RespPerson;

import java.util.List;

public interface RespPersonService {
    RespPerson findById(Long id);
    void update(RespPerson respPerson);
    void save (RespPerson respPerson);
    void delete(RespPerson respPerson);
    RespPerson findByName(String name);
    List<RespPerson> getAllPersons();
}
