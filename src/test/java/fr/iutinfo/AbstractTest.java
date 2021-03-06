/**
 * Copyright (C) 2013-2014 all@code-story.net
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License
 */
package fr.iutinfo;

import net.codestory.rest.FluentRestTest;
import net.codestory.http.Configuration;
import net.codestory.http.WebServer;


import org.junit.Rule;
import org.junit.rules.ExpectedException;

public abstract class AbstractTest implements FluentRestTest {
  private static WebServer server = new BlogServer().startOnRandomPort();

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @Override
  public int port() {
    return server.port();
  }

  protected void configure(Configuration configuration) {
    server.configure(configuration);
  }

  protected void shouldFail(String message) {
    thrown.expect(AssertionError.class);
    thrown.expectMessage(message);
  }
}
