package extension;

import java.time.LocalDate;

/**
 * Базовый класс сотрудник. Доступен для наследования
 */
public class Employee {
    private String name;
    private double salary;
    private LocalDate hireDay;

    /**
     * Пример композиции. Класс Employee содержит объект другого класса - Manager (у каждого сотрудника есть руководитель).
     */
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
 * Клвсс-наслеедник, производный от класса Employee
 */
class Manager extends Employee {

    /**
     * Класс Manager расширяет класс Employee новым полем bonus
     */
    private double bonus;

    public Manager(String name, double salary, LocalDate hireDay) {
        super(name, salary, hireDay);
    }

    /**
     * Класс Manager расширяет класс Employee новым методом для установления значения величины bonus
     * @param bonus дополнительный бонус к з/п
     */
    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    /**
     * Для класса Manager необходимо переопределить метод getSalary, т.к з/п менеджера включает в себя бонусы.
     * Например, создадим менеджера следующим образом: Employee manager = new Manager(). Переменные типа Employee
     * могут ссылаться на объекты клвсса Employee и наобъекты классов, производных от Employee.
     * Объектные переменные являются полиморфными. Это пример классического полиморфизма.
     * Если теперь вызвать метод getSalary() - manager.getSalary() - то будет вызвана реализыция метода из класса
     * Manager. Это пример динамического ad-hoc полиморфизма.
     */
    @Override
    public double getSalary() {
        double baseSalary = super.getSalary();
        return baseSalary + bonus;
    }
}


