package com.nhisyamj.springboottemplate.service;

import com.nhisyamj.springboottemplate.dao.EmployeeDaoImpl;
import com.nhisyamj.springboottemplate.vm.EmployeeVM;
import com.nhisyamj.springboottemplate.vo.EmployeeVO;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class EmployeeServiceTest {

    @InjectMocks
    private EmployeeService service;

    @Mock
    private EmployeeDaoImpl empDao;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void addEmpSuccessTest() {
        EmployeeVM vm = createEmployee();
        service.addEmp(vm);
        verify(empDao,times(1)).addEmp(vm);
    }

    @Test
    public void updateEmpSuccessTest() {
        EmployeeVM vm = createEmployee();
        String empId = vm.getEmpId();
        service.updateEmp(empId,vm);
        verify(empDao,times(1)).updateEmp(empId,vm);
    }

    @Test
    public void getEmpByEmpIdSuccessTest() {
        EmployeeVM vm = createEmployee();
        String empId = "";
        service.getEmpByEmpId(empId);
        Mockito.when(empDao.getEmpByEmpId(empId)).thenReturn(vm);

        EmployeeVM employeeVM = service.getEmpByEmpId(empId);

        assertEquals("1234",employeeVM.getEmpId());
        assertEquals("Mat",employeeVM.getEmpName());
        assertEquals("EC",employeeVM.getEmpRank());
        assertEquals("RND",employeeVM.getDepartment());
    }

    @Test
    public void getEmpListSuccessTest() {
        Iterable<EmployeeVO> list = new ArrayList<>();
        List<EmployeeVM> employeeVMList = new ArrayList<>();
        for (EmployeeVO employeeVO : list) {
            EmployeeVM vm = new EmployeeVM();
            vm.setDepartment(employeeVO.getDepartment());
            vm.setEmpRank(employeeVO.getRank());
            vm.setEmpName(employeeVO.getFirstName());
            vm.setEmpId(employeeVO.getStaffId());
            employeeVMList.add(vm);
        }
        Mockito.when(empDao.getEmpList()).thenReturn(employeeVMList);
        service.getEmpList();
    }

    public EmployeeVM createEmployee() {
        EmployeeVM vm = new EmployeeVM();
        vm.setEmpId("1234");
        vm.setEmpName("Mat");
        vm.setEmpRank("EC");
        vm.setDepartment("RND");

        return vm;
    }

}
