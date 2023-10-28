package com.saude.FelipeTorres.Service;

import com.saude.FelipeTorres.Model.Especialidade;
import com.saude.FelipeTorres.Repository.RepositoryEspecialidade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceEspecialidade {

    @Autowired
    private RepositoryEspecialidade repositoryEspecialidade;

    public void salvarEspecialidade(Especialidade especialidade) {

        repositoryEspecialidade.save(especialidade);
    }

    public List<Especialidade> listAll() {

        return repositoryEspecialidade.findAll();
    }

    public Optional<Especialidade> getEspecialidade(int id) {

        return repositoryEspecialidade.findById(id);
    }

    public void excluirEspecialidade(Especialidade especialidade) {

        repositoryEspecialidade.delete(especialidade);
    }
}
