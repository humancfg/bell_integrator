package props;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "file:src/main/resources/endpoint.properties"
})
public interface Endpoint extends Config {
    @Key("api.users.page.2")
    String usersSecondPage();

    @Key("api.login")
    String login();

    @Key("api.unknown")
    String unknown();
}
