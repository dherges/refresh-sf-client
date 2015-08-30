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

package com.refreshsf.contrib.sling.example;

import com.refreshsf.contrib.client.ErrorResult;
import com.refreshsf.contrib.client.Result;
import com.refreshsf.contrib.client.api.Javascript;
import com.refreshsf.contrib.sling.RefreshSfClient;
import com.refreshsf.contrib.sling.RefreshSfOptionSet;
import com.refreshsf.contrib.sling.RefreshSfService;
import org.apache.commons.io.IOUtils;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import retrofit.RetrofitError;

import javax.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;


@SlingServlet(
        paths = { "/services/refresh-sf-example" }
)
public class RefreshSfExampleServlet extends SlingSafeMethodsServlet {

    public static final String PARAM_CLIENT_NAME = "client";
    public static final String PARAM_OPTION_SET_NAME = "optionSet";

    @Reference
    protected RefreshSfService refreshSfService;

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response)
            throws ServletException, IOException {

        String clientName = request.getRequestParameter(PARAM_CLIENT_NAME).getString();
        String optionSetName = request.getRequestParameter(PARAM_OPTION_SET_NAME).getString();

        RefreshSfClient client = refreshSfService.getConfiguredClient(clientName);
        RefreshSfOptionSet optionSet = refreshSfService.getConfiguredOptionSet(optionSetName);

        Javascript jsApi = client.getJavascriptApi();
        String hardCodedExample = "console.log('hello world');var a = 8+2; if (a > 10) { a++; }";

        try {
            Result result = jsApi.uglify(hardCodedExample, optionSet.asJavascriptOptions());

            response.getWriter().append(result.getCode());
        } catch (RetrofitError error) {
            PrintWriter writer = response.getWriter();

            writer.append("\nurl=" + error.getUrl())
                    .append("\nkind=" + error.getKind().toString())
                    .append("\nstatus=" + error.getResponse().getStatus())
                    .append("\nreason=" + error.getResponse().getReason())
                    .append("\nbody=" + IOUtils.toString(error.getResponse().getBody().in(), "UTF-8"));

            ErrorResult error1 = (ErrorResult) error.getBodyAs(ErrorResult.class);

            writer.append("\n")
                    .append("\nmsg=" + error1.getMsg())
                    .append("\ndefs=" + error1.getDefs().toString());
        }

    }

}
