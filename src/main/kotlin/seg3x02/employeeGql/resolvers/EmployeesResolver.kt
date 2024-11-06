package seg3x02.employeeGql.resolvers

import org.springframework.stereotype.Controller
import seg3x02.employeeGql.repository.EmployeesRepository
import seg3x02.employeeGql.entity.Employee
import seg3x02.employeeGql.resolvers.types.CreateEmployeeInput
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.MutationMapping
import org.springframework.graphql.data.method.annotation.QueryMapping

@Controller
class EmployeesResolver(private val employeeRepository: EmployeesRepository) {

    @QueryMapping
    fun employees(): List<Employee> {
        return employeeRepository.findAll()
    }

    @MutationMapping
    fun addEmployee(@Argument input: CreateEmployeeInput): Employee {
        val employee = Employee(
            name = input.name ?: "Unknown",
            dateOfBirth = input.dateOfBirth ?: "Unknown",
            city = input.city ?: "Unknown",
            salary = input.salary ?: 0.0f,
            gender = input.gender ?: "Unknown",
            email = input.email ?: "Unknown",
            position = input.position ?: "Unknown",          
            department = input.department ?: "Unknown"      


        )
        return employeeRepository.save(employee)
    }
}
