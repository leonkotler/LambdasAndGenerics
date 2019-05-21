package generic_factory;

import java.util.HashMap;
import java.util.Map;

public class GenericFactory<Product> {

    private interface Creator<Product> {
        Product create();
    }

    Map<String, Creator<Product>> map;

    public GenericFactory() {

        map = new HashMap<>();
    }

    public void insertProduct(String key, Class<? extends Product> c) {

        map.put(key, () -> {
            try {
                return c.newInstance();
            } catch (InstantiationException | IllegalAccessException e) {
                return null;
            }
        });

    }

    public Product getNewProduct(String key) {
        return map.get(key).create();
    }

}
