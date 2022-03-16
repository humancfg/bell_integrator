package props;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "file:src/test/resources/driver.properties"
})
public interface PropsDriver extends Config{
    @Config.Key("configuration.timeout")
    Long configurationTimeout();
}
