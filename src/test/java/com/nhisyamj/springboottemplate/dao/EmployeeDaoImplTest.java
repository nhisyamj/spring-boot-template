package com.nhisyamj.springboottemplate.dao;

import com.nhisyamj.springboottemplate.vm.EmployeeVM;
import com.nhisyamj.springboottemplate.vo.EmployeeVO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeDaoImplTest {

    @InjectMocks
    private EmployeeDaoImpl employeeDao;

    @Mock
    private EmpDao empDao;

    @Test
    public void addEmpSuccessTest() {
        EmployeeVM vm = createEmployeeVM();
        Assert.assertNotNull(vm);
        employeeDao.addEmp(vm);
        verify(empDao,times(1)).save(any(EmployeeVO.class));
    }

    @Test
    public void updateEmpSuccessTest() {
        EmployeeVM vm = createEmployeeVM();
        when(empDao.findByStaffId(anyString())).thenReturn(createEmployeeVO());
        when(empDao.save(any(EmployeeVO.class))).thenReturn(createEmployeeVO());
        Assert.assertNotNull(vm);
        employeeDao.updateEmp("abc123",vm);
        verify(empDao,times(1)).save(any(EmployeeVO.class));
    }

    @Test
    public void getEmpByEmpIdSuccessTest() {
        when(empDao.findByStaffId("")).thenReturn(createEmployeeVO());
        EmployeeVM vm = employeeDao.getEmpByEmpId("");
        Assert.assertNotNull(vm);
    }

    @Test
    public void getEmpListSuccessTest() {
        List<EmployeeVO> list = new ArrayList<>();
        list.add(createEmployeeVO());

        when(empDao.findAll()).thenReturn(list);

        List<EmployeeVM> vmList = employeeDao.getEmpList();

        assertEquals(1,vmList.size());
        verify(empDao,times(1)).findAll();
    }

    public EmployeeVM createEmployeeVM() {
        EmployeeVM vm = new EmployeeVM();
        vm.setEmpId("1234");
        vm.setEmpName("Mat");
        vm.setEmpRank("EC");
        vm.setDepartment("RND");

        return vm;
    }

    public EmployeeVO createEmployeeVO() {
        EmployeeVO vo = new EmployeeVO();
        vo.setFirstName("Ahmad");
        vo.setLastName("Albab");
        vo.setStaffId("1234");
        vo.setAge(22);
        vo.setGender("Male");
        vo.setDepartment("RND");

        return vo;
    }


}
