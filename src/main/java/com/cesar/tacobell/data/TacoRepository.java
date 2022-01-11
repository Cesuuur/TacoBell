package com.cesar.tacobell.data;

import org.springframework.data.repository.CrudRepository;
import com.cesar.tacobell.Taco;

public interface TacoRepository extends CrudRepository<Taco, Long> {

}