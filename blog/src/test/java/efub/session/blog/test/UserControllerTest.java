package efub.session.blog.test;

import com.fasterxml.jackson.databind.ObjectMapper;
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
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(HelloController.class)
@MockBean(JpaMetamodelMappingContext.class)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class UserControllerTest {

    @Autowired
    private MockMvc mvc;
    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private UserService userService;

    @Test
    public void create_user() throws Exception {
        // given
        String name = "user1";
        UserRequestDTO userRequestDTO = new UserRequestDTO(name);
        String requestBody = objectMapper.writeValueAsString(userRequestDTO);

        given(userService.save(any(UserRequestDTO.class)))
                .willReturn(User.builder().name(name)
                        .type(UserType.MEMBER).build());

        // when & then
        mvc.perform(post("/test/user")
                .contentType("application/json")
                .content(requestBody))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("name").value(name));
    }

    @Test
    public void no_user_exception_handling() throws Exception {
        // given
        given(userService.findById(anyLong())).willThrow(new IllegalArgumentException());

        // when & then
        mvc.perform(get("/test/user/1"))
                .andExpect(status().isNotFound());
    }
}