/* Copyright 2011 SpringSource.
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

import org.cloudfoundry.client.lib.CloudApplication

/**
 * @author Burt Beckwith
 */

includeTargets << new File("$cloudFoundryPluginDir/scripts/_CfCommon.groovy")

USAGE = '''
grails cf-rename-app <newName> [--appname]
'''

target(cfRenameApp: 'Rename the application') {
	depends cfInit

	doWithTryCatch {

		String newName = getRequiredArg()

		CloudApplication application = getApplication()

		client.rename application.name, newName

		println "\nRenamed '$application.name' to '$newName'."
		println "If necessary, update grails.plugin.cloudfoundry.appname in Config.groovy with the new name.\n"
	}
}

setDefaultTarget cfRenameApp
