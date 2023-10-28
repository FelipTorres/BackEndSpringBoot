package com.saude.FelipeTorres.Repository;

import com.saude.FelipeTorres.Model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryPaciente extends JpaRepository<Paciente, Integer> {

    //
}
