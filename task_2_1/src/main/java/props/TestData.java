package props;

import org.aeonbits.owner.ConfigFactory;

public class TestData {
    public static Url url = ConfigFactory.create(Url.class);
    public static Endpoint endpoint = ConfigFactory.create(Endpoint.class);
}
