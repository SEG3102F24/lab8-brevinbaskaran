package seg3x02.employeeGql.resolvers

import org.springframework.stereotype.Controller

@Controller
class EmployeesResolver(private val employeeRepository: EmployeeRepository) {

    @QueryMapping
    fun employees(): List<Employee> {
        return employeeRepository.findAll()
    }

    @MutationMapping
    fun addEmployee(@Argument input: EmployeeInput): Employee {
        val employee = Employee(
            name = input.name,
            position = input.position,
            department = input.department
        )
        return employeeRepository.save(employee)
    }

    
}
