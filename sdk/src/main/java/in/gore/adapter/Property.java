package in.gore.adapter;

public class Property {
    private String name;
    private PropertyType type;

    public Property() {

    }

    // todo: enable builder pattern
    public Property(String name, PropertyType type) {
        this.name = name;
        this.type = type;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PropertyType getType() {
        return type;
    }

    public void setType(PropertyType type) {
        this.type = type;
    }
}
