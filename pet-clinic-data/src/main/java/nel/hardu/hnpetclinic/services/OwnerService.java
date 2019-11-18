package nel.hardu.hnpetclinic.services;

import nel.hardu.hnpetclinic.model.Owner;

import java.util.List;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName (String lastName);

    List<Owner> findAllByLastNameLike(String lastname);

}
