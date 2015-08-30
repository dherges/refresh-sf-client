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

package com.refreshsf.contrib.client.types.opts;

import java.util.HashMap;
import java.util.Map;

public class JavascriptOptions extends OptionsBag {

    private JavascriptOptions(Map<String, Object> backingMap) {
        super("options", backingMap);
    }

    public boolean sequences() {
        return get("sequences", false);
    }

    public boolean properties() {
        return get("properties", false);
    }

    public boolean deadCode() {
        return get("dead_code", false);
    }

    public boolean dropDebugger() {
        return get("drop_debugger", false);
    }

    public boolean conditionals() {
        return get("conditionals", false);
    }

    public boolean comparisons() {
        return get("comparisons", false);
    }

    public boolean evaluate() {
        return get("evaluate", false);
    }

    public boolean booleans() {
        return get("booleans", false);
    }

    public boolean loops() {
        return get("loops", false);
    }

    public boolean unused() {
        return get("unused", false);
    }

    public boolean hoistFuns() {
        return get("hoist_funs", false);
    }

    public boolean ifReturn() {
        return get("if_return", false);
    }

    public boolean joinVars() {
        return get("join_vars", false);
    }

    public boolean cascade() {
        return get("cascade", false);
    }

    public boolean warnings() {
        return get("warnings", false);
    }

    public boolean negateIIFE() {
        return get("negate_iife", false);
    }

    public boolean unsafe() {
        return get("unsafe", false);
    }

    public boolean hoistVars() {
        return get("hoist_vars", false);
    }

    public boolean pureGetters() {
        return get("pure_getters", false);
    }

    public boolean dropConsole() {
        return get("drop_console", false);
    }

    public boolean keepFargs() {
        return get("keep_fargs", false);
    }

    public static class Builder {

        private Map<String, Object> map;

        public Builder() {
            this.map = new HashMap<String, Object>();
        }

        public Builder sequences(boolean val) {
            map.put("sequences", val);

            return this;
        }

        public Builder properties(boolean val) {
            map.put("properties", val);

            return this;
        }

        public Builder deadCode(boolean val) {
            map.put("dead_code", val);

            return this;
        }

        public Builder dropDebugger(boolean val) {
            map.put("drop_debugger", val);

            return this;
        }

        public Builder conditionals(boolean val) {
            map.put("conditionals", val);

            return this;
        }

        public Builder comparisons(boolean val) {
            map.put("comparisons", val);

            return this;
        }

        public Builder evaluate(boolean val) {
            map.put("evaluate", val);

            return this;
        }

        public Builder booleans(boolean val) {
            map.put("booleans", val);

            return this;
        }

        public Builder loops(boolean val) {
            map.put("loops", val);

            return this;
        }

        public Builder unused(boolean val) {
            map.put("unused", val);

            return this;
        }

        public Builder hoistFuns(boolean val) {
            map.put("hoist_funs", val);

            return this;
        }

        public Builder ifReturn(boolean val) {
            map.put("if_return", val);

            return this;
        }

        public Builder joinVars(boolean val) {
            map.put("join_vars", val);

            return this;
        }

        public Builder cascade(boolean val) {
            map.put("cascade", val);

            return this;
        }

        public Builder warnings(boolean val) {
            map.put("warnings", val);

            return this;
        }

        public Builder negateIIFE(boolean val) {
            map.put("negate_iife", val);

            return this;
        }

        public Builder unsafe(boolean val) {
            map.put("unsafe", val);

            return this;
        }

        public Builder hoistVars(boolean val) {
            map.put("hoist_vars", val);

            return this;
        }

        public Builder pureGetters(boolean val) {
            map.put("pure_getters", val);

            return this;
        }

        public Builder dropConsole(boolean val) {
            map.put("drop_console", val);

            return this;
        }

        public Builder keepFargs(boolean val) {
            map.put("keep_fargs", val);

            return this;
        }

        public Builder fromMap(Map<String, Object> m) {
            map.clear();
            map.putAll(m);

            return this;
        }

        public JavascriptOptions build() {
            return new JavascriptOptions(map);
        }
    }

}
