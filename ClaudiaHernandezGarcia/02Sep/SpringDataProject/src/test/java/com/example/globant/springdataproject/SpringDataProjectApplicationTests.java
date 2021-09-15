package com.example.globant.springdataproject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class SpringDataProjectApplicationTests {

    @InjectMocks
    private SpringDataProjectApplication springDataProjectApplication;

    @Test
    public void contextLoads() {
        springDataProjectApplication.main(new String[] {});
    }

}
