package Listeners;

import Utilities.LogsUtils;
import org.jetbrains.annotations.NotNull;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ITestResultListenerClass implements ITestListener {

    @Override
    public void onTestStart(@NotNull ITestResult result) {
        LogsUtils.info("Test Case '" + result.getName() + "' started");
    }

    @Override
    public void onTestSuccess(@NotNull ITestResult result) {
        LogsUtils.info("Test Case '" + result.getName() + "' passed");
    }

    @Override
    public void onTestSkipped(@NotNull ITestResult result) {
        LogsUtils.warn("Test Case '" + result.getName() + "' skipped");
    }

    @Override
    public void onTestFailure(@NotNull ITestResult result) {
        LogsUtils.error("Test Case '" + result.getName() + "' failed");
        // Additional actions, such as taking screenshots or logging errors, can be added here.
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(@NotNull ITestResult result) {
        LogsUtils.warn("Test Case '" + result.getName()
                + "' failed but is within the success percentage.");
    }

    @Override
    public void onTestFailedWithTimeout(@NotNull ITestResult result) {
        LogsUtils.error("Test Case '" + result.getName() + "' failed due to a timeout.");
        onTestFailure(result);
    }
}
