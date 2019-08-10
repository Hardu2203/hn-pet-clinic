package nel.hardu.hnpetclinic.services;

import nel.hardu.hnpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName (String lastName);
}
