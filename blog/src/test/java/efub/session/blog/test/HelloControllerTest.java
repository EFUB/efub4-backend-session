package efub.session.blog.test;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.jpa.mapping.JpaMetamodelMappingContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(HelloController.class)
@MockBean(JpaMetamodelMappingContext.class)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class HelloControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnAdminUserRole() {
        final String ADMIN_ROLE = "ADMIN";

        User user = new User();
        user.setRole(ADMIN_ROLE);

        assertEquals(ADMIN_ROLE, user.getRole());
    }

    @Test
    public void return_hello() throws Exception {
        String expectedResponse = "hello";

        mockMvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string(expectedResponse));
    }
}