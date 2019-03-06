package nel.hardu.hnpetclinic.services;

import nel.hardu.hnpetclinic.model.Vet;

import java.util.Set;

public interface VetService {

    Vet findById(Long Id);

    Vet save(Vet vet);

    Set<Vet> findAll();

}
