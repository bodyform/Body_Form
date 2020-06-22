package br.com.fourbbit.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fourbbit.backend.entity.District;

@Repository
public interface DistrictRepository extends JpaRepository<District, Integer> {

}