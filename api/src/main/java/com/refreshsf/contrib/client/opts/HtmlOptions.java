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

package com.refreshsf.contrib.client.opts;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HtmlOptions extends OptionsBag {

    private HtmlOptions(Map<String, Object> backingMap) {
        super("options", backingMap);
    }

    public boolean removeComments() {
        return get("removeComments", false);
    }

    public boolean removeCommentsFromCDATA() {
        return get("removeCommentsFromCDATA", false);
    }

    public boolean removeCDATASectionsFromCDATA() {
        return get("removeCDATASectionsFromCDATA", false);
    }

    public boolean collapseWhitespace() {
        return get("collapseWhitespace", false);
    }

    public boolean conservativeCollapse() {
        return get("conservativeCollapse", false);
    }

    public boolean preserveLineBreaks() {
        return get("preserveLineBreaks", false);
    }

    public boolean collapseBooleanAttributes() {
        return get("collapseBooleanAttributes", false);
    }

    public boolean removeAttributeQuotes() {
        return get("removeAttributeQuotes", false);
    }

    public boolean removeRedundantAttributes() {
        return get("removeRedundantAttributes", false);
    }

    public boolean preventAttributesEscaping() {
        return get("preventAttributesEscaping", false);
    }

    public boolean useShortDoctype() {
        return get("useShortDoctype", false);
    }

    public boolean removeEmptyAttributes() {
        return get("removeEmptyAttributes", false);
    }

    public boolean removeScriptTypeAttributes() {
        return get("removeScriptTypeAttributes", false);
    }

    public boolean removeStyleLinkTypeAttributes() {
        return get("removeStyleLinkTypeAttributes", false);
    }

    public boolean removeOptionalTags() {
        return get("removeOptionalTags", false);
    }

    public boolean removeIgnored() {
        return get("removeIgnored", false);
    }

    public boolean removeEmptyElements() {
        return get("removeEmptyElements", false);
    }

    public boolean lint() {
        return get("lint", false);
    }

    public boolean keepClosingSlash() {
        return get("keepClosingSlash", false);
    }

    public boolean caseSensitive() {
        return get("caseSensitive", false);
    }

    public String maxLineLength() {
        return get("maxLineLength", "");
    }

    public List<String> ignoreCustomComments() {
        return Arrays.asList(StringUtils.split(get("ignoreCustomComments", ""), ","));
    }

    public List<String> processScripts() {
        return Arrays.asList(StringUtils.split(get("processScripts", ""), ","));
    }

    public List<String> customAttrAssign() {
        return Arrays.asList(StringUtils.split(get("customAttrAssign", ""), ","));
    }

    public List<String> customAttrSurround() {
        return Arrays.asList(StringUtils.split(get("customAttrSurround", ""), ","));
    }

    public List<String> customAttrCollapse() {
        return Arrays.asList(StringUtils.split(get("customAttrCollapse", ""), ","));
    }

    public boolean minifyJS() {
        return get("minifyJS", false);
    }

    public boolean minifyCSS() {
        return get("minifyCSS", false);
    }

    public boolean minifyURLs() {
        return get("minifyURLs", false);
    }

    public static class Builder {

        private Map<String, Object> map;

        public Builder() {
            this.map = new HashMap<String, Object>();
        }

        public Builder removeComments(boolean val) {
            map.put("removeComments", val);

            return this;
        }

        public Builder removeCommentsFromCDATA(boolean val) {
            map.put("removeCommentsFromCDATA", val);

            return this;
        }

        public Builder removeCDATASectionsFromCDATA(boolean val) {
            map.put("removeCDATASectionsFromCDATA", val);

            return this;
        }

        public Builder collapseWhitespace(boolean val) {
            map.put("collapseWhitespace", val);

            return this;
        }

        public Builder conservativeCollapse(boolean val) {
            map.put("conservativeCollapse", val);

            return this;
        }

        public Builder preserveLineBreaks(boolean val) {
            map.put("preserveLineBreaks", val);

            return this;
        }

        public Builder collapseBooleanAttributes(boolean val) {
            map.put("collapseBooleanAttributes", val);

            return this;
        }

        public Builder removeAttributeQuotes(boolean val) {
            map.put("removeAttributeQuotes", val);

            return this;
        }

        public Builder preventAttributesEscaping(boolean val) {
            map.put("preventAttributesEscaping", val);

            return this;
        }

        public Builder useShortDoctype(boolean val) {
            map.put("useShortDoctype", val);

            return this;
        }

        public Builder removeEmptyAttributes(boolean val) {
            map.put("removeEmptyAttributes", val);

            return this;
        }

        public Builder removeScriptTypeAttributes(boolean val) {
            map.put("removeScriptTypeAttributes", val);

            return this;
        }

        public Builder removeStyleLinkTypeAttributes(boolean val) {
            map.put("removeStyleLinkTypeAttributes", val);

            return this;
        }

        public Builder removeOptionalTags(boolean val) {
            map.put("removeOptionalTags", val);

            return this;
        }

        public Builder removeIgnored(boolean val) {
            map.put("removeIgnored", val);

            return this;
        }

        public Builder removeEmptyElements(boolean val) {
            map.put("removeEmptyElements", val);

            return this;
        }

        public Builder lint(boolean val) {
            map.put("lint", val);

            return this;
        }

        public Builder keepClosingSlash(boolean val) {
            map.put("keepClosingSlash", val);

            return this;
        }

        public Builder caseSensitive(boolean val) {
            map.put("caseSensitive", val);

            return this;
        }

        public Builder maxLineLength(String val) {
            map.put("maxLineLength", val);

            return this;
        }

        public Builder ignoreCustomComments(List<String> val) {
            map.put("ignoreCustomComments", StringUtils.join(val, ","));

            return this;
        }

        public Builder processScripts(List<String> val) {
            map.put("processScripts", StringUtils.join(val, ","));

            return this;
        }

        public Builder customAttrAssign(List<String> val) {
            map.put("customAttrAssign", StringUtils.join(val, ","));

            return this;
        }

        public Builder customAttrSurround(List<String> val) {
            map.put("customAttrSurround", StringUtils.join(val, ","));

            return this;
        }

        public Builder customAttrCollapse(List<String> val) {
            map.put("customAttrCollapse", StringUtils.join(val, ","));

            return this;
        }

        public Builder minifyJS(boolean val) {
            map.put("minifyJS", val);

            return this;
        }

        public Builder minifyCSS(boolean val) {
            map.put("minifyCSS", val);

            return this;
        }

        public Builder minifyURLs(boolean val) {
            map.put("minifyURLs", val);

            return this;
        }

        public Builder fromMap(Map<String, Object> m) {
            map.clear();
            map.putAll(m);

            return this;
        }

        public HtmlOptions build() {
            return new HtmlOptions(map);
        }
    }

}
