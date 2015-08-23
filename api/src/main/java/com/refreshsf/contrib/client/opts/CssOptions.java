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

import java.util.HashMap;
import java.util.Map;

public class CssOptions extends OptionsBag {

    public static enum Compatibility { ie7, ie8 }

    private CssOptions(Map<String, Object> backingMap) {
        super("options", backingMap);
    }

    public boolean advanced() {
        return get("advanced", false);
    }

    public boolean aggressiveMerging() {
        return get("aggressiveMerging", false);
    }

    public boolean rebase() {
        return get("rebase", false);
    }

    public boolean processImport() {
        return get("processImport", false);
    }

    public boolean benchmark() {
        return get("benchmark", false);
    }

    public Compatibility compatibility() {
        return Compatibility.valueOf(get("compatibility", ""));
    }

    public boolean keepBreaks() {
        return get("keepBreaks", false);
    }

    public boolean debug() {
        return get("debug", false);
    }

    public String relativeTo() {
        return get("relativeTo", "");
    }

    public String root() {
        return get("root", "");
    }


    public static class Builder {

        private Map<String, Object> map;

        public Builder() {
            this.map = new HashMap<String, Object>();
        }

        public Builder advanced(boolean val) {
            map.put("advanced", val);

            return this;
        }

        public Builder aggressiveMerging(boolean val) {
            map.put("aggressiveMerging", val);

            return this;
        }

        public Builder rebase(boolean val) {
            map.put("rebase", val);

            return this;
        }

        public Builder processImport(boolean val) {
            map.put("processImport", val);

            return this;
        }

        public Builder benchmark(boolean val) {
            map.put("benchmark", val);

            return this;
        }

        public Builder compatibility(Compatibility val) {
            map.put("benchmark", val.name());

            return this;
        }

        public Builder keepBreaks(boolean val) {
            map.put("keepBreaks", val);

            return this;
        }

        public Builder debug(boolean val) {
            map.put("debug", val);

            return this;
        }

        public Builder relativeTo(String val) {
            map.put("relativeTo", val);

            return this;
        }

        public Builder root(String val) {
            map.put("root", val);

            return this;
        }

        public CssOptions build() {
            return new CssOptions(map);
        }
    }


    /*
options[inliner]:
options[target]:
options[keepSpecialComments]:*
options[roundingPrecision]:2
     */
}
