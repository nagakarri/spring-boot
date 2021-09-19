package com.nkarri.waracle.cakemanager.service;

import com.nkarri.waracle.cakemanager.data.CakeRepository;
import com.nkarri.waracle.cakemanager.models.Cake;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CakeServiceTest {

    @Autowired
    private CakeService cakeService;

    @MockBean
    private CakeRepository mockRepository;

    @Test
    public void testFindById() {
        // Setup  mock repository
        Cake cake = new Cake(1l, "1", "Banana cake with cream cheese", "Use up over-ripe bananas to create a crowd-pleasing afternoon-tea cake.");
        doReturn(Optional.of(cake)).when(mockRepository).findById(1l);

        // Execute the service call
        Optional<Cake> returnedCake = cakeService.getCake(1l);

        // Assert the response
        Assertions.assertTrue(returnedCake.isPresent(), "Cake was not found");
        Assertions.assertSame(returnedCake.get(), cake, "The Cake returned was not the same as the mock");
    }

    @Test
    public void testFindAll() {
        // Setup  mock repository
        Cake cake1 = new Cake(1l, "1", "Banana cake with cream cheese", "Use up over-ripe bananas to create a crowd-pleasing afternoon-tea cake.");
        Cake cake2 = new Cake(2l, "2", "New York baked cheesecake", "Take the cake and master the basics with this creamy baked version of a classic dessert.");
        doReturn(Arrays.asList(cake1, cake2)).when(mockRepository).findAll();

        // Execute the service call
        List<Cake> returnedCakes = cakeService.getAllCakes();

        // Assert the response
        Assertions.assertEquals(2, returnedCakes.size(), "findAll should return 2 cakes");
    }

    @Test
    public void testFindByIdNotFound() {
        // Setup mock repository
        doReturn(Optional.empty()).when(mockRepository).findById(1l);

        // Execute the service call
        Optional<Cake> returnedCake = cakeService.getCake(1l);

        // Assert the response
        Assertions.assertFalse(returnedCake.isPresent(), "Cake should not be found");
    }

    @Test
    public void testSave() {
        // Setup mock repository
        Cake cake = new Cake(1l, "1", "Banana cake with cream cheese", "Use up over-ripe bananas to create a crowd-pleasing afternoon-tea cake.");
        doReturn(cake).when(mockRepository).save(any());

        // Execute the service call
        Cake returnedCake = cakeService.newCake(cake);

        // Assert the response
        Assertions.assertNotNull(returnedCake, "The saved Cake should not be null");
        Assertions.assertEquals("1", returnedCake.getNumber(), "Number is not matched");
        Assertions.assertEquals("Banana cake with cream cheese", returnedCake.getName(), "Name is not as expected");
    }
}
