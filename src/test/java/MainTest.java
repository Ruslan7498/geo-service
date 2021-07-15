import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoServiceImpl;
import ru.netology.i18n.LocalizationServiceImpl;
import ru.netology.sender.MessageSenderImpl;

import java.util.HashMap;
import java.util.Map;


public class MainTest {
    @Test
    void MessageSenderRussiaTest() {
        String ip = "172.";
        String expected = "Добро пожаловать";
        GeoServiceImpl geoService = Mockito.mock(GeoServiceImpl.class);
        Mockito.when(geoService.byIp(ip)).thenReturn(new Location("Moscow", Country.RUSSIA, null, 0));
        LocalizationServiceImpl localizationService = Mockito.mock(LocalizationServiceImpl.class);
        Mockito.when(localizationService.locale(Country.RUSSIA)).thenReturn("Добро пожаловать");
        MessageSenderImpl messageSender = new MessageSenderImpl(geoService, localizationService);
        Map<String, String> headers = new HashMap<String, String>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, ip);
        String actual = messageSender.send(headers);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void MessageSenderUSATest() {
        String ip = "96.";
        String expected = "Welcome";
        GeoServiceImpl geoService = Mockito.mock(GeoServiceImpl.class);
        Mockito.when(geoService.byIp(ip)).thenReturn(new Location("New York", Country.USA, null, 0));
        LocalizationServiceImpl localizationService = Mockito.mock(LocalizationServiceImpl.class);
        Mockito.when(localizationService.locale(Country.USA)).thenReturn("Welcome");
        MessageSenderImpl messageSender = new MessageSenderImpl(geoService, localizationService);
        Map<String, String> headers = new HashMap<String, String>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, ip);
        String actual = messageSender.send(headers);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void byIpTest() {
        String ipRussia = "172.";
        String ipUSA = "96.";
        GeoServiceImpl geoService = Mockito.spy(GeoServiceImpl.class);
        Assertions.assertEquals(Country.USA, geoService.byIp(ipUSA).getCountry());
        Assertions.assertEquals(Country.RUSSIA, geoService.byIp(ipRussia).getCountry());
    }

    @Test
    void localeTest() {
        String messageRussia = "Добро пожаловать";
        String messageUSA = "Welcome";
        LocalizationServiceImpl localizationService = Mockito.spy(LocalizationServiceImpl.class);
        Assertions.assertEquals(messageUSA, localizationService.locale(Country.USA));
        Assertions.assertEquals(messageRussia, localizationService.locale(Country.RUSSIA));
    }
}
