package Users;

import com.javaTest.javaSoftware.interfaces.DataProcessor;
import com.javaTest.javaSoftware.models.Employee;
import com.javaTest.javaSoftware.models.EmployeeToExpose;
import com.javaTest.javaSoftware.services.EmployeeListReview;
import com.javaTest.javaSoftware.services.EmployeeReview;
import com.javaTest.javaSoftware.services.UsuariosService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;



public class UserServicesTest {

    private UsuariosService usuariosService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        usuariosService = new UsuariosService();
    }

    @Test
    void testDtoReviewResponse_employeeReviewInstance() {

        Employee employee = new Employee();
        employee.setId(1d);
        employee.setEmployee_name("John Doe");
        employee.setEmployee_salary(5000d);
        employee.setEmployee_age(30d);
        employee.setProfile_image("profile.jpg");
        EmployeeReview employeeReview = new EmployeeReview(employee);

        Object result = usuariosService.dtoReviewResponse(employeeReview);

        assertTrue(result instanceof EmployeeToExpose);
        EmployeeToExpose transformedEmployee = (EmployeeToExpose) result;
        assertEquals(1L, transformedEmployee.getId());
        assertEquals("John Doe", transformedEmployee.getName());
        assertEquals(5000 * 12, transformedEmployee.getEmployee_anual_salary());
        assertEquals(30L, transformedEmployee.getEmployee_age());
        assertEquals("profile.jpg", transformedEmployee.getProfile_image());
    }

    @Test
    void testDtoReviewResponseWithEmployeeListReview() {
        Employee employee1 = new Employee();
        employee1.setId(1d);
        employee1.setEmployee_name("John Doe");
        employee1.setEmployee_salary(1000d);
        employee1.setEmployee_age(30d);
        employee1.setProfile_image("profile.png");

        Employee employee2 = new Employee();
        employee2.setId(2d);
        employee2.setEmployee_name("Jane Doe");
        employee2.setEmployee_salary(2000d);
        employee2.setEmployee_age(25d);
        employee2.setProfile_image("profile2.png");

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(employee1);
        employeeList.add(employee2);

        EmployeeListReview employeeListReview = new EmployeeListReview(employeeList);
        Object result = usuariosService.dtoReviewResponse(employeeListReview);

        assertNotNull(result);
        assertTrue(result instanceof List<?>);

        List<EmployeeToExpose> employeeDTOList = (List<EmployeeToExpose>) result;
        assertEquals(2, employeeDTOList.size());

        EmployeeToExpose dto1 = employeeDTOList.get(0);
        assertEquals(1L, dto1.getId());
        assertEquals("John Doe", dto1.getName());
        assertEquals(12000, dto1.getEmployee_anual_salary());
        assertEquals(30L, dto1.getEmployee_age());
        assertEquals("profile.png", dto1.getProfile_image());

        EmployeeToExpose dto2 = employeeDTOList.get(1);
        assertEquals(2L, dto2.getId());
        assertEquals("Jane Doe", dto2.getName());
        assertEquals(24000, dto2.getEmployee_anual_salary());
        assertEquals(25L, dto2.getEmployee_age());
        assertEquals("profile2.png", dto2.getProfile_image());
    }

    @Test
    void testDtoReviewResponseWithUnsupportedDataProviderUsingDummy() {
        DataProcessor<?> unsupportedDataProvider = new DummyDataProcessor();

        assertThrows(IllegalArgumentException.class, () -> {
            usuariosService.dtoReviewResponse(unsupportedDataProvider);
        });
    }

    private static class DummyDataProcessor implements DataProcessor<Object> {

        @Override
        public Object getData() {
            return null;
        }
    }
}
