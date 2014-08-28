/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.tika.example;

import org.apache.tika.exception.TikaException;
import org.junit.Before;
import org.junit.Test;
import org.xml.sax.SAXException;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.apache.tika.TikaTest.assertContains;

public class ContentHandlerExampleTest {
    ContentHandlerExample example;
    
    @Before
    public void setUp() {
        example = new ContentHandlerExample();
    }

    @Test
    public void testParseToPlainText() throws IOException, SAXException, TikaException {
        String result = example.parseToPlainText().trim();
        assertEquals("Expected 'test', but got '" + result + "'", "test", result);
    }

    @Test
    public void testParseToHTML() throws IOException, SAXException, TikaException {
        String result = example.parseToHTML().trim();
        
        assertContains("<html", result);
        assertContains("<head>", result);
        assertContains("<meta name=\"dc:creator\"", result);
        assertContains("<title>", result);
        assertContains("<body>", result);
        assertContains(">test", result);
    }

    // TODO Implement then test the other two methods
}