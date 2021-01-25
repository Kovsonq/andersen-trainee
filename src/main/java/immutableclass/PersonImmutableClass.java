package immutableclass;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
public class PersonImmutableClass {
    private final int age;
    private final String name;
    private final String[] address;

    public PersonImmutableClass(int age, String name, String[] address) {
        this.age = age;
        this.name = name;
        this.address = address.clone();
    }

    @Override
    public String toString() {
        return "PersonImmutableClass{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", address=" + Arrays.toString(address) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersonImmutableClass that = (PersonImmutableClass) o;

        if (age != that.age) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(address, that.address);
    }

    @Override
    public int hashCode() {
        int result = age;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(address);
        return result;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String[] getAddress() {
        return address.clone();
    }
}
