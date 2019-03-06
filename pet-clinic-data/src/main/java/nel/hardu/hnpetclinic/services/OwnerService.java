package nel.hardu.hnpetclinic.services;

import nel.hardu.hnpetclinic.model.Owner;

import java.util.Set;

public interface OwnerService {

    Owner findByLastName (String lastName);

    Owner findById(Long Id);

    Owner save(Owner owner);

    Set<Owner> findAll();

}
