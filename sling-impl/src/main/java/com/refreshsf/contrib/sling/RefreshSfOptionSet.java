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

package com.refreshsf.contrib.sling;

import com.refreshsf.contrib.client.opts.CssOptions;
import com.refreshsf.contrib.client.opts.HtmlOptions;
import com.refreshsf.contrib.client.opts.JavascriptOptions;

import java.util.Map;

/**
 * Reflects a client for an HTTP API endpoint of a gpbmike/refresh-sf service
 */
public interface RefreshSfOptionSet {

    public static enum Type { CSS, JS, HTML }

    public String getName();

    /** 'css', 'js', 'html' */
    public Type getType();

    public Map<String, Object> getMap();

    public CssOptions getCssOptions();

    public HtmlOptions getHtmlOptions();

    public JavascriptOptions getJavascriptOptions();

}
