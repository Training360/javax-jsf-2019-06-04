package employees;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope
public class EmployeeDetailsController {

    private EmployeeService employeeService;

    private long id;

    private EmployeeDto employee;

    public EmployeeDetailsController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public void findEmployeeById() {
        employee = employeeService.findEmployeeById(id);
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public EmployeeDto getEmployee() {
        return employee;
    }
}
