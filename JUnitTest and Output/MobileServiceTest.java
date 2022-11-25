package com.example.mobile.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.mobile.entity.Mobile;
import com.example.mobile.repository.MobileRepository;

import java.util.Optional;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {MobileService.class})
@ExtendWith(SpringExtension.class)
class MobileServiceTest {
    @MockBean
    private MobileRepository mobileRepository;

    @Autowired
    private MobileService mobileService;

    
    @Test
    void testSave() {
        Mobile mobile = new Mobile();
        mobile.setId(1);
        mobile.setName("Name");
        mobile.setPrice(1);
        mobile.setStatus("Status");
        when(mobileRepository.save((Mobile) any())).thenReturn(mobile);

        Mobile mobile1 = new Mobile();
        mobile1.setId(1);
        mobile1.setName("Name");
        mobile1.setPrice(1);
        mobile1.setStatus("Status");
        assertSame(mobile, mobileService.save(mobile1));
        verify(mobileRepository).save((Mobile) any());
    }

    /
    @Test
    void testGetMobile() {
        Mobile mobile = new Mobile();
        mobile.setId(1);
        mobile.setName("Name");
        mobile.setPrice(1);
        mobile.setStatus("Status");
        Optional<Mobile> ofResult = Optional.of(mobile);
        when(mobileRepository.findById((Integer) any())).thenReturn(ofResult);
        assertSame(mobile, mobileService.getMobile(1));
        verify(mobileRepository).findById((Integer) any());
    }

    @Test
    @Disabled("TODO: Complete this test")
    void testGetMobile2() {
        

        when(mobileRepository.findById((Integer) any())).thenReturn(Optional.empty());
        mobileService.getMobile(1);
    }

    
    @Test
    void testUpdate() {
        Mobile mobile = new Mobile();
        mobile.setId(1);
        mobile.setName("Name");
        mobile.setPrice(1);
        mobile.setStatus("Status");
        Optional<Mobile> ofResult = Optional.of(mobile);

        Mobile mobile1 = new Mobile();
        mobile1.setId(1);
        mobile1.setName("Name");
        mobile1.setPrice(1);
        mobile1.setStatus("Status");
        when(mobileRepository.save((Mobile) any())).thenReturn(mobile1);
        when(mobileRepository.findById((Integer) any())).thenReturn(ofResult);

        Mobile mobile2 = new Mobile();
        mobile2.setId(1);
        mobile2.setName("Name");
        mobile2.setPrice(1);
        mobile2.setStatus("Status");
        assertSame(mobile1, mobileService.update(mobile2));
        verify(mobileRepository).save((Mobile) any());
        verify(mobileRepository).findById((Integer) any());
    }

   
    @Test
    @Disabled("TODO: Complete this test")
    void testUpdate2() {
        

        Mobile mobile = new Mobile();
        mobile.setId(1);
        mobile.setName("Name");
        mobile.setPrice(1);
        mobile.setStatus("Status");
        when(mobileRepository.save((Mobile) any())).thenReturn(mobile);
        when(mobileRepository.findById((Integer) any())).thenReturn(Optional.empty());

        Mobile mobile1 = new Mobile();
        mobile1.setId(1);
        mobile1.setName("Name");
        mobile1.setPrice(1);
        mobile1.setStatus("Status");
        mobileService.update(mobile1);
    }

    @Test
    void testDelete() {
        doNothing().when(mobileRepository).deleteById((Integer) any());
        assertEquals("deleted", mobileService.delete(1).getStatus());
        verify(mobileRepository).deleteById((Integer) any());
    }

    @Test
    void testConstructor() {
       

        (new MobileService()).setMobileRepository(mock(MobileRepository.class));
    }
}

