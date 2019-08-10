package nel.hardu.hnpetclinic.services.map;

import nel.hardu.hnpetclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerMapServiceTest {

    OwnerMapService ownerMapService;

    final Long ownerId = 1L;
    final String lastname = "Smith";

    @BeforeEach
    void setUp() {

        ownerMapService = new OwnerMapService(new PetMapService(), new PetTypeMapService());

        ownerMapService.save(Owner.builder().id(ownerId).lastName(lastname).build());
    }

    @Test
    void findAll() {
        Set<Owner> ownerSet =  ownerMapService.findAll();

        assertEquals(1, ownerSet.size());
    }

    @Test
    void findById() {
        Owner owner = ownerMapService.findById(ownerId);

        assertEquals(ownerId, owner.getId());
    }

    @Test
    void saveExistingId() {
        Long id = 2L;

        Owner owner2 = Owner.builder().id(2L).build();

        Owner savedOwner = ownerMapService.save(owner2);

        assertEquals(id, savedOwner.getId());
    }

    @Test
    void saveNoId() {
        Owner savedOwner = ownerMapService.save(Owner.builder().build());

        assertNotNull(savedOwner);
        assertNotNull(savedOwner.getId());
    }

    @Test
    void delete() {
        ownerMapService.delete(ownerMapService.findById(ownerId));

        assertEquals(0, ownerMapService.findAll().size());

    }

    @Test
    void deleteById() {
        ownerMapService.delete(ownerMapService.findById(ownerId));


        assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    void findByLastName() {

        Owner owner = ownerMapService.findByLastName(lastname);

        assertNotNull(owner);

        assertEquals(ownerId, owner.getId());
    }

    @Test
    void findByLastNameNotFound() {

        Owner owner = ownerMapService.findByLastName("foo");

        assertNull(owner);

    }
}