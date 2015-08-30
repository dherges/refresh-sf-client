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

import java.util.*;

/**
 * PHP-style 'options[a]=true&options[b]=false' for url encoded form parameters
 */
public class OptionsBag implements Map<String, Object> {

    private static final String KEY_FORMAT = "%s[%s]";

    private String prefix;
    private Map<String, Object> optionsMap;

    public OptionsBag(String prefix, Map<String, Object> backingMap) {
        this.prefix = prefix;

        // map key-value pairs over
        this.optionsMap = new HashMap<String, Object>();
        for (String key : backingMap.keySet()) {
            optionsMap.put(optionKey(key), backingMap.get(key));
        }

        // ensure empty 'option[]'
        if (optionsMap.size() == 0) {
            optionsMap.put(emptyKey(), "");
        } else if (optionsMap.size() > 1 && optionsMap.containsKey(emptyKey())) {
            optionsMap.remove(emptyKey());
        }
    }

    private String emptyKey() {
        return optionKey("");
    }

    private String optionKey(String key) {
        return String.format(KEY_FORMAT, prefix, key);
    }

    public <T> T get(String key, T defaultValue) {
        Object val = optionsMap.get(optionKey(key));

        if ((val != null) && (defaultValue != null) && defaultValue.getClass().isAssignableFrom(val.getClass())) {
            //noinspection unchecked
            return (T) val;
        }

        return defaultValue;
    }

    @Override
    public OptionsBag put(String key, Object val) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void putAll(Map<? extends String, ?> m) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Object remove(Object key) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override
    public int size() {
        return optionsMap.size();
    }

    @Override
    public boolean isEmpty() {
        return optionsMap.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return optionsMap.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return optionsMap.containsValue(value);
    }

    @Override
    public Object get(Object key) {
        return optionsMap.get(key);
    }

    @Override
    public Set<String> keySet() {
        return Collections.unmodifiableSet(optionsMap.keySet());
    }

    @Override
    public Collection<Object> values() {
        return Collections.unmodifiableCollection(optionsMap.values());
    }

    @Override
    public Set<Entry<String, Object>> entrySet() {
        return Collections.unmodifiableSet(optionsMap.entrySet());
    }

}
