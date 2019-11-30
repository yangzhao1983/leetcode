package zy.basics.tstream;

/**
 * Created by kaiser_zhao on 2018/12/24.
 */
public class TestCity {
//    public static void main(String[] args) {
//        City [] cities = {
//                new City("Beijing", "Bj", 2000),
//                new City("Shenzhen", "Guangdong", 2000),
//                new City("Zhuhai", "Guangdong", 1500)};
//        List lc = new ArrayList(Arrays.asList(cities));
//        Stream<String> slc = lc.stream();
//        Map<String, Long> map = slc.collect(Collectors.groupingBy(City::getState, Collectors.counting())); // doesn't compile
//    }
}


class City {
    private String name;

    public String getName() {
        return name;
    }
    private String state;

    public String getState() {
        return state;
    }

    private int population;

    public int getPopulation() {
        return population;
    }

    public City(String n, String s, int p) {
        name = n;
        state = s;
        population = p;
    }
}
