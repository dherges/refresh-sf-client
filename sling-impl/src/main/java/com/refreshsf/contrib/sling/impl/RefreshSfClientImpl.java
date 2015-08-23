package com.refreshsf.contrib.sling.impl;

import com.refreshsf.contrib.client.api.Css;
import com.refreshsf.contrib.client.api.Html;
import com.refreshsf.contrib.client.api.Javascript;
import com.refreshsf.contrib.sling.RefreshSfClient;
import org.apache.felix.scr.annotations.Activate;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Properties;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Service;
import org.apache.sling.commons.osgi.PropertiesUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit.RestAdapter;

import java.util.Map;

@Component(
        label = "Refresh SF Client - HTTP Endpoint Factory",
        description = "Instances of this factory define registered HTTP endpoints that are Refresh SF APIs",
        configurationFactory = true,
        metatype = true
)
@Properties({
        @Property(name = RefreshSfClientImpl.PROP_NAME,
                value = "",
                label = "Client Name",
                description = "Name of Client."),
        @Property(name = RefreshSfClientImpl.PROP_URL,
                value = "",
                label = "Service URL",
                description = "URL of HTTP service.")
})
@Service
public class RefreshSfClientImpl implements RefreshSfClient {
    private static final Logger LOG = LoggerFactory.getLogger(RefreshSfClientImpl.class);

    protected static final String PROP_NAME = "refreshsf.client.name";
    protected static final String PROP_URL = "refreshsf.client.url";

    protected String name;
    protected String url;
    protected RestAdapter restAdapter;

    @Activate
    protected final void activate(final Map<String, String> properties) throws Exception {
        name = PropertiesUtil.toString(properties.get(PROP_NAME), "");
        url = PropertiesUtil.toString(properties.get(PROP_URL), "");

        LOG.info("Registering Client: {}", name);

        restAdapter = new RestAdapter.Builder()
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setEndpoint(url)
                .build();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getUrl() {
        return url;
    }

    @Override
    public Css getCssApi() {
        return restAdapter.create(Css.class);
    }

    @Override
    public Html getHtmlApi() {
        return restAdapter.create(Html.class);
    }

    @Override
    public Javascript getJavascriptApi() {
        return restAdapter.create(Javascript.class);
    }
}
