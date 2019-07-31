package nel.hardu.hnpetclinic.services.map;

import nel.hardu.hnpetclinic.model.Owner;
import nel.hardu.hnpetclinic.model.Pet;
import nel.hardu.hnpetclinic.services.OwnerService;
import nel.hardu.hnpetclinic.services.PetService;
import nel.hardu.hnpetclinic.services.PetTypeService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class OwnerMapService extends AbstractMapService<Owner, Long> implements OwnerService {

    private final PetService petService;
    private final PetTypeService petTypeService;

    public OwnerMapService(PetService petService, PetTypeService petTypeService) {
        this.petService = petService;
        this.petTypeService = petTypeService;
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner save(Owner object) {

        if (object != null){
            if (object.getPets() != null){
                object.getPets().forEach(pet -> {

                    if (pet.getPetType() != null){
                        if (pet.getPetType().getId() == null) {

                            pet.setPetType(petTypeService.save(pet.getPetType()));
                        }

                    } else {
                        throw  new RuntimeException("Pet Type is required");
                    }

                    if(pet.getId() == null){
                        Pet savedPet = petService.save(pet);
                        pet.setId(savedPet.getId());
                    }

                });
            }
        }
        return super.save( object);
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {

        super.deleteByID(id);

    }

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }
}
