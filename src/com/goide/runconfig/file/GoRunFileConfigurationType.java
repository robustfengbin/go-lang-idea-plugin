/*
 * Copyright 2013-2014 Sergey Ignatov, Alexander Zolotov
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.goide.runconfig.file;

import com.goide.GoIcons;
import com.intellij.compiler.options.CompileStepBeforeRun;
import com.intellij.execution.BeforeRunTask;
import com.intellij.execution.configurations.ConfigurationFactory;
import com.intellij.execution.configurations.ConfigurationTypeBase;
import com.intellij.execution.configurations.RunConfiguration;
import com.intellij.openapi.extensions.Extensions;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.Key;
import org.jetbrains.annotations.NotNull;

public class GoRunFileConfigurationType extends ConfigurationTypeBase {
  public GoRunFileConfigurationType() {
    super("GoRunFileConfiguration", "Go Single File", "Go single run file configuration", GoIcons.APPLICATION_RUN);
    addFactory(new ConfigurationFactory(this) {
      @NotNull
      public RunConfiguration createTemplateConfiguration(Project project) {
        return new GoRunFileConfiguration(project, "Go", getInstance());
      }

      @Override
      public void configureBeforeRunTaskDefaults(Key<? extends BeforeRunTask> providerID, @NotNull BeforeRunTask task) {
        if (providerID == CompileStepBeforeRun.ID) {
          task.setEnabled(false);
        }
      }
    });
  }

  @NotNull
  public static GoRunFileConfigurationType getInstance() {
    return Extensions.findExtension(CONFIGURATION_TYPE_EP, GoRunFileConfigurationType.class);
  }
}