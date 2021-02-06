package service;

import entity.Assets;
import entity.CodeAmortization;

import java.util.List;

public interface AssetsService {
    Assets findById(Long id);
    void update(Assets assets);
    void save (Assets assets);
    void delete(Assets assets);
    Assets findByName(String name);
    List< Assets > getAllAssets();
}
