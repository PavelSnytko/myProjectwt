package Serializacia;

/*	Создать класс Notebook - наследник Computer. В этом классе должно быть поле типа Touchpad - также созданного класса со своими полями.
        Добавить в класс Notebook transient-поле. Создать объект класса Notebook, сериализовать в файл.
        Десериализовать объект из файла, продемонстрировать, что transient-поля не сериализуются.*/
class Notebook extends Computer {
    transient private int price;
    private String model;
    public Notebook(String name, int memory, double weight, int price, String model) {
        super(name, memory, weight);
        this.price = price;
        this.model=model;
    }

    public int getPrice() {
        return price;
    }

    public String getModel() {
        return model;
    }
}

