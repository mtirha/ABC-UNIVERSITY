package edu.miu.adminservice.service;

import edu.miu.adminservice.entity.Faculty;
import edu.miu.adminservice.entity.Registrar;
import edu.miu.adminservice.repository.RegistrarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class RegistrarService implements IUserService<Registrar> {

    @Autowired
    private RegistrarRepository registrarRepository;

    public Registrar add(Registrar registrar) {
        String lastNumber = registrarRepository.findLastUserNumber();
        String  number = Registrar.GenerateNumber(lastNumber, "stu");
        registrar.setUserNumber(number);
        registrarRepository.save(registrar);
        return registrar;
    }
    public Registrar update(String userNumber, Registrar registrar) {
        Registrar updated = registrarRepository.findByUserNumber(userNumber);
        if(registrar != null){
            updated.setHiredDate(registrar.getHiredDate());
            updated.setAddress(registrar.getAddress());
            updated.setEmail(registrar.getEmail());
            updated.setFirstName(registrar.getFirstName());
            updated.setPhone_number(registrar.getPhone_number());
            updated.setLastName(registrar.getLastName());
            registrarRepository.save(updated);
        }
        return updated;
    }
    public List<Registrar> getAll() {
        return registrarRepository.findAll();
    }
    public Registrar getByUserNumber(String userNumber) {
        return registrarRepository.findByUserNumber(userNumber);
    }

}














