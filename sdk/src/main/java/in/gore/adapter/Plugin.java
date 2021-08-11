package in.gore.adapter;

import in.gore.platform.PropertyReader;

import java.util.List;

public interface Plugin {

    // parameters needed for connection
    List<Property> getConnectionProperties();

    // additional parameters for the plugin
    List<Property> getAdditionalProperties();

    String getName();

    boolean initialize(PropertyReader propertyReader);

    List<Capabilities> getCapabilities();

    // this is just a skeleton
    boolean approveRequest();
}
