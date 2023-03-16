package com.crud.example;

import com.crud.example.model.Employee;
import com.crud.example.repository.EmployeeRepository;
import com.crud.example.service.impl.EmployeeServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ApplicationTests {

	@Mock
	private EmployeeRepository employeeRepository;

	@InjectMocks
	private EmployeeServiceImpl employeeService;

	@Test
	public void testRepository() throws Exception {
		Employee employee = new Employee();
		employee.setEmailId("abc@gmail.com");
		employee.setLastName("Jose");
		employee.setFirstName("Castellanos");
		when(this.employeeRepository.findById(1L)).thenReturn(Optional.of(employee));

		Employee employee1 = this.employeeService.getAndEmployee();

		assertNotNull(employee1);
	}

}
