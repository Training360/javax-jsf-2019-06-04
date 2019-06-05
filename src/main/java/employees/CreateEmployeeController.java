package employees;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import java.util.List;

@Component
@RequestScope
public class CreateEmployeeController {

    private EmployeeService employeeService;

    private List<CodeElement> salaryOptions;

    private CreateEmployeeCommand command =
            new CreateEmployeeCommand("", 100_000);

    public CreateEmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostConstruct
    public void initSalaryOptions() {
        //salaryOptions = employeeService.listSalaryOptions();
        salaryOptions = employeeService.listCodeElements();
    }

    public String createEmployee() {
        employeeService.createEmployee(command);

        FacesContext.getCurrentInstance()
                .getExternalContext()
                .getFlash()
                .put("successMessage", "Employess has created with name " + command.getName());

        return "index.xhtml?faces-redirect=true";
    }

    public CreateEmployeeCommand getCommand() {
        return command;
    }

    public void setCommand(CreateEmployeeCommand command) {
        this.command = command;
    }

//    public List<Integer> getSalaryOptions() {
//        return salaryOptions;
//    }


    public List<CodeElement> getSalaryOptions() {
        return salaryOptions;
    }
}
