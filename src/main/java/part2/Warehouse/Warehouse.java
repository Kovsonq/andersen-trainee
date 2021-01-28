package part2.Warehouse;

import lombok.SneakyThrows;
import part2.Product.Food;
import part2.Product.NoFood;
import part2.Product.Product;

import java.lang.reflect.Field;
import java.util.HashMap;

public class Warehouse {
    private static HashMap<Product, Integer> warehouseMap = new HashMap<>();

    public static void main(String[] args) {
        Warehouse warehouse = new Warehouse();
        warehouse.addProductToWarehouse(new NoFood("Milk",12), 1);
        warehouse.addProductToWarehouse(new NoFood("Milk",12), 1);
        warehouse.addProductToWarehouse(new Food("Milk",12), 1);
        warehouse.addProductToWarehouse(new Food("Milk",12), 3);
        warehouseMap.put(new Food("Milk without date",12), 1);
        System.out.println(warehouseMap);
    }

    @SneakyThrows
    public void addProductToWarehouse(Product product, Integer count) {
        Class<?> clazz = product.getClass();
        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(ExpiredDate.class)) {
                field.setAccessible(true);
                try {
                    field.set(product, field.getType().getDeclaredConstructor().newInstance());
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        warehouseMap.merge(product, count, Integer::sum);
    }

    public HashMap<Product,Integer> getWarehouseMap(){
        return warehouseMap;
    }

}
