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

import com.refreshsf.contrib.sling.RefreshSfClient;
import com.refreshsf.contrib.sling.RefreshSfOptionSet;
import com.refreshsf.contrib.sling.RefreshSfService;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.ReferenceCardinality;
import org.apache.felix.scr.annotations.ReferencePolicy;
import org.apache.felix.scr.annotations.References;
import org.apache.felix.scr.annotations.Service;
import org.apache.sling.commons.osgi.PropertiesUtil;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component(
        label = "Refresh SF Service",
        description = "OSGi service exposing the configured clients and option sets",
        metatype = false
)
@Service(RefreshSfService.class)
@References({
        @Reference(
                name = "clients",
                referenceInterface = RefreshSfClient.class,
                policy = ReferencePolicy.DYNAMIC,
                cardinality = ReferenceCardinality.OPTIONAL_MULTIPLE
        ),
        @Reference(
                name = "optionSets",
                referenceInterface = RefreshSfOptionSet.class,
                policy = ReferencePolicy.DYNAMIC,
                cardinality = ReferenceCardinality.OPTIONAL_MULTIPLE
        )
})
public class RefreshSfServiceImpl implements RefreshSfService {

    private Map<String, RefreshSfClient> clients = new ConcurrentHashMap<String, RefreshSfClient>();

    private Map<String, RefreshSfOptionSet> optionSets = new ConcurrentHashMap<String, RefreshSfOptionSet>();

    /** OSGi clue code to inject RefreshSfClient instances into 'clients' */
    protected final void bindClients(final RefreshSfClient service, final Map<Object, Object> props) {
        final String name = PropertiesUtil.toString(props.get(RefreshSfClientImpl.PROP_NAME), null);
        if (name != null) {
            clients.put(name, service);
        }
    }

    /** OSGi clue code to evict RefreshSfClient instances from 'clients' */
    protected final void unbindClients(final RefreshSfClient service, final Map<Object, Object> props) {
        final String name = PropertiesUtil.toString(props.get(RefreshSfClientImpl.PROP_NAME), null);
        if (name != null) {
            clients.remove(name);
        }
    }

    /** OSGi clue code to inject RefreshSfOptionSet instances into 'optionSets' */
    protected final void bindOptionSets(final RefreshSfOptionSet service, final Map<Object, Object> props) {
        final String name = PropertiesUtil.toString(props.get(RefreshSfOptionSetImpl.PROP_NAME), null);
        if (name != null) {
            optionSets.put(name, service);
        }
    }

    /** OSGi clue code to evict RefreshSfOptionSet instances from 'optionSets' */
    protected final void unbindOptionSets(final RefreshSfOptionSet service, final Map<Object, Object> props) {
        final String name = PropertiesUtil.toString(props.get(RefreshSfOptionSetImpl.PROP_NAME), null);
        if (name != null) {
            optionSets.remove(name);
        }
    }

    @Override
    public RefreshSfClient getConfiguredClient(String clientName) {
        return clients.get(clientName);
    }

    @Override
    public RefreshSfOptionSet getConfiguredOptionSet(String optionSetName) {
        return optionSets.get(optionSetName);
    }

}
