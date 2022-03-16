package tests;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Для запуска из консоли требуется установить maven на локальную машину
 * Команда для запуска: mvn test -Dcucumber.options="--tags @tagName"
 * Запуск через консоль сгенерирует отчет для Allure
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        strict = true,
        plugin = {"io.qameta.allure.cucumber4jvm.AllureCucumber4Jvm", "pretty", "json:target/cucumber-report/report.json"},
        features = "src/test/java/tests/features",
        glue = "tests.stepDef",
        tags = {"@Run"}
)
public class CucumberRunnerTest {
}
