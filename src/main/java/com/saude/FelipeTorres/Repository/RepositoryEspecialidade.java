package com.saude.FelipeTorres.Repository;

import com.saude.FelipeTorres.Model.Especialidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryEspecialidade extends JpaRepository<Especialidade, Integer> {

    //
}
