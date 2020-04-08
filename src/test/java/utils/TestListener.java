package utils;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

import java.util.Optional;

public class TestListener implements TestWatcher {
    @Override
    public void testDisabled(ExtensionContext context, Optional<String> optional) {
        System.out.println(context.getDisplayName() + " test - DISABLED");
    }

    @Override
    public void testSuccessful(ExtensionContext context) {
        System.out.println(context.getDisplayName() + " test - PASS");
    }

    @Override
    public void testAborted(ExtensionContext context, Throwable throwable) {
        System.out.println(context.getDisplayName() + " test - ABORTED");
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable throwable) {
        System.out.println(context.getDisplayName() + " test - FAILED");
    }
}
