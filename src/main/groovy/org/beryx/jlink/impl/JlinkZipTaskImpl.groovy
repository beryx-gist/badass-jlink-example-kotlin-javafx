/*
 * Copyright 2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.beryx.jlink.impl

import org.beryx.jlink.data.JlinkZipTaskData
import org.gradle.api.Project

class JlinkZipTaskImpl extends BaseTaskImpl {
    JlinkZipTaskImpl(Project project, JlinkZipTaskData taskData) {
        super(project, taskData)
        project.logger.info("taskData: $taskData")
    }

    void execute() {
        project.ant.zip(destfile: td.imageZip, duplicate: 'fail') {
            zipfileset(dir: td.imageDir.parentFile, includes: "$td.imageDir.name/**", excludes: "$td.imageDir.name/bin/**")
            zipfileset(dir: td.imageDir.parentFile, includes: "$td.imageDir.name/bin/**", filemode: 755)
        }
    }
}
