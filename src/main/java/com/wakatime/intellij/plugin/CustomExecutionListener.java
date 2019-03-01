package com.wakatime.intellij.plugin;

import com.intellij.execution.ExecutionListener;
import com.intellij.execution.process.ProcessHandler;
import com.intellij.execution.runners.ExecutionEnvironment;
import org.jetbrains.annotations.NotNull;

public class CustomExecutionListener implements ExecutionListener {
    @Override
    public void processStarted(@NotNull String executorId, @NotNull ExecutionEnvironment env, @NotNull ProcessHandler handler) {
        WakaTime.isBuilding = true;
        WakaTime.appendExecHeartbeat(
                env.getProject(),
                false
        );
    }

    @Override
    public void processTerminated(
            @NotNull String executorId,
            @NotNull ExecutionEnvironment env,
            @NotNull ProcessHandler handler,
            int exitCode
    ) {
        WakaTime.isBuilding = false;
        WakaTime.appendExecHeartbeat(
                env.getProject(),
                false
        );
    }
}
