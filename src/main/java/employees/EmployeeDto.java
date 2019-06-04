package employees;

import java.util.stream.Collectors;

public class EmployeeDto {

    private long id;

    private String name;

    private int salary;

    private String cities;

    public EmployeeDto(Employee employee) {
        id = employee.getId();
        name = employee.getName();
        salary = employee.getSalary();
        cities = employee.getAddresses().stream()
                .map(Address::getCity)
                .collect(Collectors.joining(", "));
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getCities() {
        return cities;
    }

    public void setCities(String cities) {
        this.cities = cities;
    }
}
