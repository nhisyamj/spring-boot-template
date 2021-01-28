package com.nhisyamj.springboottemplate.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nhisyamj.springboottemplate.service.EmployeeService;
import com.nhisyamj.springboottemplate.vm.EmployeeVM;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeControllerTest {

    @InjectMocks
    private EmployeeController controller;

    @Mock
    private EmployeeService service;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void addEmployeeSuccessTest() throws Exception {
        EmployeeVM vm = createEmployee();
        ObjectMapper mapper = new ObjectMapper();
        String payload = mapper.writeValueAsString(vm);
        final ResultActions result = mockMvc.perform(post("/employee")
                .content(payload)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
        );
        result.andExpect(status().isOk());
        verify(service).addEmp(any(EmployeeVM.class));
    }

    @Test
    public void updateEmployeeSuccessTest() throws Exception {
        EmployeeVM vm = createEmployee();
        ObjectMapper mapper = new ObjectMapper();
        String payload = mapper.writeValueAsString(vm);
        final ResultActions result = mockMvc.perform(put("/employee")
                .param("emp_id", vm.getEmpId())
                .content(payload)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
        );
        result.andExpect(status().isOk());
    }

    @Test
    public void getEmpByEmpIdSuccessTest() throws Exception {
        String empId = "";
        final ResultActions result = mockMvc.perform(get("/employee")
                .param("emp_id", empId)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
        );
        result.andExpect(status().isOk());
    }

    @Test
    public void getEmpListSuccessTest() throws Exception {
        final ResultActions result = mockMvc.perform(get("/employee/list")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
        );
        result.andExpect(status().isOk());
    }

    public EmployeeVM createEmployee() {
        EmployeeVM vm = new EmployeeVM();
        vm.setEmpId("");
        vm.setEmpName("");
        vm.setEmpRank("");
        vm.setDepartment("");

        return vm;
    }
}
