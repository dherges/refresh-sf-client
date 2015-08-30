/*
 * refresh-sf client
 *
 * Copyright 2015 dherges <david@spektrakel.de>
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

package com.refreshsf.contrib.client.tests;

import com.refreshsf.contrib.client.api.Javascript;
import com.refreshsf.contrib.client.types.opts.JavascriptOptions;
import com.refreshsf.contrib.client.types.Result;
import org.junit.Before;
import org.junit.Test;
import retrofit.RestAdapter;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class JavascriptTest {

    protected Javascript javascript;

    @Before
    public void setUp() {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setEndpoint("http://refresh-sf.herokuapp.com")
                .build();

        javascript = restAdapter.create(Javascript.class);
    }

    @Test
    public void apiObjectIsOk() {
        assertThat(javascript).isNotNull();
    }

    @Test
    public void compress() throws IOException {
        String testCode = ResourceUtil.readResourceFile("helloworld.js");
        JavascriptOptions opts = new JavascriptOptions.Builder()
                .sequences(true)
                .build();

        Result result = javascript.uglify(testCode, opts);

        assertThat(result).isNotNull();
        assertThat(result.getCode()).isNotEmpty();
    }




}
