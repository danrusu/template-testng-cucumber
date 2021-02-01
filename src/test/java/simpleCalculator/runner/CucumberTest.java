package simpleCalculator.runner;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import io.cucumber.testng.TestNGCucumberRunner;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@CucumberOptions(
        strict = true,
        features = {"src/test/resources/features/simpleCalculator"},
        glue = {"simpleCalculator.stepdefinitions"}
)
public class CucumberTest {

    private static final TestNGCucumberRunner testNGCucumberRunner = new TestNGCucumberRunner(CucumberTest.class);

    @Test(dataProvider = "getScenarios")
    public void runScenario(final PickleWrapper pickleWrapper, final FeatureWrapper featureWrapper) throws Throwable {
        testNGCucumberRunner.runScenario(pickleWrapper.getPickle());
    }

    @DataProvider(parallel = true)
    public static Object[][] getScenarios() {
        return testNGCucumberRunner.provideScenarios();
    }

}
