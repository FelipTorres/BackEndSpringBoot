package com.saude.FelipeTorres.Repository;

import com.saude.FelipeTorres.Model.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryMedico extends JpaRepository<Medico, Integer> {

    //
}
