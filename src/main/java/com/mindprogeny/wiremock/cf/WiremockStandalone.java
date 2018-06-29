/*
 * WiremockStandalone.java, 29 Jun 2018
 * Created by Joao Viegas (joao.viegas@mindprogeny.com)
 *
 * Copyright (c) 2018 Mind Progeny.
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

package com.mindprogeny.wiremock.cf;

import com.github.tomakehurst.wiremock.standalone.WireMockServerRunner;

/**
 * Wrapper class for Wiremock standalone server with a better set of default values for cloud foundry deployment.
 * 
 * This standalone version is suited for long term running instances and is setup accordingly. The configuration
 * possibilities are limited to settings suitable for multi-use stand-alone server.
 * 
 * @author Jo&atilde;o Viegas (joao.viegas@mindprogeny.com)
 * @since 29 Jun 2018
 *
 */
public class WiremockStandalone {

	/**
	 * Calls wiremock server runner with predefined parameters
	 * 
	 * @param args currently ignored
	 */
	public static void main(String ...args) {
		// At the moment no configuration possibilities are given for simplicity purposes
		String[] options ={
				"--port", "80",
				"--no-request-journal",
				"--container-threads","105",
				"--jetty-acceptor-threads", "50",
				"--jetty-accept-queue-size", "200",
				"--async-response-threads", "50",
				"--async-response-enabled", "true",
				"--extensions", "com.mindprogeny.wiremock.extension.freemarker.FreemarkerResponseTransformer,"
						      + "com.mindprogeny.wiremock.extension.freemarker.FreemarkerVariableRepositoryManager,"
						      + "com.mindprogeny.wiremock.extension.scenario.ConcurrentScenarioExtension,"
						      + "com.mindprogeny.wiremock.extension.scenario.ConcurrentScenarioManager"
		};
		
		WireMockServerRunner.main(options);
	}
}
