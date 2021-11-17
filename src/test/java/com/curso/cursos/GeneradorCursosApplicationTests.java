package com.curso.cursos;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class GeneradorCursosApplicationTests {

  
  @Autowired
  MockMvc mock;
  
	@Test
	void testListar() {
	  try {
      mock.perform(get("/listar")).andDo(print());
    } catch (Exception e) {
           e.printStackTrace();
    }
	}

}
