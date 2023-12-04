package extension_specialization;

import java.time.LocalDate;

/**
 * Базовый класс сотрудник. Доступен для наследования
 */
public class Employee {
    private String name;
    private double salary;
    private LocalDate hireDay;

    private Manager manager;

    public Employee(String name, double salary, LocalDate hireDay) {
        this.name = name;
        this.salary = salary;
        this.hireDay = hireDay;
    }

    public double getSalary() {
        return salary;
    }
}

/**
 * Клвсс-наследник, производный от класса Employee. Расширяет Employee новым полем bonus и методом
 * для установления значения bonus. И спецмализирует(перееопределяет) метод getSalary().
 */
class Manager extends Employee {

    private double bonus;

    public Manager(String name, double salary, LocalDate hireDay) {
        super(name, salary, hireDay);
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public double getSalary() {
        double baseSalary = super.getSalary();
        return baseSalary + bonus;
    }
}


