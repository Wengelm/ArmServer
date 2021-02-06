package service;

import entity.CodeAmortization;
import entity.User;

import java.util.List;

public interface CodeService {

    CodeAmortization findById(Long id);
    void update(CodeAmortization code);
    void save (CodeAmortization code);
    void delete(CodeAmortization code);
    CodeAmortization findByCode(String code);
    List<CodeAmortization> getAllCodes();
}
