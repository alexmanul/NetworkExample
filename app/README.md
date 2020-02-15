1. Employee (Model)
2. EmployeeAPI (Requests)
3. BaseRepository (Base class)
4. EmployeeRepository (Interface)
5. EmployeeRepositoryImpl(extends BaseRepository and implements EmployeeRepository)
6. DI - injected 4 and 5 to DI
7. Pass EmployeeRepository to ViewModel through Factory