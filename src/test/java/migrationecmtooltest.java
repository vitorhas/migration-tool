import com.rabobank.migration.Application;
import com.rabobank.migration.controller.MigrationController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class migrationecmtooltest {

   @Autowired
   MockMvc mockMvc;

   @Autowired
   MigrationController migrationController;


    @Test
    public void getAllDocStatus() throws Exception{
        this.mockMvc.perform(get("/docstatus")
            .accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"));
    }

    @Test
    public void contextLoads(){
        assertThat(migrationController).isNotNull();
    }

    @Test
    public void getTime() throws Exception {
        this.mockMvc.perform(get("/time")
            .accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
            .andExpect(status().isOk());
    }

    @Test
    public void getIndex() throws Exception {
        this.mockMvc.perform(get("/")
                .accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
                .andExpect(status().isOk());
    }

    @Test
    public void getTestThread() throws Exception {
        this.mockMvc.perform(get("/testThread")
                .accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
                .andExpect(status().isOk());
    }
}
