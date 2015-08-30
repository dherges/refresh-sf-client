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


/**
 * Usage: <code>@Reference RefreshSfService myService;</code>
 */
public interface RefreshSfService {

    /**
     * Returns the OSGi-configured client with the given name.
     *
     * @param clientName Name of client, {@link RefreshSfClient#getName()}
     * @return Instance of RefreshSfClient
     */
    public RefreshSfClient getConfiguredClient(String clientName);

    /**
     * Returns the OSGi-configured option set with the given name.
     *
     * @param optionSetName Name of option set, {@link com.refreshsf.contrib.sling.RefreshSfOptionSet#}
     * @return
     */
    public RefreshSfOptionSet getConfiguredOptionSet(String optionSetName);

}
