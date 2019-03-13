package apptest;

import app.Controller.MainController;
import app.apprun;
import app.Service.webServices;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = apprun.class)
@AutoConfigureMockMvc
public class ControllerTestImp {

    @Autowired
    private MainController Cont;

    @Autowired
    private webServices service;

    @Autowired
    private MockMvc mockMvc;

    // App runs test
    @Test
    public void contextLoads() throws Exception{
        assertThat(Cont).isNotNull();
    }

    // Check URL works
    @Test
    public void GetFindAllLoads() throws  Exception{
        this.mockMvc.perform(get("/findall")).andExpect(status().isOk());
    }
    // Test find all but need to apply mocking data. refactor based on sample code.
//    @Test
//    public void GetFindAllReturn() throws  Exception{
    //		List<Country> list = new ArrayList<Country>();
    //		list.add(new Country(1, "EUR", "PORTUGAL"));
    //		list.add(new Country(2, "GBP", "ENGLAND"));
    //		list.add(new Country(3, "EUR", "FRANCE"));
    //		list.add(new Country(4, "YEN", "JAPAN"));
    //		list.add(new Country(5, "ZAR", "SOUTH AFRICA"));
    //		log.info("testFindAll() - findAll() to return " + list.toString());
    //		when(repository.findAll()).thenReturn(list);
    //		log.info("testFindAll() - findAll() calling");
    //		List<Country> result = service.findAll();
    //		log.info("testFindAll() - Verifying findAll() is called at least once");
    //		verify(repository, atLeastOnce()).findAll();
    //		log.info("testFindAll() - Asserting that the result is not null or empty");
    //		assertNotNull(result);
    //		assertFalse(result.isEmpty());
//    }
    //Test find one but need to apply mocking data. refactor based on sample code.
//    @Test
//    public void testFindOne() {
//        Country c = new Country(3, "EUR", "FRANCE");
//        log.info("testFindOne() - findOne(3) to return " + c.toString());
//        when(repository.findOne(3)).thenReturn(c);
//        log.info("testFindOne() - findOne(3) calling");
//        Country result = service.findOne(3);
//        log.info("testFindOne() - Verifying findOne(3) is called at least once");
//        verify(repository, atLeastOnce()).findOne(3);
//        log.info("testFindOne() - Asserting that the result is not null");
//        assertNotNull(result);
//    }
}
