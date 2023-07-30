package ru.netology.geo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.geo.GeoServiceImpl;

import java.util.stream.Stream;

public class GeoServiceImplTest {

    final GeoService geoService = new GeoServiceImpl();

    @ParameterizedTest
    @MethodSource("locationByIpTestParameters")
    void testByIp(String ip, Location expectedLocation) {
        Location location = this.geoService.byIp(ip);

        Assertions.assertEquals(location, expectedLocation);
    }

    static Stream<Object> locationByIpTestParameters() {
        return Stream.of(Arguments.of("", null)
                , Arguments.of("0.0.0.0", null)
                , Arguments.of("127.0.0.1", new Location(null, null, null, 0))
                , Arguments.of("172.0.32.11", new Location("Moscow", Country.RUSSIA, "Lenina", 15))
                , Arguments.of("96.44.183.149", new Location("New York", Country.USA, " 10th Avenue", 32))
                , Arguments.of("172. ...", new Location("Moscow", Country.RUSSIA, null, 0))
                , Arguments.of("96. ...", new Location("New York", Country.USA, null, 0)));
    }


}
