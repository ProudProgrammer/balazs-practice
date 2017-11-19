package hu.gaborbalazs.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.google.common.base.MoreObjects;

public class App {

    public static void main(String[] args) {

        Store carStore = new Store("carsStore", Arrays.asList("audi", "opel"));
        Store carStore2 = new Store("carsStore", Arrays.asList("ferrari", "porsche"));
        Store junkStore = new Store("junkStore", Arrays.asList("ball", "opel", "table"));

        List<Store> stores = Arrays.asList(carStore, carStore2, junkStore);

        Map<String, List<Store>> storesMap = new HashMap<>();
        stores.stream().flatMap(store -> store.getThings().stream())
                .forEach(thing -> storesMap.put(thing, new ArrayList<>()));
        stores.stream().forEach(store -> store.getThings().stream().forEach(thing -> storesMap.get(thing).add(store)));
        System.out.println(storesMap);
        System.out.println();
        Map<String, List<Store>> storesMapByName = stores.stream().collect(Collectors.groupingBy(Store::getName));
        System.out.println(storesMapByName);
    }

}

class Store {

    private String name;

    private List<String> things;

    public Store(String name, List<String> things) {
        super();
        this.name = name;
        this.things = things;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getThings() {
        return things;
    }

    public void setThings(List<String> things) {
        this.things = things;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).add("name", name).toString();
    }

}
