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

package com.refreshsf.contrib.sling.impl;

import com.refreshsf.contrib.client.opts.CssOptions;
import com.refreshsf.contrib.client.opts.HtmlOptions;
import com.refreshsf.contrib.client.opts.JavascriptOptions;
import com.refreshsf.contrib.sling.RefreshSfOptionSet;
import org.apache.felix.scr.annotations.*;
import org.apache.sling.commons.osgi.PropertiesUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

@Component(
        label = "Refresh SF Client - Option Sets Factory",
        description = "Instances of this factory define registered API Option Sets for CSS/JS/HTML manipulation",
        configurationFactory = true,
        metatype = true
)
@Properties({
        @Property(name = RefreshSfOptionSetImpl.PROP_NAME,
                value = "",
                label = "Name of Options Set",
                description = "Identifier of the set of options"),
        @Property(name = RefreshSfOptionSetImpl.PROP_TYPE,
                value = "",
                label = "Type of Options Set",
                description = "One of: 'javascript', 'css', 'html'"),
        @Property(name = RefreshSfOptionSetImpl.PROP_OPTIONS,
                value = "",
                label = "Values of Options Set",
                description = "Options passed to the web service",
                cardinality = Integer.MAX_VALUE)
})
@Service
public class RefreshSfOptionSetImpl implements RefreshSfOptionSet {
    private static final Logger LOG = LoggerFactory.getLogger(RefreshSfOptionSetImpl.class);

    protected static final String PROP_NAME = "refreshsf.options.name";
    protected static final String PROP_TYPE = "refreshsf.options.type";
    protected static final String PROP_OPTIONS = "refreshsf.options.values";
    protected static final String TYPE_JAVASCRIPT = "javascript";
    protected static final String TYPE_CSS = "css";
    protected static final String TYPE_HTML = "html";

    protected String name;
    protected Map<String, String> myMap;

    @Activate
    protected final void activate(final Map<String, String> properties) throws Exception {
        modified(properties);
    }

    @Modified
    protected final void modified(final Map<String, String> properties) throws Exception {
        LOG.error("Registering Client: {} ... propertes = {}", "a", "b");
        name = PropertiesUtil.toString(properties.get(PROP_NAME), "");
        myMap = PropertiesUtil.toMap(properties.get(PROP_OPTIONS), new String[]{});

        LOG.error("Registering Client: {} ... propertes = {}", name, myMap.toString());
    }

    @Override
    public Type getType() {
        return null;
    }

    @Override
    public Map<String, Object> getMap() {
        return new HashMap<String, Object>(myMap);
    }

    @Override
    public CssOptions getCssOptions() {
        return new CssOptions.Builder()
                .fromMap(getMap())
                .build();
    }

    @Override
    public HtmlOptions getHtmlOptions() {
        return new HtmlOptions.Builder()
                .fromMap(getMap())
                .build();
    }

    @Override
    public JavascriptOptions getJavascriptOptions() {
        return new JavascriptOptions.Builder()
                .fromMap(getMap())
                .build();
    }

}
