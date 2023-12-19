### Рефлексия по решению курсанта

```java
class General implements Serializable {
    public <T> void deepCopy(T target) throws Exception {
        try {
            target = getCopy();
        } catch (Exception e) {
            throw e;
        }
    }

    public <T> T deepClone() throws Exception {
        try {
            return getCopy();
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public <T> String serialize() throws JsonProcessingException {
        var mapper = new ObjectMapper();
        return mapper.writeValueAsString((T) this);
    }

    public static <T> T deserialize(
            String json,
            Class<T> clazz) throws JsonProcessingException {
        var mapper = new ObjectMapper();
        return mapper.readValue(json, clazz);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @JsonIgnore
    public final Class<?> getType() {
        return this.getClass();
    }

    private <T> T getCopy() throws Exception {
        try {
            var byteArrayOutputStream = new ByteArrayOutputStream();
            var objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject((T) this);
            
            var bais = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
            var objectInputStream = new ObjectInputStream(bais);

            return (T) objectInputStream.readObject();
        } catch (Exception e) {
            throw e;
        }
    }
}

/*public*/ class Any extends General {

}
```

1. Я использовал метод clone() класса Object для глубокого копирования и копирования объекта. Но с помощью этого метода 
    нельзя сделать глубокое коприование: если копируемый объект содерит поля ссылочных типов, то эти поля не будут скопированы,
    а будет просто указаны ссылка на оригинальный объект, что некорректно. Глубокого копирования можно добиться, сериализовав
    объект в байт-массив, например, а затем десериализовав этот массив в новый объект. Таким образом будут созданы и копии
    всех "вложенных" объектов.
    
    Примечание: изменение ссылки в методе deepCopy в решении курсанта не корректно (target = getCopy()). За пределами метода
    это изменение не будет "видно".

2. Так же в задаче сказано, что все прикладные классы - наследники Any. Поэтому имеет смысл ограничить возвращаемые типы
    <T extends Any>.

