package props;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "file:src/test/resources/url.properties"
})
public interface PropsUrl extends Config {
    @Key("base.url.yandex")
    String baseUrlYandex();
}
