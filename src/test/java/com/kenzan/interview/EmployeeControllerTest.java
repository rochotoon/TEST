package com.kenzan.interview;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import com.kenzan.interview.application.employee.web.controller.EmployeeController;
import com.kenzan.interview.domain.model.Employee;
import com.kenzan.interview.domain.repository.EmployeeRepository;

@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@AutoConfigureMockMvc
@WebMvcTest(controllers = EmployeeController.class)
class EmployeeControllerTest {

  
  @Autowired
  private MockMvc mockMvc;
  
  @MockBean
  private EmployeeRepository employeeRepository;
  
  @Spy
  private List<Employee> employeeLst;
  
  private static final String CONTEXT_PATH = "/kenzan/employee";
  
	@Test
	void getActiveEmployeeIdTest() throws Exception {
	
	  String url = "/kenzan/employee/11";
	  
	  when(employeeRepository.findAllActive()).thenReturn(employeeLst);
	  
	  // @formatter:off
	    mockMvc.perform(get(url)
	            .contextPath(CONTEXT_PATH)
	            .contentType(MediaType.APPLICATION_JSON)
	             )
	            .andExpect(status().isOk());
	    //@formatter:on
	}

}
