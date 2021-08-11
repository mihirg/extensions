package in.gore.service;

import in.gore.adapter.Property;
import in.gore.platform.PropertyReader;

import java.util.List;

public class PropertyReaderImpl implements PropertyReader {

    public PropertyReaderImpl(String source, List<Property> connProps,
                              List<Property> additionalProps) {
        // depending on source extract the appropriate properties
        // from some config file
    }
    @Override
    public String getValue(String key) {
        // use the property metadata to check if its a valid property
        return "some value";
    }
}
