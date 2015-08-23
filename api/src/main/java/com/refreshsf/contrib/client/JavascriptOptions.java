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

package com.refreshsf.contrib.client;

import com.refreshsf.contrib.client.util.MapDecorator;

import java.util.HashMap;
import java.util.Map;

public class JavascriptOptions extends MapDecorator<String, Object> {

    private JavascriptOptions(Map<String, Object> backingMap) {
        super(backingMap);
    }

    public boolean sequences() {
        return Boolean.valueOf(get("options[sequences]").toString());
    }

    public boolean properties() {
        return Boolean.valueOf(get("options[properties]").toString());
    }

    public boolean deadCode() {
        return Boolean.valueOf(get("options[dead_code]").toString());
    }

    public boolean dropDebugger() {
        return Boolean.valueOf(get("options[drop_debugger]").toString());
    }

    public boolean conditionals() {
        return Boolean.valueOf(get("options[conditionals]").toString());
    }

    public boolean comparisons() {
        return Boolean.valueOf(get("options[comparisons]").toString());
    }

    public boolean evaluate() {
        return Boolean.valueOf(get("options[evaluate]").toString());
    }

    public boolean booleans() {
        return Boolean.valueOf(get("options[booleans]").toString());
    }

    public boolean loops() {
        return Boolean.valueOf(get("options[loops]").toString());
    }

    public boolean unused() {
        return Boolean.valueOf(get("options[unused]").toString());
    }

    public boolean hoistFuns() {
        return Boolean.valueOf(get("options[hoist_funs]").toString());
    }

    public boolean ifReturn() {
        return Boolean.valueOf(get("options[if_return]").toString());
    }

    public boolean joinVars() {
        return Boolean.valueOf(get("options[join_vars]").toString());
    }

    public boolean cascade() {
        return Boolean.valueOf(get("options[cascade]").toString());
    }

    public boolean warnings() {
        return Boolean.valueOf(get("options[warnings]").toString());
    }

    public boolean negateIIFE() {
        return Boolean.valueOf(get("options[negate_iife]").toString());
    }

    public boolean unsafe() {
        return Boolean.valueOf(get("options[unsafe]").toString());
    }

    public boolean hoistVars() {
        return Boolean.valueOf(get("options[hoist_vars]").toString());
    }

    public boolean pureGetters() {
        return Boolean.valueOf(get("options[pure_getters]").toString());
    }

    public boolean dropConsole() {
        return Boolean.valueOf(get("options[drop_console]").toString());
    }

    public boolean keepFargs() {
        return Boolean.valueOf(get("options[keep_fargs]").toString());
    }

    public static class Builder {

        private Map<String, Object> map = new HashMap<String, Object>();

        public Builder() {
            map.put("options[]", null);
        }

        public Builder sequences(boolean val) {
            map.put("options[sequences]", val);

            return this;
        }

        public Builder properties(boolean val) {
            map.put("options[properties]", val);

            return this;
        }

        public Builder deadCode(boolean val) {
            map.put("options[dead_code]", val);

            return this;
        }

        public Builder dropDebugger(boolean val) {
            map.put("options[drop_debugger]", val);

            return this;
        }

        public Builder conditionals(boolean val) {
            map.put("options[conditionals]", val);

            return this;
        }

        public Builder comparisons(boolean val) {
            map.put("options[comparisons]", val);

            return this;
        }

        public Builder evaluate(boolean val) {
            map.put("options[evaluate]", val);

            return this;
        }

        public Builder booleans(boolean val) {
            map.put("options[booleans]", val);

            return this;
        }

        public Builder loops(boolean val) {
            map.put("options[loops]", val);

            return this;
        }

        public Builder unused(boolean val) {
            map.put("options[unused]", val);

            return this;
        }

        public Builder hoistFuns(boolean val) {
            map.put("options[hoist_funs]", val);

            return this;
        }

        public Builder ifReturn(boolean val) {
            map.put("options[if_return]", val);

            return this;
        }

        public Builder joinVars(boolean val) {
            map.put("options[join_vars]", val);

            return this;
        }

        public Builder cascade(boolean val) {
            map.put("options[cascade]", val);

            return this;
        }

        public Builder warnings(boolean val) {
            map.put("options[warnings]", val);

            return this;
        }

        public Builder negateIIFE(boolean val) {
            map.put("options[negate_iife]", val);

            return this;
        }

        public Builder unsafe(boolean val) {
            map.put("options[unsafe]", val);

            return this;
        }

        public Builder hoistVars(boolean val) {
            map.put("options[hoist_vars]", val);

            return this;
        }

        public Builder pureGetters(boolean val) {
            map.put("options[pure_getters]", val);

            return this;
        }

        public Builder dropConsole(boolean val) {
            map.put("options[drop_console]", val);

            return this;
        }

        public Builder keepFargs(boolean val) {
            map.put("options[keep_fargs]", val);

            return this;
        }

        public JavascriptOptions build() {
            if (map.size() > 1) {
                map.remove("options[]");
            }

            return new JavascriptOptions(map);
        }
    }

}
