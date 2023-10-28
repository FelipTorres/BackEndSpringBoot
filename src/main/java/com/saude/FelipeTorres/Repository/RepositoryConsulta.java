package com.saude.FelipeTorres.Repository;

import com.saude.FelipeTorres.Model.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryConsulta extends JpaRepository<Consulta, Integer> {

    //
}
