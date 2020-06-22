package br.com.fourbbit.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fourbbit.backend.entity.State;

@Repository
public interface StateRepository extends JpaRepository<State, Integer> {

}