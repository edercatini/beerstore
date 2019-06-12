package com.ec.beerstore.service.BeerService;

import com.ec.beerstore.model.Beer;
import com.ec.beerstore.model.BeerType;
import com.ec.beerstore.repository.BeerRepository;
import com.ec.beerstore.service.BeerService.exception.BeerAlreadyExistsException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class BeerServiceTest {

    @Autowired
    private BeerService service;

    @MockBean
    private BeerRepository repository;

    @Test(expected = BeerAlreadyExistsException.class)
    public void mustNotSaveBeerThatAlreadyExists() {
        Beer existingBeer = new Beer()
                .setId(1L)
                .setName("name")
                .setType(BeerType.IPA)
                .setVolume(new BigDecimal("300"));

        when(repository.findByNameAndType(any(), any())).thenReturn(existingBeer);

        service.save(this.getBeer());
    }

    @Test
    public void mustSaveABeer() {
        Beer beer = this.getBeer();
        when(repository.findByNameAndType(any(), any())).thenReturn(null);
        when(repository.save(any())).thenReturn(beer);

        service.save(beer);

        verify(repository, times(1)).save(any());
    }

    private Beer getBeer() {
        return new Beer()
                .setName("name")
                .setType(BeerType.IPA)
                .setVolume(new BigDecimal("300"));
    }
}