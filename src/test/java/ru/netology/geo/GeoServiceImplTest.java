package ru.netology.geo;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import ru.netology.entity.Country;
import ru.netology.entity.Location;

class GeoServiceImplTest {
    public static final String LOCALHOST = "127.0.0.1";
    public static final String MOSCOW_IP = "172.0.32.11";
    public static final String NEW_YORK_IP = "96.44.183.149";

    @ParameterizedTest
    @ValueSource(strings = {LOCALHOST, MOSCOW_IP, NEW_YORK_IP})
    void byIpTest(String ip) {
        Location location = null;
        if (LOCALHOST.equals(ip)) {
            location = new Location(null, null, null, 0);
        } else if (MOSCOW_IP.equals(ip)) {
            location = new Location("Moscow", Country.RUSSIA, "Lenina", 15);
        } else if (NEW_YORK_IP.equals(ip)) {
            location = new Location("New York", Country.USA, " 10th Avenue", 32);
        } else if (ip.startsWith("172.")) {
            location = new Location("Moscow", Country.RUSSIA, null, 0);
        } else if (ip.startsWith("96.")) {
            location = new Location("New York", Country.USA, null, 0);
        }
        System.out.print("Локация: " + location.getCity() + ", " + location.getCountry()
                + ", " + location.getStreet() + ", " + location.getBuiling());
    }
}