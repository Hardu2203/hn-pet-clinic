package nel.hardu.hnpetclinic.repositories;

import nel.hardu.hnpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
