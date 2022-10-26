package edu.miu.adminservice.service;

import edu.miu.adminservice.entity.Faculty;
import edu.miu.adminservice.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public interface IUserService<T> {

	T add(T user) ;
	T update(String userNumber, T user) ;
	List<T> getAll() ;
	T getByUserNumber(String userId) ;

}














