package in.gore.jira;

import in.gore.adapter.Capabilities;
import in.gore.adapter.Plugin;
import in.gore.adapter.Property;
import in.gore.adapter.PropertyType;
import in.gore.platform.PropertyReader;

import java.util.ArrayList;
import java.util.List;

public class PluginImpl implements Plugin {

    @Override
    public List<Property> getConnectionProperties() {
        Property userName = new Property("username", PropertyType.PlainText);
        Property password = new Property("password", PropertyType.Encrypted);
        List<Property> props = new ArrayList<>();
        props.add(userName);
        props.add(password);
        return props;
    }

    @Override
    public List<Property> getAdditionalProperties() {
        return null;
    }

    @Override
    public String getName() {
        return "jira";
    }

    @Override
    public boolean initialize(PropertyReader propertyReader) {
        propertyReader.getValue("username");
        propertyReader.getValue("password");
        return false;
    }

    @Override
    public List<Capabilities> getCapabilities() {
        System.out.println("Jira Get Capabilities called");
        return null;
    }

    @Override
    public boolean approveRequest() {
        System.out.println("Approve Jira Request");
        return false;
    }
}
