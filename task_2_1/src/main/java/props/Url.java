package props;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "file:src/main/resources/url.properties"
})
public interface Url extends Config {
    @Key("base.url.reqres")
    String baseUrlReqres();
}
