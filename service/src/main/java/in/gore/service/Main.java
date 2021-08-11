package in.gore.service;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;

import in.gore.adapter.Plugin;

public class Main {
    public static void main(String[] args) {
        File libDir = new File("./lib");
        List<Plugin> plugins = loadPlugins(libDir.listFiles());
        for (Plugin p : plugins) {

            PropertyReaderImpl propReader = new PropertyReaderImpl(p.getName(),
            p.getConnectionProperties(), p.getAdditionalProperties());
            p.initialize(propReader);
            p.getCapabilities();
            // the steps above can be done once when the plugins are loaded

            // send approval request to plugin. The plugin now has full context,
            // it can query connection params, additional params and connect to target system
            // the call to approve request below can now do some work.
            p.approveRequest();
        }
    }

    public static List<Plugin> loadPlugins(File[] contents) {
        List<Plugin> plugins = new ArrayList<>();
        for (File f : contents) {
            if (f.isDirectory()) {
                ClassLoader cls = getClassLoader(f.listFiles());
                ServiceLoader<Plugin> plg = ServiceLoader.load(Plugin.class, cls);
                for (Plugin p : plg) {
                    plugins.add(p);
                    break;
                }
            }
        }
        return plugins;

    }

    public static ClassLoader getClassLoader(File[] jars) {
        List<URL> urls = new ArrayList<>();
        for (File f: jars) {
            if (f.isFile()) {
                try {
                    urls.add(f.toURI().toURL());
                } catch (Exception exp) {
                }
            }
        }
        if (urls.size() > 0) {
            URLClassLoader clsLoader = new URLClassLoader(urls.toArray(new URL[urls.size()]));
            return clsLoader;
        }
        else return null;
    }
}
